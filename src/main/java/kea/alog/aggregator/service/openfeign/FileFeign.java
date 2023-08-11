package kea.alog.aggregator.service.openfeign;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kea.alog.aggregator.web.dto.FileDto;

@FeignClient(
    name="file-service",
    url="${file.service.url}"
)
public interface FileFeign {
    
    @PostMapping(path="/api/files", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    List<FileDto.UploadFilesResponseDto> uploadFiles(@RequestPart(value = "imgs") List<MultipartFile> uploadFiles);
}
