package Dao;
import javax.sql.DataSource;

import model.AgentTransactions;
import model.Agents;
import model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import services.AgentService;
import services.CustomerService;

import java.util.List;

public class AgentDao {
    private static JdbcTemplate jdbcTemplate;

    public AgentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<AgentTransactions> getAllAgentTransactions(String email) {
        return this.jdbcTemplate.query(
                "select id, email,phone, transaction_type, date,amount,balance from agentstransactions where email=?",
                (resultSet, rowNum) -> new AgentTransactions(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("transaction_type"),
                        resultSet.getString("date"),
                        resultSet.getString("amount"),
                        resultSet.getString("balance")),
                email
        );
    }
    
    //get agent by phone 
    public boolean getAgentByPhone(String phone) {
        return this.jdbcTemplate.query(
                "select 1 from agents where phone=?",
                (resu, row) -> 1, phone)
                .size()>0;
    }
    public Agents getAgent(String email) {
        return AgentService.Connect(jdbcTemplate).getAgent(email);
    }

}
