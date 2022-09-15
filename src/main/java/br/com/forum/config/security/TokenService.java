package br.com.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.secret}")
	private String secret;
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		Date date = new Date();
		Date dataExpiracao = new Date(date.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API do fórum")
				.setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(date)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
