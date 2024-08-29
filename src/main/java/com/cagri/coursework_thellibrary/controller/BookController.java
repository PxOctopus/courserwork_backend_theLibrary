package com.cagri.coursework_thellibrary.controller;

import com.cagri.coursework_thellibrary.dto.request.AddBookRequestDto;
import com.cagri.coursework_thellibrary.entity.Book;
import com.cagri.coursework_thellibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class BookController {
    private final BookService bookService;

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<String> registerBook(@RequestBody AddBookRequestDto dto) {
        bookService.save(dto);
        return ResponseEntity.ok("Book registered successfully");
    }
    @GetMapping("/getAll")
    @CrossOrigin("*")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/search")
    @CrossOrigin("*")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String keyword) {
        List<Book> books = bookService.searchBooks(keyword);
        return ResponseEntity.ok(books);
    }

}
