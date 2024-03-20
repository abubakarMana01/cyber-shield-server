package com.project.cybershield.controller;

import com.project.cybershield.exception.UserAlreadyExistsException;
import com.project.cybershield.model.dto.RecordDTO;
import com.project.cybershield.model.entity.ApiResponse;
import com.project.cybershield.service.RecordService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    @GetMapping()
    private ResponseEntity<ApiResponse<List<RecordDTO>>> getUserRecords(@RequestParam Long userId) {
        List<RecordDTO> records = recordService.getUserRecords(userId);

        var body = ApiResponse.<List<RecordDTO>>builder()
                .data(records)
                .message("Success")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping("/add")
    private ResponseEntity<ApiResponse<RecordDTO>> addRecord(@Valid @RequestBody RecordDTO recordDTO, @RequestParam Long userId) throws UserAlreadyExistsException {
        RecordDTO createdRecord = recordService.addRecord(recordDTO, userId);

        var body = ApiResponse.<RecordDTO>builder()
                .data(createdRecord)
                .message("Success")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<ApiResponse<?>> deleteRecord(@RequestParam Long userId, @PathVariable Long recordId) {
        recordService.deleteRecord(recordId, userId);

        var body = ApiResponse.builder().message("Success").build();
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}
