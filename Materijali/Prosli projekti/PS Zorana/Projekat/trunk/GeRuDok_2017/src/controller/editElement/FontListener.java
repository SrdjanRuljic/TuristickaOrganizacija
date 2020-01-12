package controller.editElement;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingUtilities;

import viewer.editElement.WindowEditElement;
import viewer.editElementToolBar.TextToolbar;

public class FontListener implements ItemListener {

	WindowEditElement windowEditElement;
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		//da se sazna koji je Window aktivan
		windowEditElement = (WindowEditElement) SwingUtilities.getWindowAncestor((Component) arg0.getSource());
		windowEditElement.getTextArea().setFont(new Font(TextToolbar.fontovi.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(TextToolbar.velicinaFonta.getSelectedItem().toString())));
		//stavljanje JTextPane-a u fokus
		windowEditElement.getTextArea().requestFocus();
		
	}

}
