package controller.drawing;

import java.awt.BasicStroke;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class promjenaDebljineListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner debljinaVelicina = (JSpinner) e.getSource();
		Object o = debljinaVelicina.getModel().getValue();
        Integer i = (Integer)o; 
        WindowDrawing.stroke = new BasicStroke(i.intValue(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,1.7f);
		
	}

}
