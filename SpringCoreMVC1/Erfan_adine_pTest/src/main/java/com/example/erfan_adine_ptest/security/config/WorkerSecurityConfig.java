package com.example.erfan_adine_ptest.security.config;

import com.example.erfan_adine_ptest.service.WorkerService;
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
public class WorkerSecurityConfig extends WebSecurityConfigurerAdapter {

    private final WorkerService workerService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/manager/**","/js/**","/css/**","/","/permission/**","/role/**" ).permitAll()
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
        provider.setUserDetailsService(workerService);
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
