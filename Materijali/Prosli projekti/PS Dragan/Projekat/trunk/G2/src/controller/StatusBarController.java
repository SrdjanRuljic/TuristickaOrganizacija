package controller;

import view.StatusBar;
import applicationModel.StatusBarModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StatusBarController {
   public StatusBar view;
   public StatusBarModel model;
   
	public StatusBarController(StatusBarModel model, StatusBar view){
		this.model = model;
		this.view = view;
		//dodamo listenere na dugmad, slider
		this.view.ZoomIn(al);
		this.view.ZoomOut(al);
		this.view.Slide(cl);
		view.Update();
	}
	
	ActionListener al = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getActionCommand())
			{
				case "ZoomIn":
					model.ZoomIncrement();
					break;
				case "ZoomOut":
					model.ZoomDecrement();
					break;
			}
			view.Update();
		}
	};
	
	ChangeListener cl = new ChangeListener(){

		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			JSlider slider = (JSlider) arg0.getSource();
			model.setZoomRatio(slider.getValue());
			view.Update();
		}		
	};	


}