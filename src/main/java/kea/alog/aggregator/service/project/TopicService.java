package kea.alog.aggregator.service.project;

import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;

public interface TopicService {
    TopicResponseDto findTopic(Long projectPk, Long topicPk);
}
