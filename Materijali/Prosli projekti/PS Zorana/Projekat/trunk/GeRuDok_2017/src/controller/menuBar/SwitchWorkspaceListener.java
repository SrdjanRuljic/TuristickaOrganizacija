package controller.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

import model.Workspace;

public class SwitchWorkspaceListener implements ActionListener {

	JFileChooser fileChooser;
	File selectedFile; 
	Workspace workspace;
	
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

//	public File getSelectedFile() {
//		return selectedFile;
//	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Izbor Workspace");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		fileChooser.showOpenDialog(fileChooser);
		//vraca null ako nista nije selektovano
		
		selectedFile = fileChooser.getSelectedFile();
		
		if(selectedFile!=null)
		{
			workspace = new Workspace(selectedFile);
			
		}
	}

}
