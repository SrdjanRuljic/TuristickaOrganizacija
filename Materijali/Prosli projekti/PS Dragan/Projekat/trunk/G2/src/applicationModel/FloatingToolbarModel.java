/***********************************************************************
 * Module:  FloatingToolbarModel.java
 * Author:  srdjan
 * Purpose: Defines the Class FloatingToolbarModel
 ***********************************************************************/

package applicationModel;

import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.SlotController;
import documentModel.Page;
import localization.Localization;
import main.MainClass;

/** @pdOid eb2d768a-a947-4ac3-9070-6b816be1301a */
public class FloatingToolbarModel {

	private static Localization local = Localization.getInstance();
	Page page;
	
	public void findPage(){
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
		}
		else page = null;
	}

	public void cutSlots(){
		findPage();
		page.model.cutSlot();
		page.Update();
	}
	public void SlotsUndo(){
		findPage();
		page.model.SlotUndo();
		page.Update();
	}
	public void SlotsRedo(){
		findPage();
		page.model.SlotRedo();
		page.Update();
	}
	public void copySlots(){
		findPage();
		page.model.copySlot();
		page.Update();
	}
	public void pasteSlots(){
		findPage();
		page.model.pasteSlot();
		page.Update();
	}
	public void pasteSlotsUndo(){
		findPage();
		page.model.pasteSlotUndo();
		page.Update();
	}

	public void pasteSlotsRedo(){
		findPage();
		page.model.pasteSlotRedo();
		page.Update();
	}

	public void selectAll(){
		findPage();
		page.model.selectAll();
		page.Update();
	}
	public void deleteSlots(){
		findPage();
		page.model.deleteSlot();
		page.Update();
	}
	
	public void addContent(){
		findPage();
		int m=0;
		for (SlotController sc : page.model.nizSlotova) {
			if(sc.view.selected)
				m++;
		}
		if(m==1){
			for (SlotController sc : page.model.nizSlotova) {
				if(sc.view.selected){
					m++;
			
					Object[] options1 = {local.getString("slot.text") , local.getString("slot.2Dgraphics")};
			
					int result = JOptionPane.showOptionDialog(null, local.getString("slot.message"), local.getString("slot.chooseElement"),
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
			
					if (result == JOptionPane.YES_OPTION)
					{
						sc.view.makeText();
				
					}
			
					else if(result == JOptionPane.NO_OPTION)
					{
						sc.view.make2D();
					}
			}
			page.Update();
		}
			
	}
}
}