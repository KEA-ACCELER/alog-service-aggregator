package kea.alog.aggregator.service.user;

import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

   private final UserFeign userFeign;

    public UserResponseDto findUserByPk(Long userPk){
        return userFeign.findUserByPk(userPk);
    }
}
