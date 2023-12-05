package com.facility.primeSport.configuration;

import com.facility.primeSport.auth.JWTAuthenticationEntrypoint;
import com.facility.primeSport.auth.JwtAuthFilter;
import com.facility.primeSport.enums.permission.Role;
import com.facility.primeSport.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    public static String[] NON_LOGIN_REQUIRED_URLS = { "/robot*", "/test/**", "/chart-test/**", "/captcha/**",
            "/signup/**", "/login/**", "/webjars/**", "/terms/**", "/static/**", "/stylesheets/**", "/js/**", "/registration-confirmation/**" };

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JWTAuthenticationEntrypoint entrypoint;

    @Bean
    public JwtAuthFilter jwtAuthenticationFilter() {
        return new JwtAuthFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(request -> {
                    request.requestMatchers(NON_LOGIN_REQUIRED_URLS).permitAll();
                    //request.anyRequest().permitAll();
                   // request.requestMatchers(HttpMethod.GET, "/", "/dashboard").permitAll();
                    request.requestMatchers("/api/auth/**").permitAll()
                            //request.requestMatchers("/api/building/**").hasAnyRole(Role.ADMIN.name(), Role.B_OWNER.name())
                    //anyRequest().permitAll();
                    .anyRequest().authenticated();
                    //request.requestMatchers("/users")
                    //      .hasAnyAuthority("USER", "ADMIN");

                }).exceptionHandling((e) -> e.authenticationEntryPoint(entrypoint))
                .rememberMe(Customizer.withDefaults());




//formLogin(login -> login.loginPage("/api/auth/login").loginPage("api/auth/register").permitAll())
        http.addFilterBefore(this.jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
