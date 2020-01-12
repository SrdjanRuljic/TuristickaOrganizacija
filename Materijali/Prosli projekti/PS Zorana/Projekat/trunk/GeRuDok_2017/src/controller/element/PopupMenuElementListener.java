package controller.element;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import viewer.element.ElementPopupMenu;

public class PopupMenuElementListener extends MouseAdapter
{
	ElementPopupMenu elementPopupMenu;

	public ElementPopupMenu getElementPopupMenu() {
		return elementPopupMenu;
	}

	public void setElementPopupMenu(ElementPopupMenu elementPopupMenu) {
		this.elementPopupMenu = elementPopupMenu;
	}
	
	public PopupMenuElementListener()
	{
		super();
	}
	
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
		// e.isPopupTrigger() ne radi ni na jedno dugme na misu 
		// pa sam morala koristiti SwingUtilities.isRightMouseButton(e)
		if(SwingUtilities.isRightMouseButton(e))
		{
			elementPopupMenu = new ElementPopupMenu();
			elementPopupMenu.show(e.getComponent(), e.getX(), e.getY());
			elementPopupMenu.setVisible(true);
		}
	}
}
