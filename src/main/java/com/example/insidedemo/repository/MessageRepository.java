package com.example.insidedemo.repository;

import com.example.insidedemo.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//репозитории
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    @Query(nativeQuery = true, value = "select * from user_messages order by message_id DESC limit 10")
    List<MessageEntity> findLastTen();
}
