/***********************************************************************
 * Module:  CanvasController.java
 * Author:  srdjan
 * Purpose: Defines the Class CanvasController
 ***********************************************************************/

package controller;

import applicationModel.CanvasModel;
import main.MainClass;
import view.Canvas;
import view.StatusBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;


public class CanvasController
{
	public  CanvasModel model;
	public  Canvas view; 
	
	public CanvasController(CanvasModel model, Canvas view)
	{
		this.model = model;
		this.view = view; 
		this.view.addListeners(ml);
	}
	
	MouseListener ml = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			model.closeTab();
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
}