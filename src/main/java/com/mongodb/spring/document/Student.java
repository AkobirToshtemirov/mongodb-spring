package com.mongodb.spring.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    private String id;
    private String name;
    private Integer age;
    private Date birthDate;
    private Gender gender;
}