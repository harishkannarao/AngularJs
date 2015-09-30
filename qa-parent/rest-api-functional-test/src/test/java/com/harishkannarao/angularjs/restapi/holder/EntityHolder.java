package com.harishkannarao.angularjs.restapi.holder;

import com.harishkannarao.angularjs.restapi.entity.AuthAccessEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EntityHolder {

    private AuthAccessEntity authAccessEntity;

    public AuthAccessEntity getAuthAccessEntity() {
        return authAccessEntity;
    }

    public void setAuthAccessEntity(AuthAccessEntity authAccessEntity) {
        this.authAccessEntity = authAccessEntity;
    }
}
