/***********************************************************************
 * Module:  Slot.java
 * Author:  Natasa
 * Purpose: Defines the Class Slot
 ***********************************************************************/

package documentModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import applicationModel.Graphics2dToolbarModel;
import applicationModel.SlotModel;
import applicationModel.TextToolbarModel;
import controller.Graphics2dToolbarController;
import controller.TextToolbarController;
import localization.Localization;
import main.MainClass;
import view.Graphics2dToolbar;
import view.TextToolbar;

/** @pdOid f114a6f2-f083-4efd-be57-c3c3a588b37b */
public class Slot extends JSplitPane {
	private static Localization local = Localization.getInstance();
	
	//******************************* text ***************************
	TextToolbarModel textToolbarModel;
	TextToolbar textToolbar;
	TextToolbarController textToolbarController;

	Graphics2dToolbarModel graphics2dToolbarModel;
	Graphics2dToolbar graphics2dToolbar;
	Graphics2dToolbarController graphics2dToolbarController;

   public SlotModel model;
   public Boolean selected = false;
   private int firstCall = 0;

   private int height;
   private int width;
   private SlotContent dataType;
   private int positionX;
   private int positionY;
   private int realHeight;
   private int realWidth;
   private int realPositionX;
   private int realPositionY;
   
   public SlotContent slotContent;
   public int contentType;
   private int zoomFactor = 50;

   public Slot copySlot (){
	   Slot s = new Slot(this.height, this.width, this.positionX, this.positionY, this.model);
	   s.model = this.model;
	   s.selected = this.selected;
	   s.firstCall = this.firstCall;
	   s.height = this.height;
	   s.width = this.width;
	   s.dataType = this.dataType;
	   s.positionX = this.positionX;
	   s.positionY = this.positionY;
	   s.realHeight = this.realHeight;
	   s.realWidth = this.realWidth;
	   s.realPositionX = this.realPositionX+100;
	   s.realPositionY = this.realPositionY+100;
	   s.zoomFactor = this.zoomFactor;
	   s.contentType = this.contentType;
	   if(s.contentType == 1){
		   s.makeText();
		   Text t = (Text) this.slotContent;
		   ((Text) s.slotContent).setTextComponent(t.textPane.getForeground(), t.getTextFont(), t.getTextSize(), t.getTextType(), t.textPane.getBackground(), t.textPane.getText());
	   }
	   else if(s.contentType == 2){
		   s.make2D();
		   Graphics2d g = (Graphics2d) this.slotContent;
		   ((Graphics2d)s.slotContent).shapes = (ArrayList<Shape>) ((Graphics2d)this.slotContent).shapes.clone();
	   }  
	   return s;
	 }
   
   public int getRealPositionX() {
	   return realPositionX;
}

public void setRealPositionX(int realPositionX) {
	this.realPositionX = realPositionX;
}

public int getRealPositionY() {
	return realPositionY;
}

public void setRealPositionY(int realPositionY) {
	this.realPositionY = realPositionY;
}

public int getRealHeight() {
	return realHeight;
}

public void setRealHeight(int realHeight) {
	this.realHeight = realHeight;
}

public int getRealWidth() {
	return realWidth;
}

public void setRealWidth(int realWidth) {
	this.realWidth = realWidth;
}

   public int getZoomFactor() {
	   return zoomFactor;
	}
	
	public void setZoomFactor(int newZoomFactor) {
		zoomFactor = newZoomFactor;
		change();
	}
	
	   /** @pdOid 3f93d1b1-ac86-45e8-973e-0846f267222f */
	   public int getHeight() {
	      return height;
	   }
	   
	   /** @param newHeight
	    * @pdOid b57d3cf8-ad80-431b-8aed-445096454be3 */
	   public void setHeight(int newHeight) {
		   if(newHeight!=0 && newHeight>150)
			   height = newHeight;
		      else
		    	  height = 150;
	   }
	   
