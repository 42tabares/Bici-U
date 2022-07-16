package com.bici_u.management;

public enum UserRole {
    PROFESSOR("P") , STUDENT("S");
    final String roleID;
    UserRole(String roleId){
        this.roleID = roleId;
    }
}
