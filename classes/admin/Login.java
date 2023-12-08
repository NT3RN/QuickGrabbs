package classes.admin;
import interfaces.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;



public class Login implements ActionListener, Ilogin {
    private JFrame frame;
    private JLabel title, title1;
    private JLabel shortNote, loginRemainder;
    private JButton loginButton1, signUpButton, exitButton, adminButton;
    private JButton loginButton2, forgotPassB;
    private JButton previousButton;
    private JLabel userName, userPass, confirmUserPass;
    private JTextField userNameField, userPassField, confirmUserPassField;
    private ImageIcon on, off;
    private JToggleButton showPass;


    Font TitleFont = new Font("Ink Free", Font.BOLD, 50);
    Font BodyFont = new Font("Grandview", Font.PLAIN, 20);
    Font DefaultFont = new Font("Grandview", Font.PLAIN, 15);

    public Login(){
        frame = new JFrame("Quick Grabbs");
    
        
        ImageIcon framelogo = new ImageIcon("icons/framelogo.png");
        frame.setIconImage(framelogo.getImage());


        Image background = new ImageIcon("icons/quickgrab.png").getImage();
        frame.setContentPane(new ImagePanel(background)); //sets images accorting to background

        
        title = new JLabel("QUICK");
        title.setForeground(Color.decode("#525151"));
        title.setFont(TitleFont);
        title.setBounds(200, 10, 300, 70);
        frame.add(title);

        title1 = new JLabel("GRABBS");
        title1.setForeground(Color.decode("#525151"));
        title1.setFont(TitleFont);
        title1.setBounds(350, 40, 300, 70);
        frame.add(title1);

        shortNote = new JLabel("Grab Your Food");
        shortNote.setForeground(Color.decode("#C93D3D"));
        shortNote.setFont(BodyFont);
        shortNote.setBounds(300, 80, 380,60);
        frame.add(shortNote);

        //text that remainds to log in or Sign up
        loginRemainder = new JLabel("Login or Sign Up to Continue");
        loginRemainder.setForeground(Color.decode("#85C93C"));
        loginRemainder.setFont(BodyFont);
        loginRemainder.setBounds(240, 130, 380,60);
        frame.add(loginRemainder);

        loginButton1 = new JButton("Login");
        loginButton1.setForeground(Color.decode("#E759E4"));
        loginButton1.setFont(BodyFont);
        loginButton1.setBounds(290, 180, 70,25);
        loginButton1.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        loginButton1.setBackground(new Color(0, 0, 0, 0)); // RGB values are 0 and alpha is 0
        loginButton1.setOpaque(false);
        loginButton1.setContentAreaFilled(false);
        loginButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton1.addActionListener(this);
        frame.add(loginButton1);
        
        signUpButton = new JButton("Sign Up");
        signUpButton.setForeground(Color.decode("#E759E4"));
        signUpButton.setFont(BodyFont);
        signUpButton.setBounds(380, 180, 80,25);
        signUpButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        //next 3 line making background transparent for the button
        signUpButton.setBackground(new Color(0, 0, 0, 0)); // RGB values are 0 and alpha is 0
        signUpButton.setOpaque(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.addActionListener(this);
        frame.add(signUpButton);

        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.decode("#E759E4"));
        exitButton.setFont(BodyFont);
        exitButton.setBounds(330, 220, 70, 25);
        exitButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        exitButton.setBackground(new Color(0, 0, 0, 0)); 
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.addActionListener(this);
        frame.add(exitButton);

        adminButton = new JButton("Admin");
        adminButton.setForeground(Color.decode("#E70909"));
        adminButton.setFont(BodyFont);
        adminButton.setBounds(700, 10, 70, 25);
        adminButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        adminButton.setBackground(new Color(0, 0, 0, 0)); 
        adminButton.setOpaque(false);
        adminButton.setContentAreaFilled(false);
        adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminButton.addActionListener(this);
        frame.add(adminButton);

        //login button after clicking login
        loginButton2 = new JButton("Login");
        loginButton2.setFont(BodyFont);
        loginButton2.setForeground(Color.decode("#E759E4"));
        loginButton2.setBounds(470, 180, 70,25);
        loginButton2.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        loginButton2.setBackground(new Color(0, 0, 0, 0));
        loginButton2.setOpaque(false);
        loginButton2.setContentAreaFilled(false);
        loginButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton2.setVisible(false);
        loginButton2.addActionListener(this);
        frame.add(loginButton2);


        previousButton = new JButton("Back");
        previousButton.setForeground(Color.decode("#E70909"));
        previousButton.setFont(BodyFont);
        previousButton.setBounds(610, 10, 70, 25);
        previousButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        previousButton.setBackground(new Color(0, 0, 0, 0)); 
        previousButton.setOpaque(false);
        previousButton.setContentAreaFilled(false);
        previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previousButton.setVisible(false);
        previousButton.addActionListener(this);
        frame.add(previousButton);

        //forgot password button
        forgotPassB = new JButton("Forgot Password?");
        forgotPassB.setForeground(Color.decode("#E70909"));
        forgotPassB.setFont(BodyFont);
        forgotPassB.setBounds(610, 50, 70, 25);
        forgotPassB.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        forgotPassB.setBackground(new Color(0, 0, 0, 0)); 
        forgotPassB.setOpaque(false);
        forgotPassB.setContentAreaFilled(false);
        forgotPassB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPassB.setVisible(false);
        forgotPassB.addActionListener(this);
        frame.add(forgotPassB);
    
        
        frame.setSize(800, 600);
        frame.setResizable(false);
        //makes layout visible
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == loginButton1){
                loginRemainder.setVisible(false);
                loginButton1.setVisible(false);
                signUpButton.setVisible(false);
                shortNote.setVisible(false);
                loginButton2.setVisible(true);
                previousButton.setVisible(true);
                forgotPassB.setVisible(true);
                    }   
                else if (e.getSource() == signUpButton) {
                System.exit(0); //temporarily
                    }
                else if (e.getSource() == exitButton) {
                System.exit(0);
                
                    }
                else if (e.getSource() == adminButton){
                // frame.setVisible(false);
                System.exit(0); //temporarily
                //new AdminLogin();
                    }   
                
        }
}