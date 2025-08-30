package com.ddatabase.show.imp;

import com.ddatabase.show.dom.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static javax.management.Query.eq;

public class BookDaoImp implements BookDao {
    private final JdbcTemplate jdbcTemplate;
    public BookDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books(Isbn, Title,author_id) VALUES (?, ?, ?)",
                book.getIsbn(),book.getTitle(),book.getAuthor_id()

        );
    }

    @Override
    public Optional<Book> upone(String title) {
        return jdbcTemplate.query(
                "SELECT isbn, Title, author_id FROM books WHERE Title = ? LIMIT 1",
                new Bookrowmap(),
                title
        ).stream().findFirst();
    }


    public static class Bookrowmap implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("Title"))
                    .author_id(rs.getLong("author_id"))
                    .build();
        }
    }
}
