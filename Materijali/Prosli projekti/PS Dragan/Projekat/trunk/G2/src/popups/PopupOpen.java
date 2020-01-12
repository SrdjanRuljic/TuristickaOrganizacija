package popups;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import localization.Localization;

public class PopupOpen extends JPopupMenu{

	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	public static JMenuItem mnuOpenProject;
	public static JMenuItem mnuOpenDocument;
	
	public PopupOpen() 
	{
		mnuOpenProject = new JMenuItem(local.getString("popup.project"));
		local.registerComponent("popup.project", mnuOpenProject);
		mnuOpenProject.setIcon(new ImageIcon("icons/project.png"));
		mnuOpenProject.setActionCommand("OpenProject");
		add(mnuOpenProject);
		
		addSeparator();
		
		mnuOpenDocument = new JMenuItem(local.getString("popup.document"));
		local.registerComponent("popup.document", mnuOpenDocument);
		mnuOpenDocument.setIcon(new ImageIcon("icons/document.png"));
		mnuOpenDocument.setActionCommand("OpenDocument");
		add(mnuOpenDocument);
		
		local.updateAll();
   }
}