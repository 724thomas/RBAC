package com.example.demo.aspect;

import com.example.demo.annotation.RoleAllowed;
import com.example.demo.context.UserContext;
import com.example.demo.exception.AccessDeniedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    @Around("@annotation(com.example.demo.annotation.RoleAllowed)")
    public Object checkRole(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
        List<String> allowedRoles = Arrays.asList(roleAllowed.value());

        List<String> userRoles = UserContext.getCurrentUserRoles();

        boolean authorized = userRoles.stream().anyMatch(allowedRoles::contains);
        if (!authorized) {
            String errorMsg = "Access is denied: insufficient privileges";
            System.out.println("Throwing exception with message: " + errorMsg);
            throw new AccessDeniedException(errorMsg);
        }

        return joinPoint.proceed();
    }
}