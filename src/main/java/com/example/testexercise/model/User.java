package com.example.testexercise.model;

import com.example.testexercise.model.superclasses.BaseEntity;
import liquibase.pro.packaged.J;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "idMedia", updatable = false, insertable = false)
    private Media media;
}
