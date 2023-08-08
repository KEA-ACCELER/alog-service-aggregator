package kea.alog.aggregator.service.project;

import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.web.constant.ProjectSortType;
import kea.alog.aggregator.web.dto.ProjectDto.ProjectResponseDto;
import kea.alog.aggregator.web.dto.ProjectMemberDto.ProjectMemberResponseDto;

public interface ProjectService {
    ProjectResponseDto findByPk(Long projectPk);

    PageDto<ProjectResponseDto> findAll(String keyword, ProjectSortType sortType, int page, int size);

    PageDto<ProjectMemberResponseDto> findMembers(Long projectPk, String keyword, int page, int size);
}
