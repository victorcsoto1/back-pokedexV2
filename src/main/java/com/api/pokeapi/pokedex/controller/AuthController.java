package com.api.pokeapi.pokedex.controller;

import java.util.Base64;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokeapi.pokedex.models.Usuario;
import com.api.pokeapi.pokedex.service.AuthService;

import tools.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	private static final String SECRET_KEY = "1234567890123456";
	
	@PostMapping("/register")
	public ResponseEntity<?> registrar(@RequestBody Map<String, String> body) {
		try {
			String decrypted = decrypt(body.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			Usuario usuario = mapper.readValue(decrypted, Usuario.class);
			
			authService.registrarUsuario(usuario);
			return ResponseEntity.ok(Map.of("mensaje", "Usuario creado exitósamente"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensaje", "Error al crear usuario: " + e.getMessage()));
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
		try {
			String decrypted = decrypt(body.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			Usuario usuario = mapper.readValue(decrypted, Usuario.class);
			
			String token = authService.login(usuario.getEmail(), usuario.getPassword());
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensaje", "Error al iniciar sesión: " + e.getMessage()));
		} 
	}
	
	@PostMapping("/recover")
	public ResponseEntity<?> recoverPassowrd(@RequestBody Map<String, String> body) {
		try {
			String decrypted = decrypt(body.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			Usuario usuario = mapper.readValue(decrypted, Usuario.class);
			
			String email = usuario.getEmail();
			String codigo = authService.generaCodigoRecuperacion(email);
			
			if (codigo == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Usuario no encontrado"));
			}
			
			return ResponseEntity.ok(Map.of("mensaje", "Se generó código exitósamente", "codigo", codigo));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Ocurrió un error al intentar generar código"));
		}
	}
	
	@PostMapping("/valida-codigo")
	public ResponseEntity<?> validarCodigo(@RequestBody Map<String, String> body) {
		try {
			String decrypted = decrypt(body.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			Usuario usuario = mapper.readValue(decrypted, Usuario.class);
			
			String email = usuario.getEmail();
			String codigo = usuario.getCodigo();
		
			boolean codigoValido = authService.validarCodigo(email, codigo);
			return ResponseEntity.ok(Map.of("valid_code", codigoValido));
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("valid_code", false, "error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Ocurrió un error al validar código."));
		}
	}
	
	@PostMapping("/cambiar-password")
	public ResponseEntity<?> cambiarPassword(@RequestBody Map<String, String> body) {
		try {
			String decrypted = decrypt(body.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			Usuario usuario = mapper.readValue(decrypted, Usuario.class);
			
			String email = usuario.getEmail();
			String newPassword = usuario.getPassword();
	
			authService.cambiarPassword(email, newPassword);
			return ResponseEntity.ok(Map.of("mensaje", "Contraseña actualizada exitosamente"));
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Ocurrió un error al intentar realizar el cambio de contraseña."));
		}
	}
	
	@PostMapping("/edit-profile")
	public ResponseEntity<?> editarPerfil(@RequestBody Map<String, String> body) {
		try {
			String decrypted = decrypt(body.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			Usuario usuario = mapper.readValue(decrypted, Usuario.class);
			
			authService.updateUsuario(usuario);
			
			return ResponseEntity.ok(Map.of("mensaje", "Usuario editado exitósamente."));
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Ocurrió un error al intentar editar el perfil del usuario."));
		}
	}
	
	private String decrypt(String encrypted) throws Exception {
		SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
		IvParameterSpec iv = new IvParameterSpec(SECRET_KEY.getBytes());
		
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decrypted);
	}
	
	public static class JwtResponse {
		private String token;
		
		public JwtResponse(String token) {
			this.token = token;
		}
		
		public String getToken() {
			return token;
		}
	}
}
