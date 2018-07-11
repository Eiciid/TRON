package Controller;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;



import Model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class GameLogic.
 */
public class GameLogic {
	
	/** The player 2. */
	private Player player1, player2;
	
	/** The height. */
	private int width, height;
	
	/** The color P 2. */
	private Color colorP1, colorP2;






	/**
	 * Instantiates a new game logic.
	 *
	 * @param maxWidth the max width
	 * @param maxHeight the max height
	 */
	public GameLogic(int maxWidth, int maxHeight)
	{
		width = maxWidth;
		height = maxHeight;
		colorP1 = new Color(3,3,173);
		colorP2 = new Color(173, 3, 3 );


		player1 = new Player(getNewName("Joueur 1"), Player.LEFT, colorP1, width - 300, 420, 0);  //Gauche
		player2 = new Player(getNewName("Joueur 2"), Player.RIGHT, colorP2, 0 + 300, 420, 0);  //Droite
	}


	/**
	 * Gets the new name.
	 *
	 * @param s the s
	 * @return the new name
	 */
	private String getNewName(String s){
		return JOptionPane.showInputDialog(s);
	}

	/**
	 * Sets the p 1 direction.
	 *
	 * @param direct the new p 1 direction
	 */
	public void setP1Direction(int direct)
	{
		player1.setDirection(direct);
	}

	/**
	 * Sets the p 2 direction.
	 *
	 * @param direct the new p 2 direction
	 */
	public void setP2Direction(int direct)
	{
		player2.setDirection(direct);
	}

	/**
	 * Gets the p 1 name.
	 *
	 * @return the p 1 name
	 */
	public String getP1Name()
	{
		return player1.getName();
	}

	/**
	 * Gets the p 2 name.
	 *
	 * @return the p 2 name
	 */
	public String getP2Name()
	{
		return player2.getName();
	}

	/**
	 * Gets the player 1 point.
	 *
	 * @return the player 1 point
	 */
	public int getPlayer1Point()
	{
		return player1.getPoints();
	}

	/**
	 * Gets the player 2 point.
	 *
	 * @return the player 2 point
	 */
	public int getPlayer2Point()
	{
		return player2.getPoints();
	}

	/**
	 * Gets the p1.
	 *
	 * @return the p1
	 */
	public Player getP1(){
		return player1;
	}

	/**
	 * Gets the p2.
	 *
	 * @return the p2
	 */
	public Player getP2(){
		return player2;
	}




	/**
	 * Step and ok.
	 *
	 * @return true, if successful
	 * @throws ClassNotFoundException the class not found exception
	 */
	public boolean stepAndOk() throws ClassNotFoundException
	{

		player1.step();
		player2.step();

		if(player1.loosed(player2, width, height))
		{
			player2.isWinner();
			return false;
		}
		else if(player2.loosed(player1, width, height))
		{
			player1.isWinner();
			return false;
		}
		return true;
	}



	/**
	 * Restart.
	 */
	public void  restart()
	{
		player1 = new Player(player1.getName(), Player.LEFT, colorP1,width - 300, 420, player1.getPoints());	//Replace le joueur 1 a gauche 
		player2 = new Player(player2.getName(), Player.RIGHT, colorP2, 0 + 300, 420, player2.getPoints());		//Replace le joueur 2 a droite

	}





	/**
	 * Draw.
	 *
	 * @param g the g
	 */
	public void draw(Graphics g)
	{
		player1.draw(g);
		player2.draw(g);

	}

}
