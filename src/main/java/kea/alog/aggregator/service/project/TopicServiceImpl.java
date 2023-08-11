package kea.alog.aggregator.service.project;

import java.util.List;
import java.util.stream.Collectors;
import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.service.openfeign.project.TopicFeign;
import kea.alog.aggregator.service.user.UserService;
import kea.alog.aggregator.web.constant.TopicSortType;
import kea.alog.aggregator.web.dto.TopicDto.FeignTopicResponseDto;
import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicFeign topicFeign;
    private final UserFeign userFeign;
    private final UserService userService;

    @Override
    public PageDto<TopicResponseDto> findAll(Long projectPk, String keyword, TopicSortType sortType,
        int page, int size) {
        ResponseDto<PageDto<FeignTopicResponseDto>> response = topicFeign.findAll(projectPk,
            keyword, sortType, page, size);
        List<FeignTopicResponseDto> topics = response.getData().getContent();

        return PageDto.<TopicResponseDto>builder()
            .content(topics.stream().map(this::convertToTopicResponse).collect(
                Collectors.toList()))
            .totalPages(response.getData().getTotalPages())
            .totalElements(response.getData().getTotalElements())
            .pageNumber(response.getData().getPageNumber())
            .pageSize(response.getData().getPageSize())
            .build();
    }

    @Override
    public TopicResponseDto findByPk(Long projectPk, Long topicPk) {
        ResponseDto<FeignTopicResponseDto> response = topicFeign.findByPk(projectPk, topicPk);
        FeignTopicResponseDto topic = response.getData();

        return TopicResponseDto.builder().pk(topic.getPk()).projectPk(topic.getProjectPk())
                               .user(userFeign.findUserByPk(topic.getUserPk()))
                               .name(topic.getName()).description(topic.getDescription())
                               .startDate(topic.getStartDate()).dueDate(topic.getDueDate())
                               .createdAt(topic.getCreatedAt()).build();
    }

    private TopicResponseDto convertToTopicResponse(FeignTopicResponseDto topic) {
        UserResponseDto user = userService.findByPk(topic.getUserPk());

        return TopicResponseDto.builder().pk(topic.getPk()).projectPk(topic.getProjectPk())
            .user(user).name(topic.getName()).description(topic.getDescription()).startDate(topic.getStartDate())
            .dueDate(topic.getDueDate()).createdAt(topic.getCreatedAt()).build();
    }
}
