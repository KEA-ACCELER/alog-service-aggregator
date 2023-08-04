package kea.alog.aggregator.web;

import kea.alog.aggregator.service.user.UserServiceImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aggr/users")
public class UserController {

    UserServiceImp userService;
}
