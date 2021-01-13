package lsof.fun.auth.mode.sms;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class SMSAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("SMSAuthenticationProvider");

        if( true ){
            throw new UsernameNotFoundException("222");
        }


        SMSAuthenticationToken token = (SMSAuthenticationToken) authentication;
        //验证code
        if(!"1111".equals(token.getCredentials())){
            throw new BadCredentialsException("验证码不对");
        }
        //TODO 构建权限，获取权限
        ArrayList<GrantedAuthority> grantedAuthorities = GrantedAuthority();
        SMSAuthenticationToken newToken = new SMSAuthenticationToken(token.getPrincipal(), token.getCredentials(), grantedAuthorities);

        return newToken;
    }
    private ArrayList<GrantedAuthority> GrantedAuthority() {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return grantedAuthorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return SMSAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
