package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen {
  public SplashScreen() {
    
	  JPanel p = new JPanel();
	  p.setOpaque(true);
	  p.setBackground(Color.white);

	ImageIcon icon = new ImageIcon("icons/GeRuDokSplash.gif");
	JLabel label = new JLabel(icon);
      p.add(label);
	  JWindow jwin = new JWindow();
    jwin.getContentPane()
        .add(p);
        	
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    jwin.setSize(new Dimension(600,500));
    jwin.setLocation((int)(dim.getWidth()-jwin.getWidth())/2, (int)(dim.getHeight()- jwin.getHeight())/2);
	jwin.setVisible(true);

    try {
      Thread.sleep(4500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    jwin.setVisible(false);
    jwin.dispose();

  }
}