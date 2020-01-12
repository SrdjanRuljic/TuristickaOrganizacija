package controller.mainWindow;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import view.View;
import view.glavniProzor.MainWindow;

public class MainWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		String objButtons[] =  {"Yes", "No", "Cancel"};
		int PromptResult = JOptionPane.showOptionDialog(View.getMainWindow(), "Are you sure you want to exit?", "GeRuDok", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, objButtons, objButtons[1]);
		if(PromptResult == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
