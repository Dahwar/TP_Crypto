package crypto;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Window extends JFrame {
		
	private JPanel connectionScreen = new ConnectionScreen(this);
	private JPanel fileScreen = new FileScreen(this);
	private JPanel content = new JPanel();
	private CardLayout cl = new CardLayout();
	
	JMenuBar JMenuBar = new JMenuBar();
	JMenu JMenuFiles = new JMenu("Files");
	JMenuItem itemFiles_Quit = new JMenuItem("Quit");
 
	public Window(){
		this.setTitle("Crypto");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.content.setLayout(this.cl);
		this.content.add(connectionScreen);
		this.content.add(fileScreen);
		
		JMenuFiles.setMnemonic('F');
		itemFiles_Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		this.JMenuFiles.add(itemFiles_Quit);
		this.JMenuBar.add(JMenuFiles);
		
		this.setJMenuBar(JMenuBar);
		
		this.setContentPane(this.content);
		this.setVisible(true);
		
		this.itemFiles_Quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
	    });
	}
	
	public void changeScreen(){
		this.cl.next(this.content);
	}
	
	public void setFileAdmin(FileAdministrator fileAdmin){
		((FileScreen) this.fileScreen).setFileAdmin(fileAdmin);
	}
}

