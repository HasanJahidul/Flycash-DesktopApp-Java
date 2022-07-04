package Dao;

import model.Agents;
import model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import services.AgentService;
import services.CustomerService;
import javax.sql.DataSource;


public class TransDao {

    private static JdbcTemplate jdbcTemplate;
    public TransDao(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }



    public int makeTransactionForCashOut(String email, String phone, String transType, String amount, String balance){
        Agents agent = AgentService.Connect(jdbcTemplate).getAgentDataByPhone(phone);

        int rcvr_balance = Integer.parseInt(agent.getBalance())+Integer.parseInt(amount);
        System.out.println("reb: "+rcvr_balance);
        int balance_updated =AgentService.Connect(jdbcTemplate).updateAgentBalanceByPhone(phone, String.valueOf(rcvr_balance));
        System.out.println("reb up: "+balance_updated);
        CustomerService.Connect(jdbcTemplate).updateBalanceByEmail(email,balance);
        return insertTransHistory(email,phone,transType,amount,balance,balance_updated);
    }

    public int makeCustomerTransaction(String email, String phone, String transType, String amount, String balance) {
       if (transType.equals("Send Money")) {
           System.out.println("mt: "+balance);

           Customer customer= CustomerService.Connect(jdbcTemplate).getCustomerDataByPhone(phone);
           int rcvr_balance = Integer.parseInt(customer.getBalance())+Integer.parseInt(amount);
           int balance_updated =CustomerService.Connect(jdbcTemplate).updateBalanceByPhone(phone, String.valueOf(rcvr_balance));
           int senderBalanceUpdated= CustomerService.Connect(jdbcTemplate).updateBalanceByEmail(email,balance);
           return insertTransHistory(email,phone,transType,amount,balance,balance_updated);
        }else{

           return 0;
     }

    }
    public int insertTransHistory(String email, String phone, String transType, String amount, String balance,int balance_updated){
        if (balance_updated==1){
            return this.jdbcTemplate.update("insert into customerstransactions (email,phone,transaction_type,amount,balance) values (?,?,?,?,?)",email,phone,transType,amount,balance);
        }else{
            return 0;
        }
    }
}
