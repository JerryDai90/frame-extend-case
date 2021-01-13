package lsof.fun.auth.mode.sms;

import lsof.fun.auth.common.IAuthSecurityConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;


@Service
public class SMSSecurityConfigurerAdapter implements IAuthSecurityConfigurer {

    public void configure(HttpSecurity http, AuthenticationManager authenticationManager){
        http.authenticationProvider(new SMSAuthenticationProvider())
                .addFilterAt(new SMSAuthenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                ;
    }
}
