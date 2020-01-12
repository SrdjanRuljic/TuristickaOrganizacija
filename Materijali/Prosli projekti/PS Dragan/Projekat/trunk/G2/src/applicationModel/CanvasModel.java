
package applicationModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controller.PageController;
import documentModel.Document;
import documentModel.Graphics2d;
import documentModel.Page;
import documentModel.Text;
import documentModel.Workspace;
import localization.Localization;
import main.MainClass;
import view.Canvas;
import view.CloseButton;
import view.MainFrame;
import xml.DocumentReader;
import xml.DocumentWriter;
import xml.WriterDOM;


public class CanvasModel
{
	public JTabbedPane kanvas = Canvas.kanvas; 
	private JScrollPane scroll;
	public ArrayList<Document> nizAktivnihDokumenata = new ArrayList<Document>();
	private static Localization local = Localization.getInstance();
	private Vector nizSlotova;
	
	//metoda za zatvaranje taba
	public void closeTab()
	{
		MainClass.mf.gotoCloseEditor();
		if(kanvas.getSelectedIndex()%2!=0 && kanvas.getSelectedIndex() != -1)
		{	
			kanvas.setSelectedIndex(kanvas.getSelectedIndex()-1);
			Object[] opcije = {local.getString("options.yes"), local.getString("options.no")};
		
		int retVal = JOptionPane.showOptionDialog(null, 
				local.getString("closeTab.message"), 
				local.getString("closeTab.title"), 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, opcije, opcije[1]);
		
		Document doc = nizAktivnihDokumenata.get(getSelectedNiz());
		
		if(retVal == JOptionPane.YES_OPTION)
		{	
			MainClass.mf.gotoSave();
			//ako se dokument snima prvi put
			if(MainClass.mf.mainPanel.projectBrowserModel.checkForName(doc.getDocumentName())==true)
			{
				doc.createDocument(doc.getDocumentName(), doc.getLocation());
			}
			
			//dokument se snimi i ukloni sa kanvasa
			doc.save();
			if(kanvas.getSelectedIndex()+1 != 1)
				nizAktivnihDokumenata.remove((kanvas.getSelectedIndex()+1)/2);
			else
				nizAktivnihDokumenata.remove(0);
			
			kanvas.remove(kanvas.getSelectedIndex()+1);
			kanvas.remove(kanvas.getSelectedIndex());
			if(kanvas.getTabCount()>0)
				kanvas.setSelectedIndex(0);
		}
		
		else if(retVal == JOptionPane.NO_OPTION)
		{
			File file = new File(doc.getLocation());
			//ako se novi dokument ne snimi treba ga obrisati iz stabla
			if(!file.exists())
			{
				MainClass.mf.mainPanel.projectBrowserModel.removeNodeByName(doc.getDocumentName());
				WriterDOM writer = new WriterDOM();
				writer.createContext(MainClass.mf.mainPanel.projectBrowser.tree);
			}
			
			//uklanjamo sa kanvasa
			if(kanvas.getSelectedIndex() != 0)
				nizAktivnihDokumenata.remove((kanvas.getSelectedIndex()+1)/2);
			else
				nizAktivnihDokumenata.remove(0);
			kanvas.remove(kanvas.getSelectedIndex()+1);
			kanvas.remove(kanvas.getSelectedIndex());
			if(kanvas.getTabCount()>0)
				kanvas.setSelectedIndex(0);
		}
		else if(retVal == JOptionPane.CANCEL_OPTION || retVal == JOptionPane.CLOSED_OPTION)
		{
			setFocus(); 
		}
			
		}
		MainClass.mf.gotoEdit();
	}
	
	//metoda koja snima sadrzaj taba bez zatvaranja
	public void saveTab()
	{	
		MainClass.mf.gotoSave();
		Object[] opcije = {local.getString("options.yes"), local.getString("options.no")};
		
		int retVal = JOptionPane.showOptionDialog(null, 
				local.getString("saveTab.message"), 
				local.getString("saveTab.title"), 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, opcije, opcije[1]);
		
		Document doc = nizAktivnihDokumenata.get(getSelectedNiz());
		
		if(retVal == JOptionPane.YES_OPTION)
		{
			MainClass.mf.gotoSave();
			//ako se dokument snima prvi put
			if(MainClass.mf.mainPanel.projectBrowserModel.checkForName(nizAktivnihDokumenata.get(getSelectedNiz()).getDocumentName())==true)
			{
				doc.createDocument(doc.getDocumentName(), doc.getLocation());
			}
			   
			doc.save();
		}
		MainClass.mf.gotoEdit();
	}	
	
