package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.config.SecurityUtil;
import com.example.springsecurityjwt.dto.JwtToken;
import com.example.springsecurityjwt.dto.MemberDto;
import com.example.springsecurityjwt.dto.SignInDto;
import com.example.springsecurityjwt.dto.SignUpDto;
import com.example.springsecurityjwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {
        String username = signInDto.getUsername();
        String password = signInDto.getPassword();
        JwtToken jwtToken = memberService.signIn(username, password);
        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}", jwtToken.getAccessToken());
        jwtToken.getRefreshToken();
        return jwtToken;
    }

    @PostMapping("/test")
    public String test(){
//        return "success";
        return SecurityUtil.getCurrentUsername();
    }

    @PostMapping("sign-up")
    public ResponseEntity<MemberDto> signUp(@RequestBody SignUpDto signUpDto) {
        MemberDto savedMemberDto = memberService.signUp(signUpDto);
        return ResponseEntity.ok(savedMemberDto);
    }


}
