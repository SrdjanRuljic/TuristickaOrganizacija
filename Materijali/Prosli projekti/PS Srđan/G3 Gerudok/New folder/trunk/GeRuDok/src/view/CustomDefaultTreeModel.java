package view;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;



public class CustomDefaultTreeModel extends DefaultTreeModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDefaultTreeModel(TreeNode root)
	{
		super(root);
		DefaultMutableTreeNode masterNode_1 = new DefaultMutableTreeNode("Workspace1");
		DefaultMutableTreeNode masterNode_2 = new DefaultMutableTreeNode("Workspace2");

		insertNodeInto(masterNode_2, (MutableTreeNode) root, 0);
		insertNodeInto(masterNode_1, (MutableTreeNode) root, 0);

		DefaultMutableTreeNode project_1 = new DefaultMutableTreeNode("Project 1");
		DefaultMutableTreeNode project_2 = new DefaultMutableTreeNode("Project 2");

		DefaultMutableTreeNode document_1 = new DefaultMutableTreeNode("Document 1");
		DefaultMutableTreeNode document_2 = new DefaultMutableTreeNode("Document 2");

		insertNodeInto(document_2, (MutableTreeNode) project_1, 0);
		insertNodeInto(document_1, (MutableTreeNode) project_1, 0);

		document_1 = new DefaultMutableTreeNode("Document 1");
		document_2 = new DefaultMutableTreeNode("Document 2");

		insertNodeInto(document_2, (MutableTreeNode) project_2, 0);
		insertNodeInto(document_1, (MutableTreeNode) project_2, 0);

		insertNodeInto(project_2, (MutableTreeNode) masterNode_1, 0);
		insertNodeInto(project_1, (MutableTreeNode) masterNode_1, 0);

		project_1 = new DefaultMutableTreeNode("Project 1");
		project_2 = new DefaultMutableTreeNode("Project 2");

		document_1 = new DefaultMutableTreeNode("Document 1");
		document_2 = new DefaultMutableTreeNode("Document 2");

		insertNodeInto(document_2, (MutableTreeNode) project_1, 0);
		insertNodeInto(document_1, (MutableTreeNode) project_1, 0);

		insertNodeInto(project_2, (MutableTreeNode) masterNode_2, 0);
		insertNodeInto(project_1, (MutableTreeNode) masterNode_2, 0);

		document_1 = new DefaultMutableTreeNode("Document 1");
		document_2 = new DefaultMutableTreeNode("Document 2");

		insertNodeInto(document_2, (MutableTreeNode) project_2, 0);
		insertNodeInto(document_1, (MutableTreeNode) project_2, 0);

		insertNodeInto(project_2, (MutableTreeNode) masterNode_2, 0);
		insertNodeInto(project_1, (MutableTreeNode) masterNode_2, 0);

		project_1 = new DefaultMutableTreeNode("Project 1");
		project_2 = new DefaultMutableTreeNode("Project 2");

		document_1 = new DefaultMutableTreeNode("Document 2");
		document_2 = new DefaultMutableTreeNode("Document 2");

	}

}
