package com.project.cybershield.service.impl;

import com.project.cybershield.exception.UserAlreadyExistsException;
import com.project.cybershield.model.dto.RecordDTO;
import com.project.cybershield.model.dto.mappers.RecordMapper;
import com.project.cybershield.model.entity.Record;
import com.project.cybershield.model.entity.User;
import com.project.cybershield.repository.RecordRepository;
import com.project.cybershield.repository.UserRepository;
import com.project.cybershield.service.RecordService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final UserRepository userRepository;


    @Override
    public List<RecordDTO> getUserRecords(Long userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return recordRepository.findAllByUser(user)
                .stream().map(RecordMapper::toDTO)
                .toList();
    }

    @Override
    public RecordDTO addRecord(RecordDTO recordDTO, Long userId) throws UserAlreadyExistsException {
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Record record = Record.builder()
                .link(recordDTO.getLink())
                .password(recordDTO.getPassword())
                .name(recordDTO.getName())
                .userIdentifier(recordDTO.getUserIdentifier())
                .user(foundUser)
                .build();
        recordRepository.save(record);
        return RecordMapper.toDTO(record);
    }

    @Override
    public void deleteRecord(Long recordId, Long userId) {
        Record existingRecord = recordRepository.findById(recordId)
                .orElseThrow(() -> new EntityNotFoundException(("Record not found")));
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        recordRepository.deleteById(recordId);
    }
}
