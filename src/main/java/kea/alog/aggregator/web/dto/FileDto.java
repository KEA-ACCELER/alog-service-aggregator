package kea.alog.aggregator.web.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class FileDto {

    @Getter
    @ToString 
    @NoArgsConstructor(access=AccessLevel.PROTECTED)
    public static class UploadFilesResponseDto{
        private Long filePk;

        private String fileName;

        private String filePath;

        private boolean fileDeleted;

    
}

}
