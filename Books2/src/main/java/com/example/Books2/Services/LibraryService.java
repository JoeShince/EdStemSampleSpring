package com.example.Books2.Services;

import com.example.Books2.Repositories.AuthorRepository;
import com.example.Books2.Repositories.BookRepository;
import com.example.Books2.Models.Authors;
import com.example.Books2.Models.Books;
import com.example.Books2.dto.AuthorUpdateDto;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.*;

public class LibraryService {

    @Autowired
    public AuthorRepository authorRepository;
    @Autowired
    public BookRepository bookRepository;

    public Books addBook(Books books) {
        return bookRepository.save(books);
    }

    public Authors registerAuthor(Authors authors) {
        return authorRepository.save(authors);
    }

    public Map<String, Object> getAuthor(String id){
        Optional<List<Books>> bookResponse = bookRepository.findBooksByAuthor(id);
        Optional<Authors> authorResponse = authorRepository.findAuthorById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bookResponse", bookResponse);
        map.put("authorResponse",authorResponse);
        return map;
    }

    public Map<String, Object> getAllBooks(){
        List<Object> dto = new ArrayList<>();
        bookRepository.findAll().stream().map((books -> {
            Authors author = authorRepository.findAuthorById(books.getId());
            Map<String, Object> bookDto = new HashMap<String, Object>();
            bookDto.put("books", books);
            bookDto.put("author", author);

            dto.add(bookDto);
            return dto;
        }));
        return dto;
    }

    public void updateAuthor(AuthorUpdateDto authorUpdateDto){
        Authors authors = authorRepository.findAuthorById(authorUpdateDto.getId())
                .orElseThrow(()-> new Exception("Not Found"));
        authors.setAuthorName(authorUpdateDto.getAuthorName());
        authors.setAuthorPhone(authorUpdateDto.getAuthorName());
        authors.setAuthorEmail(authorUpdateDto.getAuthorName());
        authors.setAuthorAddress(authorUpdateDto.getAuthorAddress());

        authorRepository.save(authors);

    }

    public void updateBook(AuthorUpdateDto authorUpdateDto){
        Books books = authorRepository.findAuthorById(authorUpdateDto.getId())
                .orElseThrow(()-> new Exception("Not Found"));
        books.setAuthor(authorUpdateDto.getAuthor());
        books.setDop(authorUpdateDto.getDop());

        bookRepository.save(books);

    }


    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

}
