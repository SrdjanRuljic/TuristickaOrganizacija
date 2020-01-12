package controller.editPageArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.WorkArea.PopupMenuEditorArea;
import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.slot.ActiveComponent;
import viewer.editElement.PopupMenuEditElement;

public class PopUpMenuEditPageAreaListener extends MouseAdapter {

	PopupMenuEditorArea popupMenuEditorArea;
	EditPageArea editPageArea;
	
	public void mousePressed(MouseEvent e)
	{
		editPageArea = (EditPageArea) e.getSource();
		PagesArea.setActiveEditPageArea(editPageArea);
		
		maybeShowPopup(e);
	}
	
	public void mouseRealeased(MouseEvent e)
	{
		editPageArea = (EditPageArea) e.getSource();
		PagesArea.setActiveEditPageArea(editPageArea);
		
		maybeShowPopup(e);
	}
	
	private void maybeShowPopup(MouseEvent e)
	{
		if(SwingUtilities.isRightMouseButton(e))
		{
			popupMenuEditorArea = new PopupMenuEditorArea();
			popupMenuEditorArea.show(e.getComponent(), e.getX(), e.getY());
		}
	}

}
