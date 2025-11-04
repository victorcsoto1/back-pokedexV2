package com.api.pokeapi.pokedex.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.pokeapi.pokedex.models.Usuario;
import com.api.pokeapi.pokedex.repository.UsuarioRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {

    private final EmailService emailService;
	
	@Value("${jwt.secret}")
	private String JWT_SECRET;
	
	@Value("${jwt.expiration-ms}")
	private long EXPIRATION_TIME;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    AuthService(EmailService emailService) {
        this.emailService = emailService;
    }
	
	public Usuario registrarUsuario(Usuario usuario) {
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			throw new RuntimeException("El email ya está registrado.");
		}
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}
	
	@SuppressWarnings("deprecation")
	public String login(String email, String password) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			if(passwordEncoder.matches(password, usuario.getPassword())) {
				return Jwts.builder()
						.setSubject(email)
						.claim("nombre", usuario.getNombre())
						.claim("apellidos", usuario.getApellidos())
						.claim("telefono", usuario.getTelefono())
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS256, JWT_SECRET.getBytes(StandardCharsets.UTF_8))
						.compact();
			}
		}
		throw new RuntimeException("Credenciales incorrectas.");
	}
	
	//Genera codigo de 6 digitos y lo envia por correo al usuario.
	public String generaCodigoRecuperacion(String email) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if (usuarioOpt.isEmpty()) {
			return null;
		}
		
		Usuario usuario = usuarioOpt.get();
		
		String codigo = String.format("%06d", new Random().nextInt(999999));
		LocalDateTime expiracion = LocalDateTime.now().plusMinutes(5);
		
		usuario.setCodigo(codigo);
		usuario.setExpiracionCodigo(expiracion);
		usuarioRepository.save(usuario);
		
		//Enviar correo al usuario
		String asunto = "Recuperación de contraseña sitio pokedex";
		String cuerpo = String.format("""
				Hola %s,
				
				Aquí tienes el código de recuperación de contraseña: %s
				
				Saludos cordiales!
				""", usuario.getNombre(), codigo);
		
		emailService.enviarCorreo(email, asunto, cuerpo);
		
		return codigo;
	}
	
	//Valida si el codigo ingresado es correcto,
	public boolean validarCodigo(String email, String codigo) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if (usuarioOpt.isEmpty()) {
			throw new RuntimeException("Usuario no encontrado.");
		}
		
		Usuario usuario = usuarioOpt.get();
		
		if (usuario.getCodigo() == null || usuario.getExpiracionCodigo() == null) {
			throw new RuntimeException("No se ha solicitado recuperar contraseña.");
		}
		if (!usuario.getCodigo().equals(codigo)) {
			throw new RuntimeException("El código ingresado no es válido.");
		}
		if (LocalDateTime.now().isAfter(usuario.getExpiracionCodigo())) {
			throw new RuntimeException("El código ha expirado.");
		}
		
		return true;
	}
	
	//Realiza el cambio de contraseña
	public void cambiarPassword(String email, String newPassword) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if (usuarioOpt.isEmpty()) {
			throw new RuntimeException("Usuario no encontrado.");
		}
		
		Usuario usuario = usuarioOpt.get();
		usuario.setPassword(passwordEncoder.encode(newPassword));
		
		//Limpieza de codigo de recuperacion password
		usuario.setCodigo(null);
        usuario.setExpiracionCodigo(null);
        
        usuarioRepository.save(usuario);
	}
	
	//Edita la información necesaria del usuario
	public void updateUsuario(Usuario usuario) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioOpt.isEmpty()) {
			throw new RuntimeException("Usuario no encontrado.");
		}
		
		Usuario updatedUsuario = usuarioOpt.get();
		updatedUsuario.setTelefono(usuario.getTelefono());
		updatedUsuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
		usuarioRepository.save(updatedUsuario);
	}
	
}
