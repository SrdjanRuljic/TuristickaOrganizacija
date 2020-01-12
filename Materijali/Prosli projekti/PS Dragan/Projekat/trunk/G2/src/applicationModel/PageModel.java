/***********************************************************************
 * Module:  PageModel.java
 * Author:  Natasa
 * Purpose: Defines the Class PageModel
 ***********************************************************************/

package applicationModel;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import controller.SlotController;
import documentModel.Document;
import documentModel.Graphics2d;
import documentModel.Slot;
import localization.Localization;
import main.MainClass;

public class PageModel {

	private static Localization local = Localization.getInstance();
	ArrayList<SlotController> nizSlotova = new ArrayList<SlotController>();
	static ArrayList<SlotController> kopiraniSlotovi = new ArrayList<SlotController>();

	int commandRedoNumber = 0;
	public int getCommandRedoNumber() {
		return commandRedoNumber;
	}

	public void setCommandRedoNumber(int commandRedoNumber) {
		if(commandRedoNumber >= 0 && commandRedoNumber<100)
			this.commandRedoNumber = commandRedoNumber;
		if(commandRedoNumber==0)
			MainClass.mf.mainPanel.toolbar.btnRedo.setEnabled(false);
		else
			MainClass.mf.mainPanel.toolbar.btnRedo.setEnabled(true);
	}

	public int getCommandUndoNumber() {
		return commandUndoNumber;
	}

	public void setCommandUndoNumber(int commandUndoNumber) {
		if(commandUndoNumber >= 0 && commandUndoNumber<100)
			this.commandUndoNumber = commandUndoNumber;
		if(commandUndoNumber==0)
			MainClass.mf.mainPanel.toolbar.btnUndo.setEnabled(false);
		else
			MainClass.mf.mainPanel.toolbar.btnUndo.setEnabled(true);
	}

	int commandUndoNumber = 0;
	int [] numberOfSlotsRedo = new int [100];
	int [] numberOfSlotsUndo = new int [100];
	ArrayList<SlotController> slotoviUndo = new ArrayList<SlotController>();	
	ArrayList<SlotController> slotoviRedo = new ArrayList<SlotController>();	
	
	public ArrayList<SlotController> getKopiraniSlotovi() {
		return kopiraniSlotovi;
	}

	public ArrayList<SlotController> getNizSlotova() {
		return nizSlotova;
	}

	int newSlotHeight;
	int newSlotWidth;
	int newSlotPositionX;
	int newSlotPositionY;
	
	public int getNewSlotPositionX() {
		return newSlotPositionX;
	}

	public void setNewSlotPositionX(int positionX) {
		this.newSlotPositionX = positionX;
	}

	public int getNewSlotPositionY() {
		return newSlotPositionY;
	}

	public void setNewSlotPositionY(int positionY) {
		this.newSlotPositionY = positionY;
	}

	public int getNewSlotHeight() {
		return newSlotHeight;
	}

	public void setNewSlotHeight(int height) {
		this.newSlotHeight = height;
	}

	public int getNewSlotWidth() {
		return newSlotWidth;
	}

	public void setNewSlotWidth(int width) {
		this.newSlotWidth = width;
	}

	public PageModel(){
		
	}
		
	public void addSlot() {
		SlotModel slotModel = new SlotModel();
		Slot s = new Slot(getNewSlotHeight(), getNewSlotWidth(),getNewSlotPositionX(), getNewSlotPositionY(), slotModel);
	    SlotController slotController = new SlotController(s, slotModel);
	    nizSlotova.add(slotController);
	}
		   
	public void deleteSlot(){
		numberOfSlotsUndo[commandUndoNumber] = 0;
		for (int i = nizSlotova.size()-1; i >= 0; i--){
		    if (nizSlotova.get(i).view.selected == true){
		    	slotoviUndo.add(nizSlotova.get(i));
				nizSlotova.remove(i);
			    numberOfSlotsUndo[commandUndoNumber]++; 
		    }
		 }
		setCommandUndoNumber(getCommandUndoNumber()+1);
	}
	   
	public void copySlot() {
		for (int i = nizSlotova.size()-1; i >= 0; i--){
		    if (nizSlotova.get(i).view.selected == true){
				kopiraniSlotovi.clear();
		    }
		 }
		for (int i = nizSlotova.size()-1; i >= 0; i--){
		    if (nizSlotova.get(i).view.selected == true){
		        kopiraniSlotovi.add(nizSlotova.get(i));
		    }
		 }
	}
	   
