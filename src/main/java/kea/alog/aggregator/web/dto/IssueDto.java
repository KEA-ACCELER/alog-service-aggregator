package kea.alog.aggregator.web.dto;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class IssueDto {

    @Getter
    @NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
    @ToString
    public static class IssueOriginalDto {
        private Long issuePk;
        private Long pjPk;
        private Long teamPk;
        private Long topicPk;
        private Long issueAuthorPk;
        private String issueContent;
        private String issueStatus;
        private String issueLabel;
        private Long issueAssigneePk;
        private String issueId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String fileLink;
    }

    @Getter
    @NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
    @ToString
    public static class IssueCreateRequestDto {
        private Long pjPk;
        private Long teamPk;
        private Long topicPk;
        private Long issueAuthorPk;
        private String issueContent;
        private String issueStatus;
        private String issueLabel;
        @Nullable
        private Long issueAssigneePk;
        private String issueId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

    }
}
