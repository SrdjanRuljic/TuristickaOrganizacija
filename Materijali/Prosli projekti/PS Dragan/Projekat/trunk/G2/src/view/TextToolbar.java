/***********************************************************************
 * Module:  TextToolbar.java
 * Author:  Ivana
 * Purpose: Defines the Class TextToolbar
 ***********************************************************************/

package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;

import applicationModel.TextToolbarModel;
import localization.Localization;

public class TextToolbar extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	public TextToolbarModel model;	

	private JButton btnTextBold, btnTextItalic, btnTextUnderline, btnTextColor, btnTextBackground, btnTextAlignLeft, btnTextAlignCenter, btnTextAlignJustify, btnTextAlignRight;
	private JButton btnFindText, btnReplace;
	public JButton btnCutText, btnCopyText, btnPasteText;
	
	public TextToolbar(TextToolbarModel model)
	{
		this.model = model;
		setRollover(true);
		setBorderPainted(true);
		setFloatable(false);
		setOrientation(JToolBar.HORIZONTAL);
		
		Dimension btnDimension = new Dimension(20,20);
		
		/*****Text buttons*****/
		
		btnCutText = new JButton(new ImageIcon("icons/cut.png"));
		btnCutText.setPreferredSize(btnDimension);
		btnCutText.setMinimumSize(btnDimension);
		btnCutText.setActionCommand("CutText");
		btnCutText.setToolTipText(local.getString("toolbarTip.cut"));
		local.registerComponent("toolbarTip.cut", btnCutText);
		add(btnCutText);
		
		btnCopyText = new JButton(new ImageIcon("icons/copy.png"));
		btnCopyText.setPreferredSize(btnDimension);
		btnCopyText.setMinimumSize(btnDimension);
		btnCopyText.setActionCommand("CopyText");
		btnCopyText.setToolTipText(local.getString("toolbarTip.copy"));
		local.registerComponent("toolbarTip.copy", btnCopyText);
		add(btnCopyText);
		
		btnPasteText = new JButton(new ImageIcon("icons/paste.png"));
		btnPasteText.setPreferredSize(btnDimension);
		btnPasteText.setMinimumSize(btnDimension);
		btnPasteText.setActionCommand("PasteText");
		btnPasteText.setToolTipText(local.getString("toolbarTip.paste"));
		local.registerComponent("toolbarTip.paste", btnPasteText);
		add(btnPasteText);
	
		btnTextBold= new JButton(new ImageIcon("icons/text_bold.png"));
		btnTextBold.setPreferredSize(btnDimension);
		btnTextBold.setMinimumSize(btnDimension);
		btnTextBold.setActionCommand("TextBold");
		btnTextBold.setToolTipText(local.getString("toolbarTip.textBold"));
		local.registerComponent("toolbarTip.textBold", btnTextBold);
		add(btnTextBold);
		
		btnTextItalic= new JButton(new ImageIcon("icons/text_italic.png"));
		btnTextItalic.setPreferredSize(btnDimension);
		btnTextItalic.setMinimumSize(btnDimension);
		btnTextItalic.setActionCommand("TextItalic");
		btnTextItalic.setToolTipText(local.getString("toolbarTip.textItalic"));
		local.registerComponent("toolbarTip.textItalic", btnTextItalic);
		add(btnTextItalic);
		
		btnTextUnderline = new JButton(new ImageIcon("icons/text_underline.png"));
		btnTextUnderline.setPreferredSize(btnDimension);
		btnTextUnderline.setMinimumSize(btnDimension);
		btnTextUnderline.setActionCommand("TextUnderline");
		btnTextUnderline.setToolTipText(local.getString("toolbarTip.textUnderline"));
		local.registerComponent("toolbarTip.textUnderline", btnTextUnderline);
		add(btnTextUnderline);
		
		btnTextColor = new JButton(new ImageIcon("icons/text_color.png"));
		btnTextColor.setPreferredSize(btnDimension);
		btnTextColor.setMinimumSize(btnDimension);
		btnTextColor.setActionCommand("TextColor");
		btnTextColor.setToolTipText(local.getString("toolbarTip.textColor"));
		local.registerComponent("toolbarTip.textColor", btnTextColor);
		add(btnTextColor);
		
		btnTextBackground = new JButton(new ImageIcon("icons/text_background.png"));
		btnTextBackground.setPreferredSize(btnDimension);
		btnTextBackground.setMinimumSize(btnDimension);
		btnTextBackground.setActionCommand("TextBackground");
		btnTextBackground.setToolTipText(local.getString("toolbarTip.textBackgroundColor"));
		local.registerComponent("toolbarTip.textBackgroundColor", btnTextBackground);
		add(btnTextBackground);
		
		btnTextAlignLeft = new JButton(new ImageIcon("icons/text_align_left.png"));
		btnTextAlignLeft.setPreferredSize(btnDimension);
		btnTextAlignLeft.setMinimumSize(btnDimension);
		btnTextAlignLeft.setActionCommand("TextAlignLeft");
		btnTextAlignLeft.setToolTipText(local.getString("toolbarTip.textParagraph"));
		local.registerComponent("toolbarTip.textParagraph", btnTextAlignLeft);
		add(btnTextAlignLeft);
		
		btnTextAlignCenter = new JButton(new ImageIcon("icons/text_align_center.png"));
		btnTextAlignCenter.setPreferredSize(btnDimension);
		btnTextAlignCenter.setMinimumSize(btnDimension);
		btnTextAlignCenter.setActionCommand("Center");
		btnTextAlignCenter.setToolTipText(local.getString("toolbarTip.textParagraph"));
		local.registerComponent("toolbarTip.textParagraph", btnTextAlignCenter);
		add(btnTextAlignCenter);
		
		btnTextAlignJustify = new JButton(new ImageIcon("icons/text_align_justify.png"));
		btnTextAlignJustify.setPreferredSize(btnDimension);
		btnTextAlignJustify.setMinimumSize(btnDimension);
		btnTextAlignJustify.setActionCommand("Justify");
		btnTextAlignJustify.setToolTipText(local.getString("toolbarTip.textParagraph"));
		local.registerComponent("toolbarTip.textParagraph", btnTextAlignJustify);
		add(btnTextAlignJustify);
		
		btnTextAlignRight = new JButton(new ImageIcon("icons/text_align_right.png"));
		btnTextAlignRight.setPreferredSize(btnDimension);
		btnTextAlignRight.setMinimumSize(btnDimension);
		btnTextAlignRight.setActionCommand("TextAlignRight");
		btnTextAlignRight.setToolTipText(local.getString("toolbarTip.textParagraph"));
		local.registerComponent("toolbarTip.textParagraph", btnTextAlignRight);
		add(btnTextAlignRight);
		
		addSeparator();
		
		btnFindText = new JButton(new ImageIcon("icons/find.png"));
		btnFindText.setPreferredSize(btnDimension);
		btnFindText.setMinimumSize(btnDimension);
		btnFindText.setActionCommand("Find");
		btnFindText.setToolTipText(local.getString("toolbarTip.textFind"));
		local.registerComponent("toolbarTip.textFind", btnFindText);
		add(btnFindText);
		
		btnReplace = new JButton(new ImageIcon("icons/replace.png"));
		btnReplace.setPreferredSize(btnDimension);
		btnReplace.setMinimumSize(btnDimension);
		btnReplace.setActionCommand("Replace");
		btnReplace.setToolTipText(local.getString("toolbarTip.textReplace"));
		local.registerComponent("toolbarTip.textReplace", btnReplace);
		add(btnReplace);
	}
	
	public void enableButtons(){
		btnCutText.setEnabled(true);
		btnCopyText.setEnabled(true); 
		btnPasteText.setEnabled(true);
		btnTextBold.setEnabled(true);
		btnTextItalic.setEnabled(true); 
		btnTextUnderline.setEnabled(true); 
		btnTextColor.setEnabled(true);
		btnTextBackground.setEnabled(true); 
		btnTextAlignLeft.setEnabled(true);
		btnTextAlignCenter.setEnabled(true);
		btnTextAlignRight.setEnabled(true);
		btnTextAlignJustify.setEnabled(true);
		btnFindText.setEnabled(true);
		btnReplace.setEnabled(true);
	}
	
	public void disableButtons(){
		btnCutText.setEnabled(false);
		btnCopyText.setEnabled(false); 
		btnPasteText.setEnabled(false);
		btnTextBold.setEnabled(false);
		btnTextItalic.setEnabled(false); 
		btnTextUnderline.setEnabled(false); 
		btnTextColor.setEnabled(false);
		btnTextBackground.setEnabled(false); 
		btnTextAlignLeft.setEnabled(false);
		btnTextAlignCenter.setEnabled(false);
		btnTextAlignRight.setEnabled(false);
		btnTextAlignJustify.setEnabled(false);
		btnFindText.setEnabled(false);
		btnReplace.setEnabled(false);
	}
	
	public void setActionListener(ActionListener listener) {
		btnCutText.addActionListener(listener);
		btnCopyText.addActionListener(listener); 
		btnPasteText.addActionListener(listener);
		btnTextBold.addActionListener(listener);
		btnTextItalic.addActionListener(listener); 
		btnTextUnderline.addActionListener(listener);
		btnTextColor.addActionListener(listener);
		btnTextBackground.addActionListener(listener);
		btnTextAlignLeft.addActionListener(listener);
		btnTextAlignCenter.addActionListener(listener);
		btnTextAlignRight.addActionListener(listener);
		btnTextAlignJustify.addActionListener(listener);
		btnFindText.addActionListener(listener);
		btnReplace.addActionListener(listener);
	}

	public void setChangeListener(ChangeListener listener) {
		btnCutText.addChangeListener(listener);
		btnCopyText.addChangeListener(listener); 
		btnPasteText.addChangeListener(listener);
		btnTextBold.addChangeListener(listener);
		btnTextItalic.addChangeListener(listener); 
		btnTextUnderline.addChangeListener(listener);
		btnTextColor.addChangeListener(listener);
		btnTextBackground.addChangeListener(listener);
		btnTextAlignLeft.addChangeListener(listener);
		btnTextAlignCenter.addChangeListener(listener);
		btnTextAlignRight.addChangeListener(listener);
		btnTextAlignJustify.addChangeListener(listener);
		btnFindText.addChangeListener(listener);
		btnReplace.addChangeListener(listener);
	}
}