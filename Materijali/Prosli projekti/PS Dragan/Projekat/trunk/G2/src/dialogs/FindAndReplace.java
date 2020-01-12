/***********************************************************************
 * Module:  FindAndReplace.java
 * Author:  Ivana
 * Purpose: Defines the Class FindAndReplace
 ***********************************************************************/

package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import controller.SlotController;
import documentModel.Text;
import localization.Localization;
import main.MainClass;

public class FindAndReplace extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Localization local = Localization.getInstance();
	
	boolean foundOne, isReplace;
	JTextField searchText, replaceText;
	JLabel statusInfo;
	JFrame owner;
	JPanel north, south;
	JButton btnFind, btnReplace;
	
	public FindAndReplace(JFrame owner, boolean isReplace){
		super(owner, true);
		this.isReplace = isReplace;
		north = new JPanel();
		south = new JPanel();
		if(isReplace){
			setTitle(local.getString("findAndReplace.titleReplace"));
			setReplacePanel(north);
		}
		else{
			setTitle(local.getString("findAndReplace.titleFind"));
			setFindPanel(north);
		}
		statusInfo = new JLabel("");
		south.add(statusInfo);
		
		addWindowListener(new WindowAdapter(){	
			@Override
			public void windowClosing(WindowEvent event){
				removeHightlights(getTextComponent());
				dispose();
			}
		});
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(south, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		int x = (owner.getWidth()*3/5)-(getWidth()/2);
		int y = (owner.getHeight()*3/5)-(getHeight()/2);
		setLocation(x, y);
		setVisible(true);
	}

	private void setFindPanel(JPanel north){
		btnFind = new JButton(local.getString("findAndReplace.btnFind"));
		btnFind.addActionListener(this);
		btnFind.setActionCommand("Find");
		btnFind.setEnabled(false);
		searchText = new JTextField(20);
		searchText.addActionListener(this);
		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e){
				boolean state = (searchText.getDocument().getLength() > 0);
				btnFind.setEnabled(state);
				foundOne = false;
			}
		});
		
		if(searchText.getText().length() > 0){
			btnFind.setEnabled(true);
		}
			
		north.add(new JLabel(local.getString("findAndReplace.lblFind")));
		north.add(searchText);
		north.add(btnFind);
	}
	
	private void setReplacePanel(JPanel north){
		GridBagLayout grid = new GridBagLayout();
		north.setLayout(grid);
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		JLabel lblFindWord = new JLabel(local.getString("findAndReplace.lblFind"));
		JLabel lblReplaceWord = new JLabel(local.getString("findAndReplace.lblReplace"));
		
		btnFind = new JButton(local.getString("findAndReplace.btnFind"));
		btnFind.addActionListener(this);
		btnFind.setActionCommand("Find");
		btnFind.setEnabled(false);
		
		btnReplace = new JButton(local.getString("findAndReplace.btnReplace"));
		btnReplace.addActionListener(this);
		btnReplace.setActionCommand("Replace");
		btnReplace.setEnabled(false);
		
		searchText = new JTextField(20);
		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e){
				boolean state = (searchText.getDocument().getLength() > 0);
				btnFind.setEnabled(state);
				foundOne = false;
			}
		});
		
		replaceText = new JTextField(20);
		replaceText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent event){
				boolean state = (replaceText.getDocument().getLength() > 0);
				btnFind.setEnabled(state);
				btnReplace.setEnabled(state);
				foundOne = false;
			}
		});
		
		con.gridx = 0;
		con.gridy = 0;
		grid.setConstraints(lblFindWord, con);
		north.add(lblFindWord);
		
		con.gridx = 1;
		con.gridy = 0;
		grid.setConstraints(searchText, con);
		north.add(searchText);
		
		con.gridx = 2;
		con.gridy = 0;
		grid.setConstraints(btnFind, con);
		north.add(btnFind);
		
		con.gridx = 0;
		con.gridy = 1;
		grid.setConstraints(lblReplaceWord, con);
		north.add(lblReplaceWord);
		
		con.gridx = 1;
		con.gridy = 1;
		grid.setConstraints(replaceText, con);
		north.add(replaceText);
		
		con.gridx = 2;
		con.gridy = 1;
		grid.setConstraints(btnReplace, con);
		north.add(btnReplace);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Find")){
			Search(getTextComponent(), getSearchText());
		}
		if(event.getActionCommand().equals("Replace")){
			Replace(getTextComponent(), searchText.getText(), replaceText.getText());
		}
	}
	
	private JTextPane getTextComponent(){
		documentModel.Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		Text text = null;
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
			if(s.view.selected)
			text = ((Text) s.view.slotContent);
		}
		return text.getPane();
	}
	
	private String getSearchText(){
		return searchText.getText();
	}

	private void Search(JTextComponent textComp, String searchText){
		removeHightlights(textComp);
		
		try{
				Highlighter.HighlightPainter hlp = new HighlightPainter(Color.yellow);
				Highlighter check = textComp.getHighlighter();
				Document doc = textComp.getDocument();
				String text = doc.getText(0, doc.getLength());
				int pos = 0;
				int matches = 0;
				while((pos = text.toUpperCase().indexOf(searchText.toUpperCase(), pos)) >= 0){
					check.addHighlight(pos, pos+searchText.length(), hlp);
					matches++;
					pos += searchText.length();
				}
				if(matches == 0){
					JOptionPane.showMessageDialog(null, local.getString("findAndReplace.msgFailedSearch"));
				}
				else{
					JOptionPane.showMessageDialog(null, local.getString("findAndReplace.msgFound") + matches);
				}
			}catch(Exception e){
				
			}
	}

	class HighlightPainter extends DefaultHighlighter.DefaultHighlightPainter{
		public HighlightPainter(Color color) {
			super(color);
		}
	}
	
	public void removeHightlights(JTextComponent textComp){
		Highlighter check = textComp.getHighlighter();
		Highlighter.Highlight[] hLights = check.getHighlights();
		
		for(int i=0; i < hLights.length; i++){
			if(hLights[i].getPainter() instanceof HighlightPainter){
				check.removeHighlight(hLights[i]);
			}
		}
	}

	private void Replace(JTextComponent textComp, String searchText, String replaceText){
		removeHightlights(textComp);
		try{
				Document doc = textComp.getDocument();
				String text = doc.getText(0, doc.getLength());
				StringBuffer sb = new StringBuffer(text);
				int difference = replaceText.length() - searchText.length();
				int offset = 0;
				int tally = 0; 
				int pos = 0;
				
				while((pos = text.toUpperCase().indexOf(searchText.toUpperCase(), pos)) >= 0){
					String temp = text.substring(pos, pos + searchText.length());
					if(temp.equals(searchText)){
						tally++;
						sb.replace(pos + offset, pos + offset + searchText.length(), replaceText);
						offset += difference;
						pos += searchText.length();
					}
				
				textComp.setText(sb.toString());
				textComp.setCaretPosition(0);
				}
				if(tally == 0){
					JOptionPane.showMessageDialog(null, local.getString("findAndReplace.msgFailedSearch"));
				}
				else{
					JOptionPane.showMessageDialog(null, local.getString("findAndReplace.msgReplaced") + tally);
				}
			}catch(Exception e){
				
			}
	}
}