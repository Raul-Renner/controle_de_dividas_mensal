package com.casa.contas.projeto_contas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.POST, "/login");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .headers().frameOptions().sameOrigin().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/devedor").hasAuthority("Administrador")
                .antMatchers(HttpMethod.GET, "/{devedorId}/devedor-dividas").hasAuthority("Administrador")
                .antMatchers(HttpMethod.DELETE, "/devedor/{devedorId}").hasAuthority("Administrador")
                .antMatchers(HttpMethod.PUT, "/atualiza-devedor").hasAuthority("Administrador")
                .antMatchers(HttpMethod.PUT, "/devedor/atualizar-divida-total").hasAuthority("Administrador")
                .antMatchers(HttpMethod.GET, "/devedores").hasAuthority("Administrador")
                .antMatchers(HttpMethod.POST, "/{devedorId}/addDivida").hasAuthority("Administrador")
                .antMatchers(HttpMethod.DELETE, "/excluir-divida/{dividaId}").hasAuthority("Administrador")
                .antMatchers(HttpMethod.PUT, "/{devedorId}/atualizar_divida").hasAuthority("Administrador")
                .antMatchers(HttpMethod.PUT, "/{devedorId}/atualizar_divida").hasAuthority("Administrador")
                .antMatchers(HttpMethod.PUT, "/{devedorId}/atualizar_divida").hasAuthority("Administrador")

                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtProvider));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
