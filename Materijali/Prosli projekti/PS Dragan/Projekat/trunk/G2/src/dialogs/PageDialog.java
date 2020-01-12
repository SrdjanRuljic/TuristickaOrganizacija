package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import documentModel.Page;
import localization.Localization;

public class PageDialog extends JDialog {

	private static Localization local = Localization.getInstance();
	public int pageSize;
	public Color pageColor = Color.white;
	public int pageGrid;
	public Boolean gridVisible;
	  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	  Dimension dimBtn = new Dimension(70,50);
	
		JLabel sizeLabel = new JLabel(local.getString("page.size.label"));
		JComboBox size = new JComboBox();
	  
	  JLabel colorLabel = new JLabel(local.getString("page.size.color"));
	  JButton btnColor = new JButton(local.getString("page.size.btnColor"));
	  
	  JLabel gridLabel = new JLabel(local.getString("page.size.grid"));
	  JComboBox grid = new JComboBox();
	  
	  JLabel gridVisibleLabel = new JLabel(local.getString("page.size.gridVisible"));
	  JCheckBox gridBox = new JCheckBox();

	  JButton btnOK = new JButton(local.getString("page.size.btnOK"));
	  JButton btnCancel = new JButton(local.getString("page.size.btnCancel"));
	  
	  Page page;
	  public PageDialog(Page page){
		  this.page = page;
		  this.setModal(true);
		  this.setTitle(local.getString("page.size.title"));
		  this.setSize(new Dimension(350,250));
		  this.setMaximumSize(new Dimension(350,250));
		  this.setMinimumSize(new Dimension(350,250));
		  this.setLocation((int)(dim.getWidth()-this.getWidth())/2, (int)(dim.getHeight()- this.getHeight())/2);
		  this.pack();
		
		  JPanel p = new JPanel();
		  p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		  p.setLayout(new GridLayout(5, 2,10,10));
		  p.setSize(new Dimension(450,200));
		  p.setMaximumSize(new Dimension(450,200));
		  p.setMinimumSize(new Dimension(450,200));
		  
		  sizeLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		  p.add(sizeLabel);
		  
		  size.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		  size.addItem(local.getString("page.size.A0"));
		  size.addItem(local.getString("page.size.A1"));
		  size.addItem(local.getString("page.size.A2"));
		  size.addItem(local.getString("page.size.A3"));
		  size.addItem(local.getString("page.size.A4"));
		  size.addItem(local.getString("page.size.A5"));
		  size.addItem(local.getString("page.size.A6"));
		  size.setSelectedItem(size.getItemAt(4));
		  local.registerComponent("size", size);
		  p.add(size);
		  
		  
		  colorLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		  p.add(colorLabel);
		  btnColor.setActionCommand("Color");
		  btnColor.addActionListener(al);
		  p.add(btnColor);
		  
		  gridLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		  p.add(gridLabel);
		  grid.setBorder(BorderFactory.createEmptyBorder(0,50, 0, 0));
		  grid.addItem("1%");
		  grid.addItem("2%");
		  grid.addItem("3%");
		  grid.addItem("4%");
		  grid.addItem("5%");
		  grid.addItem("6%");
		  grid.addItem("7%");
		  grid.addItem("8%");
		  grid.addItem("9%");
		  grid.addItem("10%");
		  p.add(grid);
		    
		  gridVisibleLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		  p.add(gridVisibleLabel);
		  p.add(gridBox);
		  
		  btnOK.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		  btnOK.addActionListener(al);
		  btnOK.setActionCommand("OK");
		  btnOK.setPreferredSize(dimBtn);
		  p.add(btnOK);
		    
		  btnCancel.setActionCommand("Cancel");
		  btnCancel.addActionListener(al);
		  btnCancel.setPreferredSize(dimBtn);
		  p.add(btnCancel);
		    
		  this.add(p);
		  setVisible(true);
	}
	  
	  ActionListener al = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch (command) {
			case "Color":
				pageColor = JColorChooser.showDialog(null, "Select  a  color", null);
				break;
			case "OK":
				pageSize = size.getSelectedIndex();
				pageGrid = grid.getSelectedIndex();
				setPage(page);
				dispose();
				break;
			case "Cancel":
				dispose();
				break;
			}
		} 
	  };
	
	  public void setPage(Page page){
		  page.color = pageColor;
		  
		  switch (pageSize) {
			case 0: page.size = new Dimension(2384,3370); break;
			case 1: page.size = new Dimension(1684,2384); break;
			case 2: page.size = new Dimension(1191,1684); break;
			case 3: page.size = new Dimension(842,1191); break;
			case 4: page.size = new Dimension(595,842); break;
			case 5: page.size = new Dimension(420,595); break;
			case 6: page.size = new Dimension(298,420); break;
			default: break;
			}
		  switch (pageGrid) {
		  	case 0: page.grid = 1; break;
			case 1: page.grid = 2; break;
			case 2: page.grid = 3; break;
			case 3: page.grid = 4; break;
			case 4: page.grid = 5; break;
			case 5: page.grid = 6; break;
			case 6: page.grid = 7; break;
			case 7: page.grid = 8; break;
			case 8: page.grid = 9; break;
			case 9: page.grid = 10; break;
			default: break;
			}
		  
		  page.gridVisible = gridBox.isSelected();
	  }
}
