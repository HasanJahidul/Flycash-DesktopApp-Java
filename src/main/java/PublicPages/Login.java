package PublicPages;

import database.DBcon;
import model.customers;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Login {
    JFrame frame = new JFrame("Login");
    private JPanel form_login;
    private JTextField txt_email;
    private JTextField txt_password;
    private JButton btn_login;
    private JLabel lbl_logo;
    private JLabel lbl_register;

    public Login(){
        createUI();
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               login();
            }
        });
        lbl_register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false); //you can't see me!
                new Register();

            }
        });
    }
    private void createUI(){

        frame.setContentPane(form_login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //set text field
        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        txt_email.setBorder(null);
        txt_email.setCaretColor(new java.awt.Color(0, 0, 0));
        txt_email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_email.setMargin(new java.awt.Insets(2, 2, 2, 2));
        txt_email.setSelectionColor(new java.awt.Color(0, 0, 0));
        txt_email.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_email.setSelectionColor(new java.awt.Color(0, 0, 0));
        txt_email.setSelectedTextColor(new java.awt.Color(0, 0, 0));


        //set window size
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        
        
    }
    private void login(){
        String email = txt_email.getText();
                String password = txt_password.getText();
                if(email.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                }else{
                    if(email.equals("admin") && password.equals("admin")){
                        JOptionPane.showMessageDialog(null, "Login successful");
                        //new AdminPage();
                    }else{
                        JOptionPane.showMessageDialog(null, "Login failed");
                    }
                }
    }

    public JPanel getForm_login() {
        return form_login;
    }
//    public static void main(String[] args) {
//        new Login();
//    }

}
