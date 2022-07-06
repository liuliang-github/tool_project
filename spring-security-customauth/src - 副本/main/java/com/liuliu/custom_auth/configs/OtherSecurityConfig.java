package com.liuliu.custom_auth.configs;

import com.liuliu.custom_auth.security.CustomerOtherAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author LL
 * @date 2022/6/27 23:05
 * @Description
 */
@Configuration
public class OtherSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomerOtherAuthenticationProvider customerOtherAuthenticationProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(customerOtherAuthenticationProvider);
    }

}
