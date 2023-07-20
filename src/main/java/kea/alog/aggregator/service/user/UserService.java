package kea.alog.aggregator.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.utils.JwtUtil;
import kea.alog.aggregator.web.dto.UserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    private Long expireMS = 1000L * 60 * 60 * 24 * 7;// 1주일

    @Autowired
    UserFeign userFeign;
    
    @Transactional
    public Optional<Object> getUserInfo(HttpServletRequest request){
        //log.info("getUserInfo : " + request.getHeader("authorization"));
        return userFeign.GetUserInfo(request.getHeader("authorization"));
    }


    @Transactional
    public String login(UserDto.LoginRequestDto loginRequestDto){
        
        Optional<UserDto.LoginResponseDto> isSuccessed = userFeign.login(loginRequestDto);
        if (isSuccessed.isEmpty()) {
            return "login failed";
        }
        
        String token = JwtUtil.createJwt(isSuccessed.get().getUserPk(), isSuccessed.get().getUserNN(), loginRequestDto.getUserEmail(), secretKey, expireMS);
        System.out.println("token  " + token);
        
        return token;
    }

}
