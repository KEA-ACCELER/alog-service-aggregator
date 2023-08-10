package kea.alog.aggregator.web.dto;

import java.time.LocalDateTime;
import java.util.List;
import kea.alog.aggregator.web.dto.TeamDto.TeamResponseDto;
import kea.alog.aggregator.web.dto.TopicDto.FeignTopicResponseDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;

public class ProjectDto {
    @Getter
    public static class FeignProjectResponseDto {
        private Long pk;
        private String name;
        private String description;
        private Long teamPk;
        private Long pmPk;
        private List<FeignTopicResponseDto> topics;
        private List<Long> projectMembers;
        private LocalDateTime createdAt;
    }

    @Getter
    public static class FeignMyProjectResponseDto {
        private Long pk;
        private String name;
        private String description;
        private Long teamPk;
        private Long pmPk;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    public static class ProjectResponseDto {
        private Long pk;
        private String name;
        private String description;
        private TeamResponseDto team;
        private UserResponseDto pm;
        private List<FeignTopicResponseDto> topics;
        private List<UserResponseDto> projectMembers;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    public static class MyProjectResponseDto {
        private Long pk;
        private String name;
        private String description;
        private TeamResponseDto team;
        private UserResponseDto pm;
        private LocalDateTime createdAt;
    }
}
