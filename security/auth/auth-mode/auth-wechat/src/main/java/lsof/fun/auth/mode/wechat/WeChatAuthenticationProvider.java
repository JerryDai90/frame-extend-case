package lsof.fun.auth.mode.wechat;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class WeChatAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("WeChatAuthenticationProvider");

//
//        try {
//            Class.forName("lsof.fun.auth.mode.sms.SMSAuthenticationFilter");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        if( true ){
            throw new UsernameNotFoundException("222");
        }


        WeChatAuthenticationToken token = (WeChatAuthenticationToken) authentication;
        //验证code
        if(!"1111".equals(token.getCredentials())){
            throw new BadCredentialsException("验证码不对");
        }
        //TODO 构建权限，获取权限
        ArrayList<GrantedAuthority> grantedAuthorities = GrantedAuthority();
        WeChatAuthenticationToken newToken = new WeChatAuthenticationToken(token.getPrincipal(), token.getCredentials(), grantedAuthorities);

        return newToken;
    }
    private ArrayList<GrantedAuthority> GrantedAuthority() {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return grantedAuthorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return WeChatAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