	public void pasteSlot() {
		numberOfSlotsUndo[commandUndoNumber] = 0;
		for (int i = kopiraniSlotovi.size()-1; i >= 0; i--) {
			SlotController sc = kopiraniSlotovi.get(i).copySlotController();
			sc.view.change();
			nizSlotova.add(sc);
			nizSlotova.get(nizSlotova.size()-1).view.change();
			slotoviUndo.add(sc);
			numberOfSlotsUndo[commandUndoNumber]++;
		}
		setCommandUndoNumber(getCommandUndoNumber()+1);
	}
	
	public void pasteSlotUndo() {
		numberOfSlotsRedo[commandRedoNumber]=0;
		setCommandUndoNumber(getCommandUndoNumber()-1);
		for (int i = 0; i < numberOfSlotsUndo[commandUndoNumber]; i++) {
			slotoviRedo.add(slotoviUndo.get(slotoviUndo.size()-1));
			nizSlotova.remove(slotoviUndo.get(slotoviUndo.size()-1));
			slotoviUndo.remove(slotoviUndo.size()-1);
			numberOfSlotsRedo[commandRedoNumber]++;
		}
		setCommandRedoNumber(getCommandRedoNumber()+1);
	}
	public void pasteSlotRedo() {
		numberOfSlotsUndo[commandUndoNumber]=0;
		setCommandRedoNumber(getCommandRedoNumber()-1);
		for (int i = 0; i < numberOfSlotsRedo[commandRedoNumber]; i++) {
			slotoviUndo.add(slotoviRedo.get(slotoviRedo.size()-1));
			nizSlotova.add(slotoviRedo.get(slotoviRedo.size()-1));
			slotoviRedo.remove(slotoviRedo.size()-1);
			numberOfSlotsUndo[commandUndoNumber]++;
		}
		setCommandUndoNumber(getCommandUndoNumber()+1);
	}
	public void cutSlot() {
		numberOfSlotsUndo[commandUndoNumber] = 0;
		kopiraniSlotovi.clear();
		for (int i = nizSlotova.size()-1; i >= 0; i--){
		    if (nizSlotova.get(i).view.selected == true){
		    	kopiraniSlotovi.add(nizSlotova.get(i));    
		    	slotoviUndo.add(nizSlotova.get(i));
				nizSlotova.remove(i);
			    numberOfSlotsUndo[commandUndoNumber]++; 
		    }
		 }	
		setCommandUndoNumber(getCommandUndoNumber()+1);
	}
	
	
	public void SlotUndo() {
		numberOfSlotsRedo[commandRedoNumber]=0;
		setCommandUndoNumber(getCommandUndoNumber()-1);
		for (int i = 0; i < numberOfSlotsUndo[commandUndoNumber]; i++) {
			slotoviRedo.add(slotoviUndo.get(slotoviUndo.size()-1));
			nizSlotova.add(slotoviUndo.get(slotoviUndo.size()-1));
			slotoviUndo.remove(slotoviUndo.size()-1);
			numberOfSlotsRedo[commandRedoNumber]++;
		}
		setCommandRedoNumber(getCommandRedoNumber()+1);
	}
	
	public void SlotRedo() {
		numberOfSlotsUndo[commandUndoNumber]=0;
		setCommandRedoNumber(getCommandRedoNumber()-1);
		for (int i = 0; i < numberOfSlotsRedo[commandRedoNumber]; i++) {
			slotoviUndo.add(slotoviRedo.get(slotoviRedo.size()-1));
			nizSlotova.remove(slotoviRedo.get(slotoviRedo.size()-1));
			slotoviRedo.remove(slotoviRedo.size()-1);
			numberOfSlotsUndo[commandUndoNumber]++;
		}
		setCommandUndoNumber(getCommandUndoNumber()+1);
	}
	
	public void selectAll(){
	   for (SlotController s : nizSlotova) {
		s.view.selected = true;
		s.view.setBorder(BorderFactory.createDashedBorder(Color.blue));
		s.view.setDividerLocation(20*s.view.getHeight()/100);
	}
   }

	public void deselectAll() {
		for (SlotController s : nizSlotova) {
			s.view.selected = false;
			s.view.setBorder(BorderFactory.createLineBorder(Color.black, 2));
			s.view.setDividerLocation(1*s.view.getHeight()/100);
		}
	}

	public void returnSelectedSlots(){
		String string = "";
		Slot s = null;
		int m=0;
		for (int i = nizSlotova.size()-1; i >= 0; i--){
		    if (nizSlotova.get(i).view.selected == true){
		    	s = nizSlotova.get(i).view;
		    	m++;
		    }
		 }
	    if(m>1){
	    	string = local.getString("slot.tooltip.group");
	    }
	    else if(m==1){
	    	string = s.getHeight()+" x "+s.getWidth();
	    }
	    MainClass.mf.statusBarModel.setCenterCell(string);
	    MainClass.mf.statusBar.Update();
	}
}
