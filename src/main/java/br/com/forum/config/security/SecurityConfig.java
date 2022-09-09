package br.com.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//configurações para autenticações
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	//configurações de autorizações
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
	    .antMatchers(HttpMethod.GET, "/topicos").permitAll()
	    .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
	    .anyRequest().authenticated()
	    .and().formLogin();
	}
	
	//Configurações de recursos estáticos(js, imagens, css, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
}
