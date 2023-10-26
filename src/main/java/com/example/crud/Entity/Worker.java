package com.example.crud.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profession;
    private String imageUrl;
    private Number phoneNumber;
    private Number score;

}
