package PrivatePages;

import Dao.AgentDao;
import Dao.CustomerDao;
import Dao.TransDao;
import PrivatePages.Customer.CustomerDash;
import com.google.protobuf.StringValue;
import model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
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

    ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("application-context.xml");
    AgentDao agentDao = applicationContext2.getBean("agentDao", AgentDao.class);
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
    private void passTrnasValue(Customer cus,int updated_balance){
        System.out.println("pass: "+updated_balance);
        int res=transDao.makeCustomerTransaction(cus.getEmail(), txt_phone.getText(),lbl_transType.getText(), txt_amount.getText(),String.valueOf(updated_balance));
        if (res==1){
            JOptionPane.showMessageDialog(null, "Transaction Successful");
            frame.setVisible(false);
            new CustomerDash(cus.getEmail());
        }else{
            JOptionPane.showMessageDialog(null,"Something is wrong with the server\n\n Please wait until experts fix bugs");
        }

    }
    private void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    private void makeTransaction(Customer cus,String transType){
        int amount = Integer.parseInt(txt_amount.getText());
        int balance = Integer.parseInt(cus.getBalance());

        if (txt_password.getText().equals(cus.getPassword())){
            int updated_balance;
            if(amount<10){
                showMessage("Can't make a transaction under 10 Taka");
            }else{
                    if (transType.equals("Add money")){
//                    System.out.println(cmb_trans.getSelectedItem());
//                    System.out.println(cus);
                        updated_balance = balance + amount;
                        passTrnasValue(cus,updated_balance );
                    }else if(transType.equals("Donate money")){
                        if (amount < balance){
                            updated_balance=balance-amount;
                            passTrnasValue(cus, updated_balance );

                        }else{
                            showMessage("insufficient Balance");
                        }


                }else if(transType.equals("Cash Out")){
                        if(agentDao.getAgentByPhone(txt_phone.getText())==true){
                            if (amount < balance){
                                updated_balance = balance - amount;
                                int res=transDao.makeTransactionForCashOut(cus.getEmail(), txt_phone.getText(),lbl_transType.getText(), txt_amount.getText(),String.valueOf(updated_balance));
                                if (res==1){
                                    JOptionPane.showMessageDialog(null, "Transaction Successful");
                                    frame.setVisible(false);
                                    new CustomerDash(cus.getEmail());
                                }else{
                                    JOptionPane.showMessageDialog(null,"Something is wrong with the server\n\n Please wait until experts fix bugs");
                                }
                                System.out.println(updated_balance);

                            }else{
                                showMessage("insufficient Balance");
                            }
                            //showMessage("user Found");

                        }else{
                            showMessage("This Phone number is not registered as agent in services");
                        }

                    }else{
                        if(customerDao.getCustomerByPhone(txt_phone.getText())==true){
                            if (amount < balance){
                                updated_balance = balance - amount;
                                passTrnasValue(cus,updated_balance );
                                System.out.println(updated_balance);
                            }else{
                                showMessage("insufficient Balance");
                            }
                            //showMessage("user Found");

                        }else{
                            showMessage("Phone number is not registered in services");
                        }


                    }
            }

        }else{
            showMessage("Invalid Password");
        }
    }
    
}
