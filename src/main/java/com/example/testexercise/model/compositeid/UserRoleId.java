package com.example.testexercise.model.compositeid;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleId implements Serializable {
    private String idUser;
    private String idRole;
}
