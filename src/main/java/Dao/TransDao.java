package Dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class TransDao {
    private static JdbcTemplate jdbcTemplate;
    public TransDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }




    public int makeTransaction(String email, String phone, String transType,String amount , String balance){

        //update balance to customer
        String sql1 = "update customers set balance=? where email=?";
        return this.jdbcTemplate.update(sql1, balance, email);
        

        // return this.jdbcTemplate.update("insert into customerstransactions (email,phone,transaction_type,amount,balance) values (?,?,?,?,?)",email,phone,transType,amount,balance);
    }
}
