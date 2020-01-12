/***********************************************************************
 * Module:  ProjectBrowserModel.java
 * Author:  Ivana
 * Purpose: Defines the Class ProjectBrowserModel
 ***********************************************************************/

package applicationModel;

import java.awt.Component;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import documentModel.Workspace;
import xml.ParserHandlerDOM;

public class ProjectBrowserModel {

	private Vector niz;
	private DefaultTreeModel treeModel;
	private JTree tree;
	private DefaultMutableTreeNode fileSystem;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public void setNiz(Vector niz) {
		this.niz = niz;
	}

	public Vector getNiz()
	{//*******************************************************************
		
		//kreiramo fabriku bildera
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//kreiramo bilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//kreiramo dokument na osnovu parsera
			//Document document = builder.parse("AppContext/context.xml");
			String location=Workspace.getLocation()+"\\context.xml";
			Document document = builder.parse(location);
			//kreirani dokument proslijedimo parseru
			ParserHandlerDOM parser = new ParserHandlerDOM(document);
			niz = parser.getNiz();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		return niz;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public JTree getTree() {        
    	niz = getNiz();
         
        fileSystem = new DefaultMutableTreeNode(niz.get(1));
        treeModel = new DefaultTreeModel(fileSystem);
        tree = new JTree(treeModel);
     
        tree.setCellRenderer(new MyTreeCellRenderer());
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
             
        tree.setVisibleRowCount(8);
     
        DefaultMutableTreeNode folder = null;
        DefaultMutableTreeNode emptyFolder = null;
        DefaultMutableTreeNode file = null;
         
        String name="";
        String type="";
        folder=fileSystem;
        for (int i = 0; i < niz.size(); i++) {
            if(niz.get(i)=="project")
            {
                i++;
                name=niz.get(i).toString();
                i++;
                type=niz.get(i).toString();
                if(type.contains("free"))
                {
                    emptyFolder = new DefaultMutableTreeNode(name);
                    fileSystem.add(emptyFolder);
                }
                else
                {
                    folder = new DefaultMutableTreeNode(name);
                    fileSystem.add(folder);
                }
            }
            else if (niz.get(i)=="document")
            {
                i++;
                name=niz.get(i).toString();
                i++;
                type=niz.get(i).toString();
                if(type.contains("free"))
                {
                    file = new DefaultMutableTreeNode(name);
                    fileSystem.add(file);
                }
                else
                {
                    file = new DefaultMutableTreeNode(name);
                    folder.add(file);
                }
            }
        }
		return tree;
	}

	//Metoda koja uklanja trenutno selektovani èvor iz projekta
	public void removeCurrentNode() {
		TreePath currentSelection = tree.getSelectionPath();
		if (currentSelection != null) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)(currentSelection.getLastPathComponent());
	        MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
	        if (parent != null) {
	        	treeModel.removeNodeFromParent(currentNode);
	        	return;
	        }
		} 
	        // Either there was no selection, or the root was selected.
	        toolkit.beep();
	        
	}
	
	public void removeNodeByName(String name) {
		Enumeration<DefaultMutableTreeNode> e = fileSystem.depthFirstEnumeration();
	    while (e.hasMoreElements()) {
	        DefaultMutableTreeNode node = e.nextElement();
	        MutableTreeNode parent = (MutableTreeNode)(node.getParent());
	        if (parent != null && node.toString().equals(name)) {
	        	treeModel.removeNodeFromParent(node);
	        }
	    }
	    
	    toolkit.beep();
	}
	

	public String getNodeLocation(String name) {
		String location = "";
		
		Enumeration<DefaultMutableTreeNode> e = fileSystem.depthFirstEnumeration();
	    while (e.hasMoreElements()) {
	        DefaultMutableTreeNode node = e.nextElement();
	        MutableTreeNode parent = (MutableTreeNode)(node.getParent());
	        if(node.toString().equals(name))
	        {
		        if (parent == fileSystem) {
		        	location = Workspace.getLocation() + "\\" + name;
		        }
		        else
		        	location = Workspace.getLocation() + "\\" + parent.toString() + "\\" + name;
		    }
	    }
	    
	    return location;
	}
	
	public void renameNode(String newName) {
		TreePath currentSelection = tree.getSelectionPath();
		if (currentSelection != null) {
			((MutableTreeNode) currentSelection).setUserObject(newName); 
   			((DefaultTreeModel) tree.getModel()).nodeChanged((TreeNode) currentSelection);
		} 
	    // Either there was no selection, or the root was selected.
	    toolkit.beep();
	    
	}
		
	/*
	 * Metoda za dodavanje elementa na stablo u neki roditeljski element
	 * Ako je roditeljski element null dodaje na root
	 * */	
	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		
		//u slucaju da nije selektovano nista ili je selektovan fajl
		if (parent == null || parent.toString().contains(".xml")) {
			parent = fileSystem;
		}
		
		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());
		
		if (shouldBeVisible) {
			tree.setSelectionPath(new TreePath(childNode.getPath()));
			tree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}

		return childNode;
	}
	
	//metoda provjerava da li dokument sa istim imenom vec postoji u vorkspejsu
		public boolean checkForName(String documentName) {
			
			niz = getNiz();
			
			int m=0;
			for (int i = 1; i < niz.size(); i+=3) {
				if(niz.get(i).equals(documentName)){
					m++;
				}
			}
			if(m==0)
				return true;
			else
				return false;
		}
		
	private static class MyTreeCellRenderer extends DefaultTreeCellRenderer {

	   @Override
	   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		   super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

	            if (value instanceof DefaultMutableTreeNode) {
	                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
	                if (node.getUserObject() instanceof String) {
	                	if(node.toString().contains(".xml"))
	                		setIcon(new ImageIcon("Icons/document2.png"));
	                	else
	                		setIcon(new ImageIcon("Icons/folder.png"));
	                } 
	            }

	            return this;
	        }
		}

}
