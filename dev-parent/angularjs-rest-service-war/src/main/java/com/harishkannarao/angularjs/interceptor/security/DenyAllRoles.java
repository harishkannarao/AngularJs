package com.harishkannarao.angularjs.interceptor.security;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DenyAllRoles {
}
