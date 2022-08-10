package com.example.testexercise.model.compositeid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class UserRoleId implements Serializable {
    private String idUser;
    private String idRole;
}
