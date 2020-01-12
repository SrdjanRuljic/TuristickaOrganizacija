package controller.slot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import viewer.editAndPreviewArea.slot.EditSlot;

public class SlotMouseListener implements MouseListener
{

	protected EditSlot editSlot;
	
	public SlotMouseListener(EditSlot editSlot) 
	{
		this.editSlot = editSlot;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		editSlot.setDrag(true);
		editSlot.setDragLocation(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		editSlot.setDrag(false);
	}

}
