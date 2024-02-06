package com.example.Books2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class Books {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid")
    private String Id;
    private String name;
    private String author;
    private String dop;
}
