/***********************************************************************
 * Module:  TextToolbarModel.java
 * Author:  Ivana
 * Purpose: Defines the Class TextToolbarModel
 ***********************************************************************/

package applicationModel;

import controller.SlotController;
import documentModel.Document;
import documentModel.Text;
import main.MainClass;

public class TextToolbarModel {
	
	public void getNiz(){
		
	}
	
	public void cutText() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).textPane.cut();
		}
	}

	public void copyText() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).textPane.copy();
		}
	}

	public void pasteText() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).textPane.paste();
		}
	}
	
	public void setTextBold() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).SetTextBold();
		}
	}
	
	public void setTextItalic() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).SetTextItalic();
		}
	}
	
	public void setTextUnderline() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).SetTextUnderline();
		}
	}

	public void setTextColor() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).SetTextColor();
		}
	}

	public void setTextBackgroundColor() {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).SetTextBackgroundColor();
		}
	}

	public void setTextAlignment(String alignment) {
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).SetTextAlignment(alignment);;
		}
	}
	
	public void findText(){
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).Find();
		}
	}
	
	public void replaceText(){
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			((Text) s.view.slotContent).Replace();
		}
	}
}