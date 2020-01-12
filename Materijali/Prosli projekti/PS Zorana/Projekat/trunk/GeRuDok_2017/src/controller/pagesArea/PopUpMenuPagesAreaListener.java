package controller.pagesArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.PopUpMenuPagesArea;

public class PopUpMenuPagesAreaListener extends MouseAdapter {

	PopUpMenuPagesArea popUpMenuPagesArea;
	PagesArea pagesArea;
	
	public void mousePressed(MouseEvent e)
	{
		pagesArea = (PagesArea) e.getSource();
		DocumentsArea.setActivePagesArea(pagesArea);;
		
		maybeShowPopup(e);
	}
	
	public void mouseRealeased(MouseEvent e)
	{
		pagesArea = (PagesArea) e.getSource();
		DocumentsArea.setActivePagesArea(pagesArea);;
		
		maybeShowPopup(e);
	}
	
	private void maybeShowPopup(MouseEvent e)
	{
		if(SwingUtilities.isRightMouseButton(e))
		{
			popUpMenuPagesArea = new PopUpMenuPagesArea();
			popUpMenuPagesArea.show(e.getComponent(), e.getX(), e.getY());
		}
	}

}
