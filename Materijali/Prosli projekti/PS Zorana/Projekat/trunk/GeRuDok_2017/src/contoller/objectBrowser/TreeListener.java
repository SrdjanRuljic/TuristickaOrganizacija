package contoller.objectBrowser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import view.objectBrowser.TreeProjectPopupMenu;
import view.objectBrowser.TreeWorkspacePopupMenu;

public class TreeListener extends MouseAdapter
{
	TreeProjectPopupMenu treeProjectPopupMenu;
	TreeWorkspacePopupMenu treeWorkspacePopupMenu;
	public static DefaultMutableTreeNode dmtn;
	public static DefaultMutableTreeNode granddmtn = null;
	public static DefaultMutableTreeNode parentdmtn = null;
	JTree jTree;
	
	 public void mouseReleased (MouseEvent e)
	 {
		 jTree = (JTree) e.getSource();
		try
		{
			dmtn = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();
		}
		catch (NullPointerException ex) {
			
		}
			try
			{
				parentdmtn = (DefaultMutableTreeNode) dmtn.getParent();
			}
			catch(NullPointerException npe){}
			
			try
			{
				granddmtn = (DefaultMutableTreeNode) dmtn.getParent().getParent();
			}
			catch(NullPointerException npe){}
			
			
			if (e.isPopupTrigger())
			{
				if(parentdmtn != null && granddmtn == null )
				{
					treeProjectPopupMenu = new TreeProjectPopupMenu();
					treeProjectPopupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
				else if(parentdmtn == null && granddmtn == null)
				{
					treeWorkspacePopupMenu = new TreeWorkspacePopupMenu();
					treeWorkspacePopupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
				else if(granddmtn!= null) 	{}
			}
			
		
      }
	 
	 public void mouseClicked(MouseEvent e)
	 {
		 jTree = (JTree) e.getSource();
		 try
			{
				dmtn = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();
			}
			catch (NullPointerException ex) {
				
			}
			try
			{
				parentdmtn = (DefaultMutableTreeNode) dmtn.getParent();
			}
			catch(NullPointerException npe){}
			
			if (e.isPopupTrigger())
			{
				if(parentdmtn != null)
				{
					treeProjectPopupMenu = new TreeProjectPopupMenu();
					treeProjectPopupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
				else if(parentdmtn == null)
				{
					treeWorkspacePopupMenu = new TreeWorkspacePopupMenu();
					treeWorkspacePopupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
			
	      }
		 

}
