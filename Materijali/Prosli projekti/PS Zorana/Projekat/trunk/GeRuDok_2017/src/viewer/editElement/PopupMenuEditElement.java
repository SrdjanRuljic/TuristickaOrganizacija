package viewer.editElement;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenuEditElement extends JPopupMenu
{
	private static final long serialVersionUID = 1L;
	
	JMenuItem addElement;
	JMenuItem addTextElement;
	JMenuItem addGraphicsElement;
	
	public PopupMenuEditElement()
	{
		super();
		dodajKomponente();
		//setVisible(true);
	}
	
	public void dodajKomponente()
	{
		addElement = new JMenuItem("New element", new ImageIcon("slike/PopupMenuSlot/addElement2.png"));
		add(addElement);
		addTextElement = new JMenuItem("Add text", new ImageIcon("slike/PopupMenuSlot/addTextElement.png"));
		add(addTextElement);
		addGraphicsElement = new JMenuItem("Add picture", new ImageIcon("slike/PopupMenuSlot/addGraphicsElement.png"));
		add(addGraphicsElement);
	}
}
