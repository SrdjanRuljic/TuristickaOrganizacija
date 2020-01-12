package viewer.editAndPreviewArea;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.pagesArea.NewPageListener;
import controller.pagesArea.PagePropertiesListener;
import view.pageProperties.PageProperties;

public class PopUpMenuPagesArea extends JPopupMenu {
	
	private static final long serialVersionUID = 1L;

	JMenuItem newPage;
	JMenuItem pageProperties;
	public PopUpMenuPagesArea() {
	dodajKomponente();
	setVisible(true);
	}

	private void dodajKomponente() {
		newPage = new JMenuItem("New Page", new ImageIcon("slike/PopUpMenuPagesArea/new page.png"));
		newPage.addActionListener(new NewPageListener());
		add(newPage);
		
		pageProperties = new JMenuItem("Page Properties", new ImageIcon("slike/PopUpMenuPagesArea/properties.png"));
		pageProperties.addActionListener(new PagePropertiesListener());
		add(pageProperties);
	}
	
	
}
