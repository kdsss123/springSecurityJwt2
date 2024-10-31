package com.example.springsecurityjwt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInDto {
    private String username;
    private String password;

}
