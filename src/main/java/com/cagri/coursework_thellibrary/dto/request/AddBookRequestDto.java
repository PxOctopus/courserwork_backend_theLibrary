package com.cagri.coursework_thellibrary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBookRequestDto {
    private String title;
    private String author;
    private String imageUrl;
}
