/***********************************************************************
 * Module:  StatusBar.java
 * Author:  draga_000
 * Purpose: Defines the Class StatusBar
 ***********************************************************************/

package view;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.StatusBarModel;

/** @pdOid fd2aae16-2fca-47e9-a711-2364122151fd */
public class StatusBar extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel labelTable, labelState, labelRow;
	JPanel cells, cellTable, cellState, cellRow;
	public StatusBarModel model;
	public StatusBar(StatusBarModel model)
	{
		this.model=model;
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		
		cells = new JPanel();
		cells.setLayout(new GridLayout(1,4));
		
		cellTable = new JPanel();
		cellTable.setLayout(new GridLayout(1,2));
		labelTable = new JLabel("Table:");
		cellTable.add(labelTable);
		cellTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			
		cellState = new JPanel();
		cellState.setLayout(new GridLayout(1,2));
		labelState = new JLabel("State:");
		cellState.add(labelState);
		cellState.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		cellRow = new JPanel();
		cellRow.setLayout(new GridLayout(1,2));
		labelRow = new JLabel("Row:");
		cellRow.add(labelRow);
		cellRow.setBorder(BorderFactory.createLineBorder(Color.lightGray));
				
		cells.add(cellTable);
		cells.add(cellState);
		cells.add(cellRow);
		this.add(cells);
		
		Update();
	}
	
	public void Update()
	{
		labelTable.setText("Table:   "+model.getCurrentTable());
		labelState.setText("State:   "+model.getCurrentState());
		labelRow.setText("Row:   "+model.getCurrentRow());
	}
	
	
}
