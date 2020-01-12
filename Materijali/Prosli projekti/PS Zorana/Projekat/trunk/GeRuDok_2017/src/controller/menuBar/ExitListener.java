package controller.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.View;

public class ExitListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String objButtons[] =  {"Yes", "No", "Cancel"};
		int PromptResult = JOptionPane.showOptionDialog(View.getMainWindow(), "Are you sure you want to exit?", "GeRuDok", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, objButtons, objButtons[1]);
		if(PromptResult == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}

	}

}
