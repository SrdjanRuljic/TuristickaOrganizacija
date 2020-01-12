/***********************************************************************
 * Module:  ProjectBrowser.java
 * Author:  Ivana
 * Purpose: Defines the Class ProjectBrowser
 ***********************************************************************/
 
package view;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import applicationModel.ProjectBrowserModel;
import localization.Localization;
 
 
public class ProjectBrowser extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
     
    ProjectBrowserModel model;
    
    //Elementi potrebni za dinamicke promjene na stablu
    protected DefaultTreeModel treeModel;
    public static JTree tree;
    DefaultMutableTreeNode fileSystem;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
     
    public static Vector niz;
     
    public ProjectBrowser(ProjectBrowserModel model) {
        this.model = model;
         
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
     
        Dimension d = this.getPreferredSize();
        d.width = 170;
        d.height = 20;
        setPreferredSize(d);
     
        JLabel label = new JLabel(local.getString("projectBrowser.title"));
		local.registerComponent("projectBrowser.title", label);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        label.setVerticalAlignment((int) CENTER_ALIGNMENT);
        label.setPreferredSize(new Dimension(d.width, 25));
        label.setOpaque(true);
        this.add(label, BorderLayout.NORTH);
 
        tree = model.getTree();
    
        //JScrollPane u koji se smjesta stablo
        JScrollPane scrollBox = new JScrollPane(tree);
        d = scrollBox.getPreferredSize();
        d.width = 160;
        d.height = 200;
        scrollBox.setPreferredSize(d);
        scrollBox.setForeground(Color.DARK_GRAY);
        this.add(scrollBox);
    }
    
    public void addListeners(TreeModelListener tml, MouseListener ml) {
    	tree.addMouseListener(ml);
    	model.getTreeModel().addTreeModelListener(tml);
    }
}