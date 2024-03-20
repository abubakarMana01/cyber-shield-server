package com.project.cybershield.service;

import com.project.cybershield.exception.PasswordMismatchException;
import com.project.cybershield.exception.SecurityAnswerMismatchException;
import com.project.cybershield.exception.UserAlreadyExistsException;
import com.project.cybershield.model.dto.SecurityQuestionRequestDTO;
import com.project.cybershield.model.dto.UserResponseDTO;
import com.project.cybershield.model.dto.UserLoginDTO;
import com.project.cybershield.model.dto.UserRegisterDTO;

public interface AuthService {

    UserResponseDTO login(UserLoginDTO loginDTO) throws PasswordMismatchException;

    UserResponseDTO register(UserRegisterDTO registerDTO) throws UserAlreadyExistsException;

    void validateSecurityQuestion(SecurityQuestionRequestDTO requestDTO) throws SecurityAnswerMismatchException;
}
