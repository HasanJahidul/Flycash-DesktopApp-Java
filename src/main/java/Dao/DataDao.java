package Dao;

import javax.sql.DataSource;

import model.LoginUser;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DataDao {
    private static JdbcTemplate jdbcTemplate;
    public DataDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public List<LoginUser> getAllFlycashLoginUsers() {
        return this.jdbcTemplate.query(
                "select id, email, password, phone, nid, type from loginusers",
                (resultSet, rowNum) -> new LoginUser(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("nid"),
                        resultSet.getString("type")
                )
        );
    }
}
