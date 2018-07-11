package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class GameFrame.
 */
public class GameFrame extends JFrame implements ActionListener{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant FRAME_HEIGHT. */
	public static final int FRAME_WIDTH = 1197, FRAME_HEIGHT = 899;

	/** The menu bar. */
	private JMenuBar menuBar;
	
	/** The menu. */
	private JMenu menu;
	
	/** The exit. */
	private JMenuItem start, controls;
	
	/** The game panel. */
	public GamePanel gamePanel;
	
	/** The controlers panel. */
	private ControlesPanel controlersPanel;
	
	/** The welcome. */
	private WelcomePanel welcome;

	/**
	 * Instantiates a new game frame.
	 */
	public GameFrame()
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Tron legacy");
		setResizable(false);
		
		//Menu

		menuBar = new JMenuBar();
		controls = new JMenuItem("Contrôles");
		menu = new JMenu("Options");
		start = new JMenuItem("Jouer");
		
		menu.add(start);
		menu.add(controls);
		menuBar.add(menu);
		
		start.addActionListener(this);
		controls.addActionListener(this);

		
		
		this.setJMenuBar(menuBar);

	
		
	
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		welcome = new WelcomePanel();
		controlersPanel = new ControlesPanel();
		gamePanel = new GamePanel();
		
		
		
		add(welcome);
		
		
		setVisible(true);


	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == controls)
		{
			System.out.println("Controls");
			welcome.setVisible(false);
			gamePanel.setVisible(false);
			add(controlersPanel);
			controlersPanel.setVisible(true);
		}
		else if( e.getSource() == start)
		{
			System.out.println("Started game");
			welcome.setVisible(false);
			controlersPanel.setVisible(false);
			gamePanel.setVisible(true);
			add(gamePanel);
			gamePanel.start();
		}
		
	}

}
