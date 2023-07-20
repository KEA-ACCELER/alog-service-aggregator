package kea.alog.aggregator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import kea.alog.aggregator.service.user.UserService;
import kea.alog.aggregator.web.dto.UserDto;
import kea.alog.aggregator.web.dto.UserDto.LoginRequestDto;

@RestController
@RequestMapping("/api/aggr")
public class UserController {
    
    @Autowired
    UserService userService;

    @Operation(summary = "회원가입", description = "회원가입")
    @ApiResponse(responseCode = "201", description = "return : userNn \n 사용예시 : userNn님 환영합니다")
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.login(loginRequestDto));
    
    
    }

}
