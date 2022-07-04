package PrivatePages;

import Dao.CustomerDao;
import Dao.TransDao;
import PrivatePages.Customer.CustomerDash;
import com.google.protobuf.StringValue;
import model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransactionsPanel {
    private JTextField txt_phone;
    private JTextField txt_amount;
    private JTextField txt_password;
    private JPanel pan_transaction;
    private JLabel lbl_transType;
    private JLabel lbl_amount;
    private JLabel lbl_password;
    private JButton btn_make_trans;
    private JLabel lbl_back;
    private JComboBox cmb_trans;
    private JPanel pan_txtPhone;
    private JPanel pan_cmbTrans;

    ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
    TransDao transDao = applicationContext1.getBean("transDao", TransDao.class);
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    CustomerDao customerDao = applicationContext.getBean("customerDao", CustomerDao.class);
    JFrame frame;

    public TransactionsPanel(Customer cus, String transType) {
        frame = new JFrame(transType);
        System.out.println("Type : "+transType);
        if (transType.equals("Donate money")){
            //
            System.out.println("In");
            // adding comboBox value
            cmb_trans.addItem("Hello");
            cmb_trans.addItem("Hi");
            pan_transaction.remove(pan_txtPhone);
        }else{
            pan_transaction.remove(pan_cmbTrans);
        }
        createUI(transType);
        lbl_transType.setText(transType);
        btn_make_trans.setText(transType);
        //lbl_back
        lbl_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new CustomerDash(cus.getEmail());
            }
        });



        btn_make_trans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeTransaction(cus,transType);
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
    private void makeTransaction(Customer cus,String transType){
        int amount = Integer.parseInt(txt_amount.getText());
        int balance = Integer.parseInt(cus.getBalance());
        if (txt_password.getText().equals(cus.getPassword())){
            if(amount<10){
                JOptionPane.showMessageDialog(null, "Can't make a transaction under 10 Taka)");
            }else{
                    if (transType.equals("Add money")||transType.equals("Cash In")) {
//                    System.out.println(cmb_trans.getSelectedItem());
//                    System.out.println(cus);
                        int updated_balance = balance + amount;
                        System.out.println(updated_balance);
                        int reso=transDao.makeTransaction(cus.getEmail(), txt_phone.getText(),lbl_transType.getText(), String.valueOf(amount),String.valueOf(updated_balance));
                        System.out.println(reso);


                    }
            }

        }else{
            JOptionPane.showMessageDialog(null, "Invalid Password");
        }
    }
    
}
