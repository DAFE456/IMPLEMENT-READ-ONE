package com.ddatabase.show.dao.imp;

import com.ddatabase.show.dom.Author;
import com.ddatabase.show.imp.AuthorDaoImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImpT {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImp underTest;

    @Test
    void testAuthorById() {
        Author author = Author.builder()
                .id(22L)
                .name("John")
                .age(56)
                .build();

        underTest.create(author);

        // Exact match of SQL string and parameters
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors(id, name,age) VALUES (?, ?, ?)"),
                eq(22l),
                eq("John"),
                eq(56)
        );
    }

    @Test
    void readone() {
        underTest.findone(22L);

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                any(AuthorDaoImp.AuthorMapper.class),
                eq(22L)
        );
    }
}
