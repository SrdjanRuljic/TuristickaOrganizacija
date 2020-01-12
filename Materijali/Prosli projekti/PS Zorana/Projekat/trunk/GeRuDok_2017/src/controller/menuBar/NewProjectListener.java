package controller.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Projekat;
import model.Workspace;
import view.View;
import view.glavniProzor.MainWindow;

public class NewProjectListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
    
		//JOptionPane pane=new JOptionPane();
		//pane.setBackground(Color.BLUE);
		
		String name = JOptionPane.showInputDialog(View.getMainWindow(), "Enter name of project: ");
		
	    if(name != null)
	    {
	    	Projekat projekat=new Projekat();
	    	projekat.setIme(name);
	    
			Workspace.getProjekti().add(projekat);
	    
	    	DefaultMutableTreeNode dmtn = MainWindow.getObjectBrowser().getStablo().getMainNode(); 
	    	MainWindow.getObjectBrowser().getStablo().addObject(dmtn, projekat.getIme());
	    
	    	MainWindow.getProjectsArea().dodajProjekatUPrikaz(projekat); 
	    }
	    
	}

}
