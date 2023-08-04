package kea.alog.aggregator.web.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

public class TeamDto {
    @Getter
    @Builder
    public static class TeamResponseDto {
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
        private Long teamPk;
        private String teamName;
        private Long teamLeaderPk;
    }
}
