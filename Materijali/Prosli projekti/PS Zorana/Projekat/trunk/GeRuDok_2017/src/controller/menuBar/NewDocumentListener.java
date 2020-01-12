package controller.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Dokument;
import model.Projekat;
import model.Workspace;
import view.View;
import view.glavniProzor.MainWindow;
import view.objectBrowser.Stablo;
import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.EditProjectArea;
import viewer.editAndPreviewArea.JScrollPaneForDocTab;
import viewer.editAndPreviewArea.slot.ActiveComponent;
/**
 * Klasa implementira {@link ActionListener}. Na izbor odgovarajuæe opcije(New Document) otvara dijalog za unos imena dokumenta.
 * Dokument smiješa u stablo, u prikaz i u odgovarajuæu instancu {@link Dokument}.
 * @author ZoranaS
 *
 */
public class NewDocumentListener implements ActionListener {

	EditProjectArea editProjectArea;
	String aktivniProjekat;
	Projekat projekat;
	DefaultTreeModel stabloModel;
	Stablo stablo;
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(View.getMainWindow(), "Enter name of document: ");

	    if(name != null)
	    {
	    	Dokument dokument=new Dokument();
	    	dokument.setImeDokumenta(name);
	    
	    	editProjectArea = ActiveComponent.findActiveEditProjectArea(); //ovo je dobro; fino vraæa
	    	aktivniProjekat = editProjectArea.getTitle();
	    	
	    	stablo = MainWindow.getObjectBrowser().getStablo();
	    	stablo.dodajDokumentCvorUStablo(dokument, aktivniProjekat);
	    	
	    	dodajDokumentUPrikaz(dokument);
	    }
	}
	
	/**
	 * Metoda kojom se prvo pronalazi aktivna {@link EditProjectArea}, a zatim se u niz projekata upisuje novi projekat.
	 * @param dokument
	 */
	public void dodajDokumentUPrikaz(Dokument dokument)
	{
    	for (int i = 0; i < Workspace.getProjekti().size(); i++)
    	{
    		if( Workspace.getProjekti().get(i).getIme().equals(aktivniProjekat) )
    		{
    			Workspace.getProjekti().get(i).addDokumenti(dokument);
    		}
    	}
    	
    	editProjectArea.getDocumentsArea().dodajDokument(dokument);
    	JScrollPaneForDocTab jScrollPaneForDocTab = (JScrollPaneForDocTab) editProjectArea.getDocumentsArea().getSelectedComponent();
    	
    	DocumentsArea.setActivePagesArea(jScrollPaneForDocTab.getPagesArea());
    	
    	//EditPageArea editPageArea = new EditPageArea(stranica);

	}

}