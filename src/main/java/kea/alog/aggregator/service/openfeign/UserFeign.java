package kea.alog.aggregator.service.openfeign;

import kea.alog.aggregator.web.dto.TeamDto.TeamResponseDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(
    name="user-service",
    url="${user.service.url}"
)
public interface UserFeign {
    
    @GetMapping(path="api/users/info/{userPk}")
    UserResponseDto findUserByPk(@PathVariable("userPk") Long userPk);

    // TODO: user service에 jwt 도입 시 변경될 부분
    @GetMapping(path="api/users/teams")
    TeamResponseDto findTeamByPk(@RequestParam("teamPk") Long teamPk, @RequestParam("userPk") Long userPk);
}
