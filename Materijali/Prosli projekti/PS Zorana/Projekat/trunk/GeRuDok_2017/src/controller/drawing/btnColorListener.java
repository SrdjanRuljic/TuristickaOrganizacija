package controller.drawing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class btnColorListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e)
	{
		 Color color = JColorChooser.showDialog(null, "Choose a color", Color.RED);
         if (color!=null)
         {
        	 WindowDrawing.setColor(color);
         }
     }
		
	

}
