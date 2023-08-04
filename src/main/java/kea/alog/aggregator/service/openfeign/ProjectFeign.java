package kea.alog.aggregator.service.openfeign;

import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.web.dto.ProjectDto.FeignProjectResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "project-service",
    url = "${project.service.url}"
)
public interface ProjectFeign {
    @GetMapping("{projectPk}")
    public ResponseDto<FeignProjectResponseDto> findByPk(@PathVariable("projectPk") Long projectPk);
}
