package kea.alog.aggregator.service.project;

import java.util.List;
import java.util.stream.Collectors;
import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.openfeign.UserFeign;
import kea.alog.aggregator.service.openfeign.project.ProjectFeign;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImp implements  ProjectMemberService{

    private final UserFeign userFeign;
    private final ProjectFeign projectFeign;

    @Override
    public PageDto<UserResponseDto> findAll(Long projectPk, String keyword, int page,
        int size) {
        ResponseDto<PageDto<Long>> response = projectFeign.findMembers(projectPk, keyword, page, size);
        List<Long> userPks = response.getData().getContent();
        List<UserResponseDto> user = userPks.stream().map(userPk -> userFeign.findUserByPk(userPk)).collect(Collectors.toList());

        return PageDto.<UserResponseDto>builder().content(user)
            .totalPages(response.getData().getTotalPages())
            .totalElements(response.getData().getTotalElements())
            .pageNumber(response.getData().getPageNumber())
            .pageSize(response.getData().getPageSize())
            .build();
    }
}
