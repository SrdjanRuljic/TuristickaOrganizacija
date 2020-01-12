package viewer.drawing;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import controller.drawing.NewDrawingListener;
import controller.drawing.OpenDrawingListener;
import controller.drawing.SaveAsImageListener;
import controller.drawing.SaveDrawingListener;

public class MenuFileDrawing extends JMenu
{
	private static final long serialVersionUID = 1L;

	 public MenuFileDrawing ()
	 {
		 setText("File");
	     JMenuItem newNEW = new JMenuItem("New");
	     newNEW.setMnemonic('n');
	     newNEW.addActionListener(new NewDrawingListener());
	     add(newNEW);
	    
	     addSeparator();
	    
	     JMenuItem open = new JMenuItem("Open");
	     open.setMnemonic('o');
	     open.addActionListener(new OpenDrawingListener());
	     //add(open);

	     JMenuItem saveItem = new JMenuItem("Save");
	     saveItem.addActionListener(new SaveDrawingListener());
	     saveItem.setMnemonic('s');
	     add(saveItem);
	     
	     JMenuItem saveImage = new JMenuItem("Save as Image");
	     saveImage.addActionListener(new SaveAsImageListener());
	     saveImage.setMnemonic('s');
	     add(saveImage);
	     
	     

	    }
}
