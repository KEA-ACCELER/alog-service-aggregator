package kea.alog.aggregator.service.project;

import java.util.ArrayList;
import java.util.List;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.openfeign.ProjectFeign;
import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.web.dto.ProjectDto.FeignProjectResponseDto;
import kea.alog.aggregator.web.dto.ProjectDto.ProjectResponseDto;
import kea.alog.aggregator.web.dto.TeamDto.TeamResponseDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImp implements ProjectService {

    private final UserFeign userFeign;
    private final ProjectFeign projectFeign;

    @Override
    public ProjectResponseDto findByPk(Long projectPk) {
        ResponseDto<FeignProjectResponseDto> response = projectFeign.FindByPk(projectPk);
        FeignProjectResponseDto project = response.getData();

        UserResponseDto pm = userFeign.findUserByPk(project.getPmPk());

        List<UserResponseDto> projectMembers = new ArrayList<>();
        for (Long userPk: project.getProjectMembers()){
            projectMembers.add(userFeign.findUserByPk(userPk));
        }

        TeamResponseDto team = userFeign.findTeamByPk(projectPk, project.getTeamPk());

        return ProjectResponseDto.builder().pk(projectPk).name(project.getName())
                                 .description(project.getDescription()).team(team).pm(pm)
                                 .topics(project.getTopics()).projectMembers(projectMembers)
                                 .createdAt(project.getCreatedAt()).build();
    }
}
