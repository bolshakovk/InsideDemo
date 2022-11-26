package com.example.insidedemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

//чтоб кидать в сервисе
@Getter
@Setter
public class MessageDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("message")
    private String message;
}
