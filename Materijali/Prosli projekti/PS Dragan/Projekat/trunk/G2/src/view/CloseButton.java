package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

import applicationModel.CanvasModel;
import controller.CanvasController;
import main.MainClass;




public class CloseButton extends JButton implements ActionListener{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public CloseButton()
		{
            int size = 17;
            
            setPreferredSize(new Dimension(size, size));
            setToolTipText("close this tab");
            //Make the button looks the same for all Laf's
            setUI(new BasicButtonUI());
            //Make it transparent
            setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
           // setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            //addMouseListener(new CustomMouseListener());            
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
        }

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MainClass.mf.mainPanel.canvasModel.closeTab();
		}
}