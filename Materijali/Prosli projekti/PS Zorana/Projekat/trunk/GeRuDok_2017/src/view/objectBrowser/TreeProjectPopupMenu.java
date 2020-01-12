package view.objectBrowser;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTree;

import contoller.objectBrowser.AddPopupMenuListener;
import contoller.objectBrowser.DeletePopupMenuListener;
import contoller.objectBrowser.OpenPopupMenuListener;
import view.glavniProzor.MainWindow;

public class TreeProjectPopupMenu extends JPopupMenu
{
	private static final long serialVersionUID = 1L;
	JMenuItem itemDelete;
	JMenuItem itemAdd;
	JMenuItem itemOpen;
	
	public TreeProjectPopupMenu()
	{
		super();
		itemDelete = new JMenuItem("Delete");
		itemAdd = new JMenuItem("Add document", new ImageIcon("slike/addDocumentTree.png"));
		itemOpen=new JMenuItem("Open project", new ImageIcon("slike/openProjectTree.png"));
		
		itemDelete.addActionListener(new DeletePopupMenuListener());
		itemAdd.addActionListener(new AddPopupMenuListener());
		itemOpen.addActionListener(new OpenPopupMenuListener() );
		
		add(itemAdd);
		add(new JSeparator());
		add(itemOpen);
		add(new JSeparator());
		//add(itemDelete);
		
		
	}
	

}
