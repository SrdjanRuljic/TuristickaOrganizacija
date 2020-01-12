/***********************************************************************
 * Module:  TextDialog.java
 * Author:  Ivana
 * Purpose: Defines the Class TextDialog
 ***********************************************************************/

package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.SlotController;
import documentModel.Document;
import documentModel.Text;
import localization.Localization;
import main.MainClass;

public class TextDialog extends JDialog implements ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
	Dimension dimension = new Dimension(400,500);
	
	JPanel panel1, panel2, panel3;
	JLabel lblFont, lblSize, lblBold, lblItalic, lblUnderline;
	JLabel lblType, lblPreview;
	JTextField label, txtFont, txtSize, txtType;
	JScrollPane scrollFont, scrollSize, scrollType;
	JList listFont, listSize, listType;
	JButton btnOk, btnCancel;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public TextDialog(){
		setTitle(local.getString("textDialog.title"));
		setSize(dimension);
		setResizable(false);
		gbl = new GridBagLayout();
		setLayout(gbl);
		gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		lblFont = new JLabel(local.getString("textDialog.font"));
		this.getContentPane().add(lblFont, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		lblSize = new JLabel(local.getString("textDialog.size"));
		this.getContentPane().add(lblSize, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		lblType = new JLabel(local.getString("textDialog.type"));
		this.getContentPane().add(lblType, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		txtFont = new JTextField("Arial", 12);
		this.getContentPane().add(txtFont, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		txtSize = new JTextField("8", 4);
		this.getContentPane().add(txtSize, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		txtType = new JTextField("Regular", 6);
		this.getContentPane().add(txtType, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		listFont = new JList(fonts);
		listFont.setFixedCellWidth(100);
		listFont.addListSelectionListener(this);
		listFont.setSelectedIndex(0);
		scrollFont = new JScrollPane(listFont);
		getContentPane().add(scrollFont, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		String[] sizes = {"8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "32", "48"};
		listSize = new JList(sizes);
		listSize.setFixedCellWidth(18);
		listSize.addListSelectionListener(this);
		listSize.setSelectedIndex(0);
		scrollSize = new JScrollPane(listSize);
		getContentPane().add(scrollSize, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		String[] types = {"Regular", "Bold", "Italic", "Bold Italic"};
		listType = new JList(types);
		listType.setFixedCellWidth(60);
		listType.addListSelectionListener(this);
		listType.setSelectedIndex(0);
		scrollType = new JScrollPane(listType);
		getContentPane().add(scrollType, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		lblPreview = new JLabel(local.getString("textDialog.preview"));
		panel1.add(lblPreview);
		this.getContentPane().add(panel1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		label = new JTextField(local.getString("textDialog.preview1"));
		label.setEditable(false);
		label.setBorder(BorderFactory.createEtchedBorder());
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel2.add(label);
		this.getContentPane().add(panel2, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		btnOk = new JButton(local.getString("textDialog.ok"));
		btnOk.setActionCommand("TextDialogOk");
		btnOk.addActionListener(al);
		btnCancel = new JButton(local.getString("textDialog.cancel"));
		btnCancel.setActionCommand("TextDialogCancel");
		btnCancel.addActionListener(al);
		panel3.add(btnOk);
		panel3.add(btnCancel);
		this.getContentPane().add(panel3, gbc);
		setLocation((int)(screen.getWidth()-this.getWidth())/2, (int)(screen.getHeight()- this.getHeight())/2);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		try{
			if(event.getSource() == listFont){
				Font f1 = new Font(String.valueOf(listFont.getSelectedValue()), listType.getSelectedIndex(), Integer.parseInt(String.valueOf(listSize.getSelectedValue())));
				txtFont.setText(String.valueOf(listFont.getSelectedValue()));
				label.setFont(f1);
			}
			else if(event.getSource() == listSize){
				Font f2 = new Font(String.valueOf(listFont.getSelectedValue()), listType.getSelectedIndex(), Integer.parseInt(String.valueOf(listSize.getSelectedValue())));
				txtSize.setText(String.valueOf(listSize.getSelectedValue()));
				label.setFont(f2);
			}
			else {
				Font f3 = new Font(String.valueOf(listFont.getSelectedValue()), listType.getSelectedIndex(), Integer.parseInt(String.valueOf(listSize.getSelectedValue())));
				txtType.setText(String.valueOf(listType.getSelectedValue()));
				label.setFont(f3);
			}
			
		} catch (Exception e){
			
		}
		
	}
	
	public Font font(){
		Font font = new Font(String.valueOf(listFont.getSelectedValue()), listType.getSelectedIndex(), Integer.parseInt(String.valueOf(listSize.getSelectedValue())));
		return font;
	}
	
	public JButton getOk(){
		return btnOk;
	}
	
	public JButton getCancel(){
		return btnCancel;
	}
	
	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand())
			{
			case "TextDialogOk":
				Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
				for (SlotController s  : doc.getPage().model.getNizSlotova()) {
					if(s.view.selected)
					((Text) s.view.slotContent).SetFont(font());
				}
				setVisible(false);
				MainClass.mf.gotoEdit();
				break;
			case "TextDialogCancel":
				setVisible(false);
				MainClass.mf.gotoEdit();
				break;
			}
		}
	};
}