package PrivatePages.Agent;

import Dao.AgentDao;
import Dao.CustomerDao;
import model.AgentTransactions;
import model.CustomerTransactions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AgentDash {
    private JButton button1;
    private JButton button3;
    private JButton button4;
    private JButton button2;
    private JTable tbl_agentTrans;
    private JLabel lbl_logout;
    private JPanel pan_agentDash;
    private JLabel lbl_name;
    final JFrame frame = new JFrame("Agent Dashboard");
    ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
    AgentDao agentDao = applicationContext1.getBean("agentDao", AgentDao.class);

    public AgentDash(String email) {
        createUI();
        Table(email);

    }
    private void createUI() {
        // add table
        frame.setContentPane(pan_agentDash);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //set window size
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        //set icon
        frame.setIconImage(new ImageIcon("flycash.png").getImage());

    }
    private void Table(String email) {
        //show data in tbl_transaction
        String[] columnNames1 = { "SL No.", "Email", "Phone", "Transaction Type", "Date", "Amount","Balance" };
//        String[] rowData = { "1", "2", "3", "4", "5", "6", "7" };
        DefaultTableModel model1 = new DefaultTableModel(columnNames1,0);
//        model1.setRowCount(0);
        model1.addRow(columnNames1);

        System.out.println("Col Count : "+model1.getColumnCount()+model1.getColumnName(1));
        tbl_agentTrans.setModel(model1);
        tbl_agentTrans.setEnabled(false);
        tbl_agentTrans.setRowSelectionAllowed(true);
        tbl_agentTrans.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_agentTrans.setRowSelectionAllowed(true);
        tbl_agentTrans.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int count=1;

        for (AgentTransactions trans: agentDao.getAllAgentTransactions(email)){
            //add data to tbl_transaction
//             System.out.println(trans);
            String[] rowData = { String.valueOf(count),trans.getEmail(),trans.getPhone(),trans.getTransaction_type(),String.valueOf(trans.getDate()),trans.getAmount(),trans.getBalance()};
            model1.addRow(rowData);
            count++;

        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
