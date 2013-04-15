package crypto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * Create a screen to search a ID, add a ID-password to the HashMap, modify a password and delete a pair
 * 
 * @author Florent LACROIX & Laetitia GAIGNIER
 * @version 1.0
 *
 * @see Window
 * @see FileAdministrator
 * 
 */
public class FileScreen extends JPanel {
	
	private FileAdministrator fileAdmin = new FileAdministrator();
	
	private JPanel JPSearch = new JPanel();
	private JPanel JPAdd = new JPanel();
	private JPanel JPDelete = new JPanel();
	private JPanel JPModify = new JPanel();
	private JPanel JPReturn= new JPanel();
	private JPanel JPNorth = new JPanel();
	
	private JLabel labelSearch = new JLabel("Search ID");
	private JTextField jtfSearch = new JTextField("ID");
	private JTextField jtfSearchResult = new JTextField();
	private JButton buttonSearch = new JButton("Search");
	
	private JLabel labelAdd = new JLabel("Add");
	private JTextField jtfAddId = new JTextField("ID");
	private JTextField jtfAddPassword = new JTextField("Password");
	private JTextField jtfAddResult = new JTextField();
	private JButton buttonAdd = new JButton("Add");
	
	private JLabel labelModify = new JLabel("Modify");
	private JTextField jtfModifyId = new JTextField("ID");
	private JTextField jtfModifyPassword = new JTextField("New Password");
	private JTextField jtfModifyResult = new JTextField();
	private JButton buttonModify = new JButton("Modify");
	
	private JLabel labelDelete = new JLabel("Delete");
	private JTextField jtfDeleteId = new JTextField("ID");
	private JTextField jtfDeleteResult = new JTextField();
	private JButton buttonDelete = new JButton("Delete");
	
	private JButton returnToMain = new JButton("Return");

	private Window myWindow;
	
