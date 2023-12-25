package classes.admin;


import java.lang.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Adminlogin extends JFrame implements ActionListener {

   JFrame frame;
   private JLabel userL, passL, imageL, textL;
   private JTextField tf;
   private JPasswordField pf;
   private JButton loginB, backB;
   private Container c;
   private Font f,f2;
   

    public Adminlogin(){
        frame = new JFrame("Admin LogIn"); //create obj of frame

        
        

        //for all type of screen size
        Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (scSize.width - 800)/2;
        int h = (scSize.height - 600)/2;
        frame.setBounds(w,h,800,600);
        
        frame.setIconImage(new ImageIcon(getClass().getResource("/icons/framelogo.png")).getImage());




        c = frame.getContentPane(); // put in to container
        c.setLayout(null);

        f = new Font("Arial",Font.BOLD,18);
        f2 = new Font("Arial",Font.BOLD,11);

        textL = new JLabel("!!Hello!!");
        textL.setBounds(300,50,200,50);
        textL.setFont(new Font("Roboto", Font.PLAIN, 50));
        c.add(textL);
        


        // for user
        userL = new JLabel("Username: ");
        userL.setBounds(50,180,150,50);
        userL.setFont(f);
        c.add(userL);
        tf = new JTextField(); //for write text
        tf.setFont(f);
        tf.setBounds(170,180,200,50);
        c.add(tf);

        //for pass
        passL = new JLabel("Password: ");
        passL.setBounds(50,250,150,50);
        passL.setFont(f);
        c.add(passL);
        pf = new JPasswordField(); //for write password text
        pf.setFont(f);
        pf.setBounds(170,250,200,50);
        c.add(pf);
        
        //log button
        loginB = new JButton("Log In");
        loginB.setBounds(170,320,90,50);
        loginB.setFont(f2);
        c.add(loginB);
        loginB.addActionListener(this);

        //Back button
        backB = new JButton("Back");
        backB.setBounds(280,320,90,50);
        backB.setFont(f2);
        c.add(backB);
        backB.addActionListener(this);


        
        

        //add image in background
        imageL = new JLabel();
        imageL.setIcon(new ImageIcon("icons/quickgrab2.png")); //image location
        Dimension size1 = imageL.getPreferredSize(); //for same as frame size
        imageL.setBounds(0, 0, size1.width, size1.height);
        c.add(imageL);
        

        frame.setVisible(true); //for frame run
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for frame close


       

        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginB){
            String userN= tf.getText();
            String passW = pf.getText();

            if(userN.equals("admin") && passW.equals("admin")){
             new AdminWindow(); // move to another window
             
             frame.setVisible(false);

            }
            else{
                
                try{
                    BufferedReader br = new BufferedReader(new FileReader("data\\admin_data\\admin_data.txt"));
                    ArrayList<String> lines = new ArrayList<>();
                    lines.addAll(br.lines().toList());  // lines into arraylist

                     
                     // only show the even lines
                     for (int i = 1; i< lines.size(); i+=2) {
                          String line = lines.get(i).trim();
                          String[] data = line.split(" - ");

                          if (data.length == 3 && data[0].equals(userN)) { 
                        
                            if (data[1].equals(passW)) { 
                                frame.setVisible(false);
                                new AdminWindow();
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Password or Username!", "Warning!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                         }else {
                                JOptionPane.showMessageDialog(null, "Invalid Password or Username!", "Warning!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
           
                        }
                    br.close();
                } catch (IOException e1) {
                       System.out.println(e1);
                    }
            }
            
            
             
            }
        
        else if (e.getSource()==backB){
            new Login();
            frame.setVisible(false);
            

        }
                
       
    }
    
}
