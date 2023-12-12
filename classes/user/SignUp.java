package classes.user;
import classes.admin.*;
import interfaces.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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




public class SignUp implements ActionListener, ISignUp{
    private JFrame frame;
    private JLabel signUpLabel, userName, userPass, cuserPass, mail;
    private JTextField userNameTF, mailTF;
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
 
        userNameTF = new JTextField();
        userNameTF.setBounds(300, 180, 200, 30);
        userNameTF.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        userNameTF.setFont(DefaultFont);
        userNameTF.setVisible(true);
        frame.add(userNameTF);        
        
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
        
        mail = new JLabel("Email:");
        mail.setBounds(300, 330, 200, 30);
        mail.setFont(DefaultFont);
        mail.setVisible(true);
        frame.add(mail);

        mailTF = new JTextField();
        mailTF.setBounds(300, 360, 200, 30);
        mailTF.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        mailTF.setFont(DefaultFont);
        mailTF.setVisible(true);
        frame.add(mailTF);

        signup = new JButton("Sign Up");
        signup.setForeground(Color.WHITE);
        signup.setFont(DefaultFont);
        signup.setBounds(300, 400, 80, 25);
        signup.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        signup.setBackground(Color.decode("#3E9AD0"));
        signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signup.addActionListener(this);
        frame.add(signup);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setFont(DefaultFont);
        cancel.setBounds(420, 400, 80, 25);
        cancel.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        cancel.setBackground(Color.decode("#EE7EDF"));
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        frame.add(cancel);


        exit = new JButton("Exit");
        exit.setForeground(Color.WHITE);
        exit.setFont(DefaultFont);
        exit.setBounds(350, 500, 70, 25);
        exit.setBorder(new LineBorder(Color.decode("#254C53"), 2));
        exit.setBackground(Color.decode("#D03E3E"));
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.addActionListener(this);
        frame.add(exit);


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

        else if(e.getSource()==signup){
            String username = userNameTF.getText();
            String password = passfUser.getText();
            String confirmPass = cpassfUser.getText();
            String email = mailTF.getText();

            if(username.isEmpty()==false && password.isEmpty()==false && email.isEmpty()==false){
                if(confirmPass.equals(password)){
                    try{
                        File file = new File("data\\user\\user_data.txt");
                        if(file.exists()==false){
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        LocalDateTime myDateTime = LocalDateTime.now();
                        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                        String timeAndDate = myDateFormat.format(myDateTime);

                        pw.println("User Name: "+ username);
                        pw.println("Password : "+ password);
                        pw.println("Email    : "+ email);
                        pw.println("Time & Date: "+ timeAndDate);
                        pw.println("***********************************");
                        pw.close();

                        JOptionPane.showMessageDialog(null, "New user account created successfully!","User created", JOptionPane.INFORMATION_MESSAGE);
                        userNameTF.setText(null);
                        passfUser.setText(null);
                        cpassfUser.setText(null);
                        mailTF.setText(null);
                        frame.setVisible(false);
                        new Login();
                    }

                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Something went wrong!","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password does not match!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please fill up all the fields!");
            }
        }
        else if(e.getSource()==cancel){
            frame.setVisible(false);
            new Login();
        }


        else if(e.getSource()==exit){
            System.exit(0);
        }

    }
    
}
