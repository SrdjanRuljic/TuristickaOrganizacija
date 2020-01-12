package controller.slot;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.EditProjectArea;
import viewer.editAndPreviewArea.JScrollPaneForDocTab;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.slot.ActiveComponent;
import viewer.editAndPreviewArea.slot.EditSlot;
import viewer.editAndPreviewArea.slot.SlotPopupMenu;

public class SlotPopupMenuListener extends MouseAdapter 
{
	SlotPopupMenu slotPopupMenu;

	public SlotPopupMenu getSlotPopupMenu() {
		return slotPopupMenu;
	}

	public void setSlotPopupMenu(SlotPopupMenu slotPopupMenu) {
		this.slotPopupMenu = slotPopupMenu;
	}

	public SlotPopupMenuListener()
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
			EditSlot editSlot = (EditSlot) e.getSource();
	    	PagesArea.activeEditSlot = editSlot;
	    	
			slotPopupMenu = new SlotPopupMenu();
			slotPopupMenu.show(e.getComponent(), e.getX(), e.getY());
			slotPopupMenu.setVisible(true);
		}
	}
	
}

