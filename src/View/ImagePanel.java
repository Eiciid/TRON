package View;
import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ImagePanel.
 */
public class ImagePanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	
	/** The l. */
	JLabel l;
	
	/**
	 * Instantiates a new image panel.
	 */
	public ImagePanel() {
		setBackground(Color.DARK_GRAY);
		l = new JLabel();  //Création du Jlabel
		l.setIcon(new ImageIcon("Resource/images.png"));  //Le JLabel prends la taille de l'image
		add(l);
		validate();
	}



}