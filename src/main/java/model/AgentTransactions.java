package model;

public class AgentTransactions {
    private int id;
    private String email;
    private String phone;
    private String transaction_type;
    private String date;
    private String amount;
    private String balance;

    public AgentTransactions(int id, String email, String phone, String transaction_type, String date, String amount,
            String balance) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.transaction_type = transaction_type;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
