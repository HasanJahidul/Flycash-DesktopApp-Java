package PrivatePages.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerDash {
    final JFrame f = new JFrame("Customer Dashboard");
    private JPanel pan_cusDash;
    private JTable tbl_cus_transaction;

    public CustomerDash() {
        createUI();

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

    private void createUI(){
        // add table
        System.out.println(pan_cusDash);
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        f.add(scrollPane);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        
    }
    
    }

