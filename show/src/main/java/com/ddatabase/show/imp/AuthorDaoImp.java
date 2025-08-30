package com.ddatabase.show.imp;


import com.ddatabase.show.dom.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImp implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;
    public AuthorDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors(id, name,age) VALUES (?, ?, ?)",
                author.getId(),author.getName(),author.getAge()

        );
    }

    @Override
    public Optional<Author> findone(long id) {
        List<Author> result = jdbcTemplate.query("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1", new AuthorMapper(), id);
        return result.stream().findFirst();
    }

    public static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
