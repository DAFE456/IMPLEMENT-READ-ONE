package com.ddatabase.show.dom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private String isbn;
    private String title;
    private long author_id;

}
