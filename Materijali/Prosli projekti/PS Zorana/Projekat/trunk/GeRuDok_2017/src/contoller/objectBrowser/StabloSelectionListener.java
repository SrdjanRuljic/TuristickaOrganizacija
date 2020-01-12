package contoller.objectBrowser;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Projekat;

public class StabloSelectionListener implements TreeSelectionListener
{
	DefaultMutableTreeNode dmtn;
	JTree jTree;
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
		jTree = (JTree) e.getSource();
		dmtn = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
		
		
	}

}
