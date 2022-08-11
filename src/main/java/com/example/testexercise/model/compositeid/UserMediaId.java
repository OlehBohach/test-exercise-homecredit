package com.example.testexercise.model.compositeid;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMediaId implements Serializable {
    private String idUser;
    private String idMedia;
}
