package services;

import model.Agents;
import org.springframework.jdbc.core.JdbcTemplate;

public class AgentService {
    private JdbcTemplate jdbcTemplate;

    public AgentService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public Agents getAgentDataByPhone(String phone) {
        return this.jdbcTemplate.queryForObject(
                "select id,name, email,password,phone, nid, dob, balance,transaction_status from agents where phone=?",
                (resultSet, rowNum) -> new Agents(
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
    public int updateAgentBalanceByPhone(String phone, String balance) {
        return this.jdbcTemplate.update("update agents set balance=? where phone=?", balance, phone);
    }
    //update transaction status by phone
    public int updateAgentTransactionStatus(String phone, String transaction_status) {
        return this.jdbcTemplate.update("update agents set transaction_status=? where phone=?", transaction_status,
                phone);
    }
    //update transaction status by email
    public int updateAgentTransactionStatusByEmail(String email, String transaction_status) {
        return this.jdbcTemplate.update("update agents set transaction_status=? where email=?", transaction_status,
                email);
    }
    //update balance by email
    public int updateAgentBalanceByEmail(String email, String balance) {
        return this.jdbcTemplate.update("update agents set balance=? where email=?", balance, email);
    }

    public static AgentService Connect(JdbcTemplate jdbcTemplate){
        return new AgentService(jdbcTemplate);
    }
}
