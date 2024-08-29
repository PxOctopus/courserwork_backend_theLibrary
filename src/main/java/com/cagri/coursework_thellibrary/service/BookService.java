package com.cagri.coursework_thellibrary.service;

import com.cagri.coursework_thellibrary.dto.request.AddBookRequestDto;
import com.cagri.coursework_thellibrary.entity.Book;
import com.cagri.coursework_thellibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
private final BookRepository repository;

    public Book save(AddBookRequestDto dto) {
        return repository.save(Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .imageUrl(dto.getImageUrl())
                .build());
    }

    public List<Book> searchBooks(String keyword) {
        return repository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
