package Dao;

import model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


public class TransDao {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    CustomerDao customerDao = applicationContext.getBean("customerDao", CustomerDao.class);
    private static JdbcTemplate jdbcTemplate;
    public TransDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }





    public int makeCustomerTransaction(String email, String phone, String transType, String amount, String balance) {
        if (transType.equals("Send money")) {
            Customer customer = customerDao.getCustomerDataByPhone(phone);
            int rcvr_balance = Integer.parseInt(customer.getBalance())+Integer.parseInt(amount);
            int balance_updated =customerDao.updateBalanceByPhone(phone, String.valueOf(rcvr_balance));
            return insertTransHistory(email,phone,transType,amount,balance,balance_updated);
        }else{
            int balance_updated = customerDao.updateBalanceByEmail(email, balance);
            return insertTransHistory(email,phone,transType,amount,balance,balance_updated);
        }

        // int balance_updated =this.jdbcTemplate.update("update customers set balance=? where email=?", balance, email);

        //update balance to customer

    }
    public int insertTransHistory(String email, String phone, String transType, String amount, String balance,int balance_updated){
        if (balance_updated==1){
            return this.jdbcTemplate.update("insert into customerstransactions (email,phone,transaction_type,amount,balance) values (?,?,?,?,?)",email,phone,transType,amount,balance);
        }else{
            return 0;
        }
    }
}
