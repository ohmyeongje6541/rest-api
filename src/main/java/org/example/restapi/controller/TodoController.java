package org.example.restapi.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.TodoCreateRequestDto;
import org.example.restapi.dto.request.TodoUpdateRequest;
import org.example.restapi.dto.response.ApiResponse;
import org.example.restapi.dto.response.TodoResponse;
import org.example.restapi.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<ApiResponse<TodoResponse>> create(
        @Valid @RequestBody TodoCreateRequestDto request
    ) {
        TodoResponse response = todoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoResponse>>> findAll() {
        List<TodoResponse> responses = todoService.findAll();
        return ResponseEntity.ok(ApiResponse.success(responses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoResponse>> findById(
        @PathVariable Long id
    ) {
        TodoResponse response = todoService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
        @PathVariable Long id
    ) {
        todoService.delete(id);
        return ResponseEntity.ok(ApiResponse.success());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoResponse>> update(
        @PathVariable Long id,
        @Valid @RequestBody TodoUpdateRequest request
    ) {
        TodoResponse response = todoService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }


}
