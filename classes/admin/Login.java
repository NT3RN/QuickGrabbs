package classes.admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class Login {
    private JFrame frame;
    private JLabel title, title1;
    private JLabel shortNote, loginRemainder;
    private JButton loginButton1, signUpButton, exitButton;


    Font TitleFont = new Font("Ink Free", Font.BOLD, 50);
    Font BodyFont = new Font("Grandview", Font.PLAIN, 20);

    public Login(){
        frame = new JFrame("Quick Grabbs");
    
        
        ImageIcon framelogo = new ImageIcon("icons/frame_logo.png");
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
        //need to add action listeners
        frame.add(loginButton1);
        
        signUpButton = new JButton("Sign Up");
        signUpButton.setForeground(Color.decode("#E759E4"));
        signUpButton.setFont(BodyFont);
        signUpButton.setBounds(380, 180, 80,25);
        signUpButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        signUpButton.setBackground(new Color(0, 0, 0, 0)); // RGB values are 0 and alpha is 0
        signUpButton.setOpaque(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //need to add action listeners
        frame.add(signUpButton);

        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.decode("#E759E4"));
        exitButton.setFont(BodyFont);
        exitButton.setBounds(330, 220, 70, 25);
        exitButton.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        //makes background transparent
        exitButton.setBackground(new Color(0, 0, 0, 0)); // RGB values are 0 and alpha is 0
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//need to add action listeners
        frame.add(exitButton);
    
        
        frame.setSize(800, 600);
        frame.setResizable(false);
        //makes layout visible
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}