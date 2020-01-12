package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import applicationModel.StatusBarModel;
import localization.Localization;
import main.MainClass;

public class StatusBar extends JPanel{
	public StatusBarModel model;
	private JLabel westCell = null;
	private JLabel centerCell = null;
	private JLabel eastCell = null;
	private JLabel zoomRatio = null;
	private JButton btnZoomOut;
	private JButton btnZoomIn;
	private JSlider slider;
	
	private static Localization local = Localization.getInstance();
	
	public StatusBar(StatusBarModel model)
	{	
		this.model = model;
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
		setLayout(new GridLayout(1, 2));
		
		/****************** Cells ******************/
		
		JPanel cells = new JPanel();
		cells.setLayout(new GridLayout(1,3));
		cells.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.gray, Color.lightGray));
		cells.setPreferredSize(new Dimension(800,20));
		westCell = new JLabel();
		local.registerComponent("statusBar.westCell", westCell);
		centerCell = new JLabel();
		local.registerComponent("statusBar.centerCell", centerCell);
		centerCell.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.gray));
		eastCell = new JLabel();
		local.registerComponent("statusBar.eastCell", eastCell);
		
		cells.add(westCell, BorderLayout.WEST);
		cells.add(centerCell, BorderLayout.CENTER);
		cells.add(eastCell, BorderLayout.EAST);
		add(cells);
				
		/***************** Scroll *********************/
		
		JPanel scroll = new JPanel();
		scroll.setLayout(new FlowLayout(FlowLayout.RIGHT,2,2));
		scroll.setPreferredSize(new Dimension(200,20));
		zoomRatio = new JLabel();
		
		btnZoomOut = new JButton("-");
		btnZoomOut.setText("-");
		btnZoomOut.setPreferredSize(new Dimension(15,15));
		btnZoomOut.setFont(new Font("Arial", Font.PLAIN, 5));
		
		JPanel slide = new JPanel();
		slider = new JSlider();
		slider.setMaximum(100);
		slider.setMinimum(1);
		slider.setValue(50);		
		
		btnZoomIn = new JButton("+");
		btnZoomIn.setText("+");
		btnZoomIn.setPreferredSize(new Dimension(15,15));
		btnZoomIn.setFont(new Font("Arial", Font.PLAIN, 5));
				
		scroll.add(zoomRatio);
		scroll.add(btnZoomOut);
		scroll.add(slider);
		scroll.add(btnZoomIn);	
		add(scroll);
		
		setVisible(true);	
	}
	
	public void Update()
	{
		if(MainClass.mf.state != null)
			model.setWestCell(MainClass.mf.state.getStateName());
		if(!(model.getCenterCell()=="") && !model.getCenterCell().contains("x"))
			model.setCenterCell(local.getString("slot.tooltip.group"));
		
		eastCell.setText(local.getString("statusBar.eastCell") + model.getEastCell());
		centerCell.setText(local.getString("statusBar.centerCell") + model.getCenterCell());
		westCell.setText(local.getString("statusBar.westCell") + model.getWestCell());
		zoomRatio.setText(String.valueOf(model.getZoomRatio()) + " %");
		slider.setValue(model.getZoomRatio());
	}
	
	public void ZoomIn(ActionListener listener)
	{
		btnZoomIn.setActionCommand("ZoomIn");
		btnZoomIn.addActionListener(listener);
	}
	
	public void ZoomOut(ActionListener listener)
	{
		btnZoomOut.setActionCommand("ZoomOut");
		btnZoomOut.addActionListener(listener);
	}
	
	public void Slide(ChangeListener listener)
	{
		slider.addChangeListener(listener);
	}
}