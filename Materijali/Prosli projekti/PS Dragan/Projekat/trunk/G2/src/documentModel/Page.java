/***********************************************************************
 * Module:  Page.java
 * Author:  Natasa
 * Purpose: Defines the Class Page
 ***********************************************************************/

package documentModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import applicationModel.CanvasModel;
import applicationModel.PageModel;
import applicationModel.URModel;
import controller.SlotController;
import dialogs.PageDialog;
import main.MainClass;
import xml.DocumentWriter;

public class Page extends JPanel{
		
	public Boolean addingSlots = false;
	public PageModel model;
	public int zoomFactor = 50;
	
	public URModel urmodel=null;
	
	public Color color = Color.white;
	public Dimension size = new Dimension(20000,20000);
	public int grid = 2;
	public Boolean gridVisible = true;

	   public int getZoomFactor() {
		   return zoomFactor;
	   }
	
	   public void setZoomFactor(int newZoomFactor) {
		   int i = newZoomFactor-zoomFactor;
		   zoomFactor = newZoomFactor;
		   for (SlotController s : model.getNizSlotova()) {
			   s.view.setZoomFactor(s.view.getZoomFactor()+i);
		   }
	   }

	   public Page(PageModel model) {
		   this.setFocusable(true);
		   this.requestFocusInWindow();
		   this.model = model;
		   setLayout(null);	
		   setOpaque(true);
		   new PageDialog(this);
		   
		   urmodel=new URModel();
	}
	   
	   public Page(PageModel model, int a) {
		   this.setFocusable(true);
		   this.requestFocusInWindow();
		   this.model = model;
		   setLayout(null);	
		   setOpaque(true);
		   
		   urmodel=new URModel();
	}

	   
	   public void addListeners(MouseListener ml, MouseMotionListener mml) {
		   this.addMouseListener(ml);
		   this.addMouseMotionListener(mml);
	   }
   
	   protected void paintComponent(Graphics g)
	   {
		   super.paintComponent(g);//poziva se roditeljska komponenta za iscrtavanje
		   Graphics2D gridline = (Graphics2D) g;

		   Dimension dim = new Dimension((int) size.getWidth()*10, (int) size.getHeight()*10);
		   dim.setSize(dim.getWidth()*zoomFactor/100, dim.getHeight()*zoomFactor/100);
		   this.setPreferredSize(dim);
		   this.setBackground(color);
		   if(gridVisible == true){
			   for (int i = 0; i < dim.getHeight(); i+=dim.getHeight()*grid/1000) {
				   Line2D line = new Line2D.Double(0,i,dim.getWidth(),i);
				   gridline.setColor(Color.lightGray);
				   gridline.draw(line);
			   }
	 		
			   for (int i = 0; i < dim.getWidth(); i+=dim.getHeight()*grid/1000) {
				   Line2D line = new Line2D.Double(i,0,i,dim.getHeight());
				   gridline.setColor(Color.lightGray);
				   gridline.draw(line);
			   }
		   }
		   for (int i = 0; i <= dim.getHeight(); i+=dim.getHeight()/10) {
			   Line2D line = new Line2D.Double(0,i,dim.getWidth(),i);
			   gridline.setColor(Color.black);
			   gridline.draw(line);
		   }
 		
		   for (int i = 0; i <= dim.getWidth(); i+=dim.getWidth()/10) {
			   Line2D line = new Line2D.Double(i,0,i,dim.getHeight());
			   gridline.setColor(Color.black);
			   gridline.draw(line);
		   }
		   this.repaint();
		   MainClass.mf.mainPanel.canvasModel.revalidateScroll();
	   }

	   public void Update() {
  			this.removeAll();
  			for (SlotController s : model.getNizSlotova()) {
  				s.view.setZoomFactor(this.zoomFactor);
  				if(s.view.selected == true){
  				   s.view.setBorder(BorderFactory.createDashedBorder(Color.blue));
  				   s.view.setDividerLocation(20*s.view.getHeight()/100);
  			   }
  			   else{
  				   s.view.setBorder(BorderFactory.createLineBorder(Color.black, 2));
  				   s.view.setDividerLocation(1*s.view.getHeight()/100);
  			   }
  				this.add(s.view);
  			}
  		}
}
