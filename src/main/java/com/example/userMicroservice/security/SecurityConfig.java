package com.example.userMicroservice.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfig {
    
   /*  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((authz) -> {
                authz.requestMatchers("/users").permitAll();
            });

            return http.build();
    }*/
    /*@Autowired
    private JwtAuthFilter authFilter;*/

     // User Creation 
    /*@Bean
    public UserDetailsService userDetailsService() { 
        return new UserInfoService(); 
    } */


    // Configuring HttpSecurity 
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
        return http.csrf().disable() */
  /* */            /*   .authorizeHttpRequests() 
                .requestMatchers("/auth/welcome", "/auth/addNewUser", "/auth/generateToken").permitAll() 
                .and() 
                .authorizeHttpRequests().requestMatchers("/auth/user/**").authenticated() 
                .and() 
                .authorizeHttpRequests().requestMatchers("/auth/admin/**").authenticated() 
                .and() 
                .sessionManagement() 
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
                .and() 
                .authenticationProvider(authenticationProvider()) 
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class) 
                .build(); 
    } 
   */

}
