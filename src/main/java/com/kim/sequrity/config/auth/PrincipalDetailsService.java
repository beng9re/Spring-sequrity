package com.kim.sequrity.config.auth;

import com.kim.sequrity.domain.User;
import com.kim.sequrity.domain.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 logginProcessingUrL 로그인 요청이 오면 자동으로 UserDetailsService 타입으로 아래함수가 실행
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User userEntity = userRepository.findByUsername(username);
        if(userEntity !=null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
