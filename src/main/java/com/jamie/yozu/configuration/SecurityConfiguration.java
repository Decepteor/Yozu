package com.jamie.yozu.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.jamie.yozu.security.RoleVoter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private AuthenticationProvider authenticationProvider;
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder builder) {
    builder.authenticationProvider(authenticationProvider);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/static/**", "/test/**");
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/login", "/logout", "/static/images/**", "/logo/**").permitAll()
    
    .anyRequest().authenticated().accessDecisionManager(accessDecisionManage())
    .and().formLogin().loginPage("/login").successHandler(new SavedRequestAwareAuthenticationSuccessHandler()).defaultSuccessUrl("/messages")
    .and().logout().logoutUrl("/logout").invalidateHttpSession(true);
  }
  
  @Bean
  @SuppressWarnings("unchecked")
  public UnanimousBased accessDecisionManage() {
    List<AccessDecisionVoter<? extends Object>> voterList = new ArrayList<>();
    voterList.add(roleVoter());
    voterList.add(new WebExpressionVoter());
    voterList.add(new AuthenticatedVoter());
    return new UnanimousBased(voterList);
  }
  
  @Bean
  public RoleVoter roleVoter() {
    return new RoleVoter();
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
