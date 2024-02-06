package com.example.Books2.dto;

import com.example.Books2.Models.Books;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ResponseBody
public class AuthorResponseDto {
    private String authorName;
    private String Id;
    private List<Books> books;
}
