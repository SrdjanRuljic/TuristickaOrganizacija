package controller.drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class TextDrawingListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		WindowDrawing.activeTool = WindowDrawing.TEXT_TOOL;

	}

}
