package com.example.erfan_adine_ptest.entity.security;


public enum Permission {
//    STUDENT_WRITE("student_write"),
//    STUDENT_READ("student_read"),
//    ADMIN_WRITE("admin_write"),
//    ADMIN_READ("admin_read"),
//    COURSE_WRITE("course_write"),
//    COURSE_READ("course_read");


    USER_WRITE("user_write"),
    USER_READ("user_read"),

    SUGGESTION_WRITE("user_write"),
    SUGGESTION_READ("user_read"),

    WORKER_WRITE("worker_write"),
    WORKER_READ("worker_read"),

    ADMIN_WRITE("admin_write"),
    ADMIN_READ("admin_read"),

    MAIN_ORDER_WRITE("main_order_write"),
    MAIN_ORDER_READ("main_order_read"),

    SUB_SERVICE_WRITE("course_write"),
    SUB_SERVICE_READ("course_read"),

    COMMENT_READ("comment_read"),
    COMMENT_WRITE("comment_write");

    private final String permissionName;

    Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }
}