	//metoda koja snima sve tabove i ne zatvara ih
	public void saveAllTabs()
	{		
		MainClass.mf.gotoSave();
		for (int i = 0; i < nizAktivnihDokumenata.size(); i++) {
			Document doc = nizAktivnihDokumenata.get(i);
			doc.save();
		}
		MainClass.mf.gotoEdit();
	}
	
	public void closeAllTabe()
	{		
		MainClass.mf.gotoCloseEditor();
		int m = kanvas.getTabCount();
		for (int i = 0; i < m; i+=2) {
			kanvas.setSelectedIndex(1);
			closeTab();
		}
		MainClass.mf.gotoIdle();
	}
	//metoda koja vraca fokus sa close button taba 
	public void setFocus()
	{		
			kanvas.setSelectedIndex(kanvas.getSelectedIndex()-1);
	}
	
	public void selectedTab(String title){
		int m=0;
		for(int i = 0; i<kanvas.getComponentCount(); i++)
		{			
			if(kanvas.getComponentAt(i).getName() == title)
			{
				kanvas.setSelectedIndex(i);
				m++;
			}
		}
	}
	
	//kada sa taba otvorimo dokument
	public void openNewTab(String title, String location){
		int m=0;
		for(int i = 0; i<kanvas.getComponentCount(); i++)
		{			
			if(kanvas.getComponentAt(i).getName() == title)
			{
				m++;
			}
		}
		if(m==0)
		{	
			scroll = new JScrollPane(citanjeNiza(location, title).getPage(),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setPreferredSize(new Dimension(100,100));
			kanvas.add(title,scroll);
			kanvas.getComponentAt(kanvas.getTabCount()-1).setName(title);	
			
			JButton btnClose = new CloseButton();
			btnClose.setBorder(null);
			btnClose.setBackground(Color.white);
			kanvas.add(btnClose);
			kanvas.setIconAt((kanvas.getTabCount()-1), new ImageIcon("Icons/CloseTabs.png"));
			kanvas.setSelectedIndex(kanvas.getTabCount()-2);
		}
		MainClass.mf.gotoEdit();
	}

	public void openNewDocument(Document doc){
			String location = MainClass.mf.mainPanel.projectBrowserModel.getNodeLocation(doc.getDocumentName());
			doc.setLocation(location);
			Page newPage = doc.getPage();
			nizAktivnihDokumenata.add(doc);
			newPage.setPreferredSize(new Dimension(2000,2000));
			scroll = new JScrollPane(newPage,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setPreferredSize(new Dimension(100,100));
			kanvas.add(doc.getDocumentName(),scroll);
			kanvas.getComponentAt(kanvas.getTabCount()-1).setName(doc.getDocumentName());		
			
			JButton btnClose = new CloseButton();
			btnClose.setBorder(null);
			btnClose.setBackground(Color.white);
			kanvas.add(btnClose);
			kanvas.setIconAt((kanvas.getTabCount()-1), new ImageIcon("Icons/CloseTabs.png"));
			kanvas.setSelectedIndex(kanvas.getTabCount()-2);
			MainClass.mf.gotoEdit();
	}

	
	//dodavanje dokumenta na stablo bez snimanja
	public void addTabToTree(String title){		
		TreePath currentSelection = MainClass.mf.mainPanel.projectBrowser.tree.getSelectionPath();
		if (currentSelection != null) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)(currentSelection.getLastPathComponent());
			MainClass.mf.mainPanel.projectBrowserModel.addObject(currentNode, title , true);
		}
		else{
			MainClass.mf.mainPanel.projectBrowserModel.addObject(null, title, true);
		}
		WriterDOM writer = new WriterDOM();
		writer.createContext(MainClass.mf.mainPanel.projectBrowser.tree);
		MainClass.mf.mainPanel.canvas.Update();
	}
	
	//metoda preracuna da li je scroll potreban ili ne
	public void revalidateScroll() {
		scroll.revalidate();
	}
	
	public int getSelectedNiz(){
		int index = kanvas.getSelectedIndex();
		
		if(index == 1)
		{
			index =0;
		}
		else if(index>1)
		{
			index = index/2;
		}
		return index;
	}
	
	
	public Vector getNizSlotova(String location)
	{//*******************************************************************
		
		//kreiramo fabriku bildera
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//kreiramo bilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//kreiramo dokument na osnovu parsera
			//Document document = builder.parse("AppContext/context.xml");
			org.w3c.dom.Document document = builder.parse(location);
			//kreirani dokument proslijedimo parseru
			DocumentReader parser = new DocumentReader(document);
			nizSlotova = parser.getNizSlotova();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		return nizSlotova;
	}
	public Document citanjeNiza(String location, String title)
	{
		Document doc = new Document(title, 1);	
		doc.setLocation(location);
		doc.setDocumentName(title);
		nizSlotova=getNizSlotova(location);
		
		for (int i = 0; i < nizSlotova.size(); i++) 
		{	
			Color pageColor = new Color(Integer.parseInt(nizSlotova.get(i).toString())); i++;
			int grid = Integer.parseInt(nizSlotova.get(i).toString()); i++;
			int pageHeight = Integer.parseInt(nizSlotova.get(i).toString()); i++;
			int pageWidth = Integer.parseInt(nizSlotova.get(i).toString());	i++;
			String gridVisible = nizSlotova.get(i).toString(); i++;
			Dimension pageSize = new Dimension(pageHeight, pageWidth);
			Boolean gridVisibleB = false;
			if(gridVisible.contains("true"))
				gridVisibleB = true;
			doc.getPage().grid = grid;
			doc.getPage().size = new Dimension(pageHeight, pageWidth);
			doc.getPage().color = pageColor;
			doc.getPage().gridVisible = gridVisibleB;
			
			for(; i<nizSlotova.size();)//Ulazimo u listu slotova
			{
				int slotX = Integer.parseInt(nizSlotova.get(i).toString());	i++;
				int slotY = Integer.parseInt(nizSlotova.get(i).toString());	i++;
				int slotHeight = Integer.parseInt(nizSlotova.get(i).toString()); i++;
				int slotWidth = Integer.parseInt(nizSlotova.get(i).toString());	i++;
				doc.getPage().model.setNewSlotPositionX(slotX);
				doc.getPage().model.setNewSlotPositionY(slotY);
				doc.getPage().model.setNewSlotHeight(slotHeight);
				doc.getPage().model.setNewSlotWidth(slotWidth);
				doc.getPage().addingSlots = true;
				doc.getPage().model.addSlot();
				doc.getPage().Update();
				String typeContent = nizSlotova.get(i).toString(); i++;
				
				if(typeContent.contains("1")) //Slot ima tekstualni sadrzaj
				{
					doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.makeText();
					
					Color textColor = new Color(Integer.parseInt(nizSlotova.get(i).toString())); i++;
					String font = nizSlotova.get(i).toString(); i++;
					int size = Integer.parseInt(nizSlotova.get(i).toString()); i++;
					int type = Integer.parseInt(nizSlotova.get(i).toString()); i++;
					Color textBackgroundColor = new Color(Integer.parseInt(nizSlotova.get(i).toString())); i++;
					String textContent = nizSlotova.get(i).toString(); i++;
					
					((Text) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).setTextComponent(textColor,font,size,type,textBackgroundColor,textContent);
				}
				else if (typeContent.contains("2")) //Slot ima 2d grafiku za sadrzaj
				{
					doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.make2D();
					
					int count = Integer.parseInt(nizSlotova.get(i).toString()); i++; //brojimo oblike
					for(int j=0; j< count; j++) //za svaki shape
					{
						int typeShape = Integer.parseInt(nizSlotova.get(i).toString()); i++;
						int height = Integer.parseInt(nizSlotova.get(i).toString()); i++;
						int width = Integer.parseInt(nizSlotova.get(i).toString()); i++;
						int x = Integer.parseInt(nizSlotova.get(i).toString()); i++;
						int y = Integer.parseInt(nizSlotova.get(i).toString()); i++;
						if(typeShape==1)
						{
							Shape dot = ((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).makeDot(x,y,height,width);
							((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).shapes.add(dot);
						}
						else if (typeShape==2)
						{
							Shape line = ((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).makeLine(x,y,height,width);
							((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).shapes.add(line);
						}
						else if (typeShape==3)
						{
							Shape rectangle = ((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).makeRectangle(x,y,height,width);
							((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).shapes.add(rectangle);
						}
						else if (typeShape==4)
						{
							Shape ellipse = ((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).makeOwal(x,y,height,width);
							((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).shapes.add(ellipse);
						}
						((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).points.add(new Point(x,y));
						((Graphics2d) doc.getPage().model.nizSlotova.get(doc.getPage().model.nizSlotova.size()-1).view.slotContent).points.add(new Point(height, width));
					}
				}
			}
		}
		nizAktivnihDokumenata.add(doc);
		return doc;
	}
}