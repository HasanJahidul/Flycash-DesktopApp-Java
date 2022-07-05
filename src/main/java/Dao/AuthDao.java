package Dao;
import model.LoginUser;
import javax.sql.DataSource;
import javax.swing.*;

import org.springframework.jdbc.core.JdbcTemplate;

public class AuthDao {
    private static JdbcTemplate jdbcTemplate;
    public AuthDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public LoginUser AuthenticateUser(String email, String password){
        // authenticate user
        try{
            return this.jdbcTemplate.queryForObject(
                    "select id, email, password, phone, nid, type from loginusers where email = ? and password = ?",
                    (resultSet, rowNum) -> new LoginUser(
                            resultSet.getInt("id"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("phone"),
                            resultSet.getString("nid"),
                            resultSet.getString("type")),
                    email,
                    password
            );
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
