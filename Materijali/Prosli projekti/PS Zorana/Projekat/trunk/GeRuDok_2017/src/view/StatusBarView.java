package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBarView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel statusTxt = new JLabel();
	private String statusTabela = new String("Model: selection");
	
	private JLabel shape = new JLabel();
	private String shapeLabela = new String("Shape: ID=33, w=34, h=66, angle=0      ");
	
	private JLabel koordinate = new JLabel();
	private String koordinateLabela = new String("x=56, y=33");
	
	public StatusBarView() {
		
		super();
		setLayout(new BorderLayout());
		
		JPanel statusBar = new JPanel(new BorderLayout());
		
		JPanel left = new JPanel();
		
		JPanel element = new JPanel(new GridLayout());
		
		element.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		statusTxt.setText(statusTabela);
		element.add(statusTxt);
		
		shape.setText(shapeLabela);
		element.add(shape);
		
		koordinate.setText(koordinateLabela);
		element.add(koordinate);
		
		left.add(element);
		
		statusBar.add(left, BorderLayout.WEST);
		
		add(statusBar);
		
	}
	
	
   public void update() {
      // TODO: implement
   }

}