package lsof.fun.auth.mode.sms;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SMSAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public SMSAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/smsLogin", "GET"));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String phone = request.getParameter("phone");
        String code = request.getParameter("code");
        SMSAuthenticationToken token = new SMSAuthenticationToken(phone, code);
        return getAuthenticationManager().authenticate(token);
    }
}
