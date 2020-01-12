package view.menuBarView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuView extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenuItem showFileToolbar;
	JMenuItem showEditToolbar;
	JMenuItem showViewToolbar;
	JMenuItem showOptionsToolbar;
	JMenuItem showHelpToolbar;
	JMenuItem showGridlines;
	JMenuItem zoomIn;
	JMenuItem zoomOut;
	
	public JMenuItem getShowFileToolbar() {
		return showFileToolbar;
	}
	public void setShowFileToolbar(JMenuItem showFileToolbar) {
		this.showFileToolbar = showFileToolbar;
	}
	
	public JMenuItem getShowViewToolbar() {
		return showViewToolbar;
	}
	public void setShowViewToolbar(JMenuItem showViewToolbar) {
		this.showViewToolbar = showViewToolbar;
	}
	
	public JMenuItem getShowOptionsToolbar() {
		return showOptionsToolbar;
	}
	public void setShowOptionsToolbar(JMenuItem showOptionsToolbar) {
		this.showOptionsToolbar = showOptionsToolbar;
	}
	
	public JMenuItem getShowHelpToolbar() {
		return showHelpToolbar;
	}
	public void setShowHelpToolbar(JMenuItem showHelpToolbar) {
		this.showHelpToolbar = showHelpToolbar;
	}
	
	public JMenuItem getShowGridlines() {
		return showGridlines;
	}
	public void setShowGridlines(JMenuItem showGridlines) {
		this.showGridlines = showGridlines;
	}
	
	public JMenuItem getZoomIn() {
		return zoomIn;
	}
	public void setZoomIn(JMenuItem zoomIn) {
		this.zoomIn = zoomIn;
	}
	
	public JMenuItem getZoomOut() {
		return zoomOut;
	}
	public void setZoomOut(JMenuItem zoomOut) {
		this.zoomOut = zoomOut;
	}
	
	public MenuView()
	{
		setText("View");
		setMnemonic('V');
		setBorder(BorderFactory.createEmptyBorder(0,5,5,8));
		dodajKomponente();
		setVisible(true);
	}
	
	
	public void dodajKomponente()
	{
		showFileToolbar = new JMenuItem("Show File Toolbar", new ImageIcon("slike/menuViewIcons/show.png"));
		showFileToolbar.setActionCommand("showFileToolbar");
		add(showFileToolbar);
		
		showEditToolbar = new JMenuItem("Show Edit Toolbar", new ImageIcon("slike/menuViewIcons/show.png"));
		showEditToolbar.setActionCommand("showEditToolbar");
		add(showEditToolbar);
		
		showViewToolbar = new JMenuItem("Show View Toolbar", new ImageIcon("slike/menuViewIcons/show.png"));
		showViewToolbar.setActionCommand("showViewToolbar");
		add(showViewToolbar);
		
		showOptionsToolbar = new JMenuItem("Show Options Toolbar", new ImageIcon("slike/menuViewIcons/show.png"));
		showOptionsToolbar.setActionCommand("showOptionsToolbar");
		add(showOptionsToolbar);
		
		showHelpToolbar = new JMenuItem("Show Help Toolbar", new ImageIcon("slike/menuViewIcons/show.png"));
		showHelpToolbar.setActionCommand("showHelpToolbar");
		add(showHelpToolbar);
		addSeparator();
		
		
		showGridlines = new JMenuItem("Show Gridlines", new ImageIcon("slike/menuViewIcons/gridlines.png"));
		showGridlines.setActionCommand("showGridlines");
		add(showGridlines);
		addSeparator();
		
		zoomIn = new JMenuItem("Zoom In", new ImageIcon("slike/menuViewIcons/zoomIn.png"));
		zoomIn.setMnemonic(KeyEvent.VK_PLUS);
		zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
		zoomIn.setActionCommand("zoomIn");
		add(zoomIn);

		zoomOut = new JMenuItem("Zoom In", new ImageIcon("slike/menuViewIcons/zoomOut.png"));
		zoomOut.setMnemonic(KeyEvent.VK_MINUS);
		zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
		zoomOut.setActionCommand("zoomOut");
		add(zoomOut);
		
		
	}
	
}
