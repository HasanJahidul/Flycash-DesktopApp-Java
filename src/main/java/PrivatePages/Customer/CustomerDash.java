package PrivatePages.Customer;

import Dao.CustomerDao;
import PrivatePages.TransactionsPanel;
import PublicPages.Login;
import model.Customer;
import model.CustomerTransactions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerDash {
    final JFrame frame = new JFrame("Customer Dashboard");
    private JPanel pan_cusDash;
    private JButton btn_donate;
    private JButton btn_addMoney;
    private JButton btn_payBill;
    private JButton btn_sendMoney;
    private JButton btn_cashOut;
    private JButton btn_transferMoney;
    private JLabel lbl_UserName;
    private JLabel lbl_logOut;
    private JTable tbl_transaction;
    private JScrollPane scPan_transactions;
    private JLabel lbl_balance;

    ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
    CustomerDao customerDao = applicationContext1.getBean("customerDao", CustomerDao.class);
    public CustomerDash(String email) {
        createUI();
        Table(email);
        Customer res=GetData(email);
        lbl_UserName.setText("Name: "+res.getName());
        lbl_balance.setText("Balance: "+res.getBalance());
        System.out.println(customerDao.getCustomerByPhone("0197354541300"));
        System.out.println(customerDao.getCustomerByPhone("01973545413"));
//        lbl_UserName.setText(email);

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
        btn_addMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.getTransaction_status().equals("blocked")){
                    JOptionPane.showMessageDialog(null, "Your transaction has been blocked\n Please contact to customer care");
                }else{
                    frame.setVisible(false);
                    new TransactionsPanel(res,"Add money");
                }

            }
        });
        btn_sendMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.getTransaction_status().equals("blocked")){
                    JOptionPane.showMessageDialog(null, "Your transaction has been blocked\n Please contact to customer care");
                }else {
                    frame.setVisible(false);
                    new TransactionsPanel(res, "Send Money");
                }
            }
        });
        btn_payBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.getTransaction_status().equals("blocked")){
                    JOptionPane.showMessageDialog(null, "Your transaction has been blocked\n Please contact to customer care");
                }else {
                    frame.setVisible(false);
                    new TransactionsPanel(res, "Pay Bill");
                }
            }
        });
        btn_cashOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.getTransaction_status().equals("blocked")){
                    JOptionPane.showMessageDialog(null, "Your transaction has been blocked\n Please contact to customer care");
                }else {
                    frame.setVisible(false);
                    new TransactionsPanel(res, "Cash Out");
                }
            }
        });
        btn_donate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.getTransaction_status().equals("blocked")){
                    JOptionPane.showMessageDialog(null, "Your transaction has been blocked\n Please contact to customer care");
                }else {
                    frame.setVisible(false);
                    new TransactionsPanel(res, "Donate money");
                }

            }
        });
        btn_transferMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.getTransaction_status().equals("blocked")){
                    JOptionPane.showMessageDialog(null, "Your transaction has been blocked\n Please contact to customer care");
                }else {
                    frame.setVisible(false);
                    new TransactionsPanel(res, "Transfer Money");
                }
            }
        });
        lbl_logOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new Login();
            }
        });
    }

    private void createUI() {
        // add table
        frame.setContentPane(pan_cusDash);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //set window size
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        //set icon
        frame.setIconImage(new ImageIcon("flycash.png").getImage());

    }
    private Customer GetData(String email){
        Customer result= customerDao.getCustomer(email);
        return result;

    }

    private void Table(String email) {
        //show data in tbl_transaction
        String[] columnNames = { "SL No.", "Phone", "Transaction Type", "Date", "Amount", "Balance" };
//        String[] rowData = { "1", "2", "3", "4", "5", "6", "7" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tbl_transaction.setModel(model);
        tbl_transaction.setEnabled(false);
        tbl_transaction.setRowSelectionAllowed(true);
        tbl_transaction.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_transaction.setRowSelectionAllowed(true);
        tbl_transaction.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        int count=1;
        for (CustomerTransactions trans: customerDao.getAllTransactions(email)){
            //add data to tbl_transaction
//             System.out.println(trans);
            String[] rowData = { String.valueOf(count),trans.getPhone(),trans.getTransaction_type(),String.valueOf(trans.getDate()),trans.getAmount(),trans.getBalance()};
            model.addRow(rowData);
            count++;


        }

    }
}

