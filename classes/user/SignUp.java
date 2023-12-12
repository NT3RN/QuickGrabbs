package classes.user;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import interfaces.ISignUp;


public class SignUp implements ActionListener, ISignUp{
    private JFrame frame;
    private JLabel signUpLabel, userName, userPass, cuserPass;
    private JTextField userNameField;
    private JPasswordField passfUser, cpassfUser;
    private ImageIcon on, off;
    private JToggleButton showPass;
    private JButton signup, cancel, exit;

    Font SignUpFont = new Font("Grandview", Font.BOLD, 30);
    Font BodyFont = new Font("Grandview", Font.PLAIN, 20);
    Font DefaultFont = new Font("Grandview", Font.BOLD, 15);

    public SignUp() {
        frame = new JFrame("QUICK GRABBS");

        ImageIcon background = new ImageIcon("icons/signup_bg.png");
        frame.setContentPane(new JLabel(background));
        
        ImageIcon framelogo = new ImageIcon("icons/framelogo.png");
        
        
        //Text in this frame
        signUpLabel = new JLabel("Sign Up Here");
        signUpLabel.setFont(SignUpFont);
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setBounds(300, 100, 250, 35);
        signUpLabel.setFont(SignUpFont);
        frame.add(signUpLabel);

        userName = new JLabel("Username:");
        userName.setBounds(300, 150, 200, 30);
        userName.setFont(DefaultFont);
        userName.setVisible(true);
        frame.add(userName);
 
        userNameField = new JTextField();
        userNameField.setBounds(300, 180, 200, 30);
        userNameField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        userNameField.setFont(DefaultFont);
        userNameField.setVisible(true);
        frame.add(userNameField);        
        
        userPass = new JLabel("Password:");
        userPass.setBounds(300, 210, 200, 30);
        userPass.setFont(DefaultFont);
        userPass.setVisible(true);
        frame.add(userPass);
        

        passfUser = new JPasswordField();
        passfUser.setBounds(300, 240, 200, 30);
        passfUser.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        passfUser.setEchoChar('*');
        passfUser.setToolTipText("Enter password");
        passfUser.setVisible(true);
        frame.add(passfUser);

        //Toggle button for showing password
        on = new ImageIcon("icons/eyeopen.png");
        off = new ImageIcon("icons/eyeclose.png");
        showPass = new JToggleButton();
        showPass.setBounds(510, 240, 30, 30);
        showPass.setIcon(off);
        showPass.setBackground(new Color(0,0,0,0));//invisible background
        showPass.setOpaque(false);
        showPass.setBorder(BorderFactory.createEmptyBorder());
        showPass.setFocusable(false);
        showPass.setToolTipText("Show Password");
        showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPass.setVisible(true);
        frame.add(showPass);
        showPass.addActionListener(this);


        //confirm password
        cuserPass= new JLabel();
        cuserPass.setText("Confirm Password:");
        cuserPass.setBounds(300, 270, 200, 30);
        cuserPass.setFont(DefaultFont);
        cuserPass.setVisible(true);
        frame.add(cuserPass);

        cpassfUser = new JPasswordField();
        cpassfUser.setBounds(300, 300, 200, 30);
        cpassfUser.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        cpassfUser.setEchoChar('*');
        cpassfUser.setToolTipText("Enter password");
        cpassfUser.setVisible(true);
        frame.add(cpassfUser);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setIconImage(framelogo.getImage());
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        //toggle password visibility
        if(e.getSource()==showPass){
            if(showPass.isSelected()){
                showPass.setIcon(on);
                showPass.setToolTipText("Hide Password");
                passfUser.setEchoChar((char)0);
                cpassfUser.setEchoChar((char)0);
            }
            else{
                showPass.setIcon(off);
                showPass.setToolTipText("Show Password");
                passfUser.setEchoChar('*');
                cpassfUser.setEchoChar('*');
            }
        }

    }
    
}
