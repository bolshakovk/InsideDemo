package com.example.insidedemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

//сущность из бд
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String roles;

    @ManyToMany
    @JoinTable(name = "users_user_messages",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_message"))
    private Set<MessageEntity> userMessages = new LinkedHashSet<>();


    public UserEntity(String username, String encode, String roles) {
        this.name = username;
        this.password = encode;
        this.roles =roles;
    }

    public UserEntity() {

    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
