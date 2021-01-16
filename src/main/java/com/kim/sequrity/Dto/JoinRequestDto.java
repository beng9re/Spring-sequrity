package com.kim.sequrity.Dto;

import com.kim.sequrity.domain.User;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class JoinRequestDto {
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private String email;

    @Builder
    JoinRequestDto(String username, String password, String email){
        this.username=username;
        this.password=password;
        this.email=email;
    }

    public User toEntity(){
        return new User().builder()
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .build();
    }
}
