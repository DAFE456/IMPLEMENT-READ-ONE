package com.ddatabase.show.imp;

import com.ddatabase.show.dom.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> upone(String title);
}
