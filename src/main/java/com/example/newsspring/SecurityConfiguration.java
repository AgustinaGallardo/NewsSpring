package com.example.newsspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    /**
     * la clase SecurityConfiguration está creando una configuración de seguridad que autoriza todas las
     * solicitudes solo si el usuario está autenticado. Además, se habilita la autenticación básica HTTP,
     * lo que significa que los clientes deben proporcionar credenciales para acceder a recursos protegidos.
     *
     *
     *
     *
     * @Bean en Spring se utiliza para indicarle al contenedor de Spring que un método específico en una clase
     * de configuración produce un bean que debe gestionarse y estar disponible para ser utilizado en otras partes
     * de la aplicación.
     */



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }


}