package viewer.editAndPreviewArea.slot;

import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;

import view.View;
import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.EditProjectArea;
import viewer.editAndPreviewArea.JScrollPaneForDocTab;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.ProjectsArea;
import viewer.element.ElementArea;

/**
 * Klasa ActiveSlot ima statièku metodu koja vraæa trenutno aktivni slot.
 * Potrebna je da se zna gdje prikazati novi objekat za sluèaj da je izabrana neka od opcija kreiranja novog Elementa.
 * @author ZoranaS
 *
 */
public class ActiveComponent
{
	static EditProjectArea editProjectArea;
	static DocumentsArea documentsArea;
	static PagesArea pagesArea;
	static EditPageArea editPageArea;
	static EditSlot editSlot;
	static ElementArea elementArea;
	static JScrollPaneForDocTab jScrollPaneForDocTab;
	static Iterator<EditSlot> iteratorEditSlot;
	/**
	 * Statièka metoda koja poziva statièke metode unutar ove klase u cilju pronalaženja aktivnog slota u aplikaciji.
	 * @return vraæa slot koji je trnutno u fokusu(aktivan), odnosno na koji je izvršena akcija klik miša i prikaz popup menija 
	 * @author ZoranaS
	 */
	public static EditSlot findActiveSlot()
	{
		editProjectArea = findActiveEditProjectArea(); //ovo je dobro; fino vraæa
		
		documentsArea = editProjectArea.getDocumentsArea(); //ovo je isto dobro; fino vraæa odreðenu DocumentsArea
		
		
		jScrollPaneForDocTab = (JScrollPaneForDocTab) documentsArea.getSelectedComponent();
		jScrollPaneForDocTab.getPagesArea().getListOfEditPageArea().iterator();
		return editSlot;
	 }
	
	/**
	 * Metoda kojom se vraæa trenutno selektovani {@link EditProjectArea}
	 * unutar liste koja postoji u klasi {@link ProjectsArea}
	 * @return vraæa se trenutno selektovani {@link EditProjectArea}
	 * @author ZoranaA
	 */
	//RADI KAKO TREBA
	public static EditProjectArea findActiveEditProjectArea()
	{
		Iterator<EditProjectArea> iterator = View.getMainWindow().getProjectsArea().createIterator();
		while(iterator.hasNext())
		{	
			editProjectArea = iterator.next();
			if(editProjectArea.isSelected())
			{
				return editProjectArea;
			}
		}
		return null;	
	}

	public static EditPageArea findActiveEditPageArea()
	{
		editPageArea = PagesArea.getActiveEditPageArea();
		
		return editPageArea;
	}
}
