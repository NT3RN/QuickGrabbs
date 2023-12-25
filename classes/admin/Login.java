package classes.admin;
import interfaces.*;
import classes.user.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;



public class Login implements ActionListener, Ilogin {
    private JFrame frame;
    private JLabel title, title1;
    private JLabel shortNote, loginRemainder;
    private JButton loginButton1, signUpButton, exitButton, adminButton;
    private JButton loginButton2, forgotPassB;
    private JButton goBack;
    private JLabel userName, userPass;
    private JTextField userNameField;
    private JPasswordField passfUser;
    private ImageIcon on, off;
    private JToggleButton showPass;


    Font TitleFont = new Font("Ink Free", Font.BOLD, 50);
    Font BodyFont = new Font("Grandview", Font.PLAIN, 20);
    Font DefaultFont = new Font("Grandview", Font.BOLD, 15);

    public Login(){
        frame = new JFrame("Quick Grabbs");
    
        
        ImageIcon framelogo = new ImageIcon("icons/framelogo.png");
        frame.setIconImage(framelogo.getImage());


        Image background = new ImageIcon("icons/quickgrab.png").getImage();
        frame.setContentPane(new ImagePanel(background)); //sets images accorting to background

        
        title = new JLabel("QUICK");
        title.setForeground(Color.decode("#525151"));
        title.setFont(TitleFont);
        title.setBounds(200, 40, 300, 70);
        frame.add(title);

        title1 = new JLabel("GRABBS");
        title1.setForeground(Color.decode("#525151"));
        title1.setFont(TitleFont);
        title1.setBounds(350, 90, 300, 70);
        frame.add(title1);

        shortNote = new JLabel("Grab Your Food");
        shortNote.setForeground(Color.decode("#C93D3D"));
        shortNote.setFont(BodyFont);
        shortNote.setBounds(300, 130, 380,60);
        frame.add(shortNote);

        //text that remainds to log in or Sign up
        loginRemainder = new JLabel("Login or Sign Up to Continue");
        loginRemainder.setForeground(Color.decode("#85C93C"));
        loginRemainder.setFont(BodyFont);
        loginRemainder.setBounds(240, 180, 380,60);
        frame.add(loginRemainder);

        loginButton1 = new JButton("Login");
        loginButton1.setForeground(Color.WHITE);
        loginButton1.setFont(DefaultFont);
        loginButton1.setBounds(290, 240, 70,25);
        loginButton1.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        loginButton1.setBackground(Color.decode("#73D052"));
        loginButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton1.addActionListener(this);
        frame.add(loginButton1);
        
        signUpButton = new JButton("Sign Up");
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(DefaultFont);
        signUpButton.setBounds(380, 240, 80,25);
        signUpButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        signUpButton.setBackground(Color.decode("#73D052"));
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.addActionListener(this);
        frame.add(signUpButton);

        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(DefaultFont);
        exitButton.setBounds(330, 500, 70, 25);
        exitButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        exitButton.setBackground(Color.decode("#D03E3E"));
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.addActionListener(this);
        frame.add(exitButton);

        adminButton = new JButton("Admin");
        adminButton.setForeground(Color.BLACK);
        adminButton.setFont(DefaultFont);
        adminButton.setBounds(700, 10, 70, 25);
        adminButton.setBorder(new LineBorder(Color.decode("#B2BF3D"), 2));
        adminButton.setBackground(Color.decode("#B2BF3D"));
        adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminButton.addActionListener(this);
        frame.add(adminButton);



        //user name text and password with box
        userName = new JLabel("Username:");
        userName.setBounds(30, 230, 200, 30);
        userName.setFont(DefaultFont);
        userName.setVisible(false);
        frame.add(userName);
 
        userNameField = new JTextField();
        userNameField.setBounds(30, 260, 200, 30);
        userNameField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        userNameField.setFont(DefaultFont);
        userNameField.setVisible(false);
        frame.add(userNameField);        
        
        userPass = new JLabel("Password:");
        userPass.setBounds(30, 300, 200, 30);
        userPass.setFont(DefaultFont);
        userPass.setVisible(false);
        frame.add(userPass);
        

        passfUser = new JPasswordField();
        passfUser.setBounds(30, 330, 200, 30);
        passfUser.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        passfUser.setEchoChar('*');
        passfUser.setToolTipText("Enter password");
        passfUser.setVisible(false);
        frame.add(passfUser);

        //login button after clicking login
        loginButton2 = new JButton("Login");
        loginButton2.setFont(DefaultFont);
        loginButton2.setForeground(Color.WHITE);
        loginButton2.setBounds(30, 370, 70, 25);
        loginButton2.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        loginButton2.setBackground(Color.decode("#73D052"));
        loginButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton2.setVisible(false);
        loginButton2.addActionListener(this);
        frame.add(loginButton2);

        //go back to Start Screen
        goBack = new JButton("Back");
        goBack.setForeground(Color.WHITE);
        goBack.setFont(DefaultFont);
        goBack.setBounds(110, 370, 70, 25);
        goBack.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        goBack.setBackground(Color.decode("#254C53")); 
        goBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goBack.setVisible(false);
        goBack.addActionListener(this);
        frame.add(goBack);


        //forgot password button
        forgotPassB = new JButton("Forgot Password?");
        forgotPassB.setForeground(Color.WHITE);
        forgotPassB.setFont(DefaultFont);
        forgotPassB.setBounds(30, 400, 150, 25);
        forgotPassB.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        forgotPassB.setBackground(Color.decode("#D03E3E")); 
        forgotPassB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPassB.setVisible(false);
        forgotPassB.addActionListener(this);
        //frame.add(forgotPassB);  //can be added later if required

        //Toggle button for showing password
        on = new ImageIcon("icons/eyeopen.png");
        off = new ImageIcon("icons/eyeclose.png");
        showPass = new JToggleButton();
        showPass.setBounds(230, 330, 30, 30);
        showPass.setIcon(off);
        showPass.setBackground(new Color(0,0,0,0));
        showPass.setOpaque(false);
        showPass.setBorder(BorderFactory.createEmptyBorder());
        showPass.setFocusable(false);
        showPass.setToolTipText("Show Password");
        showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPass.setVisible(false);
        frame.add(showPass);
        showPass.addActionListener(this);


        frame.setSize(800, 600);
        frame.setResizable(false);
        //makes layout visible
        frame.setVisible(true);
        frame.setLayout(null); //controlls position and size
        frame.setLocationRelativeTo(null); //position relative to screen mainly center
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
    }
        @Override
        public void actionPerformed(ActionEvent e) {

                //for toggle button
                if(e.getSource()==showPass){
                    if(showPass.isSelected()){
                        showPass.setIcon(on);
                        showPass.setToolTipText("Hide Password");
                        passfUser.setEchoChar((char)0);
                    }
                    else{
                        showPass.setIcon(off);
                        showPass.setToolTipText("Show Password");
                        passfUser.setEchoChar('*');
                    }
                }

                //for login button on start Screen
                if(e.getSource() == loginButton1){
                    loginRemainder.setVisible(false);
                    loginButton1.setVisible(false);
                    signUpButton.setVisible(false);
                    shortNote.setVisible(false);
                    loginButton2.setVisible(true);
                    goBack.setVisible(true);
                    forgotPassB.setVisible(true);
                    userName.setVisible(true);
                    userNameField.setVisible(true);
                    userPass.setVisible(true);
                    passfUser.setVisible(true);
                    showPass.setVisible(true);
                    userNameField.setText(null);
                    passfUser.setText(null);
                }

                if(e.getSource() == loginButton2){
                    String user = userNameField.getText();
                    String pass = passfUser.getText();
                    if(user.isEmpty() || pass.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter username and password", "Error!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else{
                        try{
                            String userNameL = "User Name: "+user;
                            String passwordL = "Password : "+pass;
                            BufferedReader reader = new BufferedReader(new FileReader("data\\user_data\\user_data.txt"));
                    
                            String line;
                            boolean found = false;
                            while ((line = reader.readLine()) != null) {
                                if(line.equals(userNameL)){
                                    found = true;
                                    if((line = reader.readLine()) != null && line.equals(passwordL)){
                                        frame.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "login working", "eaah!!!", JOptionPane.INFORMATION_MESSAGE);
                                        new Login(); //TODO change to next page
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid password!", "Warning!",
                                                JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                }
                            }
                    
                            if (!found) {
                                JOptionPane.showMessageDialog(null, "Invalid username!", "Warning!",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                    
                            reader.close();
                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Error reading user data!", "Warning!",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        
                    }
            }

                else if(e.getSource() == goBack) {
                    loginRemainder.setVisible(true);
                    loginButton1.setVisible(true);
                    signUpButton.setVisible(true);
                    shortNote.setVisible(true);
                    loginButton2.setVisible(false);
                    goBack.setVisible(false);
                    forgotPassB.setVisible(false );
                    userName.setVisible(false);
                    userNameField.setVisible(false);
                    userPass.setVisible(false);
                    passfUser.setVisible(false);
                    showPass.setVisible(false);                    
                }

                else if (e.getSource() == signUpButton) {
                    frame.setVisible(false);
                    new SignUp();
                    }
                else if (e.getSource() == exitButton) {
                    
                    System.exit(0);
                
                
                    }
                else if (e.getSource() == adminButton){
                frame.setVisible(false);
                new Adminlogin();
                // System.exit(0); temporarily TODO change to admin login Aditto
                    }   
                
        }
}