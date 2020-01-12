package contoller.objectBrowser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Projekat;
import model.Workspace;
import view.View;
import view.glavniProzor.MainWindow;
import view.objectBrowser.Stablo;
import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.EditProjectArea;
import viewer.editAndPreviewArea.JScrollPaneForDocTab;
import viewer.editAndPreviewArea.slot.ActiveComponent;

public class AddPopupMenuListener implements ActionListener {

	EditProjectArea editProjectArea;
	String aktivniProjekat;
	Stablo stablo;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(TreeListener.dmtn.toString().equals(Workspace.getIme()) )
		{	
		//treba provjeritit da li se radi o cvoru koji predstavlja projekat
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
		else if(TreeListener.parentdmtn != null)
		{
			String name = JOptionPane.showInputDialog(View.getMainWindow(), "Enter name of document: ");

		    if(name != null)
		    {
		    	Dokument dokument=new Dokument();
		    	dokument.setImeDokumenta(name);
		    
		    	
		    	aktivniProjekat = TreeListener.dmtn.toString();
		    	for (Projekat projekat : Workspace.getProjekti())
		    	{
					if(projekat.getIme().equals(aktivniProjekat))
					{
						projekat.addDokumenti(dokument);
					}
				}
		    	
		    	stablo = MainWindow.getObjectBrowser().getStablo();
		    	stablo.dodajDokumentCvorUStablo(dokument, aktivniProjekat);
		    	
		    	dodajDokumentUPrikaz(dokument);
		    }
		}
			
	}
	
	public void dodajDokumentUPrikaz(Dokument dokument)
	{
		aktivniProjekat = TreeListener.dmtn.toString();
    	for (int i = 0; i < Workspace.getProjekti().size(); i++)
    	{
    		if( Workspace.getProjekti().get(i).getIme().equals(aktivniProjekat) )
    		{
    			Workspace.getProjekti().get(i).addDokumenti(dokument);
    		}
    	}
    	try
    	{
    		for (EditProjectArea editProjectArea : MainWindow.getProjectsArea().getListOfEditProjectArea()) {
				if(editProjectArea.getTitle().equals(aktivniProjekat))
				{
					editProjectArea.getDocumentsArea().dodajDokument(dokument);
			    	JScrollPaneForDocTab jScrollPaneForDocTab = (JScrollPaneForDocTab) editProjectArea.getDocumentsArea().getSelectedComponent();
			    	
			    	DocumentsArea.setActivePagesArea(jScrollPaneForDocTab.getPagesArea());
				}
			}
    	}
    	catch (NullPointerException e) {
			
		}
    	

	}

}
