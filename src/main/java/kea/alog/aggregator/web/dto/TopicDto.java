package kea.alog.aggregator.web.dto;

import java.time.LocalDateTime;
import lombok.Getter;

public class TopicDto {
    @Getter
    public static class FeignTopicResponseDto {
        private Long pk;
        private Long projectPk;
        private String name;
        private String description;
        private LocalDateTime startDate;
        private LocalDateTime dueDate;
        private LocalDateTime createdAt;
    }
}
