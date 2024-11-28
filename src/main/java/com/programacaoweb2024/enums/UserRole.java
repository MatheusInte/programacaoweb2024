package com.programacaoweb2024.enums;

public enum UserRole {
    ADMIN("admin"),
    ALUNO("aluno");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
