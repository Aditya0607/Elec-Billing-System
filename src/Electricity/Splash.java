package Electricity;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class Splash {
    public static void main(String[] args) {
        fframe f1 = new fframe();
        f1.setVisible(true);
        int x = 1;
        for(int i = 2; i <= 600; i += 4, x += 1){
            f1.setLocation(800 - ((i + x) / 2), 500 - (i / 2));
            f1.setSize(i + x , i);
            try{
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class fframe extends JFrame implements Runnable{
    Thread thread;
    fframe(){
        super("Electricity Billing System");
        setLayout(new FlowLayout());
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/elect.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel l1 = new JLabel(imageIcon1);
        add(l1);
        thread = new Thread(this);
        thread.start();
    }
    public void run() {
        try{
            Thread.sleep(7000);
            this.setVisible(false);

            Login l = new Login();
            l.setVisible(true);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
