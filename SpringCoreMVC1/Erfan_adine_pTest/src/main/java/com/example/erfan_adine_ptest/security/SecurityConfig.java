package com.example.erfan_adine_ptest.security;

import com.example.spring_security2.service.UserManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserManagement userManagement;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**","/js/**","/css/**","/" ).permitAll()
//                .antMatchers(HttpMethod.GET,"/student/**").hasAnyRole(ADMIN.name(),STUDENT.name())
//                .antMatchers(HttpMethod.POST,"/student/**").hasAnyAuthority(STUDENT_WRITE.getPermissionName())
//                .antMatchers(HttpMethod.PUT,"/student/**").hasAnyAuthority(STUDENT_WRITE.getPermissionName())
//                .antMatchers(HttpMethod.DELETE,"/student/**").hasAnyAuthority(STUDENT_WRITE.getPermissionName())
//               .antMatchers("/student/1").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userManagement);
        return provider;
    }


//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails erfan = User.builder()
//                .username("erfan")
//                .password(passwordEncoder().encode("123"))
////                .roles("STUDENT")
//                .authorities(STUDENT.getAuthority())
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("123"))
////                .roles("Admin")
//                .authorities(ADMIN.getAuthority())
//                .build();
//
//        return new InMemoryUserDetailsManager(erfan,admin);
//
//
//
//    }
}
