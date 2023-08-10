package kea.alog.aggregator.service.openfeign.project;

import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.config.JwtRequestFeignConfiguration;
import kea.alog.aggregator.web.dto.TopicDto.FeignTopicResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "project-topic-service",
    url = "${project.service.url}",
    configuration = JwtRequestFeignConfiguration.class
)
public interface TopicFeign {
    @GetMapping("{projectPk}/topics/{topicPk}")
    ResponseDto<FeignTopicResponseDto> findTopic(@PathVariable("projectPk") Long projectPk, @PathVariable("topicPk") Long topicPk);
}
