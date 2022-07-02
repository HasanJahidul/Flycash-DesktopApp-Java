package database;

import javax.sql.DataSource;

import model.customers;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.*;
import java.util.List;

public class DBcon {
    private static JdbcTemplate jdbcTemplate;
    public DBcon(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DBcon() {

    }
    public  List<customers> getAllUsers() {
        return this.jdbcTemplate.query(
                "select id, username, password from customers",
                (resultSet, rowNum) -> new customers(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("nid"),
                        resultSet.getString("phone"),
                        resultSet.getString("dob")

                )
        );
    }
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
