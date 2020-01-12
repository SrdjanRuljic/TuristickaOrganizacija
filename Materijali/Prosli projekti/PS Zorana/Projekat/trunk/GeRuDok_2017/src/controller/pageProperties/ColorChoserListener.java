package controller.pageProperties;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import view.pageProperties.PageProperties;

public class ColorChoserListener implements ActionListener {

	JColorChooser jColorChooser;
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Color background = JColorChooser.showDialog(null, "Color Choser", Color.RED);
		PageProperties.background = background;
	}

}
