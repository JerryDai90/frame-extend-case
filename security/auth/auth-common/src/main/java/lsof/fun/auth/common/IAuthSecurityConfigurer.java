package lsof.fun.auth.common;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


/**
 * 认证配置.
 *
 * @author jerry
 * @date 2021 -01-09 22:50:50
 */
public interface IAuthSecurityConfigurer {
    /**
     * Configure.
     *
     * @param http                  http
     * @param authenticationManager authentication manager
     * @author jerry
     * @date 2021 -01-09 22:50:50
     */
    void configure(HttpSecurity http, AuthenticationManager authenticationManager);
}
