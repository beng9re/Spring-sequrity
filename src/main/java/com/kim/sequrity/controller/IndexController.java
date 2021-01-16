package com.kim.sequrity.controller;

import com.kim.sequrity.Dto.JoinRequestDto;
import com.kim.sequrity.domain.User;
import com.kim.sequrity.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //View 리턴
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(JoinRequestDto dto) {
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        User user = dto.toEntity();
        user.setRole("ROLE_USER");
        userRepository.save(user);
        System.out.println(user);

        return "redirect:/loginForm";
    }

    //. 단어선택 : ctrl + g,
    //ctrl + w. (누를때마다 같은 파일에 있는 같은 단어 선택됨).





}
