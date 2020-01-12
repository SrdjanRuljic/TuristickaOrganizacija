package viewer.editAndPreviewArea.slot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.slot.SlotMouseListener;
import controller.slot.SlotMouseMotionListener;
import controller.slot.SlotPopupMenuListener;
import model.Slot;
import viewer.element.ElementArea;


/**
 * Klasa predstavlja prikaz jednog slota.
 * Naslijeðuje klasu JPanel.
 * @author Darko
 *
 */

public class EditSlot extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private  boolean drag = false;
	private  Point dragLocation  = new Point();
	Slot slot;
	Border eBorder;
	private Boolean aktivan = false;
	SlotMouseListener slotMouseListener;
	SlotMouseMotionListener slotMouseMotionListener;
	SlotPopupMenuListener slotPopupMenuListener;
	Dimension pozicija;
	ElementArea elementArea;

	
	/**Konstruktor Slota
	 * Podesavanje dimenzija i bordura slota
	 * @author Darko
	 * @param slot 
	 *
	 */
	public EditSlot(Slot slot)
	{
		super();
		this.slot = slot;
		this.setPreferredSize(new Dimension(slot.getSirinaSlota(), slot.getVisinaSlota()));
		this.setBackground(new Color(230, 230, 250));
		
		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 eBorder = BorderFactory.createEtchedBorder();
		 this.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
		slot.setSirinaSlota(230);
		slot.setVisinaSlota(250);
		if(slot.getElemenat() != null)
        {
        	elementArea = new ElementArea(slot.getElemenat());
        	add(elementArea);
        }
        
        slotMouseListener = new SlotMouseListener(this);
        addMouseListener(slotMouseListener);
        
        slotMouseMotionListener = new SlotMouseMotionListener(this);
        addMouseMotionListener(slotMouseMotionListener);
       
       slotPopupMenuListener = new SlotPopupMenuListener();
       addMouseListener(slotPopupMenuListener);
        
       setVisible(true);
       
	}
	
	/*public EditSlot()
	{
		super();
		this.setPreferredSize(new Dimension(200, 200));
		this.setBackground(Color.WHITE);
		
		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		eBorder = BorderFactory.createEtchedBorder();
		this.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
		
        slotMouseListener = new SlotMouseListener(this);
        addMouseListener(slotMouseListener);
        
        slotMouseMotionListener = new SlotMouseMotionListener(this);
        addMouseMotionListener(slotMouseMotionListener);
       
       slotPopupMenuListener = new SlotPopupMenuListener();
       addMouseListener(slotPopupMenuListener);
        
       setVisible(true);
       
	}*/
	

	/*	public void iscrtavanjeElemenata()
	{
		ElementAreaIterator elementAreaIterator = null;
		while(elementAreaIterator.hasNext())
		{
			ElementArea elementArea = elementAreaIterator.next();
			elementArea.setVisible(true);
			add(elementArea);
		}
	}*/
	
	public boolean isDrag() {
		return drag;
	}

	public void setDrag(boolean drag) {
		this.drag = drag;
	}

	public Point getDragLocation() {
		return dragLocation;
	}

	public void setDragLocation(Point dragLocation) {
		this.dragLocation = dragLocation;
	}


	public SlotMouseListener getSlotMouseListener() {
		return slotMouseListener;
	}

	public void setSlotMouseListener(SlotMouseListener slotMouseListener) {
		this.slotMouseListener = slotMouseListener;
	}

	public SlotMouseMotionListener getSlotMouseMotionListener() {
		return slotMouseMotionListener;
	}

	public void setSlotMouseMotionListener(SlotMouseMotionListener slotMouseMotionListener) {
		this.slotMouseMotionListener = slotMouseMotionListener;
	}

	public SlotPopupMenuListener getSlotPopupMenuListener() {
		return slotPopupMenuListener;
	}

	public void setSlotPopupMenuListener(SlotPopupMenuListener slotPopupMenuListener) {
		this.slotPopupMenuListener = slotPopupMenuListener;
	}

	public ElementArea getElementArea() {
		return elementArea;
	}

	public void setElementArea(ElementArea elementArea) {
		this.elementArea = elementArea;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	

}
