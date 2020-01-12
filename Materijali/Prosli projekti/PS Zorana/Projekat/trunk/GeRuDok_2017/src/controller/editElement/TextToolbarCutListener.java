package controller.editElement;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import viewer.editElement.WindowEditElement;

public class TextToolbarCutListener implements ActionListener 
{
	WindowEditElement windowEditElement;
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//da se sazna koji je Window aktivan
		windowEditElement = (WindowEditElement) SwingUtilities.getWindowAncestor((Component) e.getSource());
		windowEditElement.getTextArea().cut();
		//stavljanje JTextPane-a u fokus
		windowEditElement.getTextArea().requestFocus();
		
	}

}
