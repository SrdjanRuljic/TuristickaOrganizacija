package view.objectBrowser;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import contoller.objectBrowser.StabloSelectionListener;
import contoller.objectBrowser.TreeListener;
import contoller.objectBrowser.objectBrowserListener;
import controller.chooseWorkspace.btnOKListener;
import controller.menuBar.NewProjectListener;
import model.Dokument;
import model.Elemenat;
import model.Projekat;
import model.Slot;
import model.Stranica;
import model.Workspace;
import view.glavniProzor.MainWindow;

public class Stablo extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	DefaultTreeModel stabloModel;
	DefaultMutableTreeNode mainNode;
	JTree stablo;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public Stablo() {
		super();
		if(Workspace.fajl != null)
		 {
			mainNode = new DefaultMutableTreeNode(btnOKListener.workspace.getIme()); 
		 }
		else
		{
			mainNode = new DefaultMutableTreeNode("Workspace");
		}
		dodavanjeProjekata();
		stabloModel =new DefaultTreeModel(mainNode);
		stabloModel.addTreeModelListener(new objectBrowserListener());
		stablo = new JTree(stabloModel);
		stablo.setEditable(true);
		stablo.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		stablo.setShowsRootHandles(true);
		stablo.addTreeSelectionListener(new StabloSelectionListener());
		setBackground(Color.WHITE);
		stablo.addMouseListener(new TreeListener());
		 
		add(stablo);
	
	}

	private void dodavanjeProjekata() {
		Iterator<Projekat> listaProjekata = Workspace.getInstance().getIteratorProjekti();
		DefaultMutableTreeNode[] projekti = new DefaultMutableTreeNode[Workspace.getProjekti().size()];
		int i=0;
		
		while(listaProjekata.hasNext())
		{
			
			Projekat projekat = listaProjekata.next();
			System.out.println(projekat.getIme());
			projekti[i]=new DefaultMutableTreeNode(projekat.getIme());
			mainNode.add(projekti[i]);
			dodavanjeDokumenta(projekat, projekti[i]);
			i++;
		}
		
	}
	

	public void dodavanjeDokumenta(Projekat projekat, DefaultMutableTreeNode node)
	{
		Iterator<Dokument> listaDokumenta = projekat.getIteratorDokumenti();
		
		DefaultMutableTreeNode[] dokumenti = new DefaultMutableTreeNode[projekat.getDokumenti().size()];
		
		int j=0;
		
		while(listaDokumenta.hasNext())
		{
			Dokument dokument = listaDokumenta.next();
			dokumenti[j] = new DefaultMutableTreeNode(dokument.getImeDokumenta());
			//dodavanjeStranica(dokument, dokumenti[j]);
			node.add(dokumenti[j]);
		}
	}
	
	public void dodavanjeStranica(Dokument dokument, DefaultMutableTreeNode node)
	{
		Iterator<Stranica> listaStranica = dokument.getIteratorStranice();
		
		DefaultMutableTreeNode[] stranice = new DefaultMutableTreeNode[dokument.getStranice().size()];
		
		int k=0;
		
		while(listaStranica.hasNext())
		{
			Stranica stranica = listaStranica.next();
			stranice[k] = new DefaultMutableTreeNode(stranica.getRedniBroj());
			//dodavanjeSlotova(stranica, stranice[k]);
			node.add(stranice[k]);
		}
	}
	
	public void dodavanjeSlotova(Stranica stranica, DefaultMutableTreeNode node)
	{
		Iterator<Slot> listaSlotova = stranica.getIteratorSlotovi();
		
		DefaultMutableTreeNode[] slotovi = new DefaultMutableTreeNode[stranica.getSlotovi().size()];
		
		int n=0;
		
		while(listaSlotova.hasNext())
		{
			Slot slot = listaSlotova.next();
			slotovi[n] = new DefaultMutableTreeNode(slot.getRedniBroj());
			dodajElemenat(slot, slotovi[n]);
			node.add(slotovi[n]);
		}
	}
	
	private void dodajElemenat(Slot slot, DefaultMutableTreeNode node) {
		
		DefaultMutableTreeNode nodeElemenat;
		Elemenat elemenat = slot.getElemenat();
		nodeElemenat = new DefaultMutableTreeNode("Elemenat");
		dodavanjeElemenata(elemenat, nodeElemenat);
		node.add(nodeElemenat);
	}

	private void dodavanjeElemenata(Elemenat elemenat, DefaultMutableTreeNode nodeElemenat)
	{
		Iterator<Elemenat> listaElemenata = elemenat.createIterator();
		
		DefaultMutableTreeNode[] elementi = new DefaultMutableTreeNode[elemenat.getListaElemenata().size()];
		
		int m=0;
		
		while(listaElemenata.hasNext())
		{
			Elemenat elemenat2 = listaElemenata.next();
			elementi[m] = new DefaultMutableTreeNode("Elemenat"+m);
			dodavanjeElemenata(elemenat2, elementi[m]);
			nodeElemenat.add(elementi[m]);
		}
		
	}
	
	
	public DefaultMutableTreeNode nadjiCvorSaImenom(DefaultMutableTreeNode parentNode, String ime)
	{
		for(int i=0; i < stabloModel.getChildCount(parentNode); i++)
		{
			if(ime.equals(stabloModel.getChild(parentNode, i).toString()))
			{
				return (DefaultMutableTreeNode) stabloModel.getChild(parentNode, i);
			}
		}
		return null;
		
	}
	
	public void dodajDokumentCvorUStablo(Dokument dokument, String aktivniProjekat)
	{
        DefaultMutableTreeNode parentNodeProject;
        
        parentNodeProject = nadjiCvorSaImenom(mainNode, aktivniProjekat);
        addObject(parentNodeProject, dokument.getImeDokumenta());
      
	}
	
	public void dodajStranicaCvorUStablo(Stranica stranica, String aktivniProjekat, String aktivniDokument)
	{
		DefaultMutableTreeNode grandParentNode = nadjiCvorSaImenom(mainNode, aktivniProjekat);
		if(grandParentNode != null)
		{
			
			DefaultMutableTreeNode parentNode = nadjiCvorSaImenom(grandParentNode, aktivniDokument);
			if(parentNode!= null)
			{
				addObject(parentNode, stranica);
			}
				
		}
	}
	
	
	/** Remove all nodes except the root node. */
    public void clear() 
    {
    	mainNode.removeAllChildren();
    	stabloModel.reload();
    }

    /** Remove the currently selected node. */
    public void removeCurrentNode() {
        TreePath currentSelection = stablo.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
            if (parent != null) {
            	stabloModel.removeNodeFromParent(currentNode);
                return;
            }
        } 

        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /** Add child to the currently selected node. */
    public DefaultMutableTreeNode addObject(Object child)
    {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = stablo.getSelectionPath();

        if (parentPath == null) {
            parentNode = mainNode;
        } else {
            parentNode = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    
    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child)
    {
        return addObject(parent, child, false);
    }

    
    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,  Object child,  boolean shouldBeVisible)
    {
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

        if (parent == null)
        {
            parent = mainNode;
        }
	
	//It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        stabloModel.insertNodeInto(childNode, parent, parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
        	stablo.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

	public DefaultTreeModel getStabloModel() {
		return stabloModel;
	}

	public void setStabloModel(DefaultTreeModel stabloModel) {
		this.stabloModel = stabloModel;
	}

	public DefaultMutableTreeNode getMainNode() {
		return mainNode;
	}

	public void setMainNode(DefaultMutableTreeNode mainNode) {
		this.mainNode = mainNode;
	}

	public JTree getStablo() {
		return stablo;
	}

	public void setStablo(JTree stablo) {
		this.stablo = stablo;
	}

	public Toolkit getToolkit() {
		return toolkit;
	}

	public void setToolkit(Toolkit toolkit) {
		this.toolkit = toolkit;
	}
}
