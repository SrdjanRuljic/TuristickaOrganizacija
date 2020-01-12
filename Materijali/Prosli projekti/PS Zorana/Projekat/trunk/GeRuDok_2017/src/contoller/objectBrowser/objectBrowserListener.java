package contoller.objectBrowser;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class objectBrowserListener implements TreeModelListener 
{
	public objectBrowserListener() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void treeNodesChanged(TreeModelEvent e) {
		 DefaultMutableTreeNode node;
	     node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());

	        /*
	         * If the event lists children, then the changed
	         * node is the child of the node we have already
	         * gotten.  Otherwise, the changed node and the
	         * specified node are the same.
	         */
	      try 
	      {
	            int index = e.getChildIndices()[0];
	            node = (DefaultMutableTreeNode)(node.getChildAt(index));
	      } catch (NullPointerException exc) {}

	}

	@Override
	public void treeNodesInserted(TreeModelEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeNodesRemoved(TreeModelEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeStructureChanged(TreeModelEvent arg0) {
		// TODO Auto-generated method stub

	}

}
