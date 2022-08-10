package com.example.testexercise.model;

import com.example.testexercise.model.compositeid.UserRoleId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserRoleId.class)
public class UserRole {
    @Id
    @Column(name = "id_user")
    private String idUser;
    @Id
    @Column(name = "id_role")
    private String idRole;

    @ManyToOne
    @JoinColumn(name = "id_role", insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;
}
