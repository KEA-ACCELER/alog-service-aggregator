package kea.alog.aggregator.service.openfeign.project;

import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.config.JwtRequestFeignConfiguration;
import kea.alog.aggregator.web.constant.TopicSortType;
import kea.alog.aggregator.web.dto.TopicDto.FeignTopicResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "project-topic-service",
    url = "${project.service.url}",
    configuration = JwtRequestFeignConfiguration.class
)
public interface TopicFeign {

    @GetMapping("api/projects/{projectPk}/topics")
    ResponseDto<PageDto<FeignTopicResponseDto>> findAll(@PathVariable("projectPk") Long projectPk,
        @RequestParam("keyword") String keyword,
        @RequestParam("sortType") TopicSortType sortType,
        @RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping("api/projects/{projectPk}/topics/{topicPk}")
    ResponseDto<FeignTopicResponseDto> findByPk(@PathVariable("projectPk") Long projectPk,
        @PathVariable("topicPk") Long topicPk);
}
