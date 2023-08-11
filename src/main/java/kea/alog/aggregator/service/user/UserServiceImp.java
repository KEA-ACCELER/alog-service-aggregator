package kea.alog.aggregator.service.user;

import kea.alog.aggregator.service.openfeign.FileFeign;
import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.web.dto.FileDto.UploadFilesResponseDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService{

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private FileFeign fileFeign;

    public UserResponseDto findByPk(Long userPk){
        return userFeign.findUserByPk(userPk);
    }

    public String uploadProfileImage(List<MultipartFile> multipartFileList, Long userPk){
        List<UploadFilesResponseDto> uploadFilesResponseDtoList = fileFeign.uploadFiles(multipartFileList);
        //log.info("uploadFilesResponseDtoList: {}", uploadFilesResponseDtoList); 
        return userFeign.uploadImage(userPk, uploadFilesResponseDtoList.get(0).getFilePath());
    }

    @Override
    public String uploadTeamImage(List<MultipartFile> multipartFileList, Long teamPk, Long userPk) {

        List<UploadFilesResponseDto> uploadFilesResponseDtoList = fileFeign.uploadFiles(multipartFileList);
        //log.info("uploadFilesResponseDtoList: {}", uploadFilesResponseDtoList); 
        return userFeign.uploadTeamImage(teamPk, userPk, uploadFilesResponseDtoList.get(0).getFilePath());
        
    }



}
