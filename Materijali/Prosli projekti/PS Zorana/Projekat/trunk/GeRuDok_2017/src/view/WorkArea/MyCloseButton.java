package view.WorkArea;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyCloseButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyCloseButton()
	{
		super();
		setBorder(BorderFactory.createEmptyBorder());
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setRolloverEnabled(false);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(16, 16);
	}
}
