package controller.pagesArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.DefaultMutableTreeNode;

import main.Main;
import model.Dokument;
import model.Projekat;
import model.Stranica;
import view.glavniProzor.MainWindow;
import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.EditProjectArea;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.slot.ActiveComponent;

public class NewPageListener implements ActionListener {

	PagesArea pagesArea;
	Stranica stranica;
	EditProjectArea editProjectArea;
	EditPageArea editPageArea;
	Dokument aktivniDokument;
	Projekat aktivniProjekat;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		pagesArea = DocumentsArea.getActivePagesArea();
		//kreiranje nove stranice
		stranica = new Stranica(pagesArea.getDokument().getBrojStranice());
		
		pagesArea.getDokument().setBrojStranice(pagesArea.getDokument().getBrojStranice()+1);
		//kreiranje novog prikaza stranice i postavljanje novokreirane stranice u prikaz
		editPageArea = new EditPageArea(stranica);
		editPageArea.setStranica(stranica);
				
		//dodavanje stranice u odgovarajuæi dokument i dodavanje prikaza u listu prikaza
		pagesArea.getListOfEditPageArea().add(editPageArea);
		pagesArea.getDokument().addStranice(stranica);
		
				
		//podešavanje velièine podloge za stranice
		pagesArea.setVisina(pagesArea.getListOfEditPageArea().size() * (pagesArea.getVisinaStranice()+20));
		//pagesArea.setSirina(pagesArea.getListOfEditPageArea().size() * pagesArea.getSirinaStranice());
		pagesArea.setPreferredSize(new Dimension(pagesArea.getSirina(), pagesArea.getVisina()));
		//da se kreira novi cvor u stablu i postavi na odgovarajuæe mjesto
		//dodajStranicuUStablo();
		pagesArea.podesiParametreStranice(editPageArea);		
		pagesArea.add(editPageArea);
	}
	

	public void dodajStranicuUStablo()
	{
		//prvo treba naæi projekat 
		editProjectArea = ActiveComponent.findActiveEditProjectArea();
		aktivniProjekat = editProjectArea.getProjekat();
		aktivniDokument = pagesArea.getDokument();
		
		MainWindow.getObjectBrowser().getStablo().dodajStranicaCvorUStablo(stranica, aktivniProjekat.getIme(), aktivniDokument.getImeDokumenta());
	}
}
