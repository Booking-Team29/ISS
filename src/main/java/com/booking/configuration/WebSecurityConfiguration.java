package com.booking.configuration;

import com.booking.security.RestAuthenticationEntryPoint;
import com.booking.security.TokenAuthenticationFilter;
import com.booking.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final TokenUtils tokenUtils;

    @Autowired
    public WebSecurityConfiguration(RestAuthenticationEntryPoint restAuthenticationEntryPoint, TokenUtils tokenUtils) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.tokenUtils = tokenUtils;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                           UserDetailsService userDetailsService,
                                           DaoAuthenticationProvider daoAuthenticationProvider) throws Exception {
        httpSecurity.cors(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.exceptionHandling(exceptionHandling ->
                exceptionHandling.authenticationEntryPoint(restAuthenticationEntryPoint));
        httpSecurity.authorizeHttpRequests(request -> {
            request.requestMatchers(new AntPathRequestMatcher("/authentication/*")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/error")).permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/v1/accommodation").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/v1/accommodation/{id}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/v1/accommodation/accommodationSearch").permitAll()
                    .anyRequest().authenticated();
        });
        httpSecurity.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, userDetailsService),
                UsernamePasswordAuthenticationFilter.class);
        httpSecurity.authenticationProvider(daoAuthenticationProvider);
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(HttpMethod.GET, "/", "/webjars/*", "/*.html", "favicon.ico",
                        "/*/*.html", "/*/*.css", "/*/*.js");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200", "*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS", "HEAD", "PATCH"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }
}