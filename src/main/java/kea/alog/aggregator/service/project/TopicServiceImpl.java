package kea.alog.aggregator.service.project;

import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.service.openfeign.project.TopicFeign;
import kea.alog.aggregator.web.dto.TopicDto.FeignTopicResponseDto;
import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService{

    private final TopicFeign topicFeign;
    private final UserFeign userFeign;

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
}
