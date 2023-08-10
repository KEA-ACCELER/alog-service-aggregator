package kea.alog.aggregator.web.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kea.alog.aggregator.common.dto.ResponseDto;
import kea.alog.aggregator.service.project.TopicService;
import kea.alog.aggregator.web.dto.TopicDto.TopicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aggr/projects/{projectPk}/topics")
@Tag(name = "topics", description = "토픽 API")
public class TopicController {

    private final TopicService topicService;

    @Operation(summary = "토픽 상세 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "403", description = "권한 없음", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "존재하지 않는 pk", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("{topicPk}")
    public ResponseDto<TopicResponseDto> findTopic(@PathVariable("projectPk") Long projectPk, @PathVariable("topicPk") Long topicPk) {
        return ResponseDto.success(200, topicService.findTopic(projectPk, topicPk));
    }
}
