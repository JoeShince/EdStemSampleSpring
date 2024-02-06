package com.example.Books2.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="Authors")
public class Authors {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
