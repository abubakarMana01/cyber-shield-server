package com.project.cybershield.service;

import com.project.cybershield.exception.UserAlreadyExistsException;
import com.project.cybershield.model.dto.RecordDTO;

import java.util.List;

public interface RecordService {
    List<RecordDTO> getUserRecords(Long userId);

    RecordDTO addRecord(RecordDTO recordDTO, Long userId) throws UserAlreadyExistsException;

    void deleteRecord(Long recordId, Long userId);
}
