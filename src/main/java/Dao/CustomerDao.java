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
                        resultSet.getString("balance")),email);
    }
    // get customer
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
    public Customer getCustomerDataByPhone(String phone) {
        return this.jdbcTemplate.queryForObject(
                "select id,name, email,password,phone, nid, dob, balance,transaction_status from customers where phone=?",
                (resultSet, rowNum) -> new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("nid"),
                        resultSet.getString("dob"),
                        resultSet.getString("balance"),
                        resultSet.getString("transaction_status")),phone);
    }

    public boolean getCustomerByPhone(String phone) {
        List<Integer> res = this.jdbcTemplate.query(
                "select 1 from customers where phone=?", (resu, row) -> 1, phone);
        return res.size() > 0;
    }
    //update balance by phone
    public int updateBalanceByPhone(String phone, String balance) {
        return this.jdbcTemplate.update("update customers set balance=? where phone=?", balance, phone);
    }
    //update transaction status by phone
    public int updateTransactionStatus(String phone, String transaction_status) {
        return this.jdbcTemplate.update("update customers set transaction_status=? where phone=?", transaction_status,
                phone);
    }
    //update transaction status by email
    public int updateTransactionStatusByEmail(String email, String transaction_status) {
        return this.jdbcTemplate.update("update customers set transaction_status=? where email=?", transaction_status,
                email);
    }
    //update balance by email
    public int updateBalanceByEmail(String email, String balance) {
        return this.jdbcTemplate.update("update customers set balance=? where email=?", balance, email);
    }
    
}
