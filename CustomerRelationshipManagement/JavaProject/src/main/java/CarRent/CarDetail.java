package CarRent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class CarDetail extends JFrame implements ActionListener
{
	private static JPanel mainPanel,addPanel,takePanel,takeDisplay,searchPanel,imgPanel,deletePanel,updatePanel;
	private static JLabel modelLabel,typeLabel,idLabel,rateLabel,seatLabel,takeLabel,imgLabel,searchLabel,deleteLabel,updateLabel;
	private static JTextField modelText,typeText,idText,rateText,seatText,takeText,searchText,deleteText,updateText;
	private static JButton addBtn,takeBtn,takeButton,searchBtn,deleteBtn,updateBtn,btn;
	private static GroupLayout layout,otherLayout,takeLayout,searchLayout,deleteLayout,updateLayout;
	private static JRadioButton r1,r2;
	private String[] carCol= {"CAR_ID","CAR_MODEL","NUMBER_OF_SEAT","TYPE_ID","AVAILABLE","DAILY_RATE","CAR_TYPE"};
	private static JTable table;
	private static JScrollPane scroll;
	private DefaultTableModel defaultTable;
	private static Vector<Object> carList=new Vector<>();
	private Car car=new Car();
	private DatabaseConnection dbConnect=new DatabaseConnection();
	private static boolean success,isUpdated;
	public CarDetail()
	{
		this.setSize(400,400);
		modelLabel=new JLabel("CAR MODEL: ");typeLabel=new JLabel("CAR TYPE: ");idLabel=new JLabel("TYPE ID(1-100): ");
		rateLabel=new JLabel("DAILY RATE(Birr): ");seatLabel=new JLabel("NUMBER OF SEAT: ");addBtn=new JButton("ADD");addBtn.addActionListener(this);
		modelText=new JTextField();typeText=new JTextField();idText=new JTextField();
		rateText=new JTextField();seatText=new JTextField();
		modelText.setMaximumSize(new Dimension(300,30));typeText.setMaximumSize(new Dimension(300,30));idText.setMaximumSize(new Dimension(300,30));
		rateText.setMaximumSize(new Dimension(300,30));seatText.setMaximumSize(new Dimension(300,30));
		mainPanel=new JPanel();mainPanel.setMaximumSize(new Dimension(500,270));idLabel.setForeground(Color.BLACK);
		layout=new GroupLayout(mainPanel);typeLabel.setForeground(Color.BLACK);rateLabel.setForeground(Color.BLACK);
		mainPanel.setLayout(layout);seatLabel.setForeground(Color.BLACK);
		mainPanel.setBackground(new Color(43, 71, 44));
		modelLabel.setForeground(Color.BLACK);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(modelLabel).addComponent(typeLabel).addComponent(idLabel)
						.addComponent(rateLabel).addComponent(seatLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(modelText).addComponent(typeText).addComponent(idText).addComponent(rateText)
						.addComponent(seatText).addComponent(addBtn)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(modelLabel).addComponent(modelText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(typeLabel).addComponent(typeText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(idLabel).addComponent(idText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(rateLabel).addComponent(rateText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(seatLabel).addComponent(seatText))
				.addComponent(addBtn));
		
		addPanel=new JPanel();
		addPanel.setBackground(Color.BLACK);
		otherLayout=new GroupLayout(addPanel);
		addPanel.setLayout(otherLayout);
		otherLayout.setHorizontalGroup(otherLayout.createSequentialGroup().addGap(280).addComponent(mainPanel));
		otherLayout.setVerticalGroup(otherLayout.createSequentialGroup().addGap(100).addComponent(mainPanel));
		addPanel.add(mainPanel);
		
	}
	public static  JPanel addPanel()
	{
		CarDetail car=new CarDetail();
		return addPanel;
	}
	public JPanel takePanel()
	{
		CarDetail car=new CarDetail();
		takePanel=new JPanel();takeLabel=new JLabel("ENTER CUSTOMER ID:  ");takeText=new JTextField();
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\vv.jpg"));
		takeDisplay=new JPanel();takeText.setMaximumSize(new Dimension(300,30));takeDisplay.add(imgLabel);
		takePanel.setBackground(Color.BLACK);takeDisplay.setBackground(new Color(43, 71, 44));
		takeButton=new JButton("SEARCH");takeButton.addActionListener(this);
		takeBtn=new JButton("TAKE CAR");takeBtn.addActionListener(this);
		takeLayout=new GroupLayout(takePanel);
		takePanel.setLayout(takeLayout);
		takeLayout.setAutoCreateContainerGaps(true);takeLayout.setAutoCreateGaps(true);
		takeLayout.setHorizontalGroup(takeLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(takeLayout.createSequentialGroup()
				.addComponent(takeLabel).addComponent(takeText)).addComponent(takeButton)
				.addComponent(takeDisplay).addComponent(takeBtn));
		takeLayout.setVerticalGroup(takeLayout.createSequentialGroup().addGroup(takeLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(takeLabel).addComponent(takeText))
				.addComponent(takeButton).addComponent(takeDisplay).addComponent(takeBtn));
		return takePanel;
	}
	public JPanel getUpdatePanel()
	{
		modelLabel=new JLabel("CAR MODEL: ");typeLabel=new JLabel("CAR TYPE: ");idLabel=new JLabel("TYPE ID(1-100): ");
		rateLabel=new JLabel("DAILY RATE(Birr): ");seatLabel=new JLabel("NUMBER OF SEAT: ");btn=new JButton("UPDATE");addBtn.addActionListener(this);
		modelText=new JTextField();typeText=new JTextField();idText=new JTextField();
		rateText=new JTextField();seatText=new JTextField();
		modelText.setMaximumSize(new Dimension(300,30));typeText.setMaximumSize(new Dimension(300,30));idText.setMaximumSize(new Dimension(300,30));
		rateText.setMaximumSize(new Dimension(300,30));seatText.setMaximumSize(new Dimension(300,30));
		mainPanel=new JPanel();mainPanel.setMaximumSize(new Dimension(500,270));idLabel.setForeground(Color.BLACK);
		layout=new GroupLayout(mainPanel);typeLabel.setForeground(Color.BLACK);rateLabel.setForeground(Color.BLACK);
		mainPanel.setLayout(layout);seatLabel.setForeground(Color.BLACK);
		mainPanel.setBackground(new Color(43, 71, 44));
		modelLabel.setForeground(Color.BLACK);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(modelLabel).addComponent(typeLabel).addComponent(idLabel)
						.addComponent(rateLabel).addComponent(seatLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(modelText).addComponent(typeText).addComponent(idText).addComponent(rateText)
						.addComponent(seatText).addComponent(btn)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(modelLabel).addComponent(modelText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(typeLabel).addComponent(typeText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(idLabel).addComponent(idText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(rateLabel).addComponent(rateText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(seatLabel).addComponent(seatText))
				.addComponent(btn));

		mainPanel.setBackground(new Color(43, 71, 44));
		btn.addActionListener(this);
		return mainPanel;
	}
	public JPanel deletePanel()
	{
		CustomerDetail customer=new CustomerDetail();
		deleteLabel=new JLabel("ENTER CAR ID: ");deleteText=new JTextField();imgPanel=new JPanel();
		deleteBtn=new JButton("DELETE CAR");deletePanel=new JPanel();
		deleteLayout=new GroupLayout(deletePanel);deletePanel.setPreferredSize(new Dimension(300,300));
		deleteText.setMaximumSize(new Dimension(300,30));imgPanel.setBackground(Color.BLACK);
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\c.jfif"));
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
		deletePanel.setBackground(Color.BLACK);
		return deletePanel;
	}
	public JPanel viewPanel()
	{
		CarDetail customer=new CarDetail();
		JPanel viewPanel=new JPanel();
		ResultSet carResult=DatabaseConnection.getCarDetail();
		defaultTable=new DefaultTableModel();
		defaultTable.setColumnIdentifiers(carCol);
		table=new JTable();table.setMaximumSize(new Dimension(300,300));
		table.setModel(defaultTable);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        table.setRowHeight(30);table.setShowGrid(true);table.setGridColor(Color.CYAN);table.setBackground(new Color(43, 71, 44));
        table.setForeground(Color.BLACK);table.setSelectionBackground(Color.WHITE);
        table.setFont(new Font("serif",Font.BOLD,16));
		try {
			while(carResult.next())
			{
				car.setCarId(carResult.getInt(1));car.setCarModel(carResult.getString(2));
				car.setNumberOfSeat(carResult.getInt(3));car.setAvailable(carResult.getBoolean(4));
				car.setTypeId(carResult.getInt(5));
				car.setRentPrice(carResult.getDouble(6));car.setCarType(carResult.getString(7));
				defaultTable.addRow(new Object[] {car.getId(),car.getCarModel(),car.getNumberOfSeat(),car.getCarId(),car.getAvail(),
				car.getRentPrice(),car.getCarType()});
				carList.add(car);
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		viewPanel.add(scroll);
		viewPanel.setBackground(Color.BLACK);
		return viewPanel;
	}
	public JPanel searchPanel()
	{
		r1=new JRadioButton("SEARCH BY CAR ID.");r2=new JRadioButton("SEARCH BY CAR NAME.");r1.setBackground(Color.BLACK);
		ButtonGroup group=new ButtonGroup();group.add(r1);group.add(r2);r2.setBackground(Color.BLACK);
		searchLabel=new JLabel("ENTER CAR ID OR NAME: ");searchText=new JTextField();imgPanel=new JPanel();
		searchBtn=new JButton("SEARCH CAR");searchPanel=new JPanel();searchText.setMaximumSize(new Dimension(300,500));
		searchLayout=new GroupLayout(searchPanel);searchPanel.setPreferredSize(new Dimension(300,300));
		searchText.setMaximumSize(new Dimension(300,30));imgPanel.setBackground(Color.BLACK);
		imgLabel=new JLabel(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\go.jpg"));
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
		searchPanel.setBackground(Color.BLACK);
		return searchPanel;
	}
	public JPanel updatePanel()
	{
		updateLabel=new JLabel("ENTER CAR ID: ");updateText=new JTextField();imgPanel=new JPanel();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addBtn)
		{
			try {
			car.setCarModel(modelText.getText());
			car.setCarType(typeText.getText());
			car.setNumberOfSeat(Integer.parseInt(seatText.getText()));
			car.setRentPrice(Double.parseDouble(rateText.getText()));
			car.setTypeId(Integer.parseInt(idText.getText()));
			success=DatabaseConnection.addCar(car);
			if(success)
			{
				JOptionPane.showMessageDialog(this, "CAR DETAIL ADD SUCCESSFULLY","ADD SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				modelText.setText("");typeText.setText("");idText.setText("");rateText.setText("");seatText.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "OPERATION UNSUCCESSFUL","ADD FAIL",JOptionPane.WARNING_MESSAGE);
			}}
			catch (NumberFormatException ev)
			{
				JOptionPane.showMessageDialog(this,"Fill the details.","",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource()==takeButton)
		{
			int custId=Integer.parseInt(takeText.getText());
			JPanel panel=new JPanel();
			try {
			ResultSet res=DatabaseConnection.takeDetail(custId);
			if(res==null)
			{
				JOptionPane.showMessageDialog(this, "NO SUCH CUSTOMER ID EXISTS.","FAIL",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				res.absolute(1);
				imgLabel.setIcon(null);
				imgLabel.setText("<html><h3>CUSTOMER ID: "+res.getInt(1)+"</h3><br><h3>CAR ID: "+res.getInt(2)+"</h3><"+
						"<h3>START DATE: "+res.getDate(3)+"</h3><br><h3>RETURN DATE: "+res.getDate(4)+"</h3><br><h3>TOTAL AMOUNT: "+res.getDouble(5)+"</h3><br>"+
						"<h3>RENT PER DAY: "+res.getDouble(7)+"</html>");
				panel.setBackground(Color.BLACK);
				panel.add(imgLabel);
				takeDisplay.add(panel);
				takeDisplay.setBackground(new Color(43, 71, 44));
				JOptionPane.showMessageDialog(this, "YOUR TOTAL PAYMENT: "+res.getDouble(5),"PAYMENT",JOptionPane.INFORMATION_MESSAGE);
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==takeBtn)
		{
			int custId=Integer.parseInt(takeText.getText());
			boolean isTake=DatabaseConnection.takeConfirm(custId);
			if(isTake)
			{
				JOptionPane.showMessageDialog(this,"CAR IS SUCCESSFULY ASSIGNED.","TAKE CAR",JOptionPane.INFORMATION_MESSAGE);
				imgLabel.setText("");
				imgLabel.setIcon(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\vv.jpg"));
				takeDisplay.setBackground(new Color(43, 71, 44));
				takeText.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"CAR IS NOT SUCCESSFULY ASSIGNED. TRY AGAIN.","FAIL",JOptionPane.ERROR_MESSAGE);
				imgLabel.setText("");
				imgLabel.setIcon(new ImageIcon("C:\\Users\\EYU\\eclipse-workspace\\JavaProject\\src\\main\\java\\images\\vv.jpg"));
				takeDisplay.setBackground(new Color(43, 71, 44));
				takeText.setText("");
			}
		}
		else if(e.getSource()==searchBtn)
		{
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
			if(r1.isSelected()){    
				int carId=Integer.parseInt(searchText.getText());
			    JPanel panel=new JPanel();
				try {
				ResultSet res=DatabaseConnection.searchCarById(carId);
					if(res==null)
					{
						JOptionPane.showMessageDialog(this, "NO CAR FOUND BY ID "+carId+".","NOT FOUND",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						res.absolute(1);
						imgLabel.setIcon(null);
						imgLabel.setText("<html><h3>CAR ID: "+res.getInt(1)+"</h3><br><h3>CAR MODEL: "+res.getString(2)+"</h3><br>"+
								"<h3>NUMBER OF SEAT: "+res.getInt(3)+"</h3><br><h3>CAR TYPE ID: "+res.getInt(4)+"</h3><br><h3>IS AVAILABLE: "+res.getBoolean(5)+"</h3><br>"+
								"<h3>DAILY RENT PRICE: "+res.getDouble(7)+"<br><h3>CAR TYPE: "+res.getString(8)+"</html>");
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
				String carName=searchText.getText();  
				JPanel panel=new JPanel();
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
				ResultSet carResult=DatabaseConnection.searchCarByType(carName);
				try {
					if(carResult==null)
					{
						JOptionPane.showMessageDialog(this,"NO SUCH CAR NAME!","INCORRECT",JOptionPane.ERROR_MESSAGE);
					}
					else {
					carResult.beforeFirst();
					while(carResult.next())
					{
						car.setCarId(carResult.getInt(1));car.setCarModel(carResult.getString(2));
						car.setNumberOfSeat(carResult.getInt(3));car.setTypeId(carResult.getInt(4));
						car.setAvailable(carResult.getBoolean(5));car.setRentPrice(carResult.getDouble(6));car.setCarType(carResult.getString(7));
						defaultTable.addRow(new Object[] {car.getId(),car.getCarModel(),car.getNumberOfSeat(),car.getCarId(),car.getAvail(),
						car.getRentPrice(),car.getCarType()});
						carList.add(car);
					}
					}
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					System.out.println("");
				}
				imgPanel.removeAll();
				imgPanel.add(scroll);
			}  
			else 
			{
				JOptionPane.showMessageDialog(this, "SELECT SEARCH CATEGORY FIRST.","SEARCH",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource()==deleteBtn)
		{
			int carId=Integer.parseInt(deleteText.getText());
			boolean isDelete = false;
		    JPanel panel=new JPanel();
		    UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
		    int yes=JOptionPane.showConfirmDialog(this,"ARE YOU SURE TO DELETE?","CONFIRM DELETE",JOptionPane.YES_NO_CANCEL_OPTION,
		    	      JOptionPane.QUESTION_MESSAGE);
		    if(yes == 0) {
		    	isDelete=DatabaseConnection.deleteCar(carId);
		    	deleteText.setText("");
		    	if(isDelete==false)
		    	{
		    		deleteText.setText("");
		    		JOptionPane.showMessageDialog(this,"CAR IS IN USE. YOU CAN DELETE IT AFTER IT RETURNED!","NOT AVAILABLE.",JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	else if(isDelete==true)
		    	{
		    		deleteText.setText("");
		    		JOptionPane.showMessageDialog(this,"DELETED SUCCESSFULLY.","FAIL",JOptionPane.INFORMATION_MESSAGE);
		    	}
		      } else if (yes == 1) {
		    	  deleteText.setText("");
		    	  JOptionPane.showMessageDialog(this,"RECORD DELETION SUSPENDED","DELETE UNSUCCESSFUL",JOptionPane.ERROR_MESSAGE);
		      } else {
		    	  deleteText.setText("");
		    	  JOptionPane.showMessageDialog(this,"RECORD DELETION SUSPENDED","DELETE UNSUCCESSFUL",JOptionPane.ERROR_MESSAGE);
		      }
		}
		else if(e.getSource()==updateBtn)
		{
			    UIManager.put("OptionPane.minimumSize", new Dimension(400, 200)); 
				int carId=Integer.parseInt(updateText.getText());
			    JPanel panel=new JPanel();
				try {
				ResultSet res=DatabaseConnection.searchCarById(carId);
				res.absolute(1);
					if(res.getRow()==0)
					{
						JOptionPane.showMessageDialog(this, "NO CAR FOUND BY ID "+carId+".","NOT FOUND",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						imgLabel.setIcon(null);
						imgLabel.setText("<html><h3>CAR ID: "+res.getInt(1)+"</h3><h3>CAR MODEL: "+res.getString(2)+"</h3>"+
								"<h3>NUMBER OF SEAT: "+res.getString(3)+"</h3><h3>TYPE-ID: "+res.getInt(4)+"</h3><h3>DAILY RATE: "+res.getInt(5)+"</h3>"+
								"<h3>CART-YPE: "+res.getString(6)+"</html>");
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
				catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(this, "NO CAR FOUND BY ID "+carId+".","NOT FOUND",JOptionPane.ERROR_MESSAGE);
				}
			}
		else if(e.getSource()==btn)
		{
			UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
			car.setTypeId(Integer.parseInt(idText.getText()));
			car.setCarModel(modelText.getText());car.setCarType(typeText.getText());
			car.setRentPrice(Double.parseDouble(rateText.getText()));car.setNumberOfSeat(Integer.parseInt(seatText.getText()));
		    isUpdated=DatabaseConnection.updateCar(car);
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


