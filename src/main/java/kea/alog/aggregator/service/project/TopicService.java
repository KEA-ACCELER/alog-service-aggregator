package kea.alog.aggregator.service.project;

import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.web.constant.TopicSortType;
import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;

public interface TopicService {
    PageDto<TopicResponseDto> findAll(Long projectPk, String keyword, TopicSortType sortType,
        int page, int size);

    TopicResponseDto findByPk(Long projectPk, Long topicPk);
}
