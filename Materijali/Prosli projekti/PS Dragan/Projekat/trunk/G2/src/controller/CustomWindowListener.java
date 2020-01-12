package controller;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import documentModel.Page;
import localization.Localization;
import main.MainClass;
import view.ProjectBrowser;
import xml.WriterDOM;

public class CustomWindowListener implements WindowListener {

	private static Localization local = Localization.getInstance();
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		MainClass.mf.gotoCloseEditor();	
		MainClass.mf.mainPanel.canvasModel.closeAllTabe();
		
		Object[] opcije = {local.getString("options.yes"), local.getString("options.no")};
		
		int retVal = JOptionPane.showOptionDialog(SwingUtilities.getRoot((Component) e.getSource()), 
				local.getString("close.message"), 
				local.getString("close.title"), 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, opcije, opcije[1]);
		
		if(retVal == JOptionPane.YES_OPTION)
		{
			
			WriterDOM writer = new WriterDOM();
			writer.createContext(MainClass.mf.mainPanel.projectBrowser.tree);
			System.exit(0); 
		}
		else if(retVal == JOptionPane.NO_OPTION)
		{
		 
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
