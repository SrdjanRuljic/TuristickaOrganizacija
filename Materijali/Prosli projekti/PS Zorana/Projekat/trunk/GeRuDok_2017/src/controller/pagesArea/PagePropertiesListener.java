package controller.pagesArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.pageProperties.PageProperties;
import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.PagesArea;

public class PagePropertiesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new PageProperties();
	}

}
