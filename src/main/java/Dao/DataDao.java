package Dao;

import javax.sql.DataSource;

import model.LoginUser;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DataDao {
    private static JdbcTemplate jdbcTemplate;
    public DataDao(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getConnection(){
        return this.jdbcTemplate;
    }

//    public DBcon() {
//
//    }

    public List<LoginUser> getAllFlycashLoginUsers() {
        return this.jdbcTemplate.query(
                "select id, email, password, phone, nid, type from loginusers",
                (resultSet, rowNum) -> new LoginUser(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("nid"),
                        resultSet.getString("type")));
    }
    
    //get customer by email and email
//    public LoginUser AuthenticateUser(String email,String password) {
//
//
//    }
    
//    public DBcon(){
//        try{
//            //Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:84/flycash", "root", "root");
//            Statement stmt = con.createStatement();
//            String sql = "select * from customers";
//            ResultSet resultSet= stmt.executeQuery(sql);
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("email"));
//                System.out.println("\n");
//            }
//            con.close();
//
//        }
//        catch(SQLException e){
//            System.out.println("An error occurred while connecting MySQL database");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
