package com.ddatabase.show.imp;

import com.ddatabase.show.dom.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findone(long id);
}
