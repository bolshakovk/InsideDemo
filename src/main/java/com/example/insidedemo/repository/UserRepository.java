package com.example.insidedemo.repository;

import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select u from UserEntity u where  u.name like %:name%")
    Optional<UserEntity>  findByName(@Param("name") String name);



    @Query(value = "select case when count (u) > 0 then true else false end from UserEntity u where lower(u.name) like lower(:name) ")
    Boolean existsByUsername(@Param("name")String name);
}
