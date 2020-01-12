package controller.drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class DrawDrawingListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowDrawing.activeTool = WindowDrawing.DRAW_TOOL;
	}

}
