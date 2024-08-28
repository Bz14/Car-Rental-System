package CarRent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminLogged extends JFrame implements ActionListener
{
	private static JTabbedPane pane;
	private static JPanel firstPanel,secondPanel,sidePanel,topPanel,mainPanel,sideSecPanel,topSecPanel,mainSecPanel;
	private static GroupLayout groupLayout,otherLayout;
	private static JButton addBtn,deleteBtn,returnBtn,updateBtn,viewBtn,searchBtn,homeBtn;
	private static JButton addProdBtn,removeProdBtn,updateProdBtn,viewProdBtn,searchProdBtn,homeProdBtn,takeProdBtn;
	private static JLabel topLabel,mainLabel,topSecLabel,mainSecLabel;
	private CustomerDetail cust=new CustomerDetail();private CarDetail car=new CarDetail();
	public AdminLogged()
	{
		this.setTitle("UNIQUE CAR RENTAL");this.setSize(1350,730);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		pane=new JTabbedPane();
		firstPanel=new JPanel();firstPanel.setBackground(Color.BLACK);
        pane.add("CUSTOMER DETAIL",firstPanel);
		secondPanel=new JPanel();secondPanel.setBackground(Color.BLACK);
		pane.add("CAR DETAIL",secondPanel);
		sidePanel=new JPanel();sidePanel.setBackground(new Color(43, 71, 44));sidePanel.setMaximumSize(new Dimension(150,650));
		topPanel=new JPanel();topPanel.setBackground(new Color(43, 71, 44));topPanel.setMaximumSize(new Dimension(1200,50));
		mainPanel=new JPanel();
		sideSecPanel=new JPanel();sideSecPanel.setBackground(new Color(43, 71, 44));sideSecPanel.setMaximumSize(new Dimension(150,650));
		topSecPanel=new JPanel();topSecPanel.setBackground(new Color(43, 71, 44));topSecPanel.setMaximumSize(new Dimension(1200,50));
		mainSecPanel=new JPanel();
		groupLayout=new GroupLayout(firstPanel);
		firstPanel.setLayout(groupLayout);
		otherLayout=new GroupLayout(secondPanel);
		secondPanel.setLayout(otherLayout);
		
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup().addComponent(sidePanel)
				.addGroup(groupLayout.createParallelGroup().addComponent(topPanel).addComponent(mainPanel)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup().addComponent(sidePanel)
				.addGroup(groupLayout.createSequentialGroup().addComponent(topPanel).addComponent(mainPanel)));
		
		otherLayout.setAutoCreateContainerGaps(true);
		otherLayout.setAutoCreateGaps(true);
		otherLayout.setHorizontalGroup(otherLayout.createSequentialGroup().addComponent(sideSecPanel)
				.addGroup(otherLayout.createParallelGroup().addComponent(topSecPanel).addComponent(mainSecPanel)));
		otherLayout.setVerticalGroup(otherLayout.createParallelGroup().addComponent(sideSecPanel)
				.addGroup(otherLayout.createSequentialGroup().addComponent(topSecPanel).addComponent(mainSecPanel)));
		
		addBtn=new JButton("BOOK CAR");deleteBtn=new JButton("DELETE CUSTOMER");homeBtn=new JButton("HOME");
		returnBtn=new JButton("RETURN CAR");updateBtn=new JButton("UPDATE CUSTOMER");takeProdBtn=new JButton("TAKE CAR");
		viewBtn=new JButton("VIEW CUSTOMER DETAIL");searchBtn=new JButton("SEARCH CUSTOMER");takeProdBtn.addActionListener(this);
		addBtn.addActionListener(this);deleteBtn.addActionListener(this);homeBtn.addActionListener(this);
		returnBtn.addActionListener(this);updateBtn.addActionListener(this);
		viewBtn.addActionListener(this);searchBtn.addActionListener(this);
		sidePanel.setLayout(new GridLayout(7,1,10,10));sidePanel.add(homeBtn);
		sidePanel.add(addBtn);sidePanel.add(returnBtn);sidePanel.add(viewBtn);sidePanel.add(searchBtn);
		sidePanel.add(deleteBtn);sidePanel.add(updateBtn);
		addBtn.setBackground(Color.black);addBtn.setForeground(Color.white);
		deleteBtn.setBackground(Color.black);deleteBtn.setForeground(Color.white);
		returnBtn.setBackground(Color.black);returnBtn.setForeground(Color.white);
		viewBtn.setBackground(Color.black);viewBtn.setForeground(Color.white);
		updateBtn.setBackground(Color.black);updateBtn.setForeground(Color.white);
		searchBtn.setBackground(Color.black);searchBtn.setForeground(Color.white);
		homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
		
		addProdBtn=new JButton("ADD NEW CAR");removeProdBtn=new JButton("DELETE CAR");homeProdBtn=new JButton("HOME");
		updateProdBtn=new JButton("UPDATE CAR");viewProdBtn=new JButton("VIEW CAR DETAIL");searchProdBtn=new JButton("SEARCH CAR");
		addProdBtn.addActionListener(this);removeProdBtn.addActionListener(this);homeProdBtn.addActionListener(this);
		updateProdBtn.addActionListener(this);viewProdBtn.addActionListener(this);searchProdBtn.addActionListener(this);
		sideSecPanel.setLayout(new GridLayout(7,1,10,10));sideSecPanel.add(homeProdBtn);sideSecPanel.add(takeProdBtn);
		sideSecPanel.add(addProdBtn);sideSecPanel.add(viewProdBtn);sideSecPanel.add(removeProdBtn);sideSecPanel.add(searchProdBtn);
		sideSecPanel.add(updateProdBtn);
		addProdBtn.setBackground(Color.black);addProdBtn.setForeground(Color.white);
		takeProdBtn.setBackground(Color.black);takeProdBtn.setForeground(Color.white);
		removeProdBtn.setBackground(Color.black);removeProdBtn.setForeground(Color.white);
		viewProdBtn.setBackground(Color.black);viewProdBtn.setForeground(Color.white);
		updateProdBtn.setBackground(Color.black);updateProdBtn.setForeground(Color.white);
		searchProdBtn.setBackground(Color.black);searchProdBtn.setForeground(Color.white);
		homeProdBtn.setBackground(Color.black);homeProdBtn.setForeground(Color.white);
		
		
		topLabel=new JLabel("WELCOME TO UNIQUE CAR RENTAL");topLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		topLabel.setForeground(Color.BLACK);
		topPanel.add(topLabel,BorderLayout.CENTER);
		mainPanel.setBackground(Color.black);
		mainLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\drive.jpg"));
		mainPanel.add(mainLabel);
		
		topSecLabel=new JLabel("WELCOME TO UNIQUE CAR RENTAL");topSecLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		topSecLabel.setForeground(Color.BLACK);
		topSecPanel.add(topSecLabel,BorderLayout.CENTER);
		mainSecPanel.setBackground(Color.black);
		mainSecLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\kk.jpg"));
		mainSecPanel.add(mainSecLabel);
		
		pane.setBackground(Color.BLACK);
		pane.setForeground(new Color(43, 71, 44));
		this.add(pane);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static JFrame getFrame()
	{
		AdminLogged admin=new AdminLogged();
		return admin;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addBtn)
		{
			topLabel.setText("REGISTER CUSTOMER");
			addBtn.setBackground(new Color(43, 71, 44));
			addBtn.setForeground(Color.BLACK);
			deleteBtn.setBackground(Color.black);deleteBtn.setForeground(Color.white);
			returnBtn.setBackground(Color.black);returnBtn.setForeground(Color.white);
			viewBtn.setBackground(Color.black);viewBtn.setForeground(Color.white);
			updateBtn.setBackground(Color.black);updateBtn.setForeground(Color.white);
			searchBtn.setBackground(Color.black);searchBtn.setForeground(Color.white);
			homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
			JPanel panel=new JPanel();
			panel=CustomerDetail.addPanel();
			mainPanel.removeAll();
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(panel,BorderLayout.CENTER);
		}
		else if(e.getSource()==deleteBtn)
		{
			topLabel.setText("DELETE CUSTOMER");
			deleteBtn.setBackground(new Color(43, 71, 44));
			deleteBtn.setForeground(Color.BLACK);
			addBtn.setBackground(Color.black);addBtn.setForeground(Color.white);returnBtn.setBackground(Color.black);returnBtn.setForeground(Color.white);
			viewBtn.setBackground(Color.black);viewBtn.setForeground(Color.white);updateBtn.setBackground(Color.black);updateBtn.setForeground(Color.white);
			searchBtn.setBackground(Color.black);searchBtn.setForeground(Color.white);homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=cust.deletePanel();
			mainPanel.removeAll();
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==returnBtn)
		{
			topLabel.setText("RETURN CAR");
			returnBtn.setBackground(new Color(43, 71, 44));
			returnBtn.setForeground(Color.BLACK);
			addBtn.setBackground(Color.black);addBtn.setForeground(Color.white);deleteBtn.setBackground(Color.black);deleteBtn.setForeground(Color.white);
			viewBtn.setBackground(Color.black);viewBtn.setForeground(Color.white);updateBtn.setBackground(Color.black);updateBtn.setForeground(Color.white);
			searchBtn.setBackground(Color.black);searchBtn.setForeground(Color.white);homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=cust.returnPanel();
			mainPanel.removeAll();
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==searchBtn)
		{
			topLabel.setText("SEARCH CUSTOMER");
			searchBtn.setBackground(new Color(43, 71, 44));
			searchBtn.setForeground(Color.BLACK);
			addBtn.setBackground(Color.black);addBtn.setForeground(Color.white);deleteBtn.setBackground(Color.black);deleteBtn.setForeground(Color.white);
			returnBtn.setBackground(Color.black);returnBtn.setForeground(Color.white);viewBtn.setBackground(Color.black);viewBtn.setForeground(Color.white);
			updateBtn.setBackground(Color.black);updateBtn.setForeground(Color.white);homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
			JPanel pane=new JPanel();pane=cust.searchPanel();
			mainPanel.removeAll();
			pane.setBackground(Color.BLACK);
			mainPanel.setBackground(Color.BLACK);
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(pane,BorderLayout.CENTER);
			
		}
		else if(e.getSource()==updateBtn)
		{
			topLabel.setText("UPDATE CUSTOMER");
			updateBtn.setBackground(new Color(43, 71, 44));
			updateBtn.setForeground(Color.BLACK);
			addBtn.setBackground(Color.black);addBtn.setForeground(Color.white);deleteBtn.setBackground(Color.black);deleteBtn.setForeground(Color.white);
			returnBtn.setBackground(Color.black);returnBtn.setForeground(Color.white);viewBtn.setBackground(Color.black);viewBtn.setForeground(Color.white);
			searchBtn.setBackground(Color.black);searchBtn.setForeground(Color.white);homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
			JPanel pane=new JPanel();pane=cust.updatePanel();
			mainPanel.removeAll();
			pane.setBackground(Color.BLACK);
			mainPanel.setBackground(Color.BLACK);
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==viewBtn)
		{
			topLabel.setText("VIEW CUSTOMERS DETAIL");
			viewBtn.setBackground(new Color(43, 71, 44));
			viewBtn.setForeground(Color.BLACK);
			addBtn.setBackground(Color.black);addBtn.setForeground(Color.white);deleteBtn.setBackground(Color.black);deleteBtn.setForeground(Color.white);
			returnBtn.setBackground(Color.black);returnBtn.setForeground(Color.white);updateBtn.setBackground(Color.black);updateBtn.setForeground(Color.white);
			searchBtn.setBackground(Color.black);searchBtn.setForeground(Color.white);homeBtn.setBackground(Color.black);homeBtn.setForeground(Color.white);
			JPanel pane=new JPanel();pane=cust.viewPanel();
			mainPanel.removeAll();
			pane.setBackground(Color.BLACK);
			mainPanel.setBackground(Color.BLACK);
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==homeBtn)
		{
			homeBtn.setBackground(new Color(43, 71, 44));
			homeBtn.setForeground(Color.BLACK);
			JPanel panel=new JPanel();
			panel=CarRentalHome.getHomePanel();
			this.setVisible(false);
			firstPanel.setVisible(false);
			this.validate();
			panel.setVisible(true);
		}
		else if(e.getSource()==takeProdBtn)
		{
			topSecLabel.setText("TAKE BOOKED CAR");
			takeProdBtn.setBackground(new Color(43, 71, 44));
			takeProdBtn.setForeground(Color.BLACK);
			removeProdBtn.setBackground(Color.black);removeProdBtn.setForeground(Color.white);viewProdBtn.setBackground(Color.black);
			viewProdBtn.setForeground(Color.white);updateProdBtn.setBackground(Color.black);updateProdBtn.setForeground(Color.white);
			searchProdBtn.setBackground(Color.black);searchProdBtn.setForeground(Color.white);homeProdBtn.setBackground(Color.black);
			homeProdBtn.setForeground(Color.white);addProdBtn.setBackground(Color.black);addProdBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=car.takePanel();
			mainSecPanel.removeAll();
			mainSecPanel.setLayout(new BorderLayout());
			mainSecPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==addProdBtn)
		{
			topSecLabel.setText("REGISTER CAR");
			addProdBtn.setBackground(new Color(43, 71, 44));
			addProdBtn.setForeground(Color.BLACK);
			removeProdBtn.setBackground(Color.black);removeProdBtn.setForeground(Color.white);viewProdBtn.setBackground(Color.black);
			viewProdBtn.setForeground(Color.white);updateProdBtn.setBackground(Color.black);updateProdBtn.setForeground(Color.white);
			searchProdBtn.setBackground(Color.black);searchProdBtn.setForeground(Color.white);homeProdBtn.setBackground(Color.black);
			homeProdBtn.setForeground(Color.white);takeProdBtn.setBackground(Color.black);takeProdBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=CarDetail.addPanel();
			mainSecPanel.removeAll();
			mainSecPanel.setLayout(new BorderLayout());
			mainSecPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==removeProdBtn)
		{
			topSecLabel.setText("DELETE CAR DETAIL");
			removeProdBtn.setBackground(new Color(43, 71, 44));
			removeProdBtn.setForeground(Color.BLACK);
			addProdBtn.setBackground(Color.black);addProdBtn.setForeground(Color.white);viewProdBtn.setBackground(Color.black);
			viewProdBtn.setForeground(Color.white);updateProdBtn.setBackground(Color.black);updateProdBtn.setForeground(Color.white);
			searchProdBtn.setBackground(Color.black);searchProdBtn.setForeground(Color.white);homeProdBtn.setBackground(Color.black);
			homeProdBtn.setForeground(Color.white);takeProdBtn.setBackground(Color.black);takeProdBtn.setForeground(Color.white);
			JPanel panel=new JPanel();
			panel=car.deletePanel();
			mainSecPanel.removeAll();
			mainSecPanel.setLayout(new BorderLayout());
			mainSecPanel.add(panel,BorderLayout.CENTER);
		}
		else if(e.getSource()==updateProdBtn)
		{
			topSecLabel.setText("UPDATE CAR DETAIL");
			updateProdBtn.setBackground(new Color(43, 71, 44));
			updateProdBtn.setForeground(Color.BLACK);
			addProdBtn.setBackground(Color.black);addProdBtn.setForeground(Color.white);removeProdBtn.setBackground(Color.black);
			removeProdBtn.setForeground(Color.white);viewProdBtn.setBackground(Color.black);viewProdBtn.setForeground(Color.white);
			searchProdBtn.setBackground(Color.black);searchProdBtn.setForeground(Color.white);
			homeProdBtn.setBackground(Color.black);homeProdBtn.setForeground(Color.white);takeProdBtn.setBackground(Color.black);takeProdBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=car.updatePanel();
			mainSecPanel.removeAll();
			pane.setBackground(Color.BLACK);
			mainSecPanel.setBackground(Color.BLACK);
			mainSecPanel.setLayout(new BorderLayout());
			mainSecPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==viewProdBtn)
		{
			topSecLabel.setText("VIEW CARS DETAIL");
			viewProdBtn.setBackground(new Color(43, 71, 44));
			viewProdBtn.setForeground(Color.BLACK);
			addProdBtn.setBackground(Color.black);addProdBtn.setForeground(Color.white);removeProdBtn.setBackground(Color.black);
			removeProdBtn.setForeground(Color.white);updateProdBtn.setBackground(Color.black);updateProdBtn.setForeground(Color.white);
			searchProdBtn.setBackground(Color.black);searchProdBtn.setForeground(Color.white);homeProdBtn.setBackground(Color.black);
			homeProdBtn.setForeground(Color.white);takeProdBtn.setBackground(Color.black);takeProdBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=car.viewPanel();
			mainSecPanel.removeAll();
			mainSecPanel.setLayout(new BorderLayout());
			mainSecPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==searchProdBtn)
		{
			topSecLabel.setText("SEARCH CAR DETAIL");
			searchProdBtn.setBackground(new Color(43, 71, 44));
			searchProdBtn.setForeground(Color.BLACK);
			addProdBtn.setBackground(Color.black);addProdBtn.setForeground(Color.white);removeProdBtn.setBackground(Color.black);
			removeProdBtn.setForeground(Color.white);viewProdBtn.setBackground(Color.black);viewProdBtn.setForeground(Color.white);
			updateProdBtn.setBackground(Color.black);updateProdBtn.setForeground(Color.white);
			homeProdBtn.setBackground(Color.black);homeProdBtn.setForeground(Color.white);
			takeProdBtn.setBackground(Color.black);takeProdBtn.setForeground(Color.white);
			JPanel pane=new JPanel();
			pane=car.searchPanel();
			mainSecPanel.removeAll();
			mainSecPanel.setLayout(new BorderLayout());
			mainSecPanel.add(pane,BorderLayout.CENTER);
		}
		else if(e.getSource()==homeProdBtn)
		{
			homeProdBtn.setBackground(new Color(43, 71, 44));
			homeProdBtn.setForeground(Color.BLACK);
			JPanel panel=new JPanel();
			panel=CarRentalHome.getHomePanel();
			this.setVisible(false);
			secondPanel.setVisible(false);
			this.validate();
			panel.setVisible(true);
		}	
	}
}
