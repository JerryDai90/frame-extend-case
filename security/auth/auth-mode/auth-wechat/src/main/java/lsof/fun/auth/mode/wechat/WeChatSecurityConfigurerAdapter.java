package lsof.fun.auth.mode.wechat;

import lsof.fun.auth.common.IAuthSecurityConfigurer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;


@Service
public class WeChatSecurityConfigurerAdapter implements IAuthSecurityConfigurer {

    public void configure(HttpSecurity http, AuthenticationManager authenticationManager){

        System.out.println(getClass());

        http.authenticationProvider(new WeChatAuthenticationProvider())
                .addFilterAt(new WeChatAuthenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                ;
    }
}
