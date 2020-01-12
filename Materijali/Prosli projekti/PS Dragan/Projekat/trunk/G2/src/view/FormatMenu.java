package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import localization.Localization;

public class FormatMenu extends JMenu {

	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuFormat = new JMenu(local.getString("mnuFormat.title"));
	
	private JMenuItem mnuItemPage;
	private JMenuItem mnuItemTextFormat;
	private JMenuItem mnuItemParagraph;
	private JMenuItem mnuItemTextColor;
	private JMenuItem mnuItemTextBackgroundColor;
	private JMenuItem mnuItemTextFind;
	private JMenuItem mnuItemTextReplace;
	private JMenuItem mnuItemTextLink;
	private JMenuItem mnuItemGraphicsColor;
	private JMenuItem mnuItemGraphicsRotation;
	private JMenuItem mnuItemImageCrop;
	private JMenuItem mnuItemImageFormat;
	private JMenuItem mnuItemImageFrame;
	private JMenuItem mnuItemPlay;
	private JMenuItem mnuItemPause;
	private JMenuItem mnuItemStop;
	private JMenuItem mnuItemRewind;
	private JMenuItem mnuItemForward;
	private JMenuItem mnuItemChartDataEnter;
	private JMenuItem mnuItemChartType;
	private JMenuItem mnuItemChartFormat;

	
	
