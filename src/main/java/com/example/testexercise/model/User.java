package com.example.testexercise.model;

import com.example.testexercise.model.superclasses.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`user`")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class User extends BaseEntity {
    private String name;
    private String idMedia;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<UserRole> userRoles;

    private LocalDateTime timeDelete;
}
