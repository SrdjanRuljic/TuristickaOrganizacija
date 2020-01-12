package viewer.editAndPreviewArea.slot;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.editElement.PopupMenuAddElementItemListener;
import controller.slot.PopupMenuAddDrawingElementListener;
import controller.slot.PopupMenuAddGrapchicsSlotListener;
import controller.slot.PopupMenuAddTextElementSlotListener;
import controller.slot.SlotPopupMenuListener;

public class SlotPopupMenu extends JPopupMenu{

	private static final long serialVersionUID = 1L;

	JMenuItem cutSlot;
	JMenuItem copySlot;
	JMenuItem pasteSlot;
	JMenuItem deleteSlot;
	JMenuItem addElement;
	JMenuItem addTextElement;
	JMenuItem addGraphicsElement;
	JMenuItem addDrawingElement;
	
	SlotPopupMenuListener slotPopupMenuListener;
	
	
	public JMenuItem getCutSlot() {
		return cutSlot;
	}
	public void setCutSlot(JMenuItem cutSlot) {
		this.cutSlot = cutSlot;
	}
	public JMenuItem getCopySlot() {
		return copySlot;
	}
	public void setCopySlot(JMenuItem copySlot) {
		this.copySlot = copySlot;
	}
	public JMenuItem getPasteSlot() {
		return pasteSlot;
	}
	public void setPasteSlot(JMenuItem pasteSlot) {
		this.pasteSlot = pasteSlot;
	}
	public JMenuItem getDeleteSlot() {
		return deleteSlot;
	}
	public void setDeleteSlot(JMenuItem deleteSlot) {
		this.deleteSlot = deleteSlot;
	}

	public JMenuItem getAddElement() {
		return addElement;
	}
	public void setAddElement(JMenuItem addElement) {
		this.addElement = addElement;
	}
	public JMenuItem getAddTextElement() {
		return addTextElement;
	}
	public void setAddTextElement(JMenuItem addTextElement) {
		this.addTextElement = addTextElement;
	}
	public JMenuItem getAddGraphicsElement() {
		return addGraphicsElement;
	}
	public void setAddGraphicsElement(JMenuItem addGraphicsElement) {
		this.addGraphicsElement = addGraphicsElement;
	}
	
	public SlotPopupMenu()
	{
		dodajKomponente();
		setVisible(true);
	}
	
	
	public void dodajKomponente()
	{
		/*cutSlot = new JMenuItem("Cut", new ImageIcon("slike/PopupMenuSlot/cut.png"));
		add(cutSlot);
		
		copySlot = new JMenuItem("Copy", new ImageIcon("slike/PopupMenuSlot/copy.png"));
		add(copySlot);
		pasteSlot = new JMenuItem("Paste", new ImageIcon("slike/PopupMenuSlot/paste.png"));
		add(pasteSlot);
		deleteSlot = new JMenuItem("Delete", new ImageIcon("slike/PopupMenuSlot/delete.png"));
		add(deleteSlot);
		addSeparator();
		
		addElement = new JMenuItem("New element", new ImageIcon("slike/PopupMenuSlot/addElement2.png"));
		add(addElement);*/
		
		addTextElement = new JMenuItem("Add text", new ImageIcon("slike/PopupMenuSlot/addTextElement.png"));
		addTextElement.addActionListener(new PopupMenuAddTextElementSlotListener());
		add(addTextElement);
		
		addGraphicsElement = new JMenuItem("Add picture", new ImageIcon("slike/PopupMenuSlot/addGraphicsElement.png"));
		addGraphicsElement.addActionListener(new PopupMenuAddGrapchicsSlotListener());
		add(addGraphicsElement);
		
		addDrawingElement = new JMenuItem("Add drawing", new ImageIcon("slike/Drawing.png"));
		addDrawingElement.addActionListener(new PopupMenuAddDrawingElementListener());
		add(addDrawingElement);
		
	}
}
