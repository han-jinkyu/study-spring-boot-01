package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 * https://docs.spring.io/spring-security/site/docs/current/guides/html5/helloworld-boot.html
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 설정한다
     * @throws Exception 모든 예외
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                                    // request를 인증한다
                .antMatchers("/css/**", "/index").permitAll()       // /css/**와 /index 주소는 모두 허용(permit all)
                .antMatchers("/user/**").hasRole("USER")            // /user/**는 사용자 인증이 필요하고 USER 롤을 갖고 있어야 된다
                .and()
            .formLogin()                                            // 폼 로그인
                .loginPage("/login").failureUrl("/login-error");    // 커스텀 로그인을 이용한 폼 기반 인증이 활성화된다. 
                                                                    // 그리고 실패하면 /login-error로 이동
    }

    /**
     * 글로벌 설정
     * @param auth 인증 매니저 빌더
     * @throws Exception 모든 예외
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()            // 인메모리 인증
                .withUser("user")
                .password("{noop}password")     // (지금은 사용하지 않기 때문에) {noop}를 붙여야 PasswordEncoder에러가 사라진다 
                .roles("USER");                 // user/password는 USER 권한을 준다
    }
}