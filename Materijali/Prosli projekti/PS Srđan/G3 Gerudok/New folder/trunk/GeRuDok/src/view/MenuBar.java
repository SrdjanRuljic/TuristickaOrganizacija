package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import model.ProjectModel;

public class MenuBar extends javax.swing.JMenuBar {
   private static final long serialVersionUID = 1L;
   
   JMenuItem menuNewProject = null;
   
   public MenuBar() {
   	Dimension dim = new Dimension(20, 35);
   	Dimension dimItem = new Dimension(220, 25);
   	Dimension dimMenu = new Dimension(40, 25);
   	setPreferredSize(dim);
   
   	JMenu menuFile = new JMenu("File");
   	menuFile.setForeground(Color.gray);
   	menuFile.setPreferredSize(dimMenu);
   	menuFile.setMnemonic(KeyEvent.VK_F);
   
   	add(menuFile);
   
   	JMenu newButton = new JMenu("New");
   
   	newButton.setPreferredSize(dimItem);
   	newButton.setIcon(new ImageIcon("icons/newFile.png"));
   	menuFile.add(newButton);
   
   	menuNewProject = new JMenuItem("Project");
   	menuNewProject.setPreferredSize(dimItem);
   	menuNewProject.setIcon(new ImageIcon("icons/newProjectIcon.png"));
   	menuNewProject.setMnemonic(KeyEvent.VK_N);
   	menuNewProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
   	menuNewProject.setActionCommand("NewProject");
   
   	JMenuItem menuNewWorkspace = new JMenuItem("Workspace");
   	menuNewWorkspace.setPreferredSize(dimItem);
   	menuNewWorkspace.setIcon(new ImageIcon("icons/newWorkspace.png"));
   	menuNewWorkspace.setMnemonic(KeyEvent.VK_W);
   	menuNewWorkspace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
   	menuNewWorkspace.setActionCommand("btnMenu");
   
   	JMenuItem menuNewDocument = new JMenuItem("Dokument");
   	menuNewDocument.setPreferredSize(dimItem);
   	menuNewDocument.setIcon(new ImageIcon("icons/newDocumentIcon.png"));
   	menuNewDocument.setMnemonic(KeyEvent.VK_D);
   	menuNewDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
   	menuNewDocument.setActionCommand("btnMenu");
   
   	JMenuItem menuOpen = new JMenuItem("Open");
   	menuOpen.setPreferredSize(dimItem);
   	menuOpen.setIcon(new ImageIcon("icons/openFileIcon.png"));
   	menuOpen.setMnemonic(KeyEvent.VK_O);
   	menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
   	menuOpen.setActionCommand("btnMenu");
   
   	JMenuItem menuSave = new JMenuItem("Save");
   	menuSave.setPreferredSize(dimItem);
   	menuSave.setIcon(new ImageIcon("icons/saveIcon.png"));
   	menuSave.setMnemonic(KeyEvent.VK_S);
   	menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
   	menuSave.setActionCommand("btnMenu");
   
   	JMenuItem menuSaveAs = new JMenuItem("Save As");
   	menuSaveAs.setPreferredSize(dimItem);
   	menuSaveAs.setIcon(new ImageIcon("icons/saveAsIcon.png"));
   	menuSaveAs.setActionCommand("btnMenu");
   
   	JMenuItem menuSaveAll = new JMenuItem("Save All");
   	menuSaveAll.setPreferredSize(dimItem);
   	menuSaveAll.setIcon(new ImageIcon("icons/saveAllIcon.png"));
   	menuSaveAll.setMnemonic(KeyEvent.VK_A);
   	menuSaveAll
   			.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
   	menuSaveAll.setActionCommand("btnMenu");
   
   	JMenuItem menuClose = new JMenuItem("Close");
   	menuClose.setPreferredSize(dimItem);
   	menuClose.setIcon(new ImageIcon("icons/closeIcon.png"));
   	menuClose.setMnemonic(KeyEvent.VK_C);
   	menuClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
   	menuClose.setActionCommand("btnMenu");
   
   	JMenuItem menuCloseAll = new JMenuItem("Close All");
   	menuCloseAll.setPreferredSize(dimItem);
   	menuCloseAll.setIcon(new ImageIcon("icons/closeAllIcon.png"));
   	menuCloseAll.setMnemonic(KeyEvent.VK_C);
   	menuCloseAll
   			.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
   	menuCloseAll.setActionCommand("btnMenu");
   
   	JMenuItem menuSharePage = new JMenuItem("Share Page");
   	menuSharePage.setPreferredSize(dimItem);
   	menuSharePage.setIcon(new ImageIcon("icons/sharePageIcon.png"));
   	menuSharePage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
   	menuSharePage.setActionCommand("btnMenu");
   
   	JMenuItem menuImport = new JMenuItem("Import");
   	menuImport.setPreferredSize(dimItem);
   	menuImport.setIcon(new ImageIcon("icons/importIcon.png"));
   	menuImport.setActionCommand("btnMenu");
   
   	JMenuItem menuExport = new JMenuItem("Export");
   	menuExport.setPreferredSize(dimItem);
   	menuExport.setIcon(new ImageIcon("icons/exportIocn.png"));
   	menuExport.setActionCommand("btnMenu");
   
   	JMenuItem menuExit = new JMenuItem("Exit");
   	menuExit.setPreferredSize(dimItem);
   	menuExit.setIcon(new ImageIcon("icons/exitIcon.png"));
   	menuExit.setMnemonic(KeyEvent.VK_E);
   	menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
   	menuExit.setActionCommand("btnExit");
   
   	newButton.add(menuNewProject);
   	newButton.add(menuNewWorkspace);
   	newButton.addSeparator();
   	newButton.add(menuNewDocument);
   	menuFile.add(menuOpen);
   	menuFile.addSeparator();
   	menuFile.add(menuSave);
   	menuFile.add(menuSaveAs);
   	menuFile.add(menuSaveAll);
   	menuFile.addSeparator();
   	menuFile.add(menuClose);
   	menuFile.add(menuCloseAll);
   	menuFile.addSeparator();
   	menuFile.add(menuSharePage);
   	menuFile.addSeparator();
   	menuFile.add(menuImport);
   	menuFile.add(menuExport);
   	menuFile.addSeparator();
   	menuFile.add(menuExit);
   
   	JMenu menuEdit = new JMenu("Edit");
   	menuEdit.setMnemonic(KeyEvent.VK_E);
   	menuEdit.setForeground(Color.gray);
   	menuEdit.setPreferredSize(dimMenu);
   
   	add(menuEdit);
   
   	JMenuItem editUndo = new JMenuItem("Undo");
   	editUndo.setPreferredSize(dimItem);
   	editUndo.setIcon(new ImageIcon("icons/undoIcon.png"));
   	editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
   	editUndo.setActionCommand("btnMenu");
   
   	JMenuItem editRedo = new JMenuItem("Redo");
   	editRedo.setPreferredSize(dimItem);
   	editRedo.setIcon(new ImageIcon("icons/redoIcon.png"));
   	editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
   	editRedo.setActionCommand("btnMenu");
   
   	JMenuItem editCut = new JMenuItem("Cut");
   	editCut.setPreferredSize(dimItem);
   	editCut.setIcon(new ImageIcon("icons/cutIcon.png"));
   	editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
   	editCut.setActionCommand("btnMenu");
   
   	JMenuItem editCopy = new JMenuItem("Copy");
   	editCopy.setPreferredSize(dimItem);
   	editCopy.setIcon(new ImageIcon("icons/copyIcon.png"));
   	editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
   	editCopy.setActionCommand("btnMenu");
   
   	JMenuItem editPaste = new JMenuItem("Paste");
   	editPaste.setPreferredSize(dimItem);
   	editPaste.setIcon(new ImageIcon("icons/pasteIcon.png"));
   	editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
   	editPaste.setActionCommand("btnMenu");
   
   	JMenuItem editDelete = new JMenuItem("Delete");
   	editDelete.setPreferredSize(dimItem);
   	editDelete.setIcon(new ImageIcon("icons/deleteIcon.png"));
   	editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
   	editDelete.setActionCommand("btnMenu");
   
   	JMenuItem editSelect = new JMenuItem("Select");
   	editSelect.setPreferredSize(dimItem);
   	editSelect.setIcon(new ImageIcon("icons/selectIcon.png"));
   	editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
   	editSelect.setActionCommand("btnMenu");
   
   	JMenuItem editFindReplace = new JMenuItem("Find/Replace");
   	editFindReplace.setPreferredSize(dimItem);
   	editFindReplace.setIcon(new ImageIcon("icons/findReplaceIcon.png"));
   	editFindReplace.setActionCommand("btnMenu");
   
   	menuEdit.add(editUndo);
   	menuEdit.add(editRedo);
   	menuEdit.addSeparator();
   	menuEdit.add(editCut);
   	menuEdit.add(editCopy);
   	menuEdit.add(editPaste);
   	menuEdit.addSeparator();
   	menuEdit.add(editFindReplace);
   	menuEdit.add(editSelect);
   	menuEdit.add(editDelete);
   
   	JMenu menuView = new JMenu("View");
   	menuView.setMnemonic(KeyEvent.VK_V);
   	menuView.setForeground(Color.gray);
   	menuView.setPreferredSize(dimMenu);
   	add(menuView);
   
   	JMenuItem viewZoomIn = new JMenuItem("Zoom In");
   	viewZoomIn.setPreferredSize(dimItem);
   	viewZoomIn.setIcon(new ImageIcon("icons/zoomInIcon.png"));
   	viewZoomIn.setActionCommand("btnMenu");
   
   	JMenuItem viewZoomOut = new JMenuItem("Zoom Out");
   	viewZoomOut.setPreferredSize(dimItem);
   	viewZoomOut.setIcon(new ImageIcon("icons/zoomOutIcon.png"));
   	viewZoomOut.setActionCommand("btnMenu");
   
   	menuView.add(viewZoomIn);
   	menuView.add(viewZoomOut);
   
   	JMenu menuHelp = new JMenu("Help");
   	menuHelp.setMnemonic(KeyEvent.VK_H);
   	menuHelp.setForeground(Color.gray);
   	menuHelp.setPreferredSize(dimMenu);
   
   	add(menuHelp);
   
   	JMenuItem helpHelp = new JMenuItem("Help Content");
   	helpHelp.setPreferredSize(dimItem);
   	helpHelp.setIcon(new ImageIcon("icons/helpIcon.png"));
   	editSelect.setActionCommand("btnMenu");
   
   	JMenuItem helpAbout = new JMenuItem("About GeRuDok");
   	helpAbout.setPreferredSize(dimItem);
   	helpAbout.setIcon(new ImageIcon("icons/aboutIcon.png"));
   	helpAbout.setActionCommand("btnMenu");
   
   	menuHelp.add(helpHelp);
   	menuHelp.add(helpAbout);
   }
   
   /** Klasa postavlja osluskivace na dugmice meni bara
    * 
    * 
    * @param al Osluskivac koji postavljamo */
   public void setListeners(ActionListener al) {
   	// Treba dodati preostale dugmice
   	menuNewProject.addActionListener(al);
   }

}