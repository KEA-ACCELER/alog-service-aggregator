package kea.alog.aggregator.web.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LoginRequestDto{
        private String userEmail;
        private String userPw;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LoginResponseDto{
        private Long userPk;
        private String userNN;
    }

    @Getter
    public static class UserResponseDto {
        private Long userPk;
        private String email;
        private String userNN;
        // TODO: user service에 profile 추가 예정
        // private String profile;
    }
}
