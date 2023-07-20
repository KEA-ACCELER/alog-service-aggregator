package kea.alog.aggregator.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import kea.alog.aggregator.service.openfeign.UserFeign;

import kea.alog.aggregator.web.dto.UserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserFeign userFeign;
    
    @Transactional
    public Optional<Object> getUserInfo(HttpServletRequest request){
        //log.info("getUserInfo : " + request.getHeader("authorization"));
        return userFeign.GetUserInfo(request.getHeader("authorization"));
    }

}
