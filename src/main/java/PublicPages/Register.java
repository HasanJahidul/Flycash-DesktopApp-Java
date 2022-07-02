package PublicPages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {
    JFrame frame = new JFrame("Register");
    private JPanel form_register;
    private JTextField txt_Email;
    private JTextField txt_name;
    private JTextField txt_cpassword;
    private JTextField txt_password;
    private JTextField txt_nid;
    private JButton btn_register;
    private JLabel lbl_login;

    public Register() {
        createUI();
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        lbl_login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new Login();

            }
        });
    }
    private void createUI(){

        frame.setContentPane(form_register);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //set window size
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

    }
    private void register(){
        String email = txt_Email.getText();
        String password = txt_name.getText();
        String confirmPassword = txt_cpassword.getText();
        String firstName = txt_password.getText();
        String lastName = txt_nid.getText();
        if(password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "Register Successful");
        }
        else{
            JOptionPane.showMessageDialog(null, "Password does not match");
        }
    }
    
}
