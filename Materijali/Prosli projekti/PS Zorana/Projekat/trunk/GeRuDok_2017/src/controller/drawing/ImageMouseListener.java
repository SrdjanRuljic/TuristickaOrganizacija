package controller.drawing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class ImageMouseListener extends MouseAdapter {

	WindowDrawing windowDrawing = PopupMenuAddDrawingElementListener.windowDrawing;

	 @Override
     public void mousePressed(MouseEvent arg0) {
         
		 if (WindowDrawing.activeTool == WindowDrawing.DRAW_TOOL)
		 {
             WindowDrawing.draw(arg0.getPoint());
         }
		 else if (WindowDrawing.activeTool == WindowDrawing.TEXT_TOOL)
		 {
             WindowDrawing.text(arg0.getPoint());
         } 
     }

}
