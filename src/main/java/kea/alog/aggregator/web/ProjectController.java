package kea.alog.aggregator.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.project.ProjectService;
import kea.alog.aggregator.web.constant.ProjectSortType;
import kea.alog.aggregator.web.dto.ProjectDto.ProjectResponseDto;
import kea.alog.aggregator.web.dto.ProjectMemberDto.ProjectMemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aggr/projects")
@Tag(name = "projects", description = "프로젝트 API")
public class ProjectController {
    private final ProjectService projectService;

    @Operation(summary = "프로젝트 상세 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "404", description = "존재하지 않는 프로젝트 pk", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("{projectPk}")
    public ResponseDto<ProjectResponseDto> findByPk(@PathVariable("projectPk") Long projectPk){
        return ResponseDto.success(200, projectService.findByPk(projectPk));
    }

    @Operation(summary = "프로젝트 전체 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "400", description = "유효하지 않은 입력 값", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping()
    public ResponseDto<PageDto<ProjectResponseDto>> findAll(@RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam("sortType") ProjectSortType sortType, @RequestParam("page") int page,
        @RequestParam("size") int size){
        return ResponseDto.success(200, projectService.findAll(keyword, sortType, page, size));
    }

    @Operation(summary = "프로젝트 멤버 전체 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "404", description = "존재하지 않는 projectPk", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("{projectPk}/members")
    public ResponseDto<PageDto<ProjectMemberResponseDto>> findMembers(@PathVariable("projectPk") Long projectPk, @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseDto.success(200, projectService.findMembers(projectPk, keyword, page, size));
    }
}