	public FormatMenu()
	{
		local.registerComponent("mnuFormat.title", mnuFormat);
		mnuFormat.setMnemonic(KeyEvent.VK_O);
		add(mnuFormat);
			
		mnuItemPage = new JMenuItem(local.getString("mnuFormat.page"));
		local.registerComponent("mnuFormat.page", mnuItemPage);
		mnuItemPage.setMnemonic(KeyEvent.VK_P);
		mnuItemPage.setIcon(new ImageIcon("Icons/page_format.png"));
		mnuFormat.add(mnuItemPage);
		
		JMenu mnuText = new JMenu(local.getString("mnuFormat.mnuText.title"));
		local.registerComponent("mnuFormat.mnuText.title", mnuText);
		mnuText.setMnemonic(KeyEvent.VK_T);
		mnuText.setIcon(new ImageIcon("Icons/text.png"));
		
		mnuItemTextFormat = new JMenuItem(local.getString("mnuFormat.mnuText.format"));
		local.registerComponent("mnuFormat.mnuText.format", mnuItemTextFormat);
		mnuItemTextFormat.setMnemonic(KeyEvent.VK_F);
		mnuText.add(mnuItemTextFormat);
		
		mnuItemParagraph = new JMenuItem(local.getString("mnuFormat.mnuText.paragraph"));
		local.registerComponent("mnuFormat.mnuText.paragraph", mnuItemParagraph);
		mnuItemParagraph.setMnemonic(KeyEvent.VK_P);
		mnuText.add(mnuItemParagraph);
		
		mnuItemTextColor = new JMenuItem(local.getString("mnuFormat.mnuText.color"));
		local.registerComponent("mnuFormat.mnuText.color", mnuItemTextColor);
		mnuItemTextColor.setMnemonic(KeyEvent.VK_C);
		mnuText.add(mnuItemTextColor);
		
		mnuItemTextBackgroundColor = new JMenuItem(local.getString("mnuFormat.mnuText.backgroundColor"));
		local.registerComponent("mnuFormat.mnuText.backgroundColor", mnuItemTextBackgroundColor);
		mnuItemTextBackgroundColor.setMnemonic(KeyEvent.VK_C);
		mnuText.add(mnuItemTextBackgroundColor);
		
		mnuItemTextFind = new JMenuItem(local.getString("mnuFormat.mnuText.find"));
		local.registerComponent("mnuFormat.mnuText.find", mnuItemTextFind);
		mnuItemTextFind.setMnemonic(KeyEvent.VK_I);
		mnuText.add(mnuItemTextFind);
		
		mnuItemTextReplace = new JMenuItem(local.getString("mnuFormat.mnuText.replace"));
		local.registerComponent("mnuFormat.mnuText.replace", mnuItemTextReplace);
		mnuItemTextReplace.setMnemonic(KeyEvent.VK_R);
		mnuText.add(mnuItemTextReplace);
		
		mnuItemTextLink = new JMenuItem(local.getString("mnuFormat.mnuText.link"));
		local.registerComponent("mnuFormat.mnuText.link", mnuItemTextLink);
		mnuItemTextLink.setMnemonic(KeyEvent.VK_L);
		mnuText.add(mnuItemTextLink);

		mnuFormat.add(mnuText);
		
		JMenu mnu2dGraphics = new JMenu(local.getString("mnuFormat.mnu2dGraphics.title"));
		local.registerComponent("mnuFormat.mnu2dGraphics.title", mnu2dGraphics);
		mnu2dGraphics.setMnemonic(KeyEvent.VK_G);
		mnu2dGraphics.setIcon(new ImageIcon("Icons/2d_graphics.png"));
		
		mnuItemGraphicsColor = new JMenuItem(local.getString("mnuFormat.mnu2dGraphics.color"));
		local.registerComponent("mnuFormat.mnu2dGraphics.color", mnuItemGraphicsColor);
		mnuItemGraphicsColor.setMnemonic(KeyEvent.VK_C);
		mnu2dGraphics.add(mnuItemGraphicsColor);
		
		mnuItemGraphicsRotation = new JMenuItem(local.getString("mnuFormat.mnu2dGraphics.rotation"));
		local.registerComponent("mnuFormat.mnu2dGraphics.rotation", mnuItemGraphicsRotation);
		mnuItemGraphicsRotation.setMnemonic(KeyEvent.VK_R);
		mnu2dGraphics.add(mnuItemGraphicsRotation);		
		
		mnuFormat.add(mnu2dGraphics);
		
		JMenu mnuImage = new JMenu(local.getString("mnuFormat.mnuImage.title"));
		local.registerComponent("mnuFormat.mnuImage.title", mnuImage);
		mnuImage.setMnemonic(KeyEvent.VK_I);
		mnuImage.setIcon(new ImageIcon("Icons/picture.png"));
		
		mnuItemImageCrop = new JMenuItem(local.getString("mnuFormat.mnuImage.crop"));
		local.registerComponent("mnuFormat.mnuImage.crop", mnuItemImageCrop);
		mnuItemImageCrop.setMnemonic(KeyEvent.VK_C);
		mnuImage.add(mnuItemImageCrop);
		
		mnuItemImageFormat = new JMenuItem(local.getString("mnuFormat.mnuImage.format"));
		local.registerComponent("mnuFormat.mnuImage.format", mnuItemImageFormat);
		mnuItemImageFormat.setMnemonic(KeyEvent.VK_F);
		mnuImage.add(mnuItemImageFormat);
		
		mnuItemImageFrame = new JMenuItem(local.getString("mnuFormat.mnuImage.frame"));
		local.registerComponent("mnuFormat.mnuImage.frame", mnuItemImageFrame);
		mnuItemImageFrame.setMnemonic(KeyEvent.VK_R);
		mnuImage.add(mnuItemImageFrame);	
		
		mnuFormat.add(mnuImage);
		
		JMenu mnuAudioVideo = new JMenu(local.getString("mnuFormat.mnuAudioVideo.title"));
		local.registerComponent("mnuFormat.mnuAudioVideo.title", mnuAudioVideo);
		mnuAudioVideo.setMnemonic(KeyEvent.VK_A);
		mnuAudioVideo.setIcon(new ImageIcon("Icons/video.png"));
		
		mnuItemPlay = new JMenuItem(local.getString("mnuFormat.mnuAudioVideo.play"));
		local.registerComponent("mnuFormat.mnuAudioVideo.play", mnuItemPlay);
		mnuItemImageCrop.setMnemonic(KeyEvent.VK_P);
		mnuAudioVideo.add(mnuItemPlay);
		
		mnuItemPause = new JMenuItem(local.getString("mnuFormat.mnuAudioVideo.pause"));
		local.registerComponent("mnuFormat.mnuAudioVideo.pause", mnuItemPause);
		mnuItemPause.setMnemonic(KeyEvent.VK_F);
		mnuAudioVideo.add(mnuItemPause);
		
		mnuItemStop = new JMenuItem(local.getString("mnuFormat.mnuAudioVideo.stop"));
		local.registerComponent("mnuFormat.mnuAudioVideo.stop", mnuItemStop);
		mnuItemStop.setMnemonic(KeyEvent.VK_R);
		mnuAudioVideo.add(mnuItemStop);	
		
		mnuItemRewind = new JMenuItem(local.getString("mnuFormat.mnuAudioVideo.rewind"));
		local.registerComponent("mnuFormat.mnuAudioVideo.rewind", mnuItemRewind);
		mnuItemRewind.setMnemonic(KeyEvent.VK_F);
		mnuAudioVideo.add(mnuItemRewind);
		
		mnuItemForward = new JMenuItem(local.getString("mnuFormat.mnuAudioVideo.forward"));
		local.registerComponent("mnuFormat.mnuAudioVideo.forward", mnuItemForward);
		mnuItemForward.setMnemonic(KeyEvent.VK_R);
		mnuAudioVideo.add(mnuItemForward);	
		
		mnuFormat.add(mnuAudioVideo);
		
		JMenu mnuChart = new JMenu(local.getString("mnuFormat.mnuChart.title"));
		local.registerComponent("mnuFormat.mnuChart.title", mnuChart);
		mnuChart.setMnemonic(KeyEvent.VK_I);
		mnuChart.setIcon(new ImageIcon("Icons/graph.png"));
		
		mnuItemChartDataEnter = new JMenuItem(local.getString("mnuFormat.mnuChart.dataEnter"));
		local.registerComponent("mnuFormat.mnuChart.dataEnter", mnuItemChartDataEnter);
		mnuItemChartDataEnter.setMnemonic(KeyEvent.VK_D);
		mnuChart.add(mnuItemChartDataEnter);
		
		mnuItemChartType = new JMenuItem(local.getString("mnuFormat.mnuChart.type"));
		local.registerComponent("mnuFormat.mnuChart.type", mnuItemChartType);
		mnuItemChartType.setMnemonic(KeyEvent.VK_T);
		mnuChart.add(mnuItemChartType);
		
		mnuItemChartFormat = new JMenuItem(local.getString("mnuFormat.mnuChart.format"));
		local.registerComponent("mnuFormat.mnuChart.format", mnuItemChartFormat);
		mnuItemChartFormat.setMnemonic(KeyEvent.VK_F);
		mnuChart.add(mnuItemChartFormat);	
		
		mnuFormat.add(mnuChart);

	}
	public void AddListener(ActionListener listener)
	{
		mnuItemPage.addActionListener(listener);
		mnuItemPage.setActionCommand("PageFormat");
		
		mnuItemTextFormat.addActionListener(listener);
		mnuItemTextFormat.setActionCommand("TextFormat");
		
		mnuItemParagraph.addActionListener(listener);
		mnuItemParagraph.setActionCommand("Paragraph");

		mnuItemTextColor.addActionListener(listener);
		mnuItemTextColor.setActionCommand("TextColor");
		
		mnuItemTextBackgroundColor.addActionListener(listener);
		mnuItemTextBackgroundColor.setActionCommand("TextBackgroundColor");
		
		mnuItemTextFind.addActionListener(listener);
		mnuItemTextFind.setActionCommand("TextFind");
		
		mnuItemTextReplace.addActionListener(listener);
		mnuItemTextReplace.setActionCommand("TextReplace");
		
		mnuItemTextLink.addActionListener(listener);
		mnuItemTextLink.setActionCommand("TextLink");
		
		mnuItemGraphicsColor.addActionListener(listener);
		mnuItemGraphicsColor.setActionCommand("GraphicsColor");
		
		mnuItemGraphicsRotation.addActionListener(listener);
		mnuItemGraphicsRotation.setActionCommand("GraphicsRotation");
		
		mnuItemImageCrop.addActionListener(listener);
		mnuItemImageCrop.setActionCommand("ImageCrop");
		
		mnuItemImageFormat.addActionListener(listener);
		mnuItemImageFormat.setActionCommand("ImageFormat");
		
		mnuItemImageFrame.addActionListener(listener);
		mnuItemImageFrame.setActionCommand("ImageFrame");
		
		mnuItemPlay.addActionListener(listener);
		mnuItemPlay.setActionCommand("Play");

		mnuItemPause.addActionListener(listener);
		mnuItemPause.setActionCommand("Pause");
		
		mnuItemStop.addActionListener(listener);
		mnuItemStop.setActionCommand("Stop");
		
		mnuItemRewind.addActionListener(listener);
		mnuItemRewind.setActionCommand("Rewind");
		
		mnuItemForward.addActionListener(listener);
		mnuItemForward.setActionCommand("Forward");

		mnuItemChartDataEnter.addActionListener(listener);
		mnuItemChartDataEnter.setActionCommand("ChartDataEnter");
		
		mnuItemChartType.addActionListener(listener);
		mnuItemChartType.setActionCommand("ChartType");
		
		mnuItemChartFormat.addActionListener(listener);
		mnuItemChartFormat.setActionCommand("ChartFormat");
	}
	
