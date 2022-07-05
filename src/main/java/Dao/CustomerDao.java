package Dao;
import model.Customer;
import model.CustomerTransactions;
import org.springframework.jdbc.core.JdbcTemplate;
import services.CustomerService;

import javax.sql.DataSource;
import java.util.List;

public class CustomerDao {

    private static JdbcTemplate jdbcTemplate;

    public CustomerDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public List<CustomerTransactions> getAllTransactions(String email) {
        return this.jdbcTemplate.query(
                "select id, email,phone, transaction_type, date,amount,balance from customerstransactions where email=?",
                (resultSet, rowNum) -> new CustomerTransactions(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("transaction_type"),
                        resultSet.getDate("date"),
                        resultSet.getString("amount"),
                        resultSet.getString("balance")),
                email
        );
    }
    // get customer
    public Customer getCustomer(String email) {
        return CustomerService.connect(jdbcTemplate).getCustomer(email);
    }


    public boolean getCustomerByPhone(String phone) {
        return this.jdbcTemplate.query(
                "select 1 from customers where phone=?", (resu, row) -> 1, phone
        ).size()>0;
    }
    //update balance by phone
}
