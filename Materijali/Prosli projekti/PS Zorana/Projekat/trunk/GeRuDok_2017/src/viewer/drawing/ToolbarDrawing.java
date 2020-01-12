package viewer.drawing;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import controller.drawing.DrawDrawingListener;
import controller.drawing.TextDrawingListener;
import controller.drawing.btnColorListener;
import controller.drawing.promjenaDebljineListener;

public class ToolbarDrawing extends JToolBar
{
	private static final long serialVersionUID = 1L;

	public ToolbarDrawing() 
	{
		JButton btnColor = new JButton("Color", new ImageIcon("slike/EditElement/TextToolbar/color.png"));
		btnColor.setToolTipText("Choose a Color");
	    btnColor.addActionListener(new btnColorListener()); 
	    add(btnColor);
	    addSeparator();

        SpinnerNumberModel modelDebljina =  new SpinnerNumberModel(1,1,50,1);
        JSpinner debljinaVelicina = new JSpinner(modelDebljina);
        debljinaVelicina.setSize(new Dimension(100, 50));
        debljinaVelicina.addChangeListener(new promjenaDebljineListener());
        
        JLabel labelSize = new JLabel("Size");
        
        add(labelSize);
        add(debljinaVelicina);

        addSeparator();
        
        JToggleButton text = new JToggleButton("Text", new ImageIcon("slike/PopupMenuSlot/addTextElement.png"));
        text.addActionListener(new TextDrawingListener());
        
        JToggleButton draw = new JToggleButton("Draw", new ImageIcon("slike/PopupMenuSlot/addGraphicsElement.png"));
        draw.addActionListener(new DrawDrawingListener());
        
        add(text);
        add(draw);
        addSeparator();
	}
	
}
