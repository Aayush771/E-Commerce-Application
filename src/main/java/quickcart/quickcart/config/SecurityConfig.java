package quickcart.quickcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import quickcart.quickcart.JWTFilters.TokenValidationFilter;
@Configuration
public class SecurityConfig{
    
    @Autowired
    private TokenValidationFilter tokenValidationFilter;
    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.POST,"/api/users").permitAll()
        .requestMatchers(HttpMethod.POST,"/api/users/login").permitAll()
        .requestMatchers("/swagger-ui/index.html", "/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs","swagger-ui.html").permitAll()
        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
        .requestMatchers("/seller/**").hasRole("SELLER")        
        .anyRequest().authenticated())
        .csrf(csrf-> csrf.disable())
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(tokenValidationFilter, UsernamePasswordAuthenticationFilter.class);

    return httpSecurity.build();    
}


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
     AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
     }
}
