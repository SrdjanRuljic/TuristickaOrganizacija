/***********************************************************************
 * Module:  Graphics2dToolbarController.java
 * Author:  srdjan
 * Purpose: Defines the Class Graphics2dToolbarController
 ***********************************************************************/

package controller;

import view.Graphics2dToolbar;
import applicationModel.Graphics2dToolbarModel;
import documentModel.Graphics2d;
import localization.Localization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;


public class Graphics2dToolbarController 
{
   
   public Graphics2dToolbar view;   
   public Graphics2dToolbarModel model;
   private Localization local = Localization.getInstance();
   public Graphics2d graf;
   
   public Graphics2dToolbarController(Graphics2dToolbarModel model, Graphics2dToolbar view)
   {
	   this.model = model;
	   this.view = view;
	   this.view.setActionListener(al);
	  
   }
   
   ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand())
			{case "Dot":
			    graf.setType(1);			    
				break;
			case "Line":
				graf.setType(2);
				break;
			case "Circle":
				graf.setType(4);
				break;
			case "Triangle":
				JOptionPane.showMessageDialog(null, "Opcija je u izradi", "Izrada", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "Rectangle":
				graf.setType(3);
				break;
		}
		
	}
};



}