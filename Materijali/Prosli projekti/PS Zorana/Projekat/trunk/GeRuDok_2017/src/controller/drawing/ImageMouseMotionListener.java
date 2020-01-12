package controller.drawing;

import java.awt.BasicStroke;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import viewer.drawing.WindowDrawing;

public class ImageMouseMotionListener implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent arg0)
    {
        reportPositionAndColor(arg0);

        if (WindowDrawing.activeTool==WindowDrawing.DRAW_TOOL)
        {	
        	WindowDrawing.draw(arg0.getPoint());
        }
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        reportPositionAndColor(arg0);
    }

	private void reportPositionAndColor(MouseEvent me)
	{
		String text = "";
		text += "X,Y: " + (me.getPoint().x+1) + "," + (me.getPoint().y+1);
		
    }
	
	

}
