package viewer.editAndPreviewArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.UIDefaults.ActiveValue;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import org.w3c.dom.Element;

import controller.pagesArea.PopUpMenuPagesAreaListener;
import model.Dokument;
import model.Stranica;
import view.View;
import view.glavniProzor.MainWindow;
import view.objectBrowser.Stablo;
import viewer.editAndPreviewArea.slot.ActiveComponent;
import viewer.editAndPreviewArea.slot.EditSlot;
import viewer.iteratorPattern.PagesAreaIterator;

/**
 * Klasa je prostor za prikaz stranica jednog dokumenta.
 * Naslijeðuje klasu JPanel.
 * @author ZoranaS
 *
 */
public class PagesArea extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int visinaStranice=1000;
	private int sirinaStranice=850;
	public Color bojaStranice= new Color(224, 238, 238); 
	public int pozicijaBroja=2; //1 za lijevo, 2 za centar i 3 za desno
	private int visina, sirina;
	private static EditPageArea activeEditPageArea;
	public static EditSlot activeEditSlot;
	public Dokument dokument;
	Stablo stablo;
	
	List<EditPageArea> listOfEditPageArea = new ArrayList<EditPageArea>();

	
	public List<EditPageArea> getListOfEditPageArea()
	{
		return listOfEditPageArea;
	}


	public void setListOfEditPageArea(List<EditPageArea> listOfEditPageArea)
	{
		this.listOfEditPageArea = listOfEditPageArea;
	}
	
	public Iterator<EditPageArea> createIterator()
	{
		return new PagesAreaIterator(listOfEditPageArea);
	}

	public PagesArea(Dokument dokument)
	{
		super();
		
		this.dokument = dokument;
		/*visinaStranice = dokument.getVisinaStranice();
		sirinaStranice = dokument.getSirinaStranice();*/
		
	    setBackground(new Color(240, 248, 255));
	    setPreferredSize(new Dimension(1100, 1600)); 
	    addMouseListener(new PopUpMenuPagesAreaListener());
	    
	    //dodavanjeStraniceUStablo();
	    //dodavanjeStranica(dokument);
	    
	    setVisible(true);
	
	}
	public void podesiParametreStranice(EditPageArea editPageArea)
	{
		editPageArea.setBackground(bojaStranice);
		editPageArea.setPreferredSize(new Dimension(sirinaStranice, visinaStranice));
		switch (pozicijaBroja) {
		case 1:
			pozicionirajLijevoBrStr();
			break;
		case 2:
			pozicioniranjecCentarBrStr();
			break;
		case 3:
			pozicioniranjeDesnoBrStr();
			break;
		
		}
		revalidate();
		repaint();
	}
	
	public void dodavanjeStraniceUStablo()
	{
		stablo = MainWindow.getObjectBrowser().getStablo();
		EditProjectArea editProjectArea = ActiveComponent.findActiveEditProjectArea(); //ovo je dobro; fino vraæa
		
		stablo.nadjiCvorSaImenom(stablo.getMainNode(), editProjectArea.getTitle());
		DocumentsArea documentsArea = editProjectArea.getDocumentsArea();
		
	}

	private void dodavanjeStranica(Dokument dokument) 
	{
		Iterator<Stranica> listaStranica = dokument.getIteratorStranice();
		visina= (dokument.getVisinaStranice())*dokument.getStranice().size();
		sirina= (dokument.getSirinaStranice());
		while(listaStranica.hasNext())
		{
			Stranica stranica = listaStranica.next();
			EditPageArea editPageArea = new EditPageArea(stranica);
			podesiParametreStranice(editPageArea);
			listOfEditPageArea.add(editPageArea);
			add(editPageArea, BorderLayout.CENTER);
			
		}
	}

	public void promijeniBojuStranica(Color background)
	{
		for (EditPageArea editPageArea : listOfEditPageArea)
		{
			editPageArea.setBackground(background);
		}
		revalidate();
		repaint();
	}
	
	public void promijeniVelicnuStranica(int width, int height)
	{
		 visina = listOfEditPageArea.size() * (height+20);
		//pagesArea.setSirina(pagesArea.getListOfEditPageArea().size() * pagesArea.getSirinaStranice());
		this.setPreferredSize(new Dimension(sirina, visina));
		for (EditPageArea editPageArea : listOfEditPageArea)
		{
			editPageArea.setPreferredSize(new Dimension(width, height));
		}
	}
	
	public void pozicioniranjeBrojaNaStr(String position)
	{
		switch (position)
		{
			case "Left": pozicionirajLijevoBrStr(); break;
			
			case "Right": pozicioniranjeDesnoBrStr(); break;

			case "Center": pozicioniranjecCentarBrStr(); break;
		}
	}

	private void pozicioniranjecCentarBrStr()
	{
		pozicijaBroja = 2;
		for (EditPageArea editPageArea : listOfEditPageArea)
		{
			String brStr = editPageArea.getStranica().getRedniBroj() + "";
			editPageArea.setBorder(BorderFactory.createTitledBorder(null, brStr, TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.BLACK));
		}
	}


	private void pozicioniranjeDesnoBrStr() 
	{
		pozicijaBroja = 3;
		for (EditPageArea editPageArea : listOfEditPageArea)
		{
			String brStr = editPageArea.getStranica().getRedniBroj() + "";
			editPageArea.setBorder(BorderFactory.createTitledBorder(null, brStr, TitledBorder.RIGHT, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.BLACK));
		}
	}


	private void pozicionirajLijevoBrStr() 
	{
		pozicijaBroja = 1;
		for (EditPageArea editPageArea : listOfEditPageArea)
		{
			String brStr = editPageArea.getStranica().getRedniBroj() + "";
			editPageArea.setBorder(BorderFactory.createTitledBorder(null, brStr, TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.BLACK));
		}
	}


	public int getSirina() {
		return sirina;
	}


	public void setSirina(int sirina) {
		this.sirina = sirina;
	}


	public static EditPageArea getActiveEditPageArea() {
		return activeEditPageArea;
	}


	public static void setActiveEditPageArea(EditPageArea activeEditPageArea) {
		PagesArea.activeEditPageArea = activeEditPageArea;
	}


	public int getVisina() {
		return visina;
	}


	public void setVisina(int visina) {
		this.visina = visina;
	}


	public Stablo getStablo() {
		return stablo;
	}


	public void setStablo(Stablo stablo) {
		this.stablo = stablo;
	}


	public int getVisinaStranice() {
		return visinaStranice;
	}


	public void setVisinaStranice(int visinaStranice) {
		this.visinaStranice = visinaStranice;
	}


	public int getSirinaStranice() {
		return sirinaStranice;
	}


	public void setSirinaStranice(int sirinaStranice) {
		this.sirinaStranice = sirinaStranice;
	}


	public Dokument getDokument() {
		return dokument;
	}


	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}


	public Color getBojaStranice() {
		return bojaStranice;
	}


	public void setBojaStranice(Color bojaStranice) {
		this.bojaStranice = bojaStranice;
	}


	public int getPozicijaBroja() {
		return pozicijaBroja;
	}


	public void setPozicijaBroja(int pozicijaBroja) {
		this.pozicijaBroja = pozicijaBroja;
	}
	
		

}
