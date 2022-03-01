package com.example.erfan_adine_ptest.security.config;

import com.example.erfan_adine_ptest.security.filter.CustomAuthenticationFilter;
import com.example.erfan_adine_ptest.security.filter.CustomAuthorizationFilter;
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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  final PasswordEncoder passwordEncoder;
    private final BasePersonService basePersonService;
    private final SecretKey secretKey;
    private final JwtConfig config;


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
//                .addFilter()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new CustomAuthenticationFilter(secretKey,authenticationManager(),config))
                .addFilterAfter(new CustomAuthorizationFilter(secretKey,config) ,CustomAuthenticationFilter.class )
                .authorizeRequests().antMatchers( "/api/BasePerson/login","/api/BasePerson/create" ,"/api/BasePerson/test").permitAll()
                .anyRequest().authenticated();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(basePersonService);
        return provider;
    }
}
