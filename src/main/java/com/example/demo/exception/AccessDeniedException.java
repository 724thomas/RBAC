package com.example.demo.exception;

/**
 * 권한이 없을 때 발생시키는 예외입니다.
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message); // 메시지를 부모 클래스에 전달합니다.
    }
}