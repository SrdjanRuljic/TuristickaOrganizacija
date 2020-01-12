package controller.element;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.editAndPreviewArea.slot.EditSlot;
import viewer.editElement.WindowEditElement;
import viewer.element.ElementArea;
import viewer.iteratorPattern.ElementAreaIterator;

/**
 * Klasa PopupMenuItemEditElementListener implementira {@link ActionListener}. Predstavlja osluškivaè kada se izabere opcija 
 * Edit iz popup menija koji se aktivira na {@link ElementArea}.
 * @author ZoranaS
 *
 */
public class PopupMenuItemEditElementListener implements ActionListener
{
	WindowEditElement windowEditElement;
	EditSlot editSlot;
	ElementAreaIterator elementAreaIterator;
	ElementArea elementArea, activeElementArea;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		/*editSlot = ActiveSlot.findActiveSlot();
		elementAreaIterator = new CompositeOfElementsIterator(editSlot.getCompositeOfElements().getListOfElements());
		while(elementAreaIterator.hasNext())
		{
			elementArea = compositeOfElementsIterator.next();
			if(elementArea.hasFocus())
			{	
				activeElementArea = elementArea;
				compositeOfElementsIterator.remove();
				editSlot.getCompositeOfElements().remove(elementArea);
				editSlot.revalidate();
				editSlot.repaint();
			
				
				
			}
		}
		//treba ovdje namjestiti da se moze pozivati ovaj donji red kao argument WindowEditElement
		//ovo za sada vraæa null Razlog:unknown
		//ActiveSlot.findActiveSlot().getElementArea();
	    windowEditElement = new WindowEditElement(activeElementArea, editSlot);
	   
		//pozivanje novog Prozora
*/	}
	
	

	
}
