package contoller.objectBrowser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Projekat;
import model.Workspace;
import view.View;
import view.glavniProzor.MainWindow;

public class OpenPopupMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(TreeListener.granddmtn == null ) //onda je u pitanju projekat
		 {
			for (Projekat projekat : Workspace.getProjekti())
			{
				if(projekat.getIme().equals(TreeListener.dmtn.toString()))
				{
					
					MainWindow.getProjectsArea().dodajProjekatUPrikaz(projekat);
				}
			}
		}
		
		
   	 
	    
	}
		
}


