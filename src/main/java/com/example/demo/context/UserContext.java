package com.example.demo.context;

import java.util.Arrays;
import java.util.List;

/**
 * 현재 사용자의 역할 정보를 반환합니다.
 * (실제 구현에서는 SecurityContext, Session 등에서 역할 정보를 가져옵니다.)
 */
public class UserContext {
    public static List<String> getCurrentUserRoles() {
        // 예제에서는 "USER" 역할만 가진 것으로 가정
        return Arrays.asList("USER");
    }
}