package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Project extends JFrame implements ActionListener{
    String meter;
    Project(String meter , String mode) {
        super("Electricity Bill Generator");
        setSize(700,700);
        getContentPane().setBackground(Color.gray);

        /* Adding background image and text message */
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("images/elect.jpg"));
        Image i1 = ic.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i1);
        JLabel l1 = new JLabel(icc3);


        JLabel l2= new JLabel("This is our Electricity Billing System");
        l2.setBounds(0, 0, 200, 26);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 24));
        l2.setVerticalTextPosition(JLabel.BOTTOM);
        l2.setHorizontalTextPosition(JLabel.CENTER);
        l2.setForeground(Color.white);

        add(l1);
        add(l2);

        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Calculate Bill");


        /* ---- New Customer ---- */
        m1.setFont(new Font("Calibre",Font.PLAIN,12));
        m1.setBackground(Color.WHITE);

        /* ---- Customer Details ---- */
        m2.setFont(new Font("Calibre",Font.PLAIN,12));
        m2.setBackground(Color.WHITE);

        /* ---- Calculate Bill ---- */
        m3.setFont(new Font("monospaced",Font.PLAIN,12));
        m3.setBackground(Color.WHITE);


        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        // --------------------------------------------------------------------------------------------

        /* Second Column */
        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");
        info.setForeground(Color.RED);

        info1.setFont(new Font("monospaced",Font.PLAIN,12));
        info1.setBackground(Color.WHITE);

        info2.setFont(new Font("monospaced",Font.PLAIN,12));
        info2.setBackground(Color.WHITE);

        info1.addActionListener(this);
        info2.addActionListener(this);


        // --------------------------------------------------------------------------------------------

        /* Third Column */
        JMenu user = new JMenu("Options");
        JMenuItem u1 = new JMenuItem("Bill Details");
        JMenuItem u2 = new JMenuItem("Generate Bill");
        JMenuItem u3 = new JMenuItem("Logout");
        user.setForeground(Color.RED);



        /* ---- Bill Details ----*/
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        u1.setBackground(Color.WHITE);

        /* ---- Generate Bill ---- */
        u2.setFont(new Font("Calibre",Font.PLAIN,12));
        u2.setBackground(Color.WHITE);

        /* ---- Exit ---- */
        u3.setFont(new Font("Calibre",Font.PLAIN,12));
        u3.setBackground(Color.WHITE);


        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);


        // ---------------------------------------------------------------------------------------------

        mb.setAlignmentX(100);
        mb.setAlignmentY(100);

        master.add(m1);
        master.add(m2);
        master.add(m3);

        info.add(info1);
        info.add(info2);

        user.add(u1);
        user.add(u2);
        user.add(u3);


        mb.add(master);
        mb.add(info);
        mb.add(user);

        setJMenuBar(mb);


        setFont(new Font("Sanserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }



    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
        }else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);
        }else if(msg.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);
        }
//        else if(msg.equals("View Information")){
//            new ViewInformation(meter).setVisible(true);
//        }else if(msg.equals("Update Information")){
//            new UpdateInformation(meter).setVisible(true);
//        }
        else if(msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);
        }else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }


    public static void main(String[] args)  {
        new Project("","").setVisible(true);
    }
}
