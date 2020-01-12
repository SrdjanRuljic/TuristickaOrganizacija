package controller.chooseWorkspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import XML.DomParserForRecentWorkspace;
import model.Workspace;
import view.PreView;
import view.View;
import view.chooseWorkspace.DialogEarthquakeCenter;
import view.chooseWorkspace.WindowForChooseWorkspace;
import view.glavniProzor.MainWindow;

public class btnOKListener implements ActionListener {

	public static Workspace workspace;
	File file;
	DomParserForRecentWorkspace domParserForRecentWorkspace;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		file = new File(WindowForChooseWorkspace.getjComboBox().getSelectedItem().toString());
		if(file.exists())
		{
			workspace = new Workspace(file);
			workspace.dodajProjekte();
		
			domParserForRecentWorkspace = new DomParserForRecentWorkspace();
			
			try {
				domParserForRecentWorkspace.sacuvaj();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreView.windowForChooseWorkspace.dispose();
			new View();
		}
		else
		{
			Object[] options = {"OK"};
			JOptionPane pane = new JOptionPane("Chosen directory does not exist!", JOptionPane.WARNING_MESSAGE, JOptionPane.OK_OPTION, null, options, options[0]);
			JDialog dialog = pane.createDialog(null, "Warning");
			new DialogEarthquakeCenter(dialog);
		}
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public DomParserForRecentWorkspace getDomParserForRecentWorkspace() {
		return domParserForRecentWorkspace;
	}
	public void setDomParserForRecentWorkspace(DomParserForRecentWorkspace domParserForRecentWorkspace) {
		this.domParserForRecentWorkspace = domParserForRecentWorkspace;
	}

}
