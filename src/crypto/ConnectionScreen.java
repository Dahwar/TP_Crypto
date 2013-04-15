package crypto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConnectionScreen extends JPanel{
	
	private FileAdministrator fileAdmin = new FileAdministrator();
	
	private JPanel JPId = new JPanel();
	private JPanel JPPassword = new JPanel();
	private JPanel JPSubmit = new JPanel();
	private JPanel JPNorth = new JPanel();
	
	private JTextField jtfFile = new JTextField("file");
	private JLabel labelFile = new JLabel("File");
	private JPasswordField jtfPassword = new JPasswordField("password");
	private JLabel labelPassword = new JLabel("Password");
	private JButton submit = new JButton("Submit");
	
	private JPanel JPNewFile = new JPanel();
	private JPanel JPSubmitNew = new JPanel();
	
	private JTextField jtfNewFile = new JTextField("New file name");
	private JTextField jtfNewPassword = new JTextField("Password");
	private JButton submitNew = new JButton("Submit");

	private Window myWindow;
	
	public ConnectionScreen(Window window){
		this.myWindow = window;
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.JPNorth.setLayout(new GridLayout(5,1));

		Font police = new Font("Calibri", Font.PLAIN, 12);
		
		this.jtfFile.setFont(police);
		this.jtfFile.setPreferredSize(new Dimension(150, 30));
		this.jtfFile.setForeground(Color.BLACK);
		this.jtfFile.setBackground(Color.WHITE);
		
		this.jtfPassword.setFont(police);
		this.jtfPassword.setPreferredSize(new Dimension(150, 30));
		this.jtfPassword.setForeground(Color.BLACK);
		this.jtfPassword.setBackground(Color.WHITE);
		
		this.JPId.setBackground(Color.LIGHT_GRAY);
		this.JPId.add(this.labelFile);
		this.JPId.add(this.jtfFile);
		
		this.JPPassword.setBackground(Color.LIGHT_GRAY);
		this.JPPassword.add(this.labelPassword);
		this.JPPassword.add(this.jtfPassword);
		
		this.JPSubmit.add(this.submit);
		
		this.JPNewFile.setBackground(Color.LIGHT_GRAY);
		
		this.jtfNewFile.setFont(police);
		this.jtfNewFile.setPreferredSize(new Dimension(150, 30));
		this.jtfNewFile.setForeground(Color.BLACK);
		this.jtfNewFile.setBackground(Color.WHITE);
		
		this.jtfNewPassword.setFont(police);
		this.jtfNewPassword.setPreferredSize(new Dimension(150, 30));
		this.jtfNewPassword.setForeground(Color.BLACK);
		this.jtfNewPassword.setBackground(Color.WHITE);
		
		this.JPNewFile.add(this.jtfNewFile);
		this.JPNewFile.add(this.jtfNewPassword);
		
		this.JPSubmitNew.add(this.submitNew);
		
		this.JPNorth.add(this.JPId);
		this.JPNorth.add(this.JPPassword);
		this.JPNorth.add(this.JPSubmit);
		this.JPNorth.add(this.JPNewFile);
		this.JPNorth.add(this.JPSubmitNew);
				
		this.add(this.JPNorth, BorderLayout.NORTH);
		
		this.submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				if(fileAdmin.openFile(jtfFile.getText(), new String(jtfPassword.getPassword()))!=null){
					myWindow.setFileAdmin(fileAdmin);
					myWindow.changeScreen();
					jtfPassword.setText("password");
				}
			}
		});
		
		this.submitNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File(jtfNewFile.getText());
			}
		});
	}
}
