package kea.alog.aggregator.web.dto;

import lombok.Builder;
import lombok.Getter;

public class ProjectMemberDto {
    @Getter
    @Builder
    public static class ProjectMemberResponseDto {
        private Long userPk;
        private String userNN;
        // TODO: user service에 profile 추가 예정
        //private String profile;
    }
}
