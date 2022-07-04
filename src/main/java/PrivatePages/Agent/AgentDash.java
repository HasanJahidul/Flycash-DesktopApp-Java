package PrivatePages.Agent;

import Dao.AgentDao;
import PrivatePages.TransactionsPanel;
import PublicPages.Login;
import model.AgentTransactions;
import model.Agents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class AgentDash {
    private JButton btn_cashin;
    private JButton btn_searchTrans;
    private JTable tbl_agentTrans;
    private JLabel lbl_logout;
    private JPanel pan_agentDash;
    private JLabel lbl_name;
    private JLabel lbl_balance;
    final JFrame frame = new JFrame("Agent Dashboard");
    ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
    AgentDao agentDao = applicationContext1.getBean("agentDao", AgentDao.class);

    public AgentDash(String email) {
        Agents res=GetData(email);
        lbl_name.setText("Name: "+res.getName());
        lbl_balance.setText("Balance: "+res.getBalance());
        createUI();
        Table(email);

        lbl_logout.addComponentListener(new ComponentAdapter() {
        });
    lbl_logout.addComponentListener(new ComponentAdapter() { } );
        lbl_name.addComponentListener(new ComponentAdapter() {
        });
        lbl_logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new Login();
            }
        });
        btn_cashin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new TransactionsPanel(res, "Cash in");
            }
        });
    }
    private Agents GetData(String email){
        Agents result= agentDao.getAgent(email);
        return result;

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
        String[] columnNames1 = { "SL No.",  "Phone", "Transaction Type", "Date", "Amount","Balance" };
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
            String[] rowData = { String.valueOf(count),trans.getPhone(),trans.getTransaction_type(),String.valueOf(trans.getDate()),trans.getAmount(),trans.getBalance()};
            model1.addRow(rowData);
            count++;

        }

    }
}
