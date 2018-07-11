package View;
import javax.swing.*;

import java.awt.*;



// TODO: Auto-generated Javadoc
/**
 * The Class MenuPanel.
 */
public class MenuPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	
	/** The p 2. */
	private JLabel p1, p2;
	

	 
 	/** The name 2. */
 	String name1, name2;



	/**
	 * Instantiates a new menu panel.
	 *
	 * @param name1 the name 1
	 * @param name2 the name 2
	 * @param score1 the score 1
	 * @param score2 the score 2
	 */
	public MenuPanel(String name1, String name2, int score1, int score2) {
		setBackground(Color.DARK_GRAY);

		this.name1 = name1;
		this.name2 = name2;


		setLayout(new BorderLayout(20, 0));
		add(p1, BorderLayout.WEST);
		add(new ImagePanel(), BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);

	}

	/**
	 * Update score.
	 *
	 * @param score1 the score 1
	 * @param score2 the score 2
	 */

}
