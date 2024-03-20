package com.project.cybershield.model.entity;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class ApiResponse<T> {

    private T data;
    private String message;
}
