package kea.alog.aggregator.service.openfeign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(
    name="user-service",
    url="${user.service.url}"
)
public interface UserFeign {
    
    @GetMapping(path="/info")
    public Optional<Object> GetUserInfo(@RequestHeader("authorization") String jwt);


}
