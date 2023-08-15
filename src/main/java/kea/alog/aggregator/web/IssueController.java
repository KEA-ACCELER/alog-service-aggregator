package kea.alog.aggregator.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PatchExchange;

import io.swagger.v3.oas.annotations.Operation;
import kea.alog.aggregator.service.issue.IssueService;
import kea.alog.aggregator.web.dto.IssueDto;


@RestController
@RequestMapping("/api/aggr/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Operation(summary = "이슈 생성", description = "파일 저장 후 이슈 서버에 링크 포함 전체 저장")
    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<Long> saveIssue(
            @RequestPart(value = "imgs") MultipartFile multipartFile,
            @RequestPart(value = "issue") IssueDto.IssueCreateRequestDto issueRequestDto) throws IOException {
            ArrayList<MultipartFile> multipartFileList = new ArrayList<>();
            multipartFileList.add(multipartFile);
        return ResponseEntity.ok(issueService.saveIssue(multipartFileList, issueRequestDto));
            }
    
    @Operation(summary = "이슈 이미지 변경", description = "이슈에 들어가는 이미지 변경")
    @PatchMapping(value = "/image", consumes = "multipart/form-data")
    public ResponseEntity<String> changeImage(
            @RequestPart(value = "imgs") MultipartFile multipartFile,
            @RequestPart(value = "issuePk") String issuePk) throws IOException {
            ArrayList<MultipartFile> multipartFileList = new ArrayList<>();
            multipartFileList.add(multipartFile);
        return ResponseEntity.ok(issueService.patchImage(Long.parseLong(issuePk), multipartFileList));
    }
    
}
