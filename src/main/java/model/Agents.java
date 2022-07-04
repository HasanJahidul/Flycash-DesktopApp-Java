package model;

public class Agents {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String nid;
    private String dob;
    private String balance;
    private String transaction_status;

    public Agents() {
    }

    public Agents(int id, String name, String email, String password, String phone, String nid,String dob, String balance,
                    String transaction_status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nid = nid;
        this.phone = phone;
        this.dob = dob;
        this.balance = balance;
        this.transaction_status = transaction_status;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTransaction_status() {
        return transaction_status;
    }
    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }
}
