package com.example.testexercise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "v_user_view")
@Immutable
@Getter
@Setter
@NoArgsConstructor
public class UserView {
    @Id
    private String userId;
    private String userName;
    private String roleNames;
}
