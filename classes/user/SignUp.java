package classes.user;
import interfaces.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SignUp {
    private JFrame frame;
    private JLabel signUpLabel;

    Font SignUpFont = new Font("Grandview", Font.BOLD, 30);
    Font BodyFont = new Font("Grandview", Font.PLAIN, 20);
    Font DefaultFont = new Font("Grandview", Font.BOLD, 15);

    public SignUp() {
        frame = new JFrame("QUICK GRABBS");

        ImageIcon sBackground = new ImageIcon("icons/signup_bg.png");
        frame.setContentPane(new JLabel(sBackground));
        
        ImageIcon framelogo = new ImageIcon("icons/framelogo.png");
        frame.setIconImage(framelogo.getImage());
        
        //Text in this frame
        signUpLabel = new JLabel("Sign Up Here");
        signUpLabel.setFont(SignUpFont);
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setBounds(350, 100, 200, 30);
        signUpLabel.setFont(SignUpFont);
        frame.add(signUpLabel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}

