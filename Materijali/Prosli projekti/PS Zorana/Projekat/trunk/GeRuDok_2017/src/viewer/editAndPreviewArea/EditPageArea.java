package viewer.editAndPreviewArea;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import controller.editPageArea.PopUpMenuEditPageAreaListener;
import model.Slot;
import model.Stranica;
import viewer.editAndPreviewArea.slot.EditSlot;
import viewer.iteratorPattern.EditPageAreaIterator;

/**
 * Klasa predstavlja prikaz jedne stranice.
 * Naslijeðuje klasu JPanel.
 * @author ZoranaS
 *
 */
public class EditPageArea extends JPanel
{
	private static final long serialVersionUID = 1L;

	List<EditSlot> listOfEditSlot = new ArrayList<EditSlot>();
	PopUpMenuEditPageAreaListener popUpMenuEditPageAreaListener;
	private Stranica stranica;
	
	public List<EditSlot> getListOfEditSlot()
	{
		return listOfEditSlot;
	}

	public void setListOfEditSlot(List<EditSlot> listOfEditSlot)
	{
		this.listOfEditSlot = listOfEditSlot;
	}
	
	public Iterator<EditSlot> createIterator()
	{
		return new EditPageAreaIterator(listOfEditSlot);
	}
	
	public EditPageArea()
	{
		
	}

	public EditPageArea(Stranica stranica)
	{
		super();
		this.stranica = stranica;
		setLayout(null);
		
        popUpMenuEditPageAreaListener = new PopUpMenuEditPageAreaListener();
		addMouseListener(popUpMenuEditPageAreaListener);
		
	}
	
	private void dodavanjeSlotova(Stranica stranica)
	{
		Iterator<Slot> listaSlotova = stranica.getIteratorSlotovi();
		
		while(listaSlotova.hasNext())
		{
			Slot slot = listaSlotova.next();
			EditSlot editSlot = new EditSlot(slot);
			getListOfEditSlot().add(editSlot);
			add(editSlot);
		}
		
	}
	
	public PopUpMenuEditPageAreaListener getPopUpMenuEditPageAreaListener() {
		return popUpMenuEditPageAreaListener;
	}

	public void setPopUpMenuEditPageAreaListener(PopUpMenuEditPageAreaListener popUpMenuEditPageAreaListener) {
		this.popUpMenuEditPageAreaListener = popUpMenuEditPageAreaListener;
	}

	public Stranica getStranica()
	{
		return stranica;
	}

	public void setStranica(Stranica stranica)
	{
		this.stranica = stranica;
	}


}
