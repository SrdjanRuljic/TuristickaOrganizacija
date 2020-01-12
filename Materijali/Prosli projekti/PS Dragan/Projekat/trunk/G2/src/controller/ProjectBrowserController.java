/***********************************************************************
 * Module:  ProjectBrowserController.java
 * Author:  Ivana
 * Purpose: Defines the Class ProjectBrowserController
 ***********************************************************************/

package controller;

import view.ProjectBrowser;
import xml.WriterDOM;
import applicationModel.ProjectBrowserModel;
import documentModel.Workspace;
import localization.Localization;
import main.MainClass;
import applicationModel.CanvasModel;
import view.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectBrowserController {
	
   ProjectBrowserModel model;
   ProjectBrowser view;
   private static Localization local = Localization.getInstance();
	

   public ProjectBrowserController(ProjectBrowserModel model, ProjectBrowser view) {
	   	this.model = model;
		this.view = view;
		this.view.addListeners(tml,ml);
   }

   //Listener modela stabla koji omogucava izmene na stablu
   TreeModelListener tml = new TreeModelListener(){

		@Override
		public void treeNodesChanged(TreeModelEvent e) {
	        DefaultMutableTreeNode node;
	        node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());
	        
	        int index = e.getChildIndices()[0];
	        node = (DefaultMutableTreeNode)(node.getChildAt(index));
	        
		}

		@Override
		public void treeNodesInserted(TreeModelEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void treeNodesRemoved(TreeModelEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void treeStructureChanged(TreeModelEvent e) {
			// TODO Auto-generated method stub
			
		}
		   
	   };
	
	MouseListener ml = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) 
		{
			try
			{
				if(e.getClickCount() == 2) 
				{
					JTree tree = (JTree)e.getSource();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					String workspace = Workspace.getLocation();
					String location = workspace+"\\";
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) node.getParent();
					String parent = parentNode.toString();
					
					if(!parentNode.isRoot())
					{
						location+=parent+"\\";
					}
					String document=node.toString();
					location+=document;
					File file= new File(location);
					int m = 0;
					for(int i = 0; i<MainClass.mf.mainPanel.canvas.kanvas.getComponentCount(); i++)
					{			
						if(MainClass.mf.mainPanel.canvas.kanvas.getComponentAt(i).getName() == node.toString())
						{
							m++;
						}
					}

					if(file.exists() || m!=0)
					{
						
						if(node.toString().contains(".xml"))
						{
							MainClass.mf.mainPanel.canvasModel.openNewTab(node.toString(), location);
							MainClass.mf.mainPanel.canvasModel.selectedTab(node.toString());
							MainClass.mf.mainPanel.canvas.Update();
						}
					}
					else
					{
						if(node.toString().contains(".xml"))
						{
							JOptionPane.showMessageDialog(null, local.getString("projectBrowser.documetMessage") );
						}
						else
						{
							JOptionPane.showMessageDialog(null, local.getString("projectBrowser.projectMessage"));
						}
						MainClass.mf.mainPanel.projectBrowserModel.removeCurrentNode();
				        WriterDOM writer = new WriterDOM();
						writer.createContext(MainClass.mf.mainPanel.projectBrowser.tree);
					}
			 	}
			}
			catch(Exception ex)
			{
				
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
			
		};
}