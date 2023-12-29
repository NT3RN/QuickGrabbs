package classes.resturants;

import interfaces.*;
import classes.user.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;



public class Home implements ActionListener, MouseListener, IHome{
	
	private JFrame frame;
	
	private JLabel sultansDine;
	private JLabel pizzaBurg;
	private JLabel chillox;
	private JLabel momo;
	private JLabel twinPeaks;
	private JLabel dosLocos;
	private JMenuBar menuBar;  
	private JMenu users, creators;
	private JMenuItem profile, logout;
	private String f;
	
	public Home (String user)
	{
		f=user;
		frame = new JFrame("Available Resturant");

		Image background = new ImageIcon("icons/restbackground.png").getImage();
		frame.setContentPane(new ImagePanel(background));
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.png");


		Image image1 = new ImageIcon("icons/pizzaburg.jpeg").getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
		ImageIcon pizzaBurgLogo = new ImageIcon(image1);
		pizzaBurg = new JLabel("PizzaBurg");
		pizzaBurg.setIcon(pizzaBurgLogo);
		pizzaBurg.setForeground(Color.CYAN);
		pizzaBurg.setVerticalTextPosition(JLabel.BOTTOM);
		pizzaBurg.setHorizontalTextPosition(JLabel.CENTER);
		pizzaBurg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pizzaBurg.setFont(new Font("Grandview",Font.PLAIN,20));
		pizzaBurg.setBorder(new EmptyBorder(0, 30, 0, 0));
		pizzaBurg.addMouseListener(this);
		frame.add(pizzaBurg);

		Image image2 = new ImageIcon("icons/SultansDine.jpg").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon kacchiBhaiLogo = new ImageIcon(image2);
		sultansDine = new JLabel("Sultan's Dine");
		sultansDine.setIcon(kacchiBhaiLogo);
		sultansDine.setForeground(Color.CYAN);
		sultansDine.setVerticalTextPosition(JLabel.BOTTOM);
		sultansDine.setHorizontalTextPosition(JLabel.CENTER);
		sultansDine.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sultansDine.setFont(new Font("Grandview",Font.PLAIN,20));
		sultansDine.setBorder(new EmptyBorder(0, 30, 0, 0));
		sultansDine.addMouseListener(this);
		frame.add(sultansDine);
		
		
		
		Image image3 = new ImageIcon("icons/chillox.png").getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
		ImageIcon chilloxLogo = new ImageIcon(image3);
		chillox = new JLabel("Chillox");
		chillox.setIcon(chilloxLogo);
		chillox.setForeground(Color.CYAN);
		chillox.setVerticalTextPosition(JLabel.BOTTOM);
		chillox.setHorizontalTextPosition(JLabel.CENTER);
		chillox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chillox.setFont(new Font("Grandview",Font.PLAIN,20));
		chillox.setBorder(new EmptyBorder(0, 30, 0, 0));
		chillox.addMouseListener(this);
		frame.add(chillox);
		
		
		Image image4 = new ImageIcon("icons/momo.png").getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
		ImageIcon momoLogo = new ImageIcon(image4);
		momo = new JLabel("Momo");
		momo.setIcon(momoLogo);
		momo.setForeground(Color.CYAN);
		momo.setVerticalTextPosition(JLabel.BOTTOM);
		momo.setHorizontalTextPosition(JLabel.CENTER);
		momo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		momo.setFont(new Font("Grandview",Font.PLAIN,20));
		momo.setBorder(new EmptyBorder(0, 30, 0, 0));
		momo.addMouseListener(this);
		frame.add(momo);

		
		Image image5 = new ImageIcon("icons/TwinPeaks.jpg").getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
		ImageIcon twinPeaksLogo = new ImageIcon(image5);
		twinPeaks = new JLabel("Twin Peaks");
		twinPeaks.setIcon(twinPeaksLogo);
		twinPeaks.setForeground(Color.CYAN);
		twinPeaks.setVerticalTextPosition(JLabel.BOTTOM);
		twinPeaks.setHorizontalTextPosition(JLabel.CENTER);
		twinPeaks.setCursor(new Cursor(Cursor.HAND_CURSOR));
		twinPeaks.setFont(new Font("Grandview",Font.PLAIN,20));
		twinPeaks.setBorder(new EmptyBorder(0, 30, 0, 0));
		twinPeaks.addMouseListener(this);
		frame.add(twinPeaks);
		
		
		Image image6 = new ImageIcon("icons/doslocos.jpg").getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
		ImageIcon dosLocosLogo = new ImageIcon(image6);
		dosLocos = new JLabel("DosLocos");
		dosLocos.setIcon(dosLocosLogo);
		dosLocos.setForeground(Color.CYAN);
		dosLocos.setVerticalTextPosition(JLabel.BOTTOM);
		dosLocos.setHorizontalTextPosition(JLabel.CENTER);
		dosLocos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dosLocos.setFont(new Font("Grandview",Font.PLAIN,20));
		dosLocos.setBorder(new EmptyBorder(0, 30, 0, 0));
		dosLocos.addMouseListener(this);
		frame.add(dosLocos);


		profile = new JMenuItem ("Profile");
		profile.addActionListener(this);
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		logout = new JMenuItem ("Logout");
		logout.addActionListener(this);
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		users = new JMenu(f);
		users.setCursor(new Cursor(Cursor.HAND_CURSOR));
		users.setBorder(new EmptyBorder(0, 20, 0, 20));
		users.setForeground(Color.black);
		users.add(profile);
		users.add(logout);
		
		creators = new JMenu("About Us");
		creators.setCursor(new Cursor(Cursor.HAND_CURSOR));
		creators.setBorder(new EmptyBorder(0, 10, 0, 10));
		creators.setForeground(Color.black);

		
		menuBar = new JMenuBar();
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(users);
		menuBar.add(creators);
		menuBar.setBackground(Color.decode("#FFD4B2"));
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		frame.setJMenuBar(menuBar);
	
		
		frame.setIconImage(framelogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		frame.getContentPane().setBackground(Color.decode("#696969"));
		frame.setLayout (new GridLayout(2,3));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout)
		{
			frame.setVisible(false);
			new Login();
		}
		else if(e.getSource()==profile){
			frame.setVisible(false);
			new UProfile(f);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==pizzaBurg)
		{
			frame.setVisible(false);
			new PizzaBurg(f);
		}
		else if(e.getSource()==sultansDine)
		{
			frame.setVisible(false);
			new SultansDine(f);
		}
		else if(e.getSource()==dosLocos)
		{
			frame.setVisible(false);
			new DosLocos(f);
		}
		else if(e.getSource()==chillox)
		{
			frame.setVisible(false);
			new Chillox(f);
		}
		else if(e.getSource()==twinPeaks)
		{
			frame.setVisible(false);
			new TwinPeaks(f);
		}
		else if(e.getSource()==momo)
		{
			frame.setVisible(false);
			new Momo(f);
		}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==sultansDine)
			{
			sultansDine.setForeground(Color.white);
			}
		
		else if(e.getSource()==pizzaBurg)
			{
			pizzaBurg.setForeground(Color.white);
			}
		
		else if(e.getSource()==chillox)
			{
			chillox.setForeground(Color.white);
			}
		
		else if(e.getSource()==momo)
			{
			momo.setForeground(Color.white);
			}
		
		else if(e.getSource()==twinPeaks)
			{
			twinPeaks.setForeground(Color.white);
			}
		else if(e.getSource()==dosLocos)
			{
			dosLocos.setForeground(Color.white);
			}
		
	}
			
	@Override
	public void mouseExited(MouseEvent e) {
		sultansDine.setForeground(Color.black);
		sultansDine.setForeground(Color.black);
		pizzaBurg.setForeground(Color.black);
		chillox.setForeground(Color.black);
		momo.setForeground(Color.black);
		twinPeaks.setForeground(Color.black);
		dosLocos.setForeground(Color.black);
		
	}

}
