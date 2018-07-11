package View;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



// TODO: Auto-generated Javadoc
/**
 * The Class ContolersPanel.
 */
public class ControlesPanel extends JPanel{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ctrl. */
	ImageIcon ctrl;
	
	/**
	 * Instantiates a new contolers panel.
	 */
	public ControlesPanel(){
		ClassLoader loader = ControlesPanel.class.getClassLoader();
		setBackground(Color.BLACK);
		ctrl = new ImageIcon(loader.getResource("controles.png"));
		
		add(new JLabel(ctrl));
	}
	

}
