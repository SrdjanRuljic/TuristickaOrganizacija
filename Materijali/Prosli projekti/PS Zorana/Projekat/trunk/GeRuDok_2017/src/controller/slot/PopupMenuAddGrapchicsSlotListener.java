package controller.slot;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Elemenat;
import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.PagesArea;

public class PopupMenuAddGrapchicsSlotListener implements ActionListener {

	String path;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		BufferedImage myPicture = null;
		JFileChooser jFileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG images", "jpg", "png");
		jFileChooser.setFileFilter(filter);
		int returnVal = jFileChooser.showOpenDialog(null);
		 if(returnVal == JFileChooser.APPROVE_OPTION)
		       path = jFileChooser.getSelectedFile().getPath();
		try {
			
			myPicture = ImageIO.read(new File(path));
		} catch (IOException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		PagesArea.activeEditSlot.setPreferredSize(new Dimension(myPicture.getWidth()+50, myPicture.getHeight()+50));
		
		picLabel.setPreferredSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
		Elemenat elemenat = new Elemenat();
		PagesArea.activeEditSlot.getSlot().setElemenat(elemenat);
		
		PagesArea.activeEditSlot.add(picLabel);
		PagesArea.activeEditSlot.revalidate();
		PagesArea.activeEditSlot.repaint();
		}

}
