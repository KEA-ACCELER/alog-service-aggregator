package kea.alog.aggregator.web;

import kea.alog.aggregator.service.user.UserService;
import kea.alog.aggregator.service.user.UserServiceImp;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/aggr/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "유저 프로필 이미지 저장")
    @PostMapping(value = "/profile/image", consumes = "multipart/form-data")
    public ResponseEntity<String> saveUserImg(
            @RequestPart(value = "imgs") MultipartFile multipartFile,
            @RequestPart(value = "userPk") Long userPk) throws IOException {
            ArrayList<MultipartFile> multipartFileList = new ArrayList<>();
            multipartFileList.add(multipartFile);
        return ResponseEntity.ok(userService.uploadProfileImage(multipartFileList, userPk));
            }

    @Operation(summary = "팀 프로필 이미지 저장")
    @PostMapping(value = "/teams/image", consumes = "multipart/form-data")

    public ResponseEntity<String> saveTeamImg(
            @RequestPart(value = "imgs") MultipartFile multipartFile,
            @RequestPart(value = "teamPk") String t,
            @RequestPart(value = "userPk") String u) throws IOException {
            ArrayList<MultipartFile> multipartFileList = new ArrayList<>();
            multipartFileList.add(multipartFile);
            Long teamPk = Long.parseLong(t);
            Long userPk = Long.parseLong(u);
        return ResponseEntity.ok(userService.uploadTeamImage(multipartFileList, teamPk, userPk));
            }
}
