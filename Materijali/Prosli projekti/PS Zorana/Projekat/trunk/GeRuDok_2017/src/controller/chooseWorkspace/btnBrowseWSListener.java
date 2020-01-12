package controller.chooseWorkspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import model.Workspace;
import view.chooseWorkspace.WindowForChooseWorkspace;

public class btnBrowseWSListener implements ActionListener{

	JFileChooser fileChooser;
	File selectedFile; 
	Workspace workspace;
	@Override
	public void actionPerformed(ActionEvent e) {
		fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Choose Workspace");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		fileChooser.showOpenDialog(fileChooser);
		//vraca null ako nista nije selektovano
		
		selectedFile = fileChooser.getSelectedFile();
		
		if(selectedFile!=null)
		{
			WindowForChooseWorkspace.getjComboBox().addItem(selectedFile.toString());
		}
		
	}

}
