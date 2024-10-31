package com.example.springsecurityjwt.dto;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
public class JwtToken {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
