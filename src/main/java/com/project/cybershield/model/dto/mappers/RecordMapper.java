package com.project.cybershield.model.dto.mappers;

import com.project.cybershield.model.dto.RecordDTO;
import com.project.cybershield.model.entity.Record;

public class RecordMapper {

    public static RecordDTO toDTO(Record record) {
        return RecordDTO.builder()
                .id(record.getId())
                .password(record.getPassword())
                .link(record.getLink())
                .name(record.getName())
                .userIdentifier(record.getUserIdentifier())
                .build();
    }

    public static Record toRecord(RecordDTO recordDto) {
        return Record.builder()
                .password(recordDto.getPassword())
                .link(recordDto.getLink())
                .name(recordDto.getName())
                .userIdentifier(recordDto.getUserIdentifier())
                .build();
    }
}
