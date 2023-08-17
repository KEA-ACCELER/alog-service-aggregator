package kea.alog.aggregator.service.project;

import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.web.constant.ProjectSortType;
import kea.alog.aggregator.web.dto.ProjectDto.MyProjectResponseDto;
import kea.alog.aggregator.web.dto.ProjectDto.ProjectResponseDto;

public interface ProjectService {
    ProjectResponseDto findByPk(Long projectPk, Long userPk);

    PageDto<ProjectResponseDto> findAll(String keyword, ProjectSortType sortType, int page, int size, Long userPk);

    PageDto<MyProjectResponseDto> findMine(Long userPk, String keyword, ProjectSortType sortType, int page, int size, Long teamPk);
}
