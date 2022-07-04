package services;
import model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerService {

    private JdbcTemplate jdbcTemplate;

    public CustomerService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean getCustomerByPhone(String phone) {
        List<Integer> res = this.jdbcTemplate.query(
                "select 1 from customers where phone=?", (resu, row) -> 1, phone);
        return res.size() > 0;
    }

    public Customer getCustomer(String email) {
        return this.jdbcTemplate.queryForObject(
                "select id,name, email,password,phone, nid, dob, balance,transaction_status from customers where email=?",
                (resultSet, rowNum) -> new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("nid"),
                        resultSet.getString("dob"),
                        resultSet.getString("balance"),
                        resultSet.getString("transaction_status")),email);
    }

    public static CustomerService Connect(JdbcTemplate jdbcTemplate){
        return new CustomerService(jdbcTemplate);
    }
}
