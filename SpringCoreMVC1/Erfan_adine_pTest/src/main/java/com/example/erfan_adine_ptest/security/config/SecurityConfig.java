package com.example.erfan_adine_ptest.security.config;

import com.example.erfan_adine_ptest.service.BasePersonService;
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

    private final BasePersonService basePersonService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
// fixme     ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/js/**","/css/**" ).permitAll()
////                .antMatchers(HttpMethod.GET,"/student/**").hasAnyRole(ADMIN.name(),STUDENT.name())
////                .antMatchers(HttpMethod.POST,"/student/**").hasAnyAuthority(STUDENT_WRITE.getPermissionName())
////                .antMatchers(HttpMethod.PUT,"/student/**").hasAnyAuthority(STUDENT_WRITE.getPermissionName())
////                .antMatchers(HttpMethod.DELETE,"/student/**").hasAnyAuthority(STUDENT_WRITE.getPermissionName())
////               .antMatchers("/student/1").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();


        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/", "api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(basePersonService);
        return provider;
    }
}
