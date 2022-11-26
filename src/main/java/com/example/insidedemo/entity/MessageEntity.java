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
@Table(name = "user_messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_id",unique=true, nullable = false)
    private Long message_id;

    @Column(name = "message")
    private String message;

    @ManyToMany(mappedBy = "userMessages")
    private Set<UserEntity> users = new LinkedHashSet<>();


    @Override
    public String toString() {
        return "MessageEntity{" +
                "message_id=" + message_id +
                ", message='" + message + '\'' +
                '}';
    }
}
