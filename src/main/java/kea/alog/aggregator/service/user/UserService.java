package kea.alog.aggregator.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kea.alog.aggregator.web.dto.UserDto.*;

public interface UserService {
    UserResponseDto findByPk(Long userPk);

    String uploadProfileImage(List<MultipartFile> multipartFileList, Long userPk);

    String uploadTeamImage(List<MultipartFile> multipartFileList, Long teamPk, Long userPk);
}
