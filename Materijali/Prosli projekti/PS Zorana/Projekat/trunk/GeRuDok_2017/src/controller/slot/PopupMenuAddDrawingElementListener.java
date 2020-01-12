package controller.slot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.drawing.WindowDrawing;

public class PopupMenuAddDrawingElementListener implements ActionListener {

	public static WindowDrawing windowDrawing;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		windowDrawing = new WindowDrawing();
		windowDrawing.setVisible(true);
	}

}
