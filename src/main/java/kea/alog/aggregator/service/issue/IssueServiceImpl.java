package kea.alog.aggregator.service.issue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kea.alog.aggregator.service.openfeign.FileFeign;
import kea.alog.aggregator.service.openfeign.IssueFeign;
import kea.alog.aggregator.web.dto.FileDto.UploadFilesResponseDto;
import kea.alog.aggregator.web.dto.IssueDto.IssueCreateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueServiceImpl implements IssueService{

    @Autowired
    private IssueFeign issueFeign;
    
    @Autowired
    private FileFeign fileFeign;

    @Override
    public Long saveIssue(List<MultipartFile> multipartFileList, IssueCreateRequestDto issueCreateRequestDto) {
        
        List<UploadFilesResponseDto> uploadFilesResponseDtoList = fileFeign.uploadFiles(multipartFileList);
        //log.info("IssueCreateRequestDto: {}", issueCreateRequestDto.toString());
        return issueFeign.saveIssue( issueCreateRequestDto, uploadFilesResponseDtoList.get(0).getFilePath());

    }

    @Override
    public String patchImage(Long issuePk, List<MultipartFile> multipartFileList) {
        List<UploadFilesResponseDto> uploadFilesResponseDtoList = fileFeign.uploadFiles(multipartFileList);
        return issueFeign.changeImage(issuePk, uploadFilesResponseDtoList.get(0).getFilePath());
    }

    
}
