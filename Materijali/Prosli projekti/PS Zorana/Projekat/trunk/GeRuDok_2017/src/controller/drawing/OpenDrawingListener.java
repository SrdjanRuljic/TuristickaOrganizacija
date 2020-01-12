package controller.drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import controller.slot.PopupMenuAddDrawingElementListener;
import viewer.drawing.WindowDrawing;

public class OpenDrawingListener implements ActionListener {
	
	@Override
		public void actionPerformed(ActionEvent arg0)
		{
			JFileChooser jFileChooser = new JFileChooser();
			int result = jFileChooser.showOpenDialog(null);
            if (result==JFileChooser.APPROVE_OPTION ) 
            {
                try
                {
                    BufferedImage bufferedImage = ImageIO.read(jFileChooser.getSelectedFile());
                    WindowDrawing.setImage(bufferedImage);
                } 
                 catch (IOException e) { }
            }
            
        }

}
