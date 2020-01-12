

package documentModel;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Graphics2d extends SlotContent {
  
   private String name;
   private Float positionX;
   private Float positionY;
   private Float height;
   private Float width;
   
   public Dimension dimension = new Dimension(2000,2000);
   public JPanel panel;
   public JScrollPane scrollPane;
   
   public int x1,x2,y1,y2;
   public static int type = 2;//default draw type
   
   public JPanel slot;
   
   public Point startDrag, endDrag;
   public ArrayList<Point> points = new ArrayList<Point>();
   public ArrayList<Shape> shapes = new ArrayList<Shape>();
   
 
   public Graphics2d(Dimension dimension) 
   {	
	   init(); 
   }
     
   public void init(){
	      setBackground(Color.white);
	      addMouseListener(new MouseAdapter()
	       {
	          public void mousePressed(MouseEvent m)
	          {	             
	        	  startDrag = new Point(m.getX(), m.getY());
	              endDrag = startDrag;
	              points.add(startDrag);
	              repaint();
	        	  
	          }
	          public void mouseReleased(MouseEvent m)
	          {
	        	  if(type==1)
	        	  {
	        		  Shape r = makeDot(startDrag.x, startDrag.y, endDrag.x, endDrag.y);	        		  
	    	          shapes.add(r);    
	        	  }
	        	  else if(type==2)
	        	  {
	        		  Shape r = makeLine(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
	    	          shapes.add(r);
	        	  }
	        	  else if(type==3)
	        	  {
	        		  Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
	    	          shapes.add(r);
	        	  }
	        	  else if(type==4)
	        	  {
	        		  Shape r = makeOwal(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
	    	          shapes.add(r);
	        	  }

	        	  points.add(endDrag);  
	        	  startDrag = null;
	              endDrag = null;
	              repaint();
	          }
	        });

	      addMouseMotionListener(new MouseMotionAdapter()
	        {
	           public void mouseDragged(MouseEvent m)
	              {
	                
	        	   endDrag = new Point(m.getX(), m.getY());
	               repaint();
	        	  
	              }
	          });
	}
   
   public static void setType(int arg){
	    if(arg == 1){
	        type = 1;
	    }else if(arg == 2){
	        type = 2;
	    }
	    else if(arg == 3){
	        type = 3;
	    }
	    else if(arg == 4){
	        type = 4;
	    }
	}

    public void paintComponent(Graphics graf)
	  { 
    	setBorder(BorderFactory.createLineBorder(Color.black,2));
    	
    		setSize(dimension);
 	   		setPreferredSize(dimension);
    	        
		  Graphics2D graf2 = (Graphics2D) graf;
	      super.paintComponent(graf2);
			
	      graf2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	     
	      graf2.setStroke(new BasicStroke(2));
	      graf2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

	      for (Shape s : shapes) 
	      {
	        graf2.setPaint(Color.BLACK);
	        graf2.draw(s);
	        
	      }

	      if (startDrag != null && endDrag != null) {
	        graf2.setPaint(Color.LIGHT_GRAY);
	        if(type==1)
      	  {
      		  
      	  }
      	  else if(type==2)
      	  {
      		  Shape r = makeLine(startDrag.x, startDrag.y, endDrag.x, endDrag.y);  
      		  graf2.draw(r);
      	  }
      	  else if(type==3)
      	  {
      		  Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);  
      	      graf2.draw(r);
      	  }
      	  else if(type==4)
      	  {
      		  Shape r = makeOwal(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
      		  graf2.draw(r);
  	          
      	  }
	        
	      }
	      
	     
	  }

   public Rectangle2D.Float makeRectangle (int x1, int y1, int x2, int y2)
   {
	   return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			
   }
   
   public Ellipse2D.Float makeOwal(int x1, int y1, int x2, int y2)
   {
	   return new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
   }
   
   public Line2D.Float makeLine(int x1, int y1, int x2, int y2)
   {
	   return new Line2D.Float(x1,  y1,  x2,  y2);
   }
   
   public Ellipse2D.Float makeDot(int x1, int y1, int x2, int y2)
   {
	   return new Ellipse2D.Float(x1 - 3, y1- 3, 7, 7);
   }
   
   public void draw() {
      // TODO: implement
   }
   
   
   public void fill(String color) {
      // TODO: implement
   }
   
   
   public void changePosition(Float positionX, Float positionY) {
      // TODO: implement
   }
   
  
   public void rotation(Float percentage) {
      // TODO: implement
   }
   
  
   public void resize(Float height, Float width) {
      // TODO: implement
   }


}