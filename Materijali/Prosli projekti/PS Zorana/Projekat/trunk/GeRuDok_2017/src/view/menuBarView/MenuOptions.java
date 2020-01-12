package view.menuBarView;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

public class MenuOptions extends JMenu {

	private static final long serialVersionUID = 1L;
	
	JMenu jezik;
	//za submenu
	JCheckBoxMenuItem jezikEng;
	JCheckBoxMenuItem jezikSrpLat;
	JCheckBoxMenuItem jezikSrpCir;
	
	public JMenu getJezik() {
		return jezik;
	}
	public void setJezik(JMenu jezik) {
		this.jezik = jezik;
	}
	
	public JCheckBoxMenuItem getJezikEng() {
		return jezikEng;
	}
	public void setJezikEng(JCheckBoxMenuItem jezikEng) {
		this.jezikEng = jezikEng;
	}
	
	public JCheckBoxMenuItem getJezikSrpLat() {
		return jezikSrpLat;
	}
	public void setJezikSrpLat(JCheckBoxMenuItem jezikSrpLat) {
		this.jezikSrpLat = jezikSrpLat;
	}
	
	public JCheckBoxMenuItem getJezikSrpCir() {
		return jezikSrpCir;
	}
	public void setJezikSrpCir(JCheckBoxMenuItem jezikSrpCir) {
		this.jezikSrpCir = jezikSrpCir;
	}
	
	public MenuOptions()
	{
		setText("Options");
		setMnemonic('O');
		setBorder(BorderFactory.createEmptyBorder(0,5,5,8));
		dodajKomponente();
		setVisible(true);
	}
	
	public void dodajKomponente()
	{
		jezik = new JMenu("Language");
		jezik.setIcon(new ImageIcon("slike/menuOptionsIcons/jezik.png"));
		
		
		jezikEng = new JCheckBoxMenuItem("English");
		jezikEng.setIcon(new ImageIcon("slike/menuOptionsIcons/JezikEng.png"));
		jezikEng.setActionCommand("jezikEng");
		jezik.add(jezikEng);
		
		jezikSrpLat = new JCheckBoxMenuItem("Srpski");
		jezikSrpLat.setIcon(new ImageIcon("slike/menuOptionsIcons/JezikSrpLat.gif"));
		jezikSrpLat.setActionCommand("jezikSrpLat");
		jezik.add(jezikSrpLat);
		
		
		
		add(jezik);
	}
}
