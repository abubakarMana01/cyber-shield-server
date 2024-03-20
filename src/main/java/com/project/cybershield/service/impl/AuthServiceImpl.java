package com.project.cybershield.service.impl;

import com.project.cybershield.exception.PasswordMismatchException;
import com.project.cybershield.exception.SecurityAnswerMismatchException;
import com.project.cybershield.exception.UserAlreadyExistsException;
import com.project.cybershield.model.dto.SecurityQuestionRequestDTO;
import com.project.cybershield.model.dto.UserResponseDTO;
import com.project.cybershield.model.dto.UserLoginDTO;
import com.project.cybershield.model.dto.UserRegisterDTO;
import com.project.cybershield.model.dto.mappers.UserDtoMapper;
import com.project.cybershield.model.entity.User;
import com.project.cybershield.repository.UserRepository;
import com.project.cybershield.service.AuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO login(UserLoginDTO loginDTO) throws PasswordMismatchException {
        User user = userRepository
                .findByPhoneNumber(loginDTO.getPhoneNumber())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new PasswordMismatchException("Password doesn't match");
        }

        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .securityQuestion(user.getSecurityQuestion())
                .build();
    }

    @Override
    public UserResponseDTO register(UserRegisterDTO registerDTO) throws UserAlreadyExistsException {
        Optional<User> existingUser = userRepository.findByPhoneNumber(registerDTO.getPhoneNumber());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User newUser = User.builder()
                .fullName(registerDTO.getFullName())
                .phoneNumber(registerDTO.getPhoneNumber())
                .securityQuestion(registerDTO.getSecurityQuestion())
                .password(registerDTO.getPassword())
                .answer(registerDTO.getAnswer().toLowerCase())
                .build();
        return UserDtoMapper
                .toUserResponseDTO(
                        userRepository.save(newUser)
                );
    }

    @Override
    public void validateSecurityQuestion(SecurityQuestionRequestDTO requestDTO) throws SecurityAnswerMismatchException {
        User user = userRepository
                .findByPhoneNumber(requestDTO.getPhoneNumber())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (!user.getAnswer().equals(requestDTO.getAnswer().toLowerCase())) {
            throw new SecurityAnswerMismatchException("Answer to security question is invalid");
        }
    }
}
