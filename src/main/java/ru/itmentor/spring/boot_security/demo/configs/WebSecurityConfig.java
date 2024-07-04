package ru.itmentor.spring.boot_security.demo.configs;


import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/user","/allusers").hasAnyRole("USER", "ADMIN")
                .antMatchers("/save-user", "/delete-user", "/update-user").hasRole("ADMIN")
                .anyRequest().hasRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


//
//@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .cors().disable()
//                .authorizeRequests(authorize -> authorize
//                        .antMatchers("/", "/login").permitAll()
//                        .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers("/save-user", "/delete-user", "/update-user").hasRole("ADMIN")
//                        .anyRequest().hasRole("ADMIN")
//                )
//                .formLogin().loginPage("/login").defaultSuccessUrl("/user", true)
//                .and()
//                .logout().permitAll()
//                .and()
//                .build();
//    }
//
//    // Здесь конфигурируем менеджера аутентификацим
//    @Bean
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }
