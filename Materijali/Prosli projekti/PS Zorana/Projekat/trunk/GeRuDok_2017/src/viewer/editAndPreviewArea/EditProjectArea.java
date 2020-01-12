package viewer.editAndPreviewArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Projekat;
import viewer.iteratorPattern.EditProjectAreaIterator;


/**
 * Klasa je prozor u kojem se prikazuju projekti.
 * Može postojati više instanci ove klase, odnosno može biti otvoreno više projekata istovremeno.
 * Klasa naslijeðuje JInternalFrame. 
 * @author ZoranaS
 *
 */
public class EditProjectArea extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private  boolean drag = false;
	private  Point dragLocation  = new Point();
	private static int pozicijaX=0;
	private static int pozicijaY=0;
	
	DocumentsArea documentsArea;
	Projekat projekat;
	
	public DocumentsArea getDocumentsArea() {
		return documentsArea;
	}

	public void setDocumentsArea(DocumentsArea documentsArea) {
		this.documentsArea = documentsArea;
	}

	public EditProjectArea(String imeProjekta, Projekat projekat) 
	{
		
		super(imeProjekta,
				true, //resizable
				true, //closable
				true, //maximizable
				true); //iconifiable
		setFrameIcon(new ImageIcon("slike/EditProjectArea/project.png"));
		setBounds(pozicijaX, pozicijaY, 700, 800);
		pozicijaX+=100;
		pozicijaY+=100;
		setBackground(new Color(240, 255, 240));
		this.projekat = projekat;
		documentsArea = new DocumentsArea(projekat);
		
		this.add(documentsArea);
		
	
		try 
		{
		     this.setSelected(true);
		} 
		catch (java.beans.PropertyVetoException e) {}
		setVisible(true);
    }

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}
	
}