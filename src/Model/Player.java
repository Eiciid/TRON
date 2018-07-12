package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {

	/** The name. */
	private String name;
	
	/** The intvisible step count. */
	private int direction, points, intvisibleStepCount;
	
	/** The head. */
	private LengthNode head;
	
	/** The color. */
	private Color color;
	
	/** The can fire. */
	private boolean canFire;
	
	/** The flicker. */
	private boolean isVisible, flicker;


	/** The right. */
	public static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;


	/** The p size. */
	public static int PIX_PER_STEP = 5, pSize = 5;

	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 * @param direction the direction
	 * @param color the color
	 * @param x the x
	 * @param y the y
	 * @param point the point
	 */
	public Player(String name, int direction, Color color, int x, int y, int point)
	{
		this.name = name;
		this.direction = direction;
		this.color = color;
		head = new LengthNode(x, y, null);
		canFire = true;
		points = point;
		isVisible = true;
		flicker = false;
		intvisibleStepCount = 0;
	}





	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Adds the points.
	 */
	public void addPoints() {
		this.points++;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}



	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}



	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public LengthNode getHead() {
		return head;
	}

	/**
	 * Step.
	 */
	public void step()
	{
		switch(direction)
		{
		case 1: 		//haut
			head = new LengthNode(head.getX(), head.getY() - PIX_PER_STEP, head);
			break;
		case 2: 		//bas
			head = new LengthNode(head.getX(), head.getY() + PIX_PER_STEP, head);
			break;
		case 3: 		//gauche
			head = new LengthNode(head.getX() - PIX_PER_STEP, head.getY(), head);
			break;
		case 4: 		//droite
			head = new LengthNode(head.getX() + PIX_PER_STEP, head.getY(), head);
			break;
		}

		if(!isVisible)
			intvisibleStepCount++;
		if(intvisibleStepCount == 300)
			isVisible = true;
	}



	/**
	 * Loosed.
	 *
	 * @param other the other
	 * @param maxWidth the max width
	 * @param maxHeight the max height
	 * @return true, if successful
	 */
	public boolean loosed(Player other, int maxWidth, int maxHeight)
	{
		//Suicide
		for(LengthNode p = head.getNext(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//Collision joueur
		for(LengthNode p = other.getHead(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//Collision mur
		if(head.getX() < 0 || head.getY() < 0 || head.getX() > maxWidth + pSize || head.getY() > maxHeight + pSize)
			return true;

		return false;
	}

    /**
     * Checks if is winner.
     *
     * @throws ClassNotFoundException the class not found exception
     */
    public void isWinner() throws ClassNotFoundException {
        
        
        try {
            String url="jdbc:mysql://localhost/tron?useSSL=false&serverTimezone=UTC";
            String user="root";
            String password="";
           
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection réussie");
            CallableStatement cStmt = conn.prepareCall("{call ajout(?)}");
            cStmt.setString(1, this.getName());
           
            cStmt.execute();
            System.out.println("Vainqueur enregistré");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        
        System.out.println("Le joueur " + this.getName() + " à gagné!");
        
        
    }

	/**
	 * Draw.
	 *
	 * @param g the g
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		LengthNode p = head;
		if(isVisible)
			for(;p != null; p=p.getNext())
				g.fillRect(p.getX(), p.getY(), pSize, pSize);	//tous les joueurs
		else 
			if(flicker){
				for(;p != null; p=p.getNext())
					g.fillRect(p.getX(), p.getY(), pSize, pSize);
				flicker = false;
			}else{
				g.fillRect(p.getX(), p.getY(), pSize, pSize);
				int flickerOdds = (int)(Math.random() * 10);
				if(flickerOdds < 1)
					flicker = true;
			}
	}

}




