package kea.alog.aggregator.service.project;

import kea.alog.aggregator.web.dto.ProjectDto.ProjectResponseDto;

public interface ProjectService {
    ProjectResponseDto findByPk(Long projectPk);
}
