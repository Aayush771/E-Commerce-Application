package quickcart.quickcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig{
    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.POST,"/api/users").permitAll()
        .requestMatchers("/api/users/login").permitAll()   
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/seller/**").hasRole("SELLER")
        .requestMatchers("/").permitAll()
        .anyRequest().authenticated())
        .csrf(csrf-> csrf.disable())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());

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
