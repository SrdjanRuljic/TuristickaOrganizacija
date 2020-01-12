/***********************************************************************
 * Module:  TextToolbarController.java
 * Author:  Ivana
 * Purpose: Defines the Class TextToolbarController
 ***********************************************************************/

package controller;

import view.TextToolbar;
import applicationModel.TextToolbarModel;

import main.MainClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextToolbarController {
	
   private TextToolbar view;
   private TextToolbarModel model;

   public TextToolbarController(TextToolbarModel model, TextToolbar view) {
	   	this.model = model;
		this.view = view;
		this.view.setActionListener(al);
		this.view.setChangeListener(cl);
   }
   
   ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand())
			{
			case "CutText":
				model.cutText();
				MainClass.mf.gotoEdit();
				break;
			case "CopyText":
				model.copyText();
				MainClass.mf.gotoEdit();
				break;
			case "PasteText":
				model.pasteText();
				MainClass.mf.gotoEdit();
				break;
			case "TextBold":
				model.setTextBold();
				MainClass.mf.gotoEdit();
				break;
			case "TextItalic":
				model.setTextItalic();
				MainClass.mf.gotoEdit();
				break;
			case "TextUnderline":
				model.setTextUnderline();
				MainClass.mf.gotoEdit();
				break;
			case "TextColor":
				model.setTextColor();
				MainClass.mf.gotoEdit();
				break;
			case "TextBackground":
				model.setTextBackgroundColor();
				MainClass.mf.gotoEdit();
				break;
			case "TextAlignLeft":
				model.setTextAlignment("left");
				MainClass.mf.gotoEdit();
				break;
			case "Center":
				model.setTextAlignment("center");
				MainClass.mf.gotoEdit();
				break;
			case "Justify":
				model.setTextAlignment("justify");
				MainClass.mf.gotoEdit();
				break;
			case "TextAlignRight":
				model.setTextAlignment("right");
				MainClass.mf.gotoEdit();
				break;
			case "Find":
				model.findText();
				MainClass.mf.gotoEdit();
				break;
			case "Replace":
				model.replaceText();
				MainClass.mf.gotoEdit();
				break;
		   }
			MainClass.mf.statusBar.Update();
	   }
  };
  
  ChangeListener cl = new ChangeListener(){
	   @Override
	   public void stateChanged(ChangeEvent e) {
		   // TODO Auto-generated method stub
	   }
  };

}