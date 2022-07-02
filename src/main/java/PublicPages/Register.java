package PublicPages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {
    JFrame frame = new JFrame("Register");
    private JPanel form_register;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
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

        //set text field
        textField1.setBackground(new java.awt.Color(255, 255, 255));
        textField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textField1.setForeground(new java.awt.Color(0, 0, 0));
        textField1.setBorder(null);
        textField1.setCaretColor(new java.awt.Color(0, 0, 0));
        textField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        textField1.setSelectionColor(new java.awt.Color(0, 0, 0));
        textField1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        textField1.setSelectionColor(new java.awt.Color(0, 0, 0));
        textField1.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        //set window size
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

    }
    private void register(){
        String email = textField1.getText();
        String password = textField2.getText();
        String confirmPassword = textField3.getText();
        String firstName = textField4.getText();
        String lastName = textField5.getText();
        if(password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "Register Successful");
        }
        else{
            JOptionPane.showMessageDialog(null, "Password does not match");
        }
    }
    
}
