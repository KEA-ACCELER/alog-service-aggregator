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
    
    @GetMapping(path="info/{userPk}")
    UserResponseDto findUserByPk(@PathVariable("userPk") Long userPk);

    @GetMapping(path="teams")
    TeamResponseDto findTeamByPk(@RequestParam("teamPk") Long teamPk, @RequestParam("userPk") Long userPk);
}
