package PublicPages;

import Dao.AuthDao;
import PrivatePages.Agent.AgentDash;
import PrivatePages.Customer.CustomerDash;
import PrivatePages.Admin.*;
import model.LoginUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
    JFrame frame = new JFrame("Login");
    private JPanel form_loginjj;
    private JTextField txt_email;
    private JTextField txt_password;
    private JButton btn_login;
    private JLabel lbl_logo;
    private JLabel lbl_register;

    public Login(){
        if (form_loginjj==null){
            System.out.println("null");
        }else{

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
    }
    private void createUI(){
        System.out.println(form_loginjj);
        frame.setContentPane(form_loginjj);
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
            } else {
                ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
                AuthDao authDao = applicationContext1.getBean("authDao", AuthDao.class);
                // String result= String.valueOf(authDao.AuthenticateUser(email,password));
                // get result from database
                LoginUser result = authDao.AuthenticateUser(email, password);
                //print result
                //System.out.println(result.getEmail());
//                String result="asdas";

                if(result!=null){
                    //System.out.println(result.getType());
                    //JOptionPane.showMessageDialog(null, result.getEmail());
                    if (result.getType() == "customer") {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        frame.setVisible(false);
                        new CustomerDash();
                    } else if (result.getEmail() == "admin") {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        frame.setVisible(false);
                        new AdminDash();
                    }else if(result.getEmail() == "agent"){
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        frame.setVisible(false);
                        new AgentDash();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed1");
                    }
                        
                    //new AdminPage();
                }else{
                    JOptionPane.showMessageDialog(null, "Login failed2");
                }
            }
    }



}
