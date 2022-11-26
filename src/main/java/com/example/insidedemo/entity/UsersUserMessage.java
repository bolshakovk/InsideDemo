package com.example.insidedemo.entity;

import com.example.insidedemo.entity.MessageEntity;
import com.example.insidedemo.entity.UserEntity;

import javax.persistence.*;

//мени ту мени таблица
@Entity
@Table(name = "users_user_messages")
public class UsersUserMessage {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity idUser;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_message", nullable = false)
    private MessageEntity idMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MessageEntity getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(MessageEntity idMessage) {
        this.idMessage = idMessage;
    }

    public UserEntity getIdUser() {
        return idUser;
    }

    public void setIdUser(UserEntity idUser) {
        this.idUser = idUser;
    }
}