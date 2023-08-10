package kea.alog.aggregator.web.dto;

import java.time.LocalDateTime;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;

public class TopicDto {
    @Getter
    public static class FeignTopicResponseDto {
        private Long pk;
        private Long projectPk;
        private Long userPk;
        private String name;
        private String description;
        private LocalDateTime startDate;
        private LocalDateTime dueDate;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    public static class TopicResponseDto {
        private Long pk;
        private Long projectPk;
        private UserResponseDto user;
        private String name;
        private String description;
        private LocalDateTime startDate;
        private LocalDateTime dueDate;
        private LocalDateTime createdAt;
    }
}
