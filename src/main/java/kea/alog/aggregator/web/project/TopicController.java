package kea.alog.aggregator.web.project;

import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.project.TopicService;
import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping("{projectPk}/topics/{topicPk}")
    public ResponseDto<TopicResponseDto> findTopic(@PathVariable("projectPk") Long projectPk, @PathVariable("topicPk") Long topicPk) {
        return ResponseDto.success(200, topicService.findTopic(projectPk, topicPk));
    }
}
