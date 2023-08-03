package kea.alog.aggregator.common.exception;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import kea.alog.aggregator.common.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.class)
    protected ResponseEntity<ResponseDto> handleFeignException(FeignException e){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode errBody = objectMapper.readTree(e.contentUTF8());
            int code = errBody.get("code").asInt();
            String message = errBody.get("message").asText();
            return ResponseEntity.status(code).body(
                ResponseDto.fail(code, message)
            );
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ResponseDto.fail(500, "INTERNAL_SERVER_ERR")
            );
        }
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseDto> handleException(
        Exception e
    ) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ResponseDto.fail(500, "INTERNAL_SERVER_ERR")
        );
    }
}