	/**
	 * 
	 * Put the different elements in the screen, and organize them
	 * 
	 * @param window the {@link Window} who instantiate the {@link FileScreen}
	 * 
	 * @see Window
	 * @see FileAdministrator
	 * 
	 */
	public FileScreen(Window window){
		this.myWindow = window;
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.JPNorth.setLayout(new GridLayout(5,1));

		Font police = new Font("Calibri", Font.PLAIN, 12);
		
		this.jtfSearch.setFont(police);
		this.jtfSearch.setPreferredSize(new Dimension(150, 30));
		this.jtfSearch.setForeground(Color.BLACK);
		this.jtfSearch.setBackground(Color.WHITE);
		
		this.jtfSearchResult.setFont(police);
		this.jtfSearchResult.setPreferredSize(new Dimension(150, 30));
		this.jtfSearchResult.setForeground(Color.BLACK);
		this.jtfSearchResult.setBackground(Color.WHITE);
		
		this.jtfAddId.setFont(police);
		this.jtfAddId.setPreferredSize(new Dimension(150, 30));
		this.jtfAddId.setForeground(Color.BLACK);
		this.jtfAddId.setBackground(Color.WHITE);
		
		this.jtfAddPassword.setFont(police);
		this.jtfAddPassword.setPreferredSize(new Dimension(150, 30));
		this.jtfAddPassword.setForeground(Color.BLACK);
		this.jtfAddPassword.setBackground(Color.WHITE);
		
		this.jtfAddResult.setFont(police);
		this.jtfAddResult.setPreferredSize(new Dimension(150, 30));
		this.jtfAddResult.setForeground(Color.BLACK);
		this.jtfAddResult.setBackground(Color.WHITE);
		
		this.jtfDeleteId.setFont(police);
		this.jtfDeleteId.setPreferredSize(new Dimension(150, 30));
		this.jtfDeleteId.setForeground(Color.BLACK);
		this.jtfDeleteId.setBackground(Color.WHITE);
		
		this.jtfDeleteResult.setFont(police);
		this.jtfDeleteResult.setPreferredSize(new Dimension(150, 30));
		this.jtfDeleteResult.setForeground(Color.BLACK);
		this.jtfDeleteResult.setBackground(Color.WHITE);
		
		this.jtfModifyId.setFont(police);
		this.jtfModifyId.setPreferredSize(new Dimension(150, 30));
		this.jtfModifyId.setForeground(Color.BLACK);
		this.jtfModifyId.setBackground(Color.WHITE);
		
		this.jtfModifyPassword.setFont(police);
		this.jtfModifyPassword.setPreferredSize(new Dimension(150, 30));
		this.jtfModifyPassword.setForeground(Color.BLACK);
		this.jtfModifyPassword.setBackground(Color.WHITE);
		
		this.jtfModifyResult.setFont(police);
		this.jtfModifyResult.setPreferredSize(new Dimension(150, 30));
		this.jtfModifyResult.setForeground(Color.BLACK);
		this.jtfModifyResult.setBackground(Color.WHITE);
		
		this.JPSearch.setBackground(Color.LIGHT_GRAY);
		this.JPSearch.add(this.labelSearch);
		this.JPSearch.add(this.jtfSearch);
		this.JPSearch.add(this.buttonSearch);
		this.JPSearch.add(this.jtfSearchResult);
		
		this.JPAdd.setBackground(Color.LIGHT_GRAY);
		this.JPAdd.add(this.labelAdd);
		this.JPAdd.add(this.jtfAddId);
		this.JPAdd.add(this.jtfAddPassword);
		this.JPAdd.add(this.buttonAdd);
		this.JPAdd.add(this.jtfAddResult);
		
		this.JPDelete.setBackground(Color.LIGHT_GRAY);
		this.JPDelete.add(this.labelDelete);
		this.JPDelete.add(this.jtfDeleteId);
		this.JPDelete.add(this.buttonDelete);
		this.JPDelete.add(this.jtfDeleteResult);
		
		this.JPModify.setBackground(Color.LIGHT_GRAY);
		this.JPModify.add(this.labelModify);
		this.JPModify.add(this.jtfModifyId);
		this.JPModify.add(this.jtfModifyPassword);
		this.JPModify.add(this.buttonModify);
		this.JPModify.add(this.jtfModifyResult);
		
		this.JPReturn.add(this.returnToMain);
		
		this.JPNorth.add(this.JPSearch);
		this.JPNorth.add(this.JPAdd);
		this.JPNorth.add(this.JPModify);
		this.JPNorth.add(this.JPDelete);
		this.JPNorth.add(this.JPReturn);
				
		this.add(this.JPNorth, BorderLayout.NORTH);
		
		this.returnToMain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				myWindow.changeScreen();
				jtfSearch.setText("ID");
				jtfSearchResult.setText("");
				jtfAddId.setText("ID");
				jtfAddPassword.setText("Password");
				jtfAddResult.setText("");
				jtfModifyId.setText("ID");
				jtfModifyPassword.setText("New Password");
				jtfModifyResult.setText("");
				jtfDeleteId.setText("ID");
				jtfDeleteResult.setText("");
				fileAdmin.setHashMapToNull();
			}
		});
		
		this.buttonSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				if(fileAdmin.search(jtfSearch.getText())!=null)
					jtfSearchResult.setText(fileAdmin.search(jtfSearch.getText()));
				else
					jtfSearchResult.setText("Error : Not Found");
			}
		});
		
		this.buttonAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				if(fileAdmin.add(jtfAddId.getText(),jtfAddPassword.getText()))
					jtfAddResult.setText("Added");
				else
					jtfAddResult.setText("Error : ID already set");
			}
		});
		
		this.buttonModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileAdmin.search(jtfModifyId.getText())!=null){
					fileAdmin.delete(jtfModifyId.getText());
					fileAdmin.add(jtfModifyId.getText(), jtfModifyPassword.getText());
					jtfModifyResult.setText("Done");
				}
				else{
					jtfModifyResult.setText("Error : ID not found");
				}
			}
		});
		
		this.buttonDelete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				if(fileAdmin.delete(jtfDeleteId.getText()))
					jtfDeleteResult.setText("Done");
				else
					jtfDeleteResult.setText("Error : Not Found");
			}
		});
	}
	
	/**
	 * 
	 * Set the {@link FileAdministrator} of the {@link FileScreen}
	 * 
	 * @param fileAdmin the {@link FileAdministrator} instantiate in the {@link FileScreen}
	 * 
	 * @see FileScreen
	 * 
	 */
	public void setFileAdmin(FileAdministrator fileAdmin){
		this.fileAdmin = fileAdmin;
	}
}
