package view.menuBarView;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuHelp extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenuItem documentation;
	JMenuItem about;
	
	public JMenuItem getDocumentation() {
		return documentation;
	}
	public void setDocumentation(JMenuItem documentation) {
		this.documentation = documentation;
	}
	
	public JMenuItem getAbout() {
		return about;
	}
	public void setAbout(JMenuItem about) {
		this.about = about;
	}
	
	public MenuHelp()
	{
		setText("Help");
		setMnemonic('H');
		setBorder(BorderFactory.createEmptyBorder(0,5,5,8));
		dodajKomponente();
		setVisible(true);
	}
	
	public void dodajKomponente()
	{
		documentation = new JMenuItem("Documentation", new ImageIcon("slike/menuHelpIcons/documentation.png"));
		documentation.setActionCommand("documentation");
		add(documentation);
		
		about = new JMenuItem("About", new ImageIcon("slike/menuHelpIcons/about.png"));
		about.setActionCommand("about");
		add(about);
		
	}
}
