package view.WorkArea;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.editPageArea.NewEmptySlotListener;
import viewer.editAndPreviewArea.EditPageArea;

public class PopupMenuEditorArea extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	
	JMenuItem emptySlotMenuItem;
	NewEmptySlotListener newEmptySlotListener;


	public PopupMenuEditorArea()
	{
		
		dodajKomponente();
		
		setVisible(true);
	}
	
	public void dodajKomponente()
	{
		emptySlotMenuItem = new JMenuItem("New empty slot", new ImageIcon("slike/PopupMenuEditorArea/emptySlot.png"));
		add(emptySlotMenuItem);
		newEmptySlotListener = new NewEmptySlotListener();
		emptySlotMenuItem.addMouseListener(newEmptySlotListener);
				
	}
	

	public JMenuItem getEmptySlotMenuItem() {
		return emptySlotMenuItem;
	}

	public void setEmptySlotMenuItem(JMenuItem emptySlotMenuItem) {
		this.emptySlotMenuItem = emptySlotMenuItem;
	}

	
	
}
