package kea.alog.aggregator.service.openfeign.project;

import kea.alog.aggregator.common.dto.PageDto;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.config.JwtRequestFeignConfiguration;
import kea.alog.aggregator.web.constant.ProjectSortType;
import kea.alog.aggregator.web.dto.ProjectDto.FeignMyProjectResponseDto;
import kea.alog.aggregator.web.dto.ProjectDto.FeignProjectResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "project-service",
    url = "${project.service.url}",
    configuration = JwtRequestFeignConfiguration.class
)
public interface ProjectFeign {
    @GetMapping("{projectPk}")
    ResponseDto<FeignProjectResponseDto> findByPk(@PathVariable("projectPk") Long projectPk);

    @GetMapping()
    ResponseDto<PageDto<FeignProjectResponseDto>> findAll(@RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam("sortType") ProjectSortType sortType, @RequestParam("page") int page,
        @RequestParam("size") int size);

    @GetMapping("{projectPk}/members")
    ResponseDto<PageDto<Long>> findMembers(@PathVariable("projectPk") Long projectPk, @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping("mine")
    ResponseDto<PageDto<FeignMyProjectResponseDto>> findMine(@RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam("sortType") ProjectSortType sortType, @RequestParam("page") int page,
        @RequestParam("size") int size);
}
