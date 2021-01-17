package com.kim.sequrity.config.auth;

// 시큐리티가 /login 주소요청시 로그인 시킴
// 로그인시 시큐리티 session 만듬 (Security ContextHolder)
// => Authentication

//시큐리티 세션 => Authentication 객체 저장 =>  userDetails 타입

import com.kim.sequrity.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {
    private User user;

    PrincipalDetails(User user){
        this.user = user;
    }

    //계정이 같고 있는 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        //new GrantedAuthority()
//        GrantedAuthority a = new GrantedAuthority(){
//            @Override
//            public String getAuthority() {
//                return null;
//            }
//        };
        collect.add(()-> user.getRole());

        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    //계정이 만료되었는지
    public boolean isAccountNonExpired() {
        //계정 만료
        return true;
    }

    @Override
    //계정 잠겼는지여부 true 안잠김
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // 비밀번호가 만료되지 않았는지 리턴 = true 만료 안됨
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 1년 로그인 아니할시 휴먼 계정
        return true;
    }
}
