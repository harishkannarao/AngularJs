package com.harishkannarao.angularjs.filter.security;

import com.harishkannarao.angularjs.constants.Roles;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AllowRoles {
    Roles[] value();
}
