package br.com.sl3v1.challengeselection.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {//liberando o acesso da aplicação ao banco H2
			http.headers().frameOptions().disable();
		}
		
		http.cors().and().csrf().disable();//liberando o CORS, desabilitando a proteção de ataque CSRF (ataque baseado em sessão), a aplicação será REST, por isso não sofre esse tipo de ataque.
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//Não armazena o estado.
		http.authorizeRequests().anyRequest().permitAll();//Permitindo o acesso à todas requisições.
		http.headers().frameOptions().disable();
		http.headers().frameOptions().sameOrigin(); //Permitindo a execução x-frame para a exibição do h2-console (https://stackoverflow.com/questions/53395200/h2-console-is-not-showing-in-browser)
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}