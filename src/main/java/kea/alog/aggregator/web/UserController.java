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



}
