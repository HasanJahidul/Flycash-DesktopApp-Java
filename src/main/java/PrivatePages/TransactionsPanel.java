package PrivatePages;

import Dao.CustomerDao;
import Dao.TransDao;
import PrivatePages.Customer.CustomerDash;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransactionsPanel {
    private JTextField txt_phone;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel pan_transaction;
    private JLabel lbl_transType;
    private JLabel txt_amount;
    private JLabel txt_password;
    private JButton btn_make_trans;
    private JLabel lbl_back;

    ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
    TransDao transDao = applicationContext1.getBean("transDao", TransDao.class);
    JFrame frame = new JFrame();

    public TransactionsPanel(String email,String transType) {
        createUI(transType);
        lbl_transType.setText(transType);
        btn_make_trans.setText(transType);
        //lbl_back
        lbl_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new CustomerDash(email);
            }
        });

    }

    private void createUI(String transType) {
        frame.setName(transType);
        frame.setContentPane(pan_transaction);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
}
