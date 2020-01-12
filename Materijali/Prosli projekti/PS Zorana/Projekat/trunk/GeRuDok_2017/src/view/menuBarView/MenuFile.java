package view.menuBarView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.menuBar.ExitListener;
import controller.menuBar.NewDocumentListener;
import controller.menuBar.NewProjectListener;
import controller.menuBar.SaveListener;
import controller.menuBar.SwitchWorkspaceListener;

public class MenuFile extends JMenu
{

	private static final long serialVersionUID = 1L;
	
	JMenuItem newDocument;
	JMenuItem newProject;
	JMenuItem save;
	JMenuItem close;
	JMenuItem switchWorkspace;
	JMenuItem importDocument;
	JMenuItem importProject;
	JMenuItem exit;

	public MenuFile()
	{
		setText("File");
		setMnemonic('F');
		//setBackground(Color.gray);
		setBorder(BorderFactory.createSoftBevelBorder(2, Color.gray, Color.red, Color.black, Color.green));
		//BorderFactory.createLineBorder(Color.gray, 2)
		dodajKomponente();
		setVisible(true);
		
	}
	
	public void dodajKomponente()
	{
		
		newDocument = new JMenuItem("New Document", new ImageIcon("slike/newDocument.png"));
		newDocument.setMnemonic(KeyEvent.VK_D);
		newDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		newDocument.setActionCommand("newDocument");
		newDocument.addActionListener(new NewDocumentListener());
		add(newDocument);
		
		newProject = new JMenuItem("New Project", new ImageIcon("slike/newProject.png"));
		newProject.setMnemonic(KeyEvent.VK_P);
		newProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		newProject.setActionCommand("newProject");
		newProject.addActionListener(new NewProjectListener());
		add(newProject);
		addSeparator();
		
		save = new JMenuItem("Save", new ImageIcon("slike/save.png"));
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.setActionCommand("save");
		save.addActionListener(new SaveListener());
		add(save);
		addSeparator();
		
		close = new JMenuItem("Close", new ImageIcon("slike/close.png"));
		close.setMnemonic(KeyEvent.VK_W);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		close.setActionCommand("close");
		add(close);
		addSeparator();
		
		
		switchWorkspace = new JMenuItem("Switch Workspace", new ImageIcon("slike/switchWorkspace.png"));
		switchWorkspace.setMnemonic(KeyEvent.VK_K);
		switchWorkspace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		switchWorkspace.setActionCommand("switchWorkspace");
		switchWorkspace.addActionListener(new SwitchWorkspaceListener());
		add(switchWorkspace);
		addSeparator();
		

		importProject = new JMenuItem("Import Project", new ImageIcon("slike/importProject.png"));
		importProject.setActionCommand("importProject");
		add(importProject);
		
		importDocument = new JMenuItem("Import Document", new ImageIcon("slike/importDocument.png"));
		importDocument.setActionCommand("importDocument");
		add(importDocument);
		addSeparator();
		
		exit = new JMenuItem("Exit", new ImageIcon("slike/exit.png"));
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		exit.addActionListener(new ExitListener());
		exit.setActionCommand("exit");
		add(exit);
	}
	
	public JMenuItem getNewDocument() {
		return newDocument;
	}
	
	public void setNewDocument(JMenuItem newDocument) {
		this.newDocument = newDocument;
	}
	
	public JMenuItem getNewProject() {
		return newProject;
	}
	
	public void setNewProject(JMenuItem newProject) {
		this.newProject = newProject;
	}
	
	public JMenuItem getSave() {
		return save;
	}
	
	public void setSave(JMenuItem save) {
		this.save = save;
	}
	
	public JMenuItem getClose() {
		return close;
	}
	
	public void setClose(JMenuItem close) {
		this.close = close;
	}
	
	public JMenuItem getSwitchWorkspace() {
		return switchWorkspace;
	}
	
	public void setSwitchWorkspace(JMenuItem switchWorkspace) {
		this.switchWorkspace = switchWorkspace;
	}
	
	public JMenuItem getImportDocument() {
		return importDocument;
	}
	
	public void setImportDocument(JMenuItem importDocument) {
		this.importDocument = importDocument;
	}
	
	public JMenuItem getImportProject() {
		return importProject;
	}
	
	public void setImportProject(JMenuItem importProject) {
		this.importProject = importProject;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}
	
}
