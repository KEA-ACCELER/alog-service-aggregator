package kea.alog.aggregator.web.dto;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import lombok.Builder;
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

        @Builder
        public IssueCreateRequestDto(Long pjPk, Long teamPk, Long topicPk, Long issueAuthorPk, String issueContent,
                String issueStatus, String issueLabel, Long issueAssigneePk, String issueId, String startDate,
                String endDate) {
            this.pjPk = pjPk;
            this.teamPk = teamPk;
            this.topicPk = topicPk;
            this.issueAuthorPk = issueAuthorPk;
            this.issueContent = issueContent;
            this.issueStatus = issueStatus;
            this.issueLabel = issueLabel;
            this.issueAssigneePk = issueAssigneePk;
            this.issueId = issueId;
            this.startDate = LocalDateTime.parse(startDate);
            this.endDate = LocalDateTime.parse(endDate);
        }
    }
}
