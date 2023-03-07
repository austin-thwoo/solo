package com.noah.solo.domain.person.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@Setter
@RedisHash("Person")
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createdAt;



}
