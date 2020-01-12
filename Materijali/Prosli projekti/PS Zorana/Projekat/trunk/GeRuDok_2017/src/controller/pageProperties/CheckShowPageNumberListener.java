package controller.pageProperties;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import view.pageProperties.PageProperties;

public class CheckShowPageNumberListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		JCheckBox cb = (JCheckBox) arg0.getSource();
		if(!cb.isSelected())
		{
			PageProperties.positionPageNumber.setEnabled(false);
		}
		else
		{
			PageProperties.positionPageNumber.setEnabled(true);
		}	
			
	}

}
