package classes.admin;

import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame implements ActionListener {
    JFrame wf;
    private Container c;
    private Font f;
    private JLabel WtextL, imageL;
    private JButton userB,backB,  adminB;

    AdminWindow(){
        wf = new JFrame("Admin Window");
        wf.setIconImage(new ImageIcon(getClass().getResource("/icons/framelogo.png")).getImage());

        //for all type of screen size
        Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (scSize.width - 800)/2;
        int h = (scSize.height - 600)/2;
        wf.setBounds(w,h,800,600);


        c = wf.getContentPane(); // put in to container
        c.setLayout(null);

        f = new Font("Arial",Font.BOLD,11);

        WtextL = new JLabel("Welcome Back");
        WtextL.setBounds(259,50,300,50);
        WtextL.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        c.add(WtextL);

        //user info button
        userB = new JButton("User Information");
        userB.setBounds(290,200,200,70);
        userB.setFont(f);
        c.add(userB);
        userB.addActionListener(this);

        // admin info button
        adminB = new JButton("Admin Information");
        adminB.setBounds(290,350,200,70);
        adminB.setFont(f);
        c.add(adminB);
        adminB.addActionListener(this);


        //Back button
        backB = new JButton("Back");
        backB.setBounds(680,500,90,30);
        backB.setFont(f);
        c.add(backB);
        backB.addActionListener(this);


        //add image in background
        imageL = new JLabel();
        imageL.setIcon(new ImageIcon("icons/signup_bg.png")); //image location
        Dimension size1 = imageL.getPreferredSize(); //for same as frame size
        imageL.setBounds(0, 0, size1.width, size1.height);
        c.add(imageL);

        wf.setVisible(true);
        wf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==userB){
            Adminuserinfo uw= new Adminuserinfo();
            uw.setVisible(false);
            wf.setVisible(false);
        }
        
       
        else if(e.getSource()==adminB){
            Adminaddadmin a = new Adminaddadmin();
            a.setVisible(false);
            wf.setVisible(false);
        }
        else if(e.getSource()==backB){
            Adminlogin al = new Adminlogin();
            al.setVisible(false);
            wf.setVisible(false);
        }
        
    }
    
    
}