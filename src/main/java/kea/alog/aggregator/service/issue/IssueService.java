package kea.alog.aggregator.service.issue;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kea.alog.aggregator.web.dto.IssueDto.IssueCreateRequestDto;

public interface IssueService {
    
    public Long saveIssue(List<MultipartFile> multipartFileList, IssueCreateRequestDto issueCreateRequestDto);
}
