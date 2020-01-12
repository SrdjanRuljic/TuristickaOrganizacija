package controller.editPageArea;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Slot;
import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.slot.EditSlot;

public class NewEmptySlotListener implements MouseListener {

	EditPageArea editPageArea;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Slot slot = new Slot();
		EditSlot editSlot = new EditSlot(slot);
		editSlot.setBounds(arg0.getX(), arg0.getY(), 200, 200);
		
		
		editPageArea.getStranica().addSlotovi(slot);
		editPageArea = PagesArea.getActiveEditPageArea();
		editPageArea.getListOfEditSlot().add(editSlot);
		editPageArea.add(editSlot);
		
		editPageArea.getStranica().getSlotovi().add(slot);
		editPageArea.revalidate();
		editPageArea.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Slot slot = new Slot();
		EditSlot editSlot = new EditSlot(slot);
		editSlot.setBounds(arg0.getX(), arg0.getY(), 200, 200);
		editPageArea = PagesArea.getActiveEditPageArea();
		editPageArea.add(editSlot);
		editPageArea.getListOfEditSlot().add(editSlot);
		editPageArea.getStranica().getSlotovi().add(slot);
		editPageArea.revalidate();
		editPageArea.repaint();
	}

}
