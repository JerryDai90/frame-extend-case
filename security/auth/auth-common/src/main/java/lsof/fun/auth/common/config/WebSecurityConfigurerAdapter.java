package lsof.fun.auth.common.config;

import lsof.fun.auth.common.IAuthSecurityConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.Collection;

@Configuration
@Order(100)
public class WebSecurityConfigurerAdapter extends org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter {


    public WebSecurityConfigurerAdapter() {
        System.out.println(getClass());

    }

    //由于5.x 版本是无法获取到 AuthenticationManager，需要声明
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        Collection<IAuthSecurityConfigurer> values = applicationContext.getBeansOfType(IAuthSecurityConfigurer.class).values();
        for (IAuthSecurityConfigurer auth : values){
            auth.configure(http, authenticationManager);
        }
    }
}
