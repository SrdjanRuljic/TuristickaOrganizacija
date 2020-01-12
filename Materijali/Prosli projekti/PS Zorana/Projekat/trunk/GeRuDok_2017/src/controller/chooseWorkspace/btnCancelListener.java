package controller.chooseWorkspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PreView;

public class btnCancelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		PreView.windowForChooseWorkspace.dispose();

	}

}
