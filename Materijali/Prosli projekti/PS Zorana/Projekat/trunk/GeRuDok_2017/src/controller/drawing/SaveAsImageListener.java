package controller.drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import viewer.drawing.WindowDrawing;

public class SaveAsImageListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
	 JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION )
        {
            try 
            {
                File file = jFileChooser.getSelectedFile();
                ImageIO.write(WindowDrawing.image, "png", file);
            } 
            catch (IOException ioe) { }
        }
    }


}
