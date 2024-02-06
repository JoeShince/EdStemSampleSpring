package com.example.Books2.Controllers;


import com.example.Books2.Models.Authors;
import com.example.Books2.Services.LibraryService;
import com.example.Books2.dto.AuthorResponseDto;
import com.example.Books2.dto.AuthorUpdateDto;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library")
@NoArgsConstructor
public class LibraryController {
    @Autowired public LibraryService libraryService;

@PostMapping("/add-author")
    public Authors authorRegistration(@RequestBody @NonNull Authors author){
    return libraryService.registerAuthor(author);
}

@GetMapping("/get-author-books")
    public Object getAuthorBooks(@PathVariable @NonNull String id){
    return ResponseEntity.ok(libraryService.getAuthor(id));
}

@GetMapping("/get-all-book-details")
    public Object getAllBookDetails(){
    return ResponseEntity.ok(libraryService.getAllBooks());
}

@PostMapping("/update-author")
    public void updateAuthor(@RequestBody @NonNull AuthorUpdateDto authorUpdateDto){
    libraryService.updateAuthor(authorUpdateDto);
}

@PostMapping("/delete-book")
    public void deleteBook(@PathVariable @NonNull String id){
    libraryService.deleteBook(id);
}
}
