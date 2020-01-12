package viewer.editAndPreviewArea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTabbedPane;
import model.Dokument;
import model.Projekat;

/**
 * Klasa naslijeðuje JTabbedPane. Jedan tab predstavlja prikaz jednog dokumenta.
 * Za sve dokumente je zajednicka DocumentArea
 * @author Darko
 */

public class DocumentsArea extends JTabbedPane
{
	private static final long serialVersionUID = 1L;
	private List<JScrollPaneForDocTab> listOfJScrollPaneForDoc = new ArrayList<JScrollPaneForDocTab>();
	JScrollPaneForDocTab jScrollPaneForDocTab;
	private static PagesArea activePagesArea;
	
	public DocumentsArea(Projekat projekat)
	{
		super();
		//this.setPreferredSize(new Dimension(800, 1200));  // PODESENA VELICINA DOKUMENTA
		dodavanjeDokumenata(projekat);
		
	}
	

	private void dodavanjeDokumenata(Projekat projekat)
	{
		Iterator<Dokument> listaDokumenata = projekat.getIteratorDokumenti();
		
		while(listaDokumenata.hasNext())
		{
			Dokument dokument = listaDokumenata.next();
			jScrollPaneForDocTab = new JScrollPaneForDocTab(dokument);
			listOfJScrollPaneForDoc.add(jScrollPaneForDocTab);
			addTab(dokument.getImeDokumenta(), jScrollPaneForDocTab);
		}
	}
	
	public void dodajDokument(Dokument dokument)
	{
		
		jScrollPaneForDocTab = new JScrollPaneForDocTab(dokument);
		listOfJScrollPaneForDoc.add(jScrollPaneForDocTab);
		addTab(dokument.getImeDokumenta(), jScrollPaneForDocTab);
	}


	public List<JScrollPaneForDocTab> getListOfJScrollPaneForDoc() {
		return listOfJScrollPaneForDoc;
	}


	public void setListOfJScrollPaneForDoc(List<JScrollPaneForDocTab> listOfJScrollPaneForDoc) {
		this.listOfJScrollPaneForDoc = listOfJScrollPaneForDoc;
	}


	public JScrollPaneForDocTab getjScrollPaneForDocTab() {
		return jScrollPaneForDocTab;
	}


	public void setjScrollPaneForDocTab(JScrollPaneForDocTab jScrollPaneForDocTab) {
		this.jScrollPaneForDocTab = jScrollPaneForDocTab;
	}


	public static PagesArea getActivePagesArea() {
		return activePagesArea;
	}


	public static void setActivePagesArea(PagesArea activePagesArea) {
		DocumentsArea.activePagesArea = activePagesArea;
	}



}