	 public void setIdleState() {
		 	mnuItemPage.setEnabled(false);
	        mnuItemTextFormat.setEnabled(false);
	        mnuItemParagraph.setEnabled(false);
	        mnuItemTextColor.setEnabled(false);
	        mnuItemTextBackgroundColor.setEnabled(false);
	        mnuItemTextFind.setEnabled(false);
	        mnuItemTextReplace.setEnabled(false);
	        mnuItemTextLink.setEnabled(false);
	        mnuItemGraphicsColor.setEnabled(false);
	        mnuItemGraphicsRotation.setEnabled(false);
	        mnuItemImageCrop.setEnabled(false);
	        mnuItemImageFormat.setEnabled(false);
	        mnuItemImageFrame.setEnabled(false);
	        mnuItemPlay.setEnabled(false);
	        mnuItemPause.setEnabled(false);
	        mnuItemStop.setEnabled(false);
	        mnuItemRewind.setEnabled(false);
	        mnuItemForward.setEnabled(false);
	        mnuItemChartDataEnter.setEnabled(false);
	        mnuItemChartType.setEnabled(false);
	        mnuItemChartFormat.setEnabled(false);
	    }

	    public void setEditState() {
	    	mnuItemPage.setEnabled(true);
	        mnuItemTextFormat.setEnabled(true);
	        mnuItemParagraph.setEnabled(true);
	        mnuItemTextColor.setEnabled(true);
	        mnuItemTextBackgroundColor.setEnabled(true);
	        mnuItemTextFind.setEnabled(true);
	        mnuItemTextReplace.setEnabled(true);
	        mnuItemTextLink.setEnabled(true);
	        mnuItemGraphicsColor.setEnabled(true);
	        mnuItemGraphicsRotation.setEnabled(true);
	        mnuItemImageCrop.setEnabled(true);
	        mnuItemImageFormat.setEnabled(true);
	        mnuItemImageFrame.setEnabled(true);
	        mnuItemPlay.setEnabled(true);
	        mnuItemPause.setEnabled(true);
	        mnuItemStop.setEnabled(true);
	        mnuItemRewind.setEnabled(true);
	        mnuItemForward.setEnabled(true);
	        mnuItemChartDataEnter.setEnabled(true);
	        mnuItemChartType.setEnabled(true);
	        mnuItemChartFormat.setEnabled(true);
	    }
}
