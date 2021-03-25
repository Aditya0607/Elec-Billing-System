package Electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4;
    JTextField t1;
    JPasswordField P1;
    JButton b1, b2, b3;
    JPanel p1, p2, p3, p4;
    Choice c1;
    Login(){
        super("Login");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1 = new JLabel("Username");
        l1.setBounds(300,20,100,20);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300,60,100,20);
        add(l2);

        t1 = new JTextField(15);
        t1.setBounds(400,20,150,20);
        add(t1);
        P1 = new JPasswordField(15);
        P1.setBounds(400,60,150,20);
        add(P1);

        l4 = new JLabel("Logging in as ");
        l4.setBounds(300,100,100,20);
        add(l4);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400,100,150,20);
        add(c1);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image image1 = imageIcon1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(image1));
        b1.setBounds(330,160,100,20);
        add(b1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("images/cancel.png"));
        Image image2 = imageIcon2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(image2));
        b2.setBounds(450,160,100,20);
        add(b2);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("images/signup.png"));
        Image image4 = imageIcon4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("Sign Up", new ImageIcon(image4));
        b3.setBounds(380,200,130,20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("images/person.jpg"));
        Image image3 = imageIcon3.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon_3 = new ImageIcon(image3);
        l3 = new JLabel(imageIcon_3);
        l3.setBounds(0,0,250,250);

        setLayout(new BorderLayout());

        setSize(640, 300);
        setLocation(600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == b1){
            try{
                Conn C1 = new Conn();
                String u = t1.getText();
                String p = String.valueOf(P1.getPassword());
                String user = c1.getSelectedItem();
                String q = "select * from login where username = '"+u+"' and password = '"+p+"' and user = '"+user+"'";
                ResultSet rs = C1.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(meter,user).setVisible(true);
                    this.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    t1.setText("");
                    P1.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Error : " + e);
            }
        }else if(actionEvent.getSource() == b2){
            this.setVisible(false);
        }else if(actionEvent.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
