package controller.drawing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Elemenat;
import viewer.drawing.WindowDrawing;
import viewer.editAndPreviewArea.PagesArea;
import viewer.element.ElementArea;

public class SaveDrawingListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Elemenat elemenat = new Elemenat();
		ElementArea elementArea = new ElementArea(elemenat);
		PagesArea.activeEditSlot.getSlot().setElemenat(elemenat);
		elementArea.setPreferredSize(new Dimension(WindowDrawing.image.getWidth()+20, WindowDrawing.image.getHeight()+20));
		elementArea.add(new JLabel(new ImageIcon(WindowDrawing.image)));
		PagesArea.activeEditSlot.add(elementArea);
		PagesArea.activeEditSlot.getParent().revalidate();
		//PagesArea.activeEditSlot.getParent().repaint();
		
		

	}
}
