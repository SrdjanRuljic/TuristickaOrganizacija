package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


import localization.Localization;

public class InsertMenu extends JMenu {

	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuInsert = new JMenu(local.getString("mnuInsert.title"));
	
	private JMenuItem mnuItemNewSlot;
	private JMenuItem mnuItemNewText;
	private JMenuItem mnuItemNew2dGraphics;
	private JMenuItem mnuItemNewImage;
	private JMenuItem mnuItemNewAudio;
	private JMenuItem mnuItemNewVideo;
	private JMenuItem mnuItemNewChart;

	public InsertMenu()
	{
		local.registerComponent("mnuInsert.title", mnuInsert);
		mnuInsert.setMnemonic(KeyEvent.VK_I);
		add(mnuInsert);
		
		mnuItemNewSlot = new JMenuItem(local.getString("mnuInsert.slot"));
		local.registerComponent("mnuInsert.slot", mnuItemNewSlot);
		mnuItemNewSlot.setMnemonic(KeyEvent.VK_S);
		mnuItemNewSlot.setIcon(new ImageIcon("Icons/slot.png"));
		mnuInsert.add(mnuItemNewSlot);
		
		JMenu mnuElement = new JMenu (local.getString("mnuInsert.mnuElement.title"));
		local.registerComponent("mnuInsert.mnuElement.title", mnuElement);
		mnuElement.setMnemonic(KeyEvent.VK_E);
		
		mnuItemNewText = new JMenuItem(local.getString("mnuInsert.mnuElement.text"));
		local.registerComponent("mnuInsert.mnuElement.text", mnuItemNewText);
		mnuItemNewText.setMnemonic(KeyEvent.VK_T);
		mnuItemNewText.setIcon(new ImageIcon("Icons/text.png"));
		mnuElement.add(mnuItemNewText);
		
		mnuItemNew2dGraphics = new JMenuItem(local.getString("mnuInsert.mnuElement.graphics2d"));
		local.registerComponent("mnuInsert.mnuElement.graphics2d", mnuItemNew2dGraphics);
		mnuItemNew2dGraphics.setMnemonic(KeyEvent.VK_G);
		mnuItemNew2dGraphics.setIcon(new ImageIcon("Icons/2d_graphics.png"));
		mnuElement.add(mnuItemNew2dGraphics);
		
		mnuItemNewImage = new JMenuItem(local.getString("mnuInsert.mnuElement.image"));
		local.registerComponent("mnuInsert.mnuElement.image", mnuItemNewImage);
		mnuItemNewImage.setMnemonic(KeyEvent.VK_I);
		mnuItemNewImage.setIcon(new ImageIcon("Icons/picture.png"));
		mnuElement.add(mnuItemNewImage);
		
		mnuItemNewAudio = new JMenuItem(local.getString("mnuInsert.mnuElement.audio"));
		local.registerComponent("mnuInsert.mnuElement.audio", mnuItemNewAudio);
		mnuItemNewAudio.setMnemonic(KeyEvent.VK_A);
		mnuItemNewAudio.setIcon(new ImageIcon("Icons/audio.png"));
		mnuElement.add(mnuItemNewAudio);
		
		mnuItemNewVideo = new JMenuItem(local.getString("mnuInsert.mnuElement.video"));
		local.registerComponent("mnuInsert.mnuElement.video", mnuItemNewVideo);
		mnuItemNewVideo.setMnemonic(KeyEvent.VK_V);
		mnuItemNewVideo.setIcon(new ImageIcon("Icons/video.png"));
		mnuElement.add(mnuItemNewVideo);
		
		mnuItemNewChart = new JMenuItem(local.getString("mnuInsert.mnuElement.chart"));
		local.registerComponent("mnuInsert.mnuElement.chart", mnuItemNewChart);
		mnuItemNewChart.setMnemonic(KeyEvent.VK_C);
		mnuItemNewChart.setIcon(new ImageIcon("Icons/graph.png"));
		mnuElement.add(mnuItemNewChart);
		
		mnuInsert.add(mnuElement);
		
	}
	
	public void AddListener(ActionListener listener)
	{		
		mnuItemNewSlot.addActionListener(listener);
		mnuItemNewSlot.setActionCommand("NewSlot");
		
		mnuItemNewText.addActionListener(listener);
		mnuItemNewText.setActionCommand("NewText");
		
		mnuItemNew2dGraphics.addActionListener(listener);
		mnuItemNew2dGraphics.setActionCommand("New2dGraphics");
		
		mnuItemNewImage.addActionListener(listener);
		mnuItemNewImage.setActionCommand("NewImage");
		
		mnuItemNewAudio.addActionListener(listener);
		mnuItemNewAudio.setActionCommand("NewAudio");
		
		mnuItemNewVideo.addActionListener(listener);
		mnuItemNewVideo.setActionCommand("NewVideo");
		
		mnuItemNewChart.addActionListener(listener);
		mnuItemNewChart.setActionCommand("NewChart");
	}
	
	public void setIdleState() {
        mnuItemNewSlot.setEnabled(false);
        mnuItemNewText.setEnabled(false);
        mnuItemNew2dGraphics.setEnabled(false);
        mnuItemNewImage.setEnabled(false);
        mnuItemNewAudio.setEnabled(false);
        mnuItemNewVideo.setEnabled(false);
        mnuItemNewChart.setEnabled(false);
    }
 
    public void setEditState() {
        mnuItemNewSlot.setEnabled(true);
        mnuItemNewText.setEnabled(true);
        mnuItemNew2dGraphics.setEnabled(true);
        mnuItemNewImage.setEnabled(true);
        mnuItemNewAudio.setEnabled(true);
        mnuItemNewVideo.setEnabled(true);
        mnuItemNewChart.setEnabled(true);
    }
}