	   /** @pdOid 9aafd6a6-e033-44fa-bd04-8e41a6030dc5 */
	   public int getWidth() {
	      return width;
	   }
	   
	   /** @param newWidth
	    * @pdOid 70d9b210-6509-4ef5-9cec-efbe9bf9a746 */
	   public void setWidth(int newWidth) {
	      switch (contentType) {
		case 0:
			if(newWidth!=0)
				this.width = newWidth;
			break;
		case 1:
			if(newWidth!=0 && newWidth>350)
				this.width = newWidth;		
			else
				this.width = 350;
			break;
		case 2:
			if(newWidth!=0 && newWidth>200)
				this.width = newWidth;
			else
				this.width = 200;
	
			break;
			
		default:
			break;
		}

	   }
	   
	   /** @pdOid 821d0f81-baab-418c-aa31-2828f7714bf6 */
	   public int getPositionX() {
	      return positionX;
	   }
	   
	   /** @param newPositionX
	    * @pdOid afabd448-b218-40b6-a63b-d31963df153c */
	   public void setPositionX(int newPositionX) {
		   if(MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.size()>0){
		   int pageWidth = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage().size.width;
		   if(newPositionX>=0)
		   {
			   if((newPositionX+width)<=5*pageWidth)
				   positionX = newPositionX;
			   else
				   positionX = 5*pageWidth - width;
		   }
		   else
			   positionX=0;
		   }
		   else 
			   positionX = newPositionX;
	   }
	   
	   /** @pdOid a5ec716e-f863-43bf-ae90-889ea9196a9d */
	   public int getPositionY() {
		   
	      return positionY;
	   }
	   
	   /** @param newPositionY
	    * @pdOid fd504f9e-6a39-4b01-a613-ed30f2832751 */
	   public void setPositionY(int newPositionY) {
		   if(MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.size()>0){
			   int pageHeight = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage().size.height;
		   if(newPositionY>=0)
		   {
			   if((newPositionY+height)<=5*pageHeight)
				   positionY = newPositionY;
			   else
				   positionY = 5*pageHeight - height;
		   }
		   else
			   positionY=0;
		   }
		   else 
			   positionY = newPositionY;
	   
	   }



   public Slot(int newHeight, int newWidth, int newPositionX, int newPositionY, SlotModel model){
	   this.model = model;
	   if(MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.size()!=0)
		   setZoomFactor(MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage().getZoomFactor());
	   setHeight(newHeight);
	   	setWidth(newWidth);
	   	setPositionX(newPositionX);
	   	setPositionY(newPositionY);
	   	realHeight=height;
	   	realWidth=width;
	   	realPositionX=positionX;
	   	realPositionY=positionY;
	   	
	    setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(20*getHeight()/100);
		   
	   	setLayout(null);
	   	setBounds(0, 0, getWidth(), getHeight());
	   	
	   	setOpaque(true);
	   	Point p = new Point(getPositionX(), getPositionY());
	   	setLocation(p);
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		Dimension dim = new Dimension(getHeight(), getWidth());
		setPreferredSize(dim);
		setPositionX(getPositionX());
		setPositionY(getPositionY());
		
		String info = local.getString("slot.tooltip.height")+ ": " + this.getHeight() + " " + local.getString("slot.tooltip.width")+ ": " + this.getWidth(); 
		setToolTipText(info);
		setVisible(true);
   }
   
   
   public void change(){
			
	   setHeight(realHeight*zoomFactor/50);
	   	setWidth(realWidth*zoomFactor/50);
	   	
	   	setPositionX(realPositionX*zoomFactor/50);
	   	setPositionY(realPositionY*zoomFactor/50);
	   
	   	setLayout(null);
	   	setBounds(0, 0, getWidth(), getHeight());
	   	
	   	setOpaque(true);
	   	Point p = new Point(getPositionX(), getPositionY());
	   	setLocation(p);
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		Dimension dim = new Dimension(getHeight(), getWidth());
		setPreferredSize(dim);

		String info = local.getString("slot.tooltip.height")+ ": " + this.getHeight() + " " + local.getString("slot.tooltip.width")+ ": " + this.getWidth(); 
		setToolTipText(info);
		
		AddContent(slotContent, contentType);
		revalidate();
   }
   
