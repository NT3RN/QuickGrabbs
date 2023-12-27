package classes.admin;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import interfaces.*;


public class AdminUserinfo extends JFrame implements ActionListener {
    JFrame w2f;
    private Container c;
    private Font f;
    private JLabel WtextL, imageL,uL,pL,eL;
    private JTextField uT,pT,eT;
    private JButton backB,addB,delB,clB;
    private JButton logOutB;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel m;

    private String[] columns = {"Customer's Record"};
    private String[] rows = new String[3];

    AdminUserinfo(){

        w2f=new JFrame("User Information");
        w2f.setIconImage(new ImageIcon(getClass().getResource("/icons/framelogo.png")).getImage());

        

        //for all type of screen size
        Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (scSize.width - 800)/2;
        int h = (scSize.height - 600)/2;
        w2f.setBounds(w,h,800,600);

        c = w2f.getContentPane(); // put in to container
        c.setLayout(null);

        f = new Font("Arial",Font.BOLD,11);

        WtextL = new JLabel("All Data of User");
        WtextL.setBounds(250,15,350,40);
        WtextL.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        c.add(WtextL);

        //for username
        uL = new JLabel("Username:");
        uL.setBounds(20,80,140,30);
        uL.setFont(f);
        c.add(uL);

        uT= new JTextField();
        uT.setBounds(105,80,260,30);
        uT.setFont(f);
        c.add(uT);


        //for password
        pL = new JLabel("Password :");
        pL.setBounds(20,130,140,30);
        pL.setFont(f);
        c.add(pL);

        pT= new JTextField();
        pT.setBounds(105,130,260,30);
        pT.setFont(f);
        c.add(pT);

        //for email
        eL = new JLabel("Email    :");
        eL.setBounds(20,180,140,30);
        eL.setFont(f);
        c.add(eL);

        eT= new JTextField();
        eT.setBounds(105,180,260,30);
        eT.setFont(f);
        c.add(eT);

        //Back button
        backB = new JButton("Back");
        backB.setBounds(680,500,90,30);
        backB.setFont(f);
        c.add(backB);
        backB.addActionListener(this);

        //add button
        addB = new JButton("Add");
        addB.setBounds(10,230,90,30);
        addB.setFont(f);
        c.add(addB);
        addB.addActionListener(this);

        

        //clear button
        clB = new JButton("Clear");
        clB.setBounds(190,230,90,30);
        clB.setFont(f);
        c.add(clB);
        clB.addActionListener(this);

        //Delete button
        delB = new JButton("Delete");
        delB.setBounds(370,230,90,30);
        delB.setFont(f);
        c.add(delB);
        delB.addActionListener(this);

        //for table
        table = new JTable();
        m = new DefaultTableModel();
        m.setColumnIdentifiers(columns);
        table.setModel(m);
        table.setFont(f);
        table.setSelectionBackground(Color.YELLOW);
        table.setBackground(Color.WHITE);
        table.setRowHeight(25);

        scroll = new JScrollPane(table);
        scroll.setBounds(10,280,450,250);
        c.add(scroll);

        //logout
        logOutB = new JButton("Log Out");
        logOutB.setForeground(Color.BLACK);
        logOutB.setFont(f);
        logOutB.setBounds(700, 10, 70, 25);
        logOutB.setBorder(new LineBorder(Color.decode("#B2BF3D"), 2));
        logOutB.setBackground(Color.decode("#B2BF3D"));
        logOutB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logOutB.addActionListener(this);
        c.add(logOutB);


        

        try{
            BufferedReader br = new BufferedReader(new FileReader("data\\user_data\\user_data.txt"));
            ArrayList<String> lines = new ArrayList<>();
            lines.addAll(br.lines().toList());  // lines into arraylist

            
            for (int i = 0; i< lines.size(); i++) {
            String line = lines.get(i).trim();
            String[] data = line.split("-");
            m.addRow(data);
            }
            br.close();
            } catch (IOException e1) {
               System.out.println(e1);
            }

        //add image in background
        imageL = new JLabel();
        imageL.setIcon(new ImageIcon("icons/quickgrab.png")); //image location
        Dimension size1 = imageL.getPreferredSize(); //for same as frame size
        imageL.setBounds(0, 0, size1.width, size1.height);
        c.add(imageL);

        w2f.setVisible(true);
        w2f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backB){
            AdminWindow aw = new AdminWindow();
            aw.setVisible(false);
            w2f.setVisible(false);
        }
        else if(e.getSource()==addB){
            rows[0]=uT.getText();
            rows[1]=pT.getText();
            rows[2]=eT.getText();
            m.addRow(rows);
            
            
            try{
                File file2 = new File("data\\user_data\\user_data.txt");
                if(file2.exists()==false){
                    file2.createNewFile();
                }
                FileWriter fw = new FileWriter(file2,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                LocalDateTime myDateTime = LocalDateTime.now();
                DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                String timeAndDate = myDateFormat.format(myDateTime);
                pw.println("             ## Added by Admin ##");
                pw.println("User Name  : "+ rows[0]);
                pw.println("Password   : "+ rows[1]);
                pw.println("Email      : "+ rows[2]);
                pw.println("Time & Date: "+ timeAndDate);
                pw.println("***********************************");
                pw.close();
                JOptionPane.showMessageDialog(null, "New user account created successfully!","User created", JOptionPane.INFORMATION_MESSAGE);

                new AdminUserinfo();
                w2f.setVisible(false);
            }catch(Exception e2){
                System.out.println(e2);
            }
            
           
            
              
        }
        else if(e.getSource()==clB){
            uT.setText("");
            pT.setText("");
            eT.setText("");
        }
        else if(e.getSource()==logOutB){
            new Adminlogin();
            w2f.setVisible(false);
        }
        else if(e.getSource()==delB){
            int numR = table.getSelectedRow();
            if(numR>=0){
               m.removeRow(numR);

               try{
                ArrayList<String> lines = new ArrayList<>();
                try(BufferedReader br = new BufferedReader(new FileReader("data\\user_data\\user_data.txt"))){
                    
                    lines.addAll(br.lines().toList());
                    br.close();

                }
                lines.remove(numR);
                
                try(FileWriter fw = new FileWriter("data\\user_data\\user_data.txt")){
                    for(String l:lines){
                        fw.write(l +"\n");
                    }
                

                }
                
            }catch (Exception e4) {
                System.out.println(e4);
            }
                
            }
            
                
                

                 
        }
            else{
                JOptionPane.showMessageDialog(null, "Please Select Row !");
            }

    }
    
}

   

