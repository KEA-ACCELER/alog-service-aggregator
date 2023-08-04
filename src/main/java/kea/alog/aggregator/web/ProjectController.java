package kea.alog.aggregator.web;

import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.project.ProjectService;
import kea.alog.aggregator.web.dto.ProjectDto.ProjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aggr/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("{projectPk}")
    public ResponseDto<ProjectResponseDto> findByPk(@PathVariable("projectPk") Long projectPk){
        return ResponseDto.success(200, projectService.findByPk(projectPk));
    }
}
