package com.example.erfan_adine_ptest.entity.security;


public enum Permission {
    STUDENT_WRITE("student_write"),
    STUDENT_READ("student_read"),
    ADMIN_WRITE("admin_write"),
    ADMIN_READ("admin_read"),
    COURSE_WRITE("course_write"),
    COURSE_READ("course_read");



    private final String permissionName;

    Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }
}
