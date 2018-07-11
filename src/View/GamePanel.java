package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameLogic;

import Model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The logic. */
	private GameLogic logic;

	/** The lbl score. */
	private JLabel lblScore;

	
	/** The Constant H. */
	public static final int W = 1195, H = 855;


	


	/** The timer general. */
	Timer timerGeneral;
	
	/** The timer bullet. */
	Timer timerBullet;

	/**
	 * Instantiates a new game panel.
	 */
	public GamePanel() {
		
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setSize(W, H);
	
		
		
		logic = new GameLogic(W, H);
		lblScore = new JLabel(logic.getP2Name()+": "+logic.getPlayer2Point()+"     "+logic.getP1Name()+": "+logic.getPlayer1Point());
		lblScore.setForeground(Color.WHITE);
		lblScore.setHorizontalAlignment(JLabel.CENTER);



		
		timerGeneral = new Timer(30, this);
		
		

	}

	



	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		logic.draw(g);
		g.setColor(Color.RED);				//bordures
		g.drawRect(0, 0, W-1, H-1);
	}



	
	/**
	 * Start.
	 */
	public void start(){
		
		logic.restart();
		timerGeneral.start();
		
	}
	
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==timerGeneral)
		{
			
			try {
				if(logic.stepAndOk())
					repaint();
				else
				{
					;
					timerGeneral.stop();	
					System.out.println("Game Over");
					lblScore.setText(logic.getP2Name()+": "+logic.getPlayer2Point()+"     "+logic.getP1Name()+": "+logic.getPlayer1Point());
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
		}
		if(e.getSource() == timerBullet)
		{
			repaint();
		}

		

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		 // Touches J1
		 

		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(logic.getP1().getDirection() != Player.UP)
				logic.setP1Direction(Player.DOWN);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			if(logic.getP1().getDirection() != Player.DOWN)
				logic.setP1Direction(Player.UP);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(logic.getP1().getDirection() != Player.RIGHT)
				logic.setP1Direction(Player.LEFT);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(logic.getP1().getDirection() != Player.LEFT)
				logic.setP1Direction(Player.RIGHT);
		}

		
		 //Touches J2
		 
		if(e.getKeyCode() == KeyEvent.VK_S){
			if(logic.getP2().getDirection() != Player.UP)
				logic.setP2Direction(Player.DOWN);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			if(logic.getP2().getDirection() != Player.DOWN)
				logic.setP2Direction(Player.UP);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q){
			if(logic.getP2().getDirection() != Player.RIGHT)
				logic.setP2Direction(Player.LEFT);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){
			if(logic.getP2().getDirection() != Player.LEFT)
				logic.setP2Direction(Player.RIGHT);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_F2)
		{
			start();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



}
