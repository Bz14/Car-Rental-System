package CarRent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class CarRentalHome extends JFrame implements ActionListener,MouseMotionListener
{
	private static JPanel homePanel,imgPanel,bodyPanel,logPanel,frontPanel,otherPanel;
	private static GroupLayout groupLayout,mainLayout,loginLayout,otherLayout;
	private JLabel imageLabel,textLabel,logoLabel,loginLabel,userLabel,passwordLabel;
	private JButton loginBtn,exitBtn,loginSubmit,homeButton;
	private JTextField userText;
	private JPasswordField passwordText;
	private Admin adminstrator=new Admin();
	private DatabaseConnection dbConn=new DatabaseConnection();
	private static boolean isLogged;
	public CarRentalHome()
	{
		this.setTitle("UNIQUE CAR RENTAL");this.setSize(1350,650);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		frontPanel=new JPanel();
		homePanel=new JPanel();imgPanel=new JPanel();
		bodyPanel=new JPanel();
		homePanel.setBackground(Color.BLACK);
		homePanel.setMaximumSize(new Dimension(1350,50));
		imgPanel.setMaximumSize(new Dimension(500,600));
		imgPanel.setBackground(Color.BLACK);
		imageLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\c.jfif"));
		imgPanel.add(imageLabel);
		bodyPanel.setMaximumSize(new Dimension(600,600));
		bodyPanel.setBackground(new Color(43, 71, 44));
		
		groupLayout=new GroupLayout(frontPanel);
		frontPanel.setLayout(groupLayout);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup().addComponent(homePanel)
				.addGroup(groupLayout.createSequentialGroup().addComponent(imgPanel).addComponent(bodyPanel))
				);
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(homePanel)
				.addGroup(groupLayout.createParallelGroup().addComponent(imgPanel).addComponent(bodyPanel)));
		
		textLabel=new JLabel("WELCOME TO UNIQUE CAR RENTAL");
		logoLabel=new JLabel("\"Drive through the peace.\"");
		loginBtn=new JButton("LOG IN");
		exitBtn=new JButton("EXIT");
		textLabel.setForeground(Color.WHITE);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		loginBtn.setBackground(Color.BLACK);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setMaximumSize(new Dimension(100,50));
		exitBtn.setBackground(Color.BLACK);
		exitBtn.setForeground(Color.WHITE);
		exitBtn.setMaximumSize(new Dimension(100,50));
		loginBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		mainLayout=new GroupLayout(bodyPanel);
		bodyPanel.setLayout(mainLayout);
		mainLayout.setAutoCreateContainerGaps(true);
		mainLayout.setHorizontalGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addGap(100)
				.addComponent(textLabel).addGap(20).addComponent(logoLabel)
				.addGap(100)
				.addGroup(mainLayout.createSequentialGroup().addComponent(loginBtn).addGap(20).addComponent(exitBtn)));
		mainLayout.setVerticalGroup(mainLayout.createSequentialGroup()
				.addGap(100)
				.addComponent(textLabel).addGap(20).addComponent(logoLabel).addGap(80)
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(20).addComponent(loginBtn).addGap(20).addComponent(exitBtn)));
	
		logPanel=new JPanel();
		loginLabel=new JLabel("WELCOME ADMIN");
		loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));loginLabel.setForeground(Color.WHITE);
		userLabel=new JLabel("USER-NAME: ");userText=new JTextField("");
		userText.setMaximumSize(new Dimension(250,30));
		userLabel.setForeground(Color.WHITE);userLabel.setMaximumSize(new Dimension(100,50));
		passwordLabel=new JLabel("PASSWORD: ");passwordText=new JPasswordField();
		passwordText.setMaximumSize(new Dimension(250,30));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setMaximumSize(new Dimension(100,50));
		loginSubmit=new JButton("LOG IN");
		loginSubmit.setBackground(Color.BLACK);
		loginSubmit.addActionListener(this);
		loginSubmit.setMaximumSize(new Dimension(100,30));loginSubmit.setForeground(Color.WHITE);
		homeButton=new JButton("HOME");
		homeButton.setBackground(Color.BLACK);homeButton.setForeground(Color.WHITE);
		homeButton.setMaximumSize(new Dimension(100,30));
		homeButton.addActionListener(this);
		
		otherPanel=new JPanel();
		otherPanel.addMouseMotionListener(this);
		otherPanel.setBackground(Color.BLACK);
		otherLayout=new GroupLayout(otherPanel);
		otherPanel.setLayout(otherLayout);
		
		otherLayout.setAutoCreateContainerGaps(true);
		otherLayout.setAutoCreateGaps(true);
		otherLayout.setHorizontalGroup(otherLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(homePanel).addComponent(logPanel));
		otherLayout.setVerticalGroup(otherLayout.createSequentialGroup().addComponent(homePanel).addComponent(logPanel));
		
		
		loginLayout=new GroupLayout(logPanel);
		logPanel.setLayout(loginLayout);
		logPanel.setMaximumSize(new Dimension(500,400));
		logPanel.setBackground(new Color(43, 71, 44));
		loginLayout.setHorizontalGroup(loginLayout.createSequentialGroup()
				.addGroup(loginLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(80).addComponent(loginLabel)
						.addGroup(loginLayout.createSequentialGroup().addGap(50).addComponent(userLabel).addGap(10).addComponent(userText)).addGap(50)
						.addGroup(loginLayout.createSequentialGroup().addGap(50).addComponent(passwordLabel).addGap(10).addComponent(passwordText)).addGap(50)
						.addGroup(loginLayout.createSequentialGroup().addGap(50).addComponent(loginSubmit).addGap(10).addComponent(homeButton))));
		loginLayout.setVerticalGroup(loginLayout.createSequentialGroup().addGap(80)
				.addComponent(loginLabel)
				.addGap(30)
				.addGroup(loginLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(80).addComponent(userLabel).addGap(50).addComponent(userText))
				.addGroup(loginLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(80).addComponent(passwordLabel).addGap(50).addComponent(passwordText))
				.addGroup(loginLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(80).addComponent(loginSubmit).addGap(50).addComponent(homeButton)));
		
		this.add(frontPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginBtn)
		{
			frontPanel.setVisible (false);this.validate ();
			homePanel.setBackground(new Color(43, 71, 44));
			this.add(otherPanel,BorderLayout.CENTER);
		}
		else if(e.getSource()==exitBtn)
		{
			System.exit(0);
		}
		else if(e.getSource()==homeButton)
		{
			otherPanel.setVisible (false);
			JPanel panel=new JPanel();
			panel=CarRentalHome.getHomePanel();
		    this.validate ();
		    panel.setVisible(true);
		    this.setVisible(false);
		    //this.add(panel,BorderLayout.CENTER);
		   // this.pack();
		}
		else if(e.getSource()==loginSubmit)
		{
			String uName=userText.getText();
			adminstrator.setUserName(uName);
			char[] uPassword=passwordText.getPassword();
			String strPassword=new String(uPassword);
			adminstrator.setPassword(strPassword);
			try {
				isLogged =DatabaseConnection.adminLogin(adminstrator);
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			if(isLogged)
			{
					JOptionPane.showMessageDialog(this,"WELCOME ADMIN.","LOGIN SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					this.validate();
					SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
					    	JFrame custFrame=new JFrame();
							custFrame=AdminLogged.getFrame();
							custFrame.setVisible(true);
					    }
					  });
					
			}
			else if(uName.isEmpty()||uName.isBlank()||strPassword.isEmpty()||strPassword.isBlank())
			{
				JOptionPane.showMessageDialog(this,"PLEASE FILL OUT THE FIELDS.","LOGIN FAILED", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
					JOptionPane.showMessageDialog(this,"INCORRECT PASSWORD OR USERNAME.","LOGIN FAILED", JOptionPane.ERROR_MESSAGE);
					userText.setText("");
					passwordText.setText("");
			}
		}
		
	}
	public static JPanel getHomePanel()
	{
		CarRentalHome home=new CarRentalHome();
		return frontPanel;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		    logPanel.setBackground(Color.DARK_GRAY);
		    loginLabel.setForeground(Color.BLACK);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
