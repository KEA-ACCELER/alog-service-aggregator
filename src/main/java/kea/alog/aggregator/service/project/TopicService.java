package kea.alog.aggregator.service.project;

import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;

public interface TopicService {
    TopicResponseDto findByPk(Long projectPk, Long topicPk);
}
