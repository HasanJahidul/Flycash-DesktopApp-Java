package PublicPages;

import database.DBcon;
import model.customers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class table {
    private JTable tbl_customer;
    private JPanel form_table;
    JFrame jFrame = new JFrame("Table");
    private JButton btn_add;
    private JButton btn_edit;
    private JButton btn_delete;
    private JButton btn_back;
    private JButton btn_logout;
    private JButton btn_refresh;
    private JButton btn_search;
    private JTextField txt_search;
    private JLabel lbl_search;
    private JLabel lbl_logo;
    private JLabel lbl_register;
    private JLabel lbl_logout;
    private JLabel lbl_back;
    private JLabel lbl_refresh;
    private JLabel lbl_add;
    private JLabel lbl_edit;
    private JLabel lbl_delete;
    private JLabel lbl_customer;
    private JLabel lbl_email;
    private JLabel lbl_password;
    private JLabel lbl_phone;

    public table() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {




                jFrame.setSize(600, 500);
                LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT, 0, 20);
                jFrame.setLayout(layoutManager);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JTextField usernameField = new JTextField();
                usernameField.setColumns(16);
                jFrame.add(usernameField);


                final JTextField passwordField = new JTextField();
                passwordField.setColumns(16);
                jFrame.add(passwordField);

                JButton loginButton = new JButton("Login");
                jFrame.add(loginButton);

                JButton regButton = new JButton("Sign Up");
                jFrame.add(regButton);

                JLabel message = new JLabel("");
                jFrame.add(message);

                String[] columns = new String[]{"id","username","password"};

                ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
                DBcon userDao = applicationContext1.getBean("DBCon", DBcon.class);

//                String[][] rows = (String[][]) userDao
//                        .getAllUsers()
//                        .stream()
//                        .map(user-> new String[]{
//                                String.valueOf(user.getId()),
//                                user.getUsername(),
//                                user.getPassword()
//                        }).toArray();
                List<customers> users = userDao.getAllUsers();

                String[][] rows = new String[users.size()][3];
                int index = 0;
                for (customers user : users){
                    rows[index] = new String[]{String.valueOf(user.getId()),user.getEmail(),user.getPassword()};
                    System.out.println(rows[index][1]);
                }

                JTable usersTable = new JTable(rows,columns);
                jFrame.add(usersTable);


//                regButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String username = usernameField.getText();
//                        String password = passwordField.getText();
//                        message.setText(userDao.addUser(username,password)>0?"Sign Up Successful":"Sign Up Error");
//                    }
//                });

//                loginButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String username = usernameField.getText();
//                        String password = passwordField.getText();
//                        message.setText(userDao.authenticateUser(username,password));
//                    }
//                });

            }
        });
    }




    public void createUI() {
        jFrame.setContentPane(form_table);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Table");
        jFrame.setIconImage(new ImageIcon("src/images/logo.png").getImage());
    }


    private void getAllUser () {
            ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
            DBcon DBCon = applicationContext1.getBean("DBCon", DBcon.class);
            String[] columns = new String[]{"id", "username", "password"};
            List<customers> users = DBCon.getAllUsers();

            String[][] rows = new String[users.size()][3];
            int index = 0;
            for (customers user : users) {
                rows[index] = new String[]{String.valueOf(user.getId()), user.getEmail(), user.getPassword()};
                System.out.println(rows[index][1]);
            }

            JTable usersTable = new JTable(rows, columns);
            jFrame.add(usersTable);
        }
    }

