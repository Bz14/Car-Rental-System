package CarRent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class CustomerDetail extends JFrame implements ActionListener
{
	private static JPanel panel_1,panel_2,panel_3,mainPanel,takePanel,tablePanel,returnpanel,updatePanel;
	private static JPanel viewPanel,searchPanel,imgPanel,deletePanel;
	private GroupLayout groupLayout,otherLayout,inputLayout,deleteLayout,returnLayout,searchLayout,updateLayout;
	private static JRadioButton r1,r2;
	private static JLabel startLabel,endLabel,firstLabel,lastLabel,ageLabel,emailLabel,phoneLabel,carLabel,takeLabel,returnlabel;
	private static JLabel searchLabel,imgLabel,deleteLabel,updateLabel;
	private static JTextField firstText,lastText,ageText,emailText,phoneText,carText,takeText,returntext,searchText,deleteText,updateText;
	private static JButton checkBtn,registerBtn,takeBtn,returnBtn,searchBtn,deleteBtn,updateBtn,btn;
	private static JDateChooser pickCalender,dropCalender;
	private static DatabaseConnection dbconn=new DatabaseConnection();
	private static ResultSet result;
	private String[] carCol= {"CAR_ID","CAR_MODEL","NUMBER_OF_SEAT","TYPE_ID","AVAILABLE","DAILY_RATE","CAR_TYPE"};
	private String[] custCol= {"CUSTOMER_ID","FIRST_NAME","LAST_NAME","AGE","EMAIL","PHONE"};
	private static JTable table;
	private static JScrollPane scroll;
	private DefaultTableModel defaultTable;
	private static Vector<Object> carList=new Vector<>();private static Vector<Object> customerList=new Vector<>();
	private Car viewCar=new Car();
	private Customer customer=new Customer();
	private Customer cust;
	private static boolean isAvail,isregistered,isUpdated;
	private DatabaseConnection dbConn=new DatabaseConnection();
	public  CustomerDetail()
	{
	  this.setSize(1350,730);
	  mainPanel=new JPanel();
	  mainPanel.setBackground(Color.DARK_GRAY);
	  panel_1=new JPanel();panel_2=new JPanel();panel_3=new JPanel();
	  panel_1.setMaximumSize(new Dimension(800,100));
	  panel_3.setMaximumSize(new Dimension(700,800));
	  panel_1.setBackground(Color.BLACK);
	  panel_2.setBackground(new Color(43, 71, 44));
	  panel_3.setBackground(Color.BLACK);
	  startLabel=new JLabel("START DATE: ");endLabel=new JLabel("RETURN DATE: ");
	  pickCalender=new JDateChooser();pickCalender.setMaximumSize(new Dimension(250,20));
	  dropCalender=new JDateChooser();dropCalender.setMaximumSize(new Dimension(250,20));
	  pickCalender.getJCalendar().setPreferredSize(new Dimension(200, 200));
	  dropCalender.getJCalendar().setPreferredSize(new Dimension(200, 200));
	
	  checkBtn=new JButton("CHECK");checkBtn.addActionListener(this);
	  groupLayout=new GroupLayout(mainPanel);
	  mainPanel.setLayout(groupLayout);
	  groupLayout.setAutoCreateContainerGaps(true);
	  groupLayout.setAutoCreateGaps(true);
	  
	  groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
			  .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(panel_1).addComponent(panel_2)).addComponent(panel_3));
	  groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(groupLayout.createSequentialGroup().addComponent(panel_1)
			  .addComponent(panel_2)).addComponent(panel_3));
	  
	  otherLayout=new GroupLayout(panel_1);
	  panel_1.setLayout(otherLayout);
	  otherLayout.setAutoCreateContainerGaps(true);
	  otherLayout.setAutoCreateGaps(true);
	  otherLayout.setHorizontalGroup(otherLayout.createSequentialGroup().addGroup(otherLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(startLabel)
			  .addComponent(endLabel)).addGroup(otherLayout.createParallelGroup().addComponent(pickCalender).addComponent(dropCalender)).addComponent(checkBtn));
	  otherLayout.setVerticalGroup(otherLayout.createSequentialGroup().addGroup(otherLayout.createParallelGroup().addComponent(startLabel)
			  .addComponent(pickCalender)).addGroup(otherLayout.createParallelGroup().addComponent(endLabel).addComponent(dropCalender).addComponent(checkBtn)));
	  
	  firstLabel=new JLabel("FIRST NAME: ");lastLabel=new JLabel("LAST NAME: ");ageLabel=new JLabel("AGE: ");emailLabel=new JLabel("EMAIL: ");
	  phoneLabel=new JLabel("PHONE: ");carLabel=new JLabel("CAR-ID: ");registerBtn=new JButton("REGISTER");
	  firstText=new JTextField();lastText=new JTextField();ageText=new JTextField();registerBtn.addActionListener(this);
	  emailText=new JTextField();phoneText=new JTextField();carText=new JTextField();
	  firstText.setMaximumSize(new Dimension(350,30));lastText.setMaximumSize(new Dimension(350,30));
	  ageText.setMaximumSize(new Dimension(350,30));emailText.setMaximumSize(new Dimension(350,30));
	  phoneText.setMaximumSize(new Dimension(350,30));carText.setMaximumSize(new Dimension(350,30));
	  firstText.setEnabled(false); lastText.setEnabled(false); ageText.setEnabled(false); phoneText.setEnabled(false); emailText.setEnabled(false);
	  
	  inputLayout=new GroupLayout(panel_3);
	  panel_3.setLayout(inputLayout);
	  
	  inputLayout.setAutoCreateContainerGaps(true);
	  inputLayout.setAutoCreateGaps(true);
	  inputLayout.setHorizontalGroup(inputLayout.createSequentialGroup()
			  .addGroup(inputLayout.createParallelGroup().addComponent(firstLabel).addComponent(lastLabel).addComponent(ageLabel).addComponent(phoneLabel).addComponent(emailLabel).addComponent(carLabel))
			  .addGroup(inputLayout.createParallelGroup().addComponent(firstText).addComponent(lastText).addComponent(ageText).addComponent(phoneText).addComponent(emailText).addComponent(carText).addComponent(registerBtn)));
	  inputLayout.setVerticalGroup(inputLayout.createSequentialGroup()
			  .addGroup(inputLayout.createParallelGroup().addComponent(firstLabel).addComponent(firstText))
			  .addGroup(inputLayout.createParallelGroup().addComponent(lastLabel).addComponent(lastText))
			  .addGroup(inputLayout.createParallelGroup().addComponent(ageLabel).addComponent(ageText))
			  .addGroup(inputLayout.createParallelGroup().addComponent(phoneLabel).addComponent(phoneText))
			  .addGroup(inputLayout.createParallelGroup().addComponent(emailLabel).addComponent(emailText))
			  .addGroup(inputLayout.createParallelGroup().addComponent(carLabel).addComponent(carText))
			  .addComponent(registerBtn)
			  );
	  takePanel=new JPanel();takeLabel=new JLabel("CAR-ID: ");takeText=new JTextField();takeBtn=new JButton("CHECK");
	  takePanel.setLayout(new GridLayout(1,3,5,5));takeBtn.addActionListener(this);
	  takePanel.add(takeLabel);takePanel.add(takeText);takePanel.add(takeBtn);takePanel.setBackground(Color.BLACK);takeBtn.setMaximumSize(new Dimension(150,30));
	  takeText.setMaximumSize(new Dimension(350,30));
	  panel_2.setLayout(new BorderLayout());
	  panel_2.add(takePanel,BorderLayout.SOUTH);
	  tablePanel=new JPanel();
	  panel_2.add(tablePanel,BorderLayout.CENTER);
	}
	public static  JPanel addPanel()
	{
		CustomerDetail customer=new CustomerDetail();
		return mainPanel;
	}
	public JPanel returnPanel()
	{
		CustomerDetail customer=new CustomerDetail();
		returnlabel=new JLabel("CUSTOMER ID: ");returntext=new JTextField();returnpanel=new JPanel();
		returnBtn=new JButton("RETURN CAR");
		returnpanel.setBackground(Color.BLACK);returntext.setMaximumSize(new Dimension(300,30));
		returnLayout=new GroupLayout(returnpanel);returnpanel.setPreferredSize(new Dimension(300,300));
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\go.jpg"));
		returnpanel.setLayout(returnLayout);
		returnLayout.setAutoCreateContainerGaps(true);returnLayout.setAutoCreateGaps(true);
		returnLayout.setHorizontalGroup(returnLayout.createSequentialGroup().addComponent(imgLabel).addComponent(returnlabel)
					.addGroup(returnLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(returntext).addGap(50).addComponent(returnBtn))
			);
		returnLayout.setVerticalGroup(returnLayout.createParallelGroup().addComponent(imgLabel)
				 .addGroup(returnLayout.createSequentialGroup().addGap(50).addComponent(returnlabel))
				.addGroup(returnLayout.createSequentialGroup().addGap(50).addComponent(returntext).addComponent(returnBtn)));
		returnBtn.addActionListener(this);
		return returnpanel;
	}
	public JPanel deletePanel()
	{
		CustomerDetail customer=new CustomerDetail();
		deleteLabel=new JLabel("ENTER CUSTOMER ID: ");deleteText=new JTextField();imgPanel=new JPanel();
		deleteBtn=new JButton("DELETE CUSTOMER");deletePanel=new JPanel();
		deleteLayout=new GroupLayout(deletePanel);deletePanel.setPreferredSize(new Dimension(300,300));
		deleteText.setMaximumSize(new Dimension(300,30));imgPanel.setBackground(Color.BLACK);
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\go.jpg"));
		imgPanel.add(imgLabel);deletePanel.setBackground(Color.BLACK);
		deletePanel.setLayout(deleteLayout);
		deleteLayout.setAutoCreateContainerGaps(true);deleteLayout.setAutoCreateGaps(true);	
		deleteLayout.setHorizontalGroup(deleteLayout.createSequentialGroup().addComponent(imgPanel).addGap(30)
				.addGroup(deleteLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(50)
						.addComponent(deleteLabel).addComponent(deleteText).addGap(50).addComponent(deleteBtn)));
		deleteLayout.setVerticalGroup(deleteLayout.createParallelGroup().addComponent(imgPanel)
				 .addGroup(deleteLayout.createSequentialGroup().addGap(30).addGap(30)
						 .addComponent(deleteLabel).addGap(30).addComponent(deleteText).addGap(30).addComponent(deleteBtn)));
		deleteBtn.addActionListener(this);
		return deletePanel;
	}
	public JPanel getUpdatePanel()
	{
		  firstLabel=new JLabel("FIRST NAME: ");lastLabel=new JLabel("LAST NAME: ");ageLabel=new JLabel("AGE: ");emailLabel=new JLabel("EMAIL: ");
		  phoneLabel=new JLabel("PHONE: ");btn=new JButton("UPDATE");
		  firstText=new JTextField();lastText=new JTextField();ageText=new JTextField();registerBtn.addActionListener(this);
		  emailText=new JTextField();phoneText=new JTextField();
		  firstText.setMaximumSize(new Dimension(350,30));lastText.setMaximumSize(new Dimension(350,30));
		  ageText.setMaximumSize(new Dimension(350,30));emailText.setMaximumSize(new Dimension(350,30));
		  phoneText.setMaximumSize(new Dimension(350,30));carText.setMaximumSize(new Dimension(350,30));
		  firstText.setForeground(Color.BLACK);lastText.setForeground(Color.BLACK);ageText.setForeground(Color.BLACK);
		  emailText.setForeground(Color.BLACK);phoneText.setForeground(Color.BLACK);
		  
		  inputLayout=new GroupLayout(panel_3);
		  panel_3.setLayout(inputLayout);
		  
		  inputLayout.setAutoCreateContainerGaps(true);
		  inputLayout.setAutoCreateGaps(true);
		  inputLayout.setHorizontalGroup(inputLayout.createSequentialGroup()
				  .addGroup(inputLayout.createParallelGroup().addComponent(firstLabel).addComponent(lastLabel).addComponent(ageLabel).addComponent(phoneLabel).addComponent(emailLabel))
				  .addGroup(inputLayout.createParallelGroup().addComponent(firstText).addComponent(lastText).addComponent(ageText).addComponent(phoneText).addComponent(emailText).addComponent(btn)));
		  inputLayout.setVerticalGroup(inputLayout.createSequentialGroup()
				  .addGroup(inputLayout.createParallelGroup().addComponent(firstLabel).addComponent(firstText))
				  .addGroup(inputLayout.createParallelGroup().addComponent(lastLabel).addComponent(lastText))
				  .addGroup(inputLayout.createParallelGroup().addComponent(ageLabel).addComponent(ageText))
				  .addGroup(inputLayout.createParallelGroup().addComponent(phoneLabel).addComponent(phoneText))
				  .addGroup(inputLayout.createParallelGroup().addComponent(emailLabel).addComponent(emailText))
				  .addComponent(btn)
				  );
		panel_3.setBackground(new Color(43, 71, 44));
		btn.addActionListener(this);
		return panel_3;
		
	}
	public JPanel searchPanel()
	{
		r1=new JRadioButton("SEARCH BY CUSTOMRT ID.");r2=new JRadioButton("SEARCH BY FIRST NAME.");r1.setBackground(Color.BLACK);
		ButtonGroup group=new ButtonGroup();group.add(r1);group.add(r2);r2.setBackground(Color.BLACK);
		searchLabel=new JLabel("ENTER CUSTOMER ID OR FIRSE NAME: ");searchText=new JTextField();imgPanel=new JPanel();
		searchBtn=new JButton("SEARCH CUSTOMER");searchPanel=new JPanel();searchText.setMaximumSize(new Dimension(300,500));
		searchLayout=new GroupLayout(searchPanel);searchPanel.setPreferredSize(new Dimension(300,300));
		searchText.setMaximumSize(new Dimension(300,30));imgPanel.setBackground(Color.BLACK);
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\c.jfif"));
		imgPanel.add(imgLabel);
		searchPanel.setLayout(searchLayout);
		searchLayout.setAutoCreateContainerGaps(true);searchLayout.setAutoCreateGaps(true);	
		searchLayout.setHorizontalGroup(searchLayout.createSequentialGroup().addComponent(imgPanel).addGap(30)
				.addGroup(searchLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(50).addComponent(r1).addGap(100)
						.addComponent(r2).addGap(100)
						.addComponent(searchLabel).addComponent(searchText).addGap(50).addComponent(searchBtn)));
		searchLayout.setVerticalGroup(searchLayout.createParallelGroup().addComponent(imgPanel)
				 .addGroup(searchLayout.createSequentialGroup().addGap(30).addComponent(r1).addGap(30).addComponent(r2).addGap(30)
						 .addComponent(searchLabel).addGap(30).addComponent(searchText).addGap(30).addComponent(searchBtn)));
		searchBtn.addActionListener(this);
		return searchPanel;
	}
	public JPanel updatePanel()
	{
		updateLabel=new JLabel("ENTER CUSTOMER ID: ");updateText=new JTextField();imgPanel=new JPanel();
		updateBtn=new JButton("CHECK");updatePanel=new JPanel();updateText.setMaximumSize(new Dimension(300,500));
		updateLayout=new GroupLayout(updatePanel);updatePanel.setPreferredSize(new Dimension(300,300));
		updateText.setMaximumSize(new Dimension(300,30));imgPanel.setBackground(Color.BLACK);
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\c.jfif"));
		imgPanel.add(imgLabel);
		updatePanel.setLayout(updateLayout);
		updateLayout.setAutoCreateContainerGaps(true);updateLayout.setAutoCreateGaps(true);	
		updateLayout.setHorizontalGroup(updateLayout.createSequentialGroup().addComponent(imgPanel).addGap(30)
				.addGroup(updateLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGap(50)
						.addComponent(updateLabel).addComponent(updateText).addGap(50).addComponent(updateBtn)));
		updateLayout.setVerticalGroup(updateLayout.createParallelGroup().addComponent(imgPanel)
				 .addGroup(updateLayout.createSequentialGroup().addGap(30)
						 .addComponent(updateLabel).addGap(30).addComponent(updateText).addGap(30).addComponent(updateBtn)));
		updateBtn.addActionListener(this);
		updatePanel.setBackground(Color.BLACK);
		return updatePanel;
		
	}
	public JPanel viewPanel()
	{
		CustomerDetail customer=new CustomerDetail();
		viewPanel=new JPanel();
		try
		{
			ResultSet res=DatabaseConnection.viewCustomer();
			defaultTable=new DefaultTableModel();
			defaultTable.setColumnIdentifiers(custCol);
			table=new JTable();table.setMaximumSize(new Dimension(300,300));
			table.setLocation(100, 100);
			table.setModel(defaultTable);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);table.setFillsViewportHeight(true);
	        scroll = new JScrollPane(table);
	        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        table.setRowHeight(30);table.setShowGrid(true);table.setGridColor(Color.CYAN);table.setBackground(new Color(43, 71, 44));
	        table.setForeground(Color.BLACK);table.setSelectionBackground(Color.WHITE);
	        table.setFont(new Font("serif",Font.BOLD,16));
	        cust=new Customer();
			try {
				while(res.next())
				{
					cust.setCustId(res.getInt(1));cust.setFirstName(res.getString(2));cust.setLastName(res.getString(3));
					cust.setAge(res.getInt(4));cust.setEmail(res.getString(5));cust.setPhoneNumber(res.getString(6));
					defaultTable.addRow(new Object[] {cust.getCustId(),cust.getFirstName(),cust.getLastName(),cust.getAge(),cust.getEmail()
							,cust.getPhone()});
					customerList.add(cust);
				}
				
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			viewPanel.add(scroll);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return viewPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
		boolean isValid = false;
		if(e.getSource()==checkBtn)
		{
			try {
			Date pickDate=pickCalender.getDate();
			Date dropDate=dropCalender.getDate();
			Date date=new Date();
			if(pickDate.before(date)||dropDate.before(date))
			{
				JOptionPane.showMessageDialog(this, "Date already passed!.","Invalid Date",JOptionPane.ERROR_MESSAGE);
				isValid=false;
			}
			else
			{
				if(pickDate.getYear()==dropDate.getYear())
				{
					if((dropDate.getMonth()-pickDate.getMonth()==0)||(dropDate.getMonth()-pickDate.getMonth()==1))
					{
					  if(dropDate.getMonth()-pickDate.getMonth()==0)
					  {
							if(pickDate.getDate()<dropDate.getDate())
							{
								isValid=true;
							}
							else
							{
								JOptionPane.showMessageDialog(this,"Start date must be less than return date","Invalid Date",JOptionPane.ERROR_MESSAGE);
								isValid=false;
							}
						}
						else 
						{
							isValid=true;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Rent not allowed more than a month","Invalid Date",JOptionPane.ERROR_MESSAGE);
						isValid=false;
					}
				 }
				else
				{
					JOptionPane.showMessageDialog(this, "Rent not allowed more than a month","Invalid Year",JOptionPane.ERROR_MESSAGE);
					isValid=false;
				}
				if(isValid) {
					firstText.setEnabled(true);lastText.setEnabled(true);ageText.setEnabled(true);emailText.setEnabled(true);phoneText.setEnabled(true);
					ResultSet carResult=dbconn.getCarDetail();
					defaultTable=new DefaultTableModel();
					defaultTable.setColumnIdentifiers(carCol);
					table=new JTable();table.setMaximumSize(new Dimension(300,300));
					table.setModel(defaultTable);
			        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);table.setFillsViewportHeight(true);
			        scroll = new JScrollPane(table);
			        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			        table.setRowHeight(30);table.setShowGrid(true);table.setGridColor(Color.CYAN);table.setBackground(new Color(43, 71, 44));
			        table.setForeground(Color.BLACK);table.setSelectionBackground(Color.WHITE);
			        table.setFont(new Font("serif",Font.BOLD,16));
					try {
						while(carResult.next())
						{
							viewCar.setCarId(carResult.getInt(1));viewCar.setCarModel(carResult.getString(2));
							viewCar.setNumberOfSeat(carResult.getInt(3));viewCar.setTypeId(carResult.getInt(5));
							viewCar.setAvailable(carResult.getBoolean(4));viewCar.setRentPrice(carResult.getDouble(6));viewCar.setCarType(carResult.getString(7));
							defaultTable.addRow(new Object[] {viewCar.getId(),viewCar.getCarModel(),viewCar.getNumberOfSeat(),viewCar.getCarId(),viewCar.getAvail(),
							viewCar.getRentPrice(),viewCar.getCarType()});
							carList.add(viewCar);
						}
						
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					catch (NumberFormatException ev)
					{
						JOptionPane.showMessageDialog(this,"Fill the details.","",JOptionPane.INFORMATION_MESSAGE);
					}
					    	panel_2.add(scroll);
				}
				}
			}
			catch(NullPointerException exe)
			{
				JOptionPane.showMessageDialog(this, "PLEASE FILL ALL THE FIELD","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if(e.getSource()==takeBtn)
		{
			try {
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
			int car_id=Integer.parseInt(takeText.getText());
			Date pickDate=pickCalender.getDate();
			Date dropDate=dropCalender.getDate();
			isAvail=DatabaseConnection.getAvailable(car_id, pickDate, dropDate);
			System.out.println(isAvail);
			if(isAvail)
			{
				JOptionPane.showMessageDialog(this,"CAR IS AVAILABLE.FILL THE DETAILS ON THE RIGHT.","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"CAR IS UNAVAILABLE.CHOOSE OTHER CAR.","FAILED",JOptionPane.ERROR_MESSAGE);
			}		
			}
			catch(NullPointerException exe)
			{
				JOptionPane.showMessageDialog(this, "PLEASE FILL ALL THE FIELD","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			catch (NumberFormatException ev)
			{
				JOptionPane.showMessageDialog(this,"Fill the details.","",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		else if(e.getSource()==registerBtn)
		{
			int custId=0;
			try {
				UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
				customer.setFirstName(firstText.getText());customer.setLastName(lastText.getText());
				customer.setAge(Integer.parseInt(ageText.getText()));customer.setEmail(emailText.getText());
				customer.setPhoneNumber(phoneText.getText());
				result=DatabaseConnection.getDetail(Integer.parseInt(takeText.getText()));
				custId=DatabaseConnection.getLastInserted();
				while(result.next())
				{
				viewCar.setCarId(result.getInt(1));viewCar.setCarModel(result.getString(2));viewCar.setNumberOfSeat(result.getInt(3));
					viewCar.setTypeId(result.getInt(4));viewCar.setAvailable(result.getBoolean(5)); viewCar.setRentPrice(result.getDouble(6));
					viewCar.setCarType(result.getString(7));
					
				}
			} catch (SQLException e1) 
			{
				try {
					result.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (NumberFormatException ev)
			{
				JOptionPane.showMessageDialog(this,"Fill the details.","",JOptionPane.INFORMATION_MESSAGE);
			}
			isregistered=DatabaseConnection.registerCustomer(customer,viewCar,pickCalender.getDate(),dropCalender.getDate());
			if(isregistered)
			{
				JOptionPane.showMessageDialog(this,"BOOK SUCCESSFUL.\nYOUR CUSTOMER ID IS "+custId+1,"SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				firstText.setText("");lastText.setText("");ageText.setText("");emailText.setText("");phoneText.setText("");
				carText.setText("");takeText.setText("");tablePanel.setBackground(new Color(43, 71, 44));scroll.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"BOOKING FAIL.TRY AGAIN!","FAIL",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==returnBtn)
		{
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
				int custId=Integer.parseInt(returntext.getText());
				boolean isReturn=DatabaseConnection.returnCar(custId);
				if(isReturn)
				{
					JOptionPane.showMessageDialog(this, "CAR RETURNED SUCESSFULLY.","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				}
				else
					{
					JOptionPane.showMessageDialog(this, "NO SUCH ID FOUND. UNSUCCESSFUL!","FAIL",JOptionPane.ERROR_MESSAGE);
					}
		}
		else if(e.getSource()==searchBtn)
		{
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
			if(r1.isSelected()){    
				int custId=Integer.parseInt(searchText.getText());
			    JPanel panel=new JPanel();
				try {
				ResultSet res=DatabaseConnection.searchById(custId);
				res.absolute(1);
					if(res.getRow()==0)
					{
						JOptionPane.showMessageDialog(this, "NO CUSTOMER FOUND BY ID "+custId+".","NOT FOUND",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						imgLabel.setIcon(null);
						imgLabel.setText("<html><h3>CUSTOMER ID: "+res.getInt(1)+"</h3><h3>FIRST NAME: "+res.getString(2)+"</h3>"+
								"<h3>LAST NAME: "+res.getString(3)+"</h3><h3>AGE: "+res.getInt(4)+"</h3><h3>EMAIL: "+res.getString(5)+"</h3>"+
								"<h3>PHONE: "+res.getString(6)+"</h3><h3>CAR ID:"+res.getInt(8)+"</h3><h3>START DATE: "+res.getString(9)+"</h3>"+
								"<h3>RETURN DATE: "+res.getString(10)+"</h3><h3>TOTAL AMOUNT: "+res.getDouble(11)+"</h3></html>");
						panel.setBackground(Color.BLACK);
						panel.add(imgLabel);
						imgPanel.add(panel);
						imgPanel.setBackground(new Color(43, 71, 44));
						//searchPanel.add(panel);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}    
			else if(r2.isSelected()){    
				String firstName=searchText.getText();  
				JPanel panel=new JPanel();
				try {
					ResultSet res=DatabaseConnection.searchByName(firstName);
					res.absolute(1);
						if(res.getRow()==0)
						{
							JOptionPane.showMessageDialog(this, "NO CUSTOMER FOUND BY NAME "+firstName+".","NOT FOUND",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							imgLabel.setIcon(null);
							imgLabel.setText("<html><h3>CUSTOMER ID: "+res.getInt(1)+"</h3><br><h3>FIRST NAME: "+res.getString(2)+"</h3><br>"+
									"<h3>LAST NAME: "+res.getString(3)+"</h3><br><h3>AGE: "+res.getInt(4)+"</h3><br><h3>EMAIL: "+res.getString(5)+"</h3><br>"+
									"<h3>PHONE: "+res.getString(6)+"</html>");
							panel.setBackground(Color.BLACK);
							panel.add(imgLabel);
							imgPanel.add(panel);
							imgPanel.setBackground(new Color(43, 71, 44));
							//searchPanel.add(panel);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}  
			else 
			{
				JOptionPane.showMessageDialog(this, "SELECT SEARCH CATEGORY FIRST.","SEARCH",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource()==deleteBtn)
		{
			int custId=Integer.parseInt(deleteText.getText());
			boolean isDelete=false;
		    JPanel panel=new JPanel();
		    UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
		    int yes=JOptionPane.showConfirmDialog(this,"ARE YOU SURE TO DELETE?","CONFIRM DELETE",JOptionPane.YES_NO_CANCEL_OPTION,
		    	      JOptionPane.QUESTION_MESSAGE);
		    if(yes == 0) {
		    	isDelete=DatabaseConnection.deleteCustomer(custId);
		    	deleteText.setText("");
		      } else if (yes == 1) {
		    	  deleteText.setText("");
		         isDelete=false;
		      } else {
		    	  deleteText.setText("");
		         isDelete=false;
		      }
		    if(isDelete)
		    {
		    	JOptionPane.showMessageDialog(this,"RECORD DELETED SUCESSFULLY","DELETE SUCCESS",JOptionPane.INFORMATION_MESSAGE);
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(this,"RECORD DELETION SUSPENDED","DELETE UNSUCCESSFUL",JOptionPane.ERROR_MESSAGE);
		   }    
		}
		else if(e.getSource()==updateBtn)
		{
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200)); 
				int custId=Integer.parseInt(updateText.getText());
			    JPanel panel=new JPanel();
				try {
				ResultSet res=DatabaseConnection.searchById(custId);
				res.absolute(1);
					if(res.getRow()==0)
					{
						JOptionPane.showMessageDialog(this, "NO CUSTOMER FOUND BY ID "+custId+".","NOT FOUND",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						imgLabel.setIcon(null);
						imgLabel.setText("<html><h3>CUSTOMER ID: "+res.getInt(1)+"</h3><h3>FIRST NAME: "+res.getString(2)+"</h3>"+
								"<h3>LAST NAME: "+res.getString(3)+"</h3><h3>AGE: "+res.getInt(4)+"</h3><h3>EMAIL: "+res.getString(5)+"</h3>"+
								"<h3>PHONE: "+res.getString(6)+"</h3><h3>CAR ID:"+res.getInt(8)+"</h3><h3>START DATE: "+res.getString(9)+"</h3>"+
								"<h3>RETURN DATE: "+res.getString(10)+"</h3><h3>TOTAL AMOUNT: "+res.getDouble(11)+"</h3></html>");
						imgLabel.setForeground(Color.BLACK);
						panel.setBackground(Color.BLACK);
						panel.add(imgLabel);
						panel.setBackground(new Color(43, 71, 44));
						JButton fill=new JButton("FILL DETAILS TO UPDATE");
						imgPanel.removeAll();
						imgPanel.setLayout(new BorderLayout());
						imgPanel.setBackground(Color.BLACK);
						imgPanel.add(panel,BorderLayout.CENTER);
						imgPanel.add(fill,BorderLayout.SOUTH);
						fill.addActionListener(new ActionListener()
								{
									@Override
									public void actionPerformed(ActionEvent e) {
										JPanel panel=new JPanel();
										panel=getUpdatePanel();
										imgPanel.removeAll();
									    imgPanel.add(panel);}});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}    
			
		else if(e.getSource()==btn)
		{
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
			int custId=Integer.parseInt(updateText.getText());
			customer.setCustId(custId);
			customer.setFirstName(firstText.getText());customer.setLastName(lastText.getText());
			customer.setAge(Integer.parseInt(ageText.getText()));customer.setEmail(emailText.getText());
			customer.setPhoneNumber(phoneText.getText());
		    isUpdated=DatabaseConnection.updatePersonal(customer);
			if(isUpdated)
			{
				JOptionPane.showMessageDialog(this,"DETAIL UPDATE SUCCESSULLY.","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				imgPanel.removeAll();
				JLabel img=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\c.jfif"));
				imgPanel.add(img);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"DETAIL UPDATE NOT SUCCESS.","FAIL",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
