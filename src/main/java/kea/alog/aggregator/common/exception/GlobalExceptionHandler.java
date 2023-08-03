package kea.alog.aggregator.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import kea.alog.aggregator.common.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public Object handleFeignException(FeignException e){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Object errBody = objectMapper.readTree(e.contentUTF8());
            return ResponseEntity.status(e.status()).body(errBody);
        }
        catch (Exception ex) {
            return ResponseEntity.status(500).body(ResponseDto.builder().code(500).message("INTERNAL_SERVER_ERR").build());
        }
    }
}
