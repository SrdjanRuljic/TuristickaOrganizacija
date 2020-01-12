/***********************************************************************
 * Module:  PageController.java
 * Author:  Natasa
 * Purpose: Defines the Class PageController
 ***********************************************************************/
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import applicationModel.PageModel;
import documentModel.Page;
import documentModel.Slot;
import main.MainClass;

public class PageController {

	int x;
	int y;
	int z;
	int w;
	
	private Page view;
	private PageModel model;
	
	public PageController(Page view, PageModel model){
		this.view = view;
		this.model = model;
		
		view.addListeners(ml, mml);
	}
	
	MouseListener ml = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			model.deselectAll();
			model.returnSelectedSlots();
			view.Update();
			MainClass.mf.statusBarModel.setCenterCell("");
			MainClass.mf.statusBar.Update();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) { 
			x=e.getX();
			 y=e.getY();
			 model.setNewSlotPositionX(x);
			 model.setNewSlotPositionY(y);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			z=e.getX();
			w=e.getY();
			model.setNewSlotHeight(w-y);
			model.setNewSlotWidth(z-x);
			if(view.addingSlots == true){
				model.addSlot();
				view.Update();
				view.addingSlots = false;
			}
			view.repaint();
		}
		
	};	 
	
	MouseMotionListener mml = new MouseMotionListener(){

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			String text = " x: " + e.getX() + " y: " + e.getY();
			MainClass.mf.statusBar.model.setEastCell(text);
			MainClass.mf.statusBar.Update();
		}
		
	};
}
