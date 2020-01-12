package viewer.element;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import org.w3c.dom.Element;

import controller.element.PopupMenuElementListener;
import model.Elemenat;
import viewer.editAndPreviewArea.slot.EditSlot;

public class ElementArea extends JPanel {

	private static final long serialVersionUID = 1L;
    
	private List<ElementArea> listOfElementArea= new ArrayList<ElementArea>();
	private JTextPane text;

	PopupMenuElementListener popupMenuElementListener;
	Dimension dimenzije= new Dimension(400, 220);
	Point pozicija = new Point(50, 50);
	
	public ElementArea(Elemenat elemenat)
	{
		super();
		
		setBackground(Color.WHITE);
		setPreferredSize(dimenzije);
		setBounds((int)pozicija.getX(), (int)pozicija.getY(), (int)dimenzije.getWidth(), (int)dimenzije.getHeight());
		dodavanjeElemenata(elemenat, this);
		//setLocation ne radi
		//setLocation(new Point(20, 210));
		if(elemenat.getTekst() != null)
		{
			text = new JTextPane();
			text.setText(elemenat.getTekst());
			text.setPreferredSize(new Dimension(380, 150));
			text.setBackground(Color.YELLOW);
		add(text);
		}
		popupMenuElementListener = new PopupMenuElementListener();
		addMouseListener(popupMenuElementListener);
		
	}
	

	public void dodavanjeElemenata(Elemenat elemenat, ElementArea elementAreaParent) {
		
		Iterator<Elemenat> listaElemenata = elemenat.createIterator();
		
		while(listaElemenata.hasNext())
		{
			Elemenat elemenat2 = listaElemenata.next();
			ElementArea elementArea = new ElementArea(elemenat2);
			elementArea.setBackground(Color.WHITE);
			elementArea.setPreferredSize(new Dimension(50, 50));
			elementAreaParent.getListOfElementArea().add(elementArea);
			elementAreaParent.add(elementArea);
		}
		
	}


	public List<ElementArea> getListOfElementArea() {
		return listOfElementArea;
	}

	public void setListOfElementArea(List<ElementArea> listOfElementArea) {
		this.listOfElementArea = listOfElementArea;
	}

}
