package controller.editElement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import viewer.editElement.PopupMenuEditElement;

public class PopupMenuEditElementListener extends MouseAdapter
{
	PopupMenuEditElement popupMenuEditElement;
	
	public void mousePressed(MouseEvent e)
	{
		maybeShowPopup(e);
	}
	
	public void mouseRealeased(MouseEvent e)
	{
		maybeShowPopup(e);
	}
	
	private void maybeShowPopup(MouseEvent e)
	{
		if(SwingUtilities.isRightMouseButton(e))
		{
			popupMenuEditElement = new PopupMenuEditElement();
			popupMenuEditElement.show(e.getComponent(), e.getX(), e.getY());
			popupMenuEditElement.setVisible(true);
		}
	}
}
