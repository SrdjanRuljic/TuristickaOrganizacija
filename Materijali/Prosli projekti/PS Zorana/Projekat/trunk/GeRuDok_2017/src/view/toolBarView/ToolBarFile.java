package view.toolBarView;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.menuBar.ExitListener;
import controller.menuBar.NewDocumentListener;
import controller.menuBar.NewProjectListener;
import controller.menuBar.SaveListener;
import controller.menuBar.SwitchWorkspaceListener;

public class ToolBarFile extends JToolBar 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton newDocument;
	JButton newProject;
	JButton save;
	JButton close;
	JButton switchWorkspace;
	JButton importDocument;
	JButton importProject;
	JButton exit;

	public ToolBarFile()
	{
		setName("File");
		setRollover(true);
		dodajKomponente();
	}
	
	public void dodajKomponente()
	{
		newDocument = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/newDocument.png"));
		newDocument.setToolTipText("New Document");
		newDocument.addActionListener(new NewDocumentListener());
		add(newDocument);
		
		newProject = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/newProject.png"));
		newProject.setToolTipText("New Project");
		newProject.addActionListener(new NewProjectListener());
		add(newProject);
		addSeparator();
		
		save = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/save.png"));
		save.setToolTipText("Save");
		save.addActionListener(new SaveListener());
		add(save);
		addSeparator();
		
		close = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/close.png"));
		close.setToolTipText("Close");
		add(close);
		addSeparator();
		
		switchWorkspace = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/switchWorkspace.png"));
		switchWorkspace.setToolTipText("Switch Workspace");
		switchWorkspace.addActionListener(new SwitchWorkspaceListener());
		add(switchWorkspace);
		addSeparator();
		
		importDocument = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/importDocument.png"));
		importDocument.setToolTipText("Import Document");
		add(importDocument);
		
		importProject = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/importProject.png"));
		importProject.setToolTipText("Import Project");
		add(importProject);
		addSeparator();
		
		exit = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarFileIcons/exit.png"));
		exit.setToolTipText("Exit");
		exit.addActionListener(new ExitListener());
		add(exit);
	}

	public JButton getNewDocument() {
		return newDocument;
	}

	public void setNewDocument(JButton newDocument) {
		this.newDocument = newDocument;
	}

	public JButton getNewProject() {
		return newProject;
	}

	public void setNewProject(JButton newProject) {
		this.newProject = newProject;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getClose() {
		return close;
	}

	public void setClose(JButton close) {
		this.close = close;
	}

	public JButton getSwitchWorkspace() {
		return switchWorkspace;
	}

	public void setSwitchWorkspace(JButton switchWorkspace) {
		this.switchWorkspace = switchWorkspace;
	}

	public JButton getImportDocument() {
		return importDocument;
	}

	public void setImportDocument(JButton importDocument) {
		this.importDocument = importDocument;
	}

	public JButton getImportProject() {
		return importProject;
	}

	public void setImportProject(JButton importProject) {
		this.importProject = importProject;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	
}
