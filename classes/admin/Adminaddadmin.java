package classes.admin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.lang.*;

import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Adminaddadmin extends JFrame implements ActionListener {
    JFrame w2f;
    private Container c;
    private Font f;
    private JLabel WtextL, imageL,uL,pL,eL;
    private JTextField uT,pT,eT;
    private JButton backB,addB,delB,clB;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel m;

    private String[] columns = {"Admin Name","Password","Email"};
    private String[] rows = new String[3];

    Adminaddadmin(){

        w2f=new JFrame("Admin Information");
        w2f.setIconImage(new ImageIcon(getClass().getResource("/icons/framelogo.png")).getImage());

        

        //for all type of screen size
        Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (scSize.width - 800)/2;
        int h = (scSize.height - 600)/2;
        w2f.setBounds(w,h,800,600);

        c = w2f.getContentPane(); // put in to container
        c.setLayout(null);

        f = new Font("Arial",Font.BOLD,11);

        WtextL = new JLabel("All Data of Admin");
        WtextL.setBounds(250,15,350,40);
        WtextL.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        c.add(WtextL);

        //for username
        uL = new JLabel("Admin Name:");
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


        

        try{
            BufferedReader br = new BufferedReader(new FileReader("data\\admin_data\\admin_data.txt"));
            ArrayList<String> lines = new ArrayList<>();
            lines.addAll(br.lines().toList());  // lines into arraylist

            // only show the even lines
            for (int i = 1; i< lines.size(); i+=2) {
            String line = lines.get(i).trim();
            String[] data = line.split("- ");
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
            File file = new File("data\\admin_data\\admin_data.txt");
            try{
                
                if(file.exists()==false){
                   file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                
                pw.println(columns[0]+" - "+ columns[1]+" - "+columns[2]);
                pw.println(rows[0]+" - "+ rows[1]+" - "+ rows[2]);
                
                pw.close();

                JOptionPane.showMessageDialog(null, "New Admin account created successfully!","Admin created", JOptionPane.INFORMATION_MESSAGE);
                
                   
                    

                   

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Something went wrong!","Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if(e.getSource()==clB){
            uT.setText("");
            pT.setText("");
            eT.setText("");
        }
        else if(e.getSource()==delB){
            int numR = table.getSelectedRow();
            if(numR>=0){
                m.removeRow(numR);
                
                // try{
                //     ArrayList<String> lines = new ArrayList<>();
                //     try(BufferedReader br = new BufferedReader(new FileReader("data\\admin_data\\admin_data.txt"))){
                        
                //         lines.addAll(br.lines().toList());
                //         br.close();

                //     }
                //     lines.remove(numR);
                //     lines.remove(numR+1);
                //     try(FileWriter fw = new FileWriter("data\\admin_data\\admin_data.txt")){
                //         for(String l:lines){
                //             fw.write(l +"\n");
                //         }
                    

                //     }
                    
                // }catch (Exception e4) {
                //     System.out.println(e4);
                // }

                 
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Select Row !");
            }

        }
        
    }
    
}