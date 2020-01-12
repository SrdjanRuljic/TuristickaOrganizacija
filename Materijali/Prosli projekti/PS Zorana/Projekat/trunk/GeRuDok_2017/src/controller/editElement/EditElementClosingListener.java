package controller.editElement;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Elemenat;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editElement.WindowEditElement;

public class EditElementClosingListener extends WindowAdapter 
{
	
	public void windowClosing(WindowEvent windowEvent)
	{
		Elemenat elemenat = new Elemenat();
		PagesArea.activeEditSlot.getSlot().setElemenat(elemenat);
		PagesArea.activeEditSlot.add(WindowEditElement.elementArea);
		PagesArea.activeEditSlot.getParent().revalidate();
		PagesArea.activeEditSlot.getParent().repaint();
		
	}
	
	
	
	
}
