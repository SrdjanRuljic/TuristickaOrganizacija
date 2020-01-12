/***********************************************************************
 * Module:  Configure.java
 * Author:  draga_000
 * Purpose: Defines the Class Configure
 ***********************************************************************/

package dialogs;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import localization.Localization;
import xml.ConfigDOM;

/** @pdOid d0bf6cd8-0ef4-4025-9386-76aa06c867d7 */
public class Configure extends JDialog {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Localization local = Localization.getInstance();
	
	JLabel selectionLabel = new JLabel(local.getString("configure.select"));
	JComboBox selectionComboBox = new JComboBox();
	
	JButton btnOK = new JButton(local.getString("configure.btnOK"));
	JButton btnCancel = new JButton(local.getString("configure.btnCancel"));
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension dimBtn = new Dimension(30,30);
	
	JLabel image;
	public int chosenLookAndFeel;
	public String lookAndFeel;
	public Configure()
	{
		this.setModal(true);
		this.setTitle(local.getString("configure.title"));
		
		this.setSize(new Dimension(425,375));
		this.setMaximumSize(new Dimension(425,375));
		this.setMinimumSize(new Dimension(425,375));
		this.setLocation((int)(dim.getWidth()-this.getWidth())/2, (int)(dim.getHeight()- this.getHeight())/2);
		this.pack();
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridBagLayout());
		panel.setSize(new Dimension(400,350));
		panel.setMaximumSize(new Dimension(400,350));
		panel.setMinimumSize(new Dimension(400,350));
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		selectionLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		//c.anchor = GridBagConstraints.PAGE_START; 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,10,0,10);		//padding 
	    c.gridx = 0;	//kolona
	    c.gridy = 0;	//red
	    c.gridwidth=1;
	    panel.add(selectionLabel, c);
		
		selectionComboBox.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		selectionComboBox.addItem("Window");
		selectionComboBox.addItem("Metal");
		selectionComboBox.addItem("Motif");
		selectionComboBox.setSelectedItem(selectionComboBox.getItemAt(0));
		selectionComboBox.addItemListener(il);
		
		//c.anchor = GridBagConstraints.PAGE_START; 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,10,0,10);		//padding 
	    c.gridx = 1;	//kolona
	    c.gridy = 0;	//red
		panel.add(selectionComboBox, c);
		
		image=new JLabel();
		
		image.setSize(new Dimension(325,195));
		image.setIcon(new ImageIcon("Icons/window.png"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,37,0,10);		//padding 
		c.ipady = 50; //podesavanje visine
		//c.ipadx = 150; //podesavanje sirine
		c.gridwidth = 2;
	    c.gridx = 0;	//kolona
	    c.gridy = 1;	//red
	    panel.add(image, c);
	    
	    c.gridwidth=1;
	    c.ipadx=0;
	    c.ipady=0;
		//btnOK.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		btnOK.addActionListener(al);
		btnOK.setActionCommand("OK");
		btnOK.setPreferredSize(dimBtn);
		btnOK.setSize(dimBtn);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,10,10,10);		//padding 
		c.weightx=1.0;
		
	    c.gridx = 0;	//kolona
	    c.gridy = 2;	//red
	    //c.anchor = GridBagConstraints.PAGE_END; 
		panel.add(btnOK, c);
		  
		//btnCancel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		btnCancel.setActionCommand("Cancel");
		btnCancel.addActionListener(al);
		btnCancel.setPreferredSize(dimBtn);
		btnCancel.setSize(dimBtn);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridwidth=1;
		c.insets = new Insets(10,10,10,10);		//padding 
	    c.gridx = 1;	//kolona
	    c.gridy = 2;	//red
	    //c.anchor = GridBagConstraints.PAGE_END; 
		panel.add(btnCancel, c);
		    
		this.add(panel);
		setVisible(true);
	}
	ItemListener il = new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			String command = e.getItem().toString();
			switch(command)
			{
			case "Window":
				image.setIcon(new ImageIcon("Icons/window.png"));
				break;
			case "Metal":
				image.setIcon(new ImageIcon("Icons/metal.png"));
				break;
			case "Motif":
				image.setIcon(new ImageIcon("Icons/motif.png"));
				break;
			
			}
			
		}
	};
	ActionListener al = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch (command) {
			case "OK":
				chosenLookAndFeel = selectionComboBox.getSelectedIndex();
				setLookAndFeel(chosenLookAndFeel);
				dispose();
				break;
			case "Cancel":
				dispose();
				break;
			}
		} 
	};
	public void setLookAndFeel(int chosenLookAndFeel)
	{
		  switch (chosenLookAndFeel) {
			case 0: 
				lookAndFeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				break;
			case 1: 
				lookAndFeel="javax.swing.plaf.metal.MetalLookAndFeel";
				break;
			case 2: 
				lookAndFeel="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
				break;
			default: 
				break;
			}
		  ConfigDOM write=new ConfigDOM();
		  write.WriteConfig(lookAndFeel);
		  JOptionPane.showMessageDialog(null, local.getString("configure.message.content"), local.getString("configure.message.title"), JOptionPane.INFORMATION_MESSAGE);
	 }  
}