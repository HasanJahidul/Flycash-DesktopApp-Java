package PrivatePages.Customer;

import Dao.CustomerDao;
import model.CustomerTransactions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDash {
    final JFrame frame = new JFrame("Customer Dashboard");
    private JPanel pan_cusDash;
    private JButton btn_donate;
    private JButton btn_addMoney;
    private JButton btn_payBill;
    private JButton btn_cashIn;
    private JButton btn_cashOut;
    private JButton btn_transferMoney;
    private JLabel lbl_UserName;
    private JLabel lbl_logOut;
    private JTable tbl_transaction;
    private JScrollPane scPan_transactions;

    public CustomerDash() {
        createUI();
        Table();

        // JPanel panel = new JPanel(new GridLayout(4, 4, 3, 3));

        // for (int i = 0; i < 16; i++) {
        //     //JLabel l = new JLabel("" + i, JLabel.CENTER);
        //     JLabel l = new JLabel(new ImageIcon("flycash.png"), JLabel.CENTER);
        //     l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //     l.setFont(l.getFont().deriveFont(20f));
        //     panel.add(l);
        // }

        // f.setContentPane(panel);
        // f.setSize(500, 500);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.setVisible(true);
        // f.setLocationRelativeTo(null);
    }

    private void createUI() {
        // add table
        frame.setContentPane(pan_cusDash);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //set window size
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        //set icon
        frame.setIconImage(new ImageIcon("flycash.png").getImage());

    }

    private void Table() {
        //show data in tbl_transaction
        String[] columnNames = { "ID", "Email", "Phone", "Transaction Type", "Date", "Amount", "Balance" };
//        String[] rowData = { "1", "2", "3", "4", "5", "6", "7" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tbl_transaction.setModel(model);
        tbl_transaction.setEnabled(false);
        tbl_transaction.setRowSelectionAllowed(true);
        tbl_transaction.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_transaction.setRowSelectionAllowed(true);
        tbl_transaction.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
        CustomerDao customerDao = applicationContext1.getBean("customerDao", CustomerDao.class);
        for (CustomerTransactions trans: customerDao.getAllTransactions()){
            //add data to tbl_transaction
            System.out.println(trans);
            String[] rowData = { String.valueOf(trans.getId()),trans.getEmail(),trans.getPhone(),trans.getTransaction_type(),String.valueOf(trans.getDate()),trans.getAmount(),trans.getBalance() };
            model.addRow(rowData);


        }

    }
}

