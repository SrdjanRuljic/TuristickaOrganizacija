package view.objectBrowser;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import contoller.objectBrowser.AddPopupMenuListener;

public class TreeWorkspacePopupMenu extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	JMenuItem itemAdd;
	
	public TreeWorkspacePopupMenu()
	{
		super();
		itemAdd = new JMenuItem("Add project", new ImageIcon("slike/addProjectTree.png"));
		
		itemAdd.addActionListener(new AddPopupMenuListener());
		
		
		add(new JSeparator());
		add(itemAdd);
		
		
		
	}
}
