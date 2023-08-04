package kea.alog.aggregator.service.user;

import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;

public interface UserService {
    UserResponseDto findUserByPk(Long userPk);
}
