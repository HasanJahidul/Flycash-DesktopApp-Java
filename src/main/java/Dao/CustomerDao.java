package Dao;
import model.Customer;
import model.CustomerTransactions;
import model.LoginUser;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class CustomerDao {

    private static JdbcTemplate jdbcTemplate;

    public CustomerDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public List<CustomerTransactions> getAllTransactions() {
        return this.jdbcTemplate.query(
                "select id, email,phone, transaction_type, date,amount,balance from customerstransactions",
                (resultSet, rowNum) -> new CustomerTransactions(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("transaction_type"),
                        resultSet.getDate("date"),
                        resultSet.getString("amount"),
                        resultSet.getString("balance")));
    }
    // get customer
    public Customer getCustomer(String email) {
        return this.jdbcTemplate.queryForObject(
                "select id, email,phone, nid, type, balance from customers where email=?",
                (resultSet, rowNum) -> new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("nid"),
                        resultSet.getString("type"),
                        resultSet.getString("balance")),email);
    }
}
