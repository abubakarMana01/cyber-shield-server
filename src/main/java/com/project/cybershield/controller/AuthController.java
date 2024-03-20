package com.project.cybershield.controller;

import com.project.cybershield.exception.PasswordMismatchException;
import com.project.cybershield.exception.SecurityAnswerMismatchException;
import com.project.cybershield.exception.UserAlreadyExistsException;
import com.project.cybershield.model.dto.SecurityQuestionRequestDTO;
import com.project.cybershield.model.dto.UserResponseDTO;
import com.project.cybershield.model.dto.UserLoginDTO;
import com.project.cybershield.model.dto.UserRegisterDTO;
import com.project.cybershield.model.entity.ApiResponse;
import com.project.cybershield.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    private ResponseEntity<ApiResponse<UserResponseDTO>> login(@Valid @RequestBody UserLoginDTO loginDTO) throws PasswordMismatchException {
        UserResponseDTO user =  authService.login(loginDTO);

        ApiResponse<UserResponseDTO> body = ApiResponse.<UserResponseDTO>builder().data(user).message("Success").build();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping("/register")
    private ResponseEntity<ApiResponse<UserResponseDTO>> register(@Valid @RequestBody UserRegisterDTO registerDTO) throws UserAlreadyExistsException {
        UserResponseDTO user =  authService.register(registerDTO);

        ApiResponse<UserResponseDTO> body = ApiResponse.<UserResponseDTO>builder().data(user).message("Success").build();
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PostMapping("/validate-security-question")
    private ResponseEntity<ApiResponse<?>> validateSecurityQuestion(@Valid @RequestBody SecurityQuestionRequestDTO requestDTO) throws SecurityAnswerMismatchException {
        authService.validateSecurityQuestion(requestDTO);

        ApiResponse<UserResponseDTO> body = ApiResponse.<UserResponseDTO>builder().message("Success").build();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
