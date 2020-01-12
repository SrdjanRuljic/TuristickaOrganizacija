package popups;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import localization.Localization;

public class PopupNew extends JPopupMenu {
	
	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	public static JMenuItem mnuNewProject;
	public static JMenuItem mnuNewDocument;
	
	public PopupNew()
	{
		mnuNewProject = new JMenuItem(local.getString("popup.newProject"));
		local.registerComponent("popup.newProject", mnuNewProject);
		mnuNewProject.setIcon(new ImageIcon("icons/project.png"));
		mnuNewProject.setActionCommand("NewProject");
		add(mnuNewProject);
		
		addSeparator();
		
		mnuNewDocument = new JMenuItem(local.getString("popup.newDocument"));
		local.registerComponent("popup.newDocument", mnuNewDocument);
		mnuNewDocument.setIcon(new ImageIcon("icons/document.png"));
		mnuNewDocument.setActionCommand("NewDocument");
		add(mnuNewDocument);
		
		local.updateAll();
	}
}
