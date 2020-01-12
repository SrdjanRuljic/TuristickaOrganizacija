package viewer.drawing;

import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import controller.drawing.ImageMouseListener;
import controller.drawing.ImageMouseMotionListener;

public class WindowDrawing extends JFrame{
	 
	 
	private static final long serialVersionUID = 1L;
    public static BufferedImage image;
    public static JPanel jPanel;
    public static JPanel jPanelDrawing;
    public static Color color = Color.WHITE;

    public static JLabel imageLabel;
    public static int activeTool;
    public static final int DRAW_TOOL = 1;
    public static final int TEXT_TOOL = 2;

    public static Stroke stroke = new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,1.7f);
    public static RenderingHints renderingHints;
    
	 public WindowDrawing()
	 {
		 setBounds(200, 200, 850, 650);
		 setTitle("Drawing");
		 
		 Toolkit.getDefaultToolkit().getImage("slike/Drawing.png");
		  
	      Map<Key, Object> hintsMap = new HashMap<RenderingHints.Key,Object>();
	      hintsMap.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	      hintsMap.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	      hintsMap.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	      renderingHints = new RenderingHints(hintsMap); 

	      JMenuBar jMenubar = new JMenuBar();
	      jMenubar.add(new MenuFileDrawing());
	      setJMenuBar(jMenubar);
	
	      jPanel = new JPanel(new BorderLayout(4,4));
	      jPanel.setBorder(new EmptyBorder(5,3,5,3));
	      setImage(new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB_PRE)); // RGB je za crnu
	
	      jPanelDrawing = new JPanel(new GridBagLayout());
	      jPanelDrawing.setPreferredSize(new Dimension(600,400));
	      imageLabel = new JLabel(new ImageIcon(image));
	      imageLabel.addMouseMotionListener(new ImageMouseMotionListener());
	      imageLabel.addMouseListener(new ImageMouseListener());
	      jPanelDrawing.add(imageLabel);
	      JScrollPane imageScroll = new JScrollPane(jPanelDrawing);
	      
	      
	      jPanel.add(imageScroll,BorderLayout.CENTER);

	      ToolbarDrawing toolbarDrawing = new ToolbarDrawing();
	      add(toolbarDrawing, BorderLayout.NORTH);

	      add(jPanel, BorderLayout.CENTER);
	      clear(new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB_PRE)); 
	      
	      setVisible(true);
}

	public static void setImage(BufferedImage image1)
	{
		int w = image1.getWidth();
		int h = image1.getHeight();
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB_PRE);
		
		Graphics2D g = image.createGraphics();
		g.setRenderingHints(renderingHints);
		g.drawImage(image, 0, 0, jPanel);
		g.dispose();

		
		if (imageLabel!=null)
		{
			imageLabel.setIcon(new ImageIcon(image));
        imageLabel.repaint();
		}
		if (jPanel!=null)
		{
			jPanel.invalidate();
    }
}
	
	 public static void setColor(Color color1) {
	       color = color1;
	       //clear(colorSample);
	    }
	 
	 public static void text(Point point)
	 {
		 String text = JOptionPane.showInputDialog(jPanel, "Text to add", "Text");
		 if (text!=null)
		 {
			 Graphics2D g = image.createGraphics();
			 g.setRenderingHints(renderingHints);
	         g.setColor(color);
	         g.setStroke(stroke);
	         int n = 0;
	         g.drawString(text,point.x,point.y);
	         g.dispose();
	         imageLabel.repaint();
	     }
	
	 }
	 
	 public static void draw(Point point)
	 {
	    Graphics2D g = image.createGraphics();
	    g.setRenderingHints(renderingHints);
	    g.setColor(color);
	    g.setStroke(stroke);
	    int n = 0;
	    g.drawLine(point.x, point.y, point.x+n, point.y+n);
	    g.dispose();
	    imageLabel.repaint();
	 }
	    
	    public static void clear(BufferedImage bi) {
	        Graphics2D g = bi.createGraphics();
	        g.setRenderingHints(renderingHints);
	        g.setColor(Color.WHITE);
	        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());

	        g.dispose();
	        imageLabel.repaint();
	    }

}
