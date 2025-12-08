package org.example.restapi.exception;

import java.util.stream.Collectors;
import org.example.restapi.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // customException 처리
    @ExceptionHandler
    public ResponseEntity<ApiResponse<Void>> handlerCustomException(CustomException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus())
            .body(ApiResponse.error(errorCode.getCode(), errorCode.getMessage()));
    }
    // validation 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        //제목은 필수입니다., 내용은 500자 이하입니다
        String message = ex.getBindingResult().getFieldErrors().stream()
            .map(FieldError::getDefaultMessage)
            .collect(Collectors.joining(", "));

        return ResponseEntity.badRequest()
            .body(ApiResponse.error("VALIDATION_ERROR", message));
    }

    // 그 외 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handlerException(Exception ex) {
        return ResponseEntity.internalServerError()
            .body(ApiResponse.error("INTERNAL_ERROR", "서버 오류가 발생했습니다"));
    }
}
