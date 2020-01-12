package view;

import java.lang.annotation.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import model.WorkspaceModel;

public class TreePanel extends javax.swing.JPanel implements javax.swing.event.TreeModelListener {
   private static final long serialVersionUID = 1L;
   
   /** @param model */
   public TreePanel(WorkspaceModel model) {
   	setLayout(new BorderLayout());
   
   	setPreferredSize(new Dimension(200, 0));
   	setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.ORANGE));
   	JPanel searchPanel = new JPanel();
   	searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
   	searchPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.ORANGE));
   	searchPanel.setMaximumSize(new Dimension(1000, 25));
   	searchPanel.setBackground(Color.LIGHT_GRAY);
   
   	JLabel searchLab = new JLabel("Search:");
   	searchLab.setForeground(Color.WHITE);
   	JTextField searchText = new JTextField();
   	searchText.setPreferredSize(new Dimension(100, 20));
   
   	JButton searchButton = new JButton(new ImageIcon("icons/searchIcon.png"));
   	searchButton.setPreferredSize(new Dimension(25, 25));
   
   	searchPanel.add(searchLab);
   	searchPanel.add(searchText);
   	searchPanel.add(searchButton);
   
   	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Workspace");
   	// poziv metode za formiranje hijerarhije stabla
   	JTree tree = new JTree(model.getTree(model, root));
   	DefaultTreeModel treeModel = new DefaultTreeModel(root);
   	treeModel.addTreeModelListener(this);
   
   	tree = new JTree(treeModel);
   
   	tree.setBackground(Color.lightGray);
   
   	tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
   
   	add(tree, BorderLayout.CENTER);
   
   	add(searchPanel, BorderLayout.NORTH);
   
   }
   
   /** @param arg0 */
   @Override
   public void treeNodesChanged(TreeModelEvent arg0) {
   	// TODO Auto-generated method stub
   
   }
   
   /** @param arg0 */
   @Override
   public void treeNodesInserted(TreeModelEvent arg0) {
   	// TODO Auto-generated method stub
   
   }
   
   /** @param arg0 */
   @Override
   public void treeNodesRemoved(TreeModelEvent arg0) {
   	// TODO Auto-generated method stub
   
   }
   
   /** @param arg0 */
   @Override
   public void treeStructureChanged(TreeModelEvent arg0) {
   	// TODO Auto-generated method stub
   
   }

}