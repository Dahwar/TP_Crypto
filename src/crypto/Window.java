package crypto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Window extends JFrame {
		
	private JPanel connectionScreen = new ConnectionScreen(this);
	private JPanel fileScreen = new FileScreen(this);
	private JPanel content = new JPanel();
	private CardLayout cl = new CardLayout();
 
	public Window(){
		this.setTitle("Crypto");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.content.setLayout(this.cl);
		this.content.add(connectionScreen);
		this.content.add(fileScreen);
		
		this.setContentPane(this.content);
		this.setVisible(true); 
	}
	
	public void changeScreen(){
		this.cl.next(this.content);
	}
	
	public void setFileAdmin(FileAdministrator fileAdmin){
		((FileScreen) this.fileScreen).setFileAdmin(fileAdmin);
	}
}

