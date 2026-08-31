package com.starter.spring_bootstrap.shared.response;

public record ApiResponse<T>(
        T data,
        String message
) {
}