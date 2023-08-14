package kea.alog.aggregator.service.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kea.alog.aggregator.web.dto.IssueDto.IssueCreateRequestDto;

@FeignClient(
    name = "issue-service",
    url = "${issue.service.url}"
)
public interface IssueFeign {
    
    @PostMapping(path = "/api/issue")
    public Long saveIssue(@RequestBody IssueCreateRequestDto issueCreateRequestDto, 
                        @RequestParam String fileLink);

}
