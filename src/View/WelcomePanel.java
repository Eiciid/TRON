package View;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



// TODO: Auto-generated Javadoc
/**
 * The Class WellcomePanel.
 */
public class WelcomePanel extends JPanel{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;
	
	/** The wlcm. */
	ImageIcon wlcm;
	
	/**
	 * Instantiates a new wellcome panel.
	 */
	public WelcomePanel(){
		ClassLoader loader = ControlesPanel.class.getClassLoader();
		setBackground(Color.BLACK);
		wlcm = new ImageIcon(loader.getResource("Chargement.png"));
		
		add(new JLabel(wlcm));
	}
	

}