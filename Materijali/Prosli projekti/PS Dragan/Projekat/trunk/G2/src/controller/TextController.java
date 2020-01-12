/***********************************************************************
 * Module:  TextController.java
 * Author:  Ivana
 * Purpose: Defines the Class TextController
 ***********************************************************************/

package controller;

import applicationModel.TextModel;
import documentModel.Text;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextController {
   public TextModel textModel;
   public Text text;
   
   boolean textChanged;
   
   TextListener tl = new TextListener(){
		@Override
		public void textValueChanged(TextEvent event) {
			// TODO Auto-generated method stub
		}
	};

}