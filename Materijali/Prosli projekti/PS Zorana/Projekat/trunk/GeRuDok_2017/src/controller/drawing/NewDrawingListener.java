package controller.drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class NewDrawingListener implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
       BufferedImage bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
       WindowDrawing.clear(bufferedImage);
       WindowDrawing.setImage(bufferedImage);
    }

}
