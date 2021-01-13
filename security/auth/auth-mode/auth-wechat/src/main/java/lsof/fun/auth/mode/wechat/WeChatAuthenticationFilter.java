package lsof.fun.auth.mode.wechat;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WeChatAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public WeChatAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/wechat", "GET"));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String phone = request.getParameter("phone");
        String code = request.getParameter("code");
        WeChatAuthenticationToken token = new WeChatAuthenticationToken(phone, code);
        return getAuthenticationManager().authenticate(token);
    }
}