   public void addListeners(MouseListener ml,MouseMotionListener mml){
	   this.addMouseListener(ml);
	   this.addMouseMotionListener(mml);
   }

   public void setBorder() {
	   if(selected == true){
		   this.setBorder(BorderFactory.createDashedBorder(Color.blue));
		   this.setDividerLocation(20*this.getHeight()/100);
	   }
	   else{
		   setBorder(BorderFactory.createLineBorder(Color.black, 2));
		   this.setDividerLocation(1*this.getHeight()/100);
	   }
   }

   public void makeText(){
	   contentType = 1;
	   textToolbarModel = new TextToolbarModel();
	   textToolbar = new TextToolbar(textToolbarModel);
	   textToolbarController = new TextToolbarController(textToolbarModel, textToolbar);
	   setTopComponent(textToolbar);
	   
		Dimension dimension = new Dimension(getWidth()-20, getHeight()-getHeight()*40/100);
		slotContent = new Text(dimension);
		slotContent.setSize(dimension);
		setBottomComponent(slotContent);
		updateUI();
   }
   public void make2D() {
	   contentType = 2;
	   graphics2dToolbarModel = new Graphics2dToolbarModel();
	   graphics2dToolbar = new Graphics2dToolbar(graphics2dToolbarModel);
	   graphics2dToolbarController = new Graphics2dToolbarController(graphics2dToolbarModel, graphics2dToolbar);
	   setTopComponent(graphics2dToolbar);
	   
	   Dimension dimension = new Dimension(getWidth()-20, getHeight()-getHeight()*40/100);
		JPanel p = new JPanel();
		p.setPreferredSize(dimension);
		slotContent = new Graphics2d(dimension);
		JScrollPane scrollPane = new JScrollPane(slotContent);
		scrollPane.setPreferredSize(dimension);
		scrollPane.createHorizontalScrollBar();
		scrollPane.setVisible(true);
		scrollPane.getBaselineResizeBehavior();
		p.add(scrollPane);
		slotContent.setSize(dimension);
		setBottomComponent(p);
		updateUI();	
	}
   
   public void AddContent(SlotContent sc, int ct){
	   removeAll();
	   if(ct == 1){
		   contentType = 1;
		   textToolbarModel = new TextToolbarModel();
		   textToolbar = new TextToolbar(textToolbarModel);
		   textToolbarController = new TextToolbarController(textToolbarModel, textToolbar);
		   setTopComponent(textToolbar);
		   
			Dimension dimension = new Dimension(getWidth()-20, getHeight()-getHeight()*40/100);
			((Text) sc).changeDimension(dimension);
			slotContent = sc;
			slotContent.setSize(dimension);
			setBottomComponent(sc);
		updateUI();
	   }
	   else if(ct ==2){
		   removeAll();
		   contentType = 2;
		   graphics2dToolbarModel = new Graphics2dToolbarModel();
		   graphics2dToolbar = new Graphics2dToolbar(graphics2dToolbarModel);
		   graphics2dToolbarController = new Graphics2dToolbarController(graphics2dToolbarModel, graphics2dToolbar);
		   setTopComponent(graphics2dToolbar);
		   			
			Dimension dimension = new Dimension(getWidth()-20, getHeight()-getHeight()*40/100);
			slotContent = sc;
			JPanel p = new JPanel();
			p.setPreferredSize(dimension);
			JScrollPane scrollPane = new JScrollPane(sc);
			scrollPane.setPreferredSize(dimension);
			scrollPane.createHorizontalScrollBar();
			scrollPane.setVisible(true);
			scrollPane.getBaselineResizeBehavior();
			p.add(scrollPane);
			setBottomComponent(p);

			updateUI();
			
			
	   }
}
  }