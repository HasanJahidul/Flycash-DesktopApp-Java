package model;

public class LoginUser {
    private int id;
    private String email;
    private String password;
    private String phone;
    private String nid;
    private String type;

    public LoginUser(int id, String email, String password, String phone, String nid, String type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.nid = nid;
        this.type = type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}