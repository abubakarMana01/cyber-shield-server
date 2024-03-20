package com.project.cybershield.model.dto.mappers;

import com.project.cybershield.model.dto.UserResponseDTO;
import com.project.cybershield.model.dto.UserRegisterDTO;
import com.project.cybershield.model.entity.User;

public class UserDtoMapper {

    public static UserResponseDTO toUserResponseDTO(User user) {
        return UserResponseDTO
                .builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .securityQuestion(user.getSecurityQuestion())
                .build();
    }

    public static User toUser(UserRegisterDTO dto) {
        return User
                .builder()
                .fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .answer(dto.getAnswer())
                .securityQuestion(dto.getSecurityQuestion())
                .build();
    }
}
