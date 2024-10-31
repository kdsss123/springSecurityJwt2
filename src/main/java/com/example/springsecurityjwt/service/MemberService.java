package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.dto.JwtToken;
import com.example.springsecurityjwt.dto.MemberDto;
import com.example.springsecurityjwt.dto.SignUpDto;


public interface MemberService {
    JwtToken signIn(String username, String password);
    MemberDto signUp(SignUpDto signUpDto);
}
