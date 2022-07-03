package Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class TransDao {
    private static JdbcTemplate jdbcTemplate;
    public TransDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }


}
