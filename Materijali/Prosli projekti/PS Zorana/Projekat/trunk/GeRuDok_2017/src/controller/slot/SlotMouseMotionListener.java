package controller.slot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import viewer.editAndPreviewArea.slot.EditSlot;

public class SlotMouseMotionListener implements MouseMotionListener
{
	protected EditSlot editSlot;
	
	public SlotMouseMotionListener(EditSlot editSlot)
	{
		this.editSlot = editSlot;
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		if (editSlot.isDrag())
		{
            if (editSlot.getDragLocation().getX()> editSlot.getWidth()-10 && editSlot.getDragLocation().getY()>editSlot.getHeight()-10)
            {
            	editSlot.setSize((int)(editSlot.getWidth()+(e.getPoint().getX()-editSlot.getDragLocation().getX())),
                        (int)(editSlot.getHeight()+(e.getPoint().getY()-editSlot.getDragLocation().getY())));
                editSlot.setDragLocation(e.getPoint());
                  }
            else
            {
            	e.translatePoint(e.getComponent().getLocation().x, e.getComponent().getLocation().y);
                editSlot.setLocation(e.getX(), e.getY());
               
            }
        }

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
