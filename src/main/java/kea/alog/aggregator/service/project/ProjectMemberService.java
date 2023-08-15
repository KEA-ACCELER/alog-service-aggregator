package kea.alog.aggregator.service.project;

import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;

public interface ProjectMemberService {
    PageDto<UserResponseDto> findAll(Long projectPk, String keyword, int page, int size);
}
