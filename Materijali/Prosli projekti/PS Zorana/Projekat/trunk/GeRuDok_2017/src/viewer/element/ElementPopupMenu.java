package viewer.element;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.element.PopupMenuItemEditElementListener;

public class ElementPopupMenu extends JPopupMenu
{
	private static final long serialVersionUID = 1L;
	
	JMenuItem edit;
	
	PopupMenuItemEditElementListener popupMenuItemEditElementListener;
	
	public ElementPopupMenu()
	{
		super();
		dodajKomponente();
		
	}
	
	public void dodajKomponente()
	{
		System.out.println("Pop up");
		edit = new JMenuItem("Edit", new ImageIcon("slike/ElementPopupMenu/edit.png"));
		popupMenuItemEditElementListener = new PopupMenuItemEditElementListener();
		edit.addActionListener(popupMenuItemEditElementListener);
		add(edit);
		
		
	}
}
