/***********************************************************************
 * Module:  AboutDialog.java
 * Author:  Ivana
 * Purpose: Defines the Class AboutDialog
 ***********************************************************************/

package dialogs;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
 
import localization.Localization;
 
public class AboutDialog extends JDialog{
 
    private static final long serialVersionUID = 1L;
    private static Localization local = Localization.getInstance();
    
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension size = new Dimension(450, 450);
    Dimension dim1 = new Dimension(200, 200);
    Dimension dim2 = new Dimension(400, 180);
    Dimension dim3 = new Dimension(200, 100);
     
    public AboutDialog(JFrame parent) {
        super(parent);
 
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        setTitle(local.getString("aboutDialog.title"));
        setPreferredSize(size);
        setBackground(Color.white);
        setResizable(false);
    
        JLabel image = new JLabel();
        image.setPreferredSize(dim1);
        image.setIcon(new ImageIcon("Icons/Icon.png"));
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 0;
        c.gridy = 0;
        add(image, c);
        
        JPanel right = new JPanel();
        right.setPreferredSize(dim1);
        right.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        
        TitledBorder upBorder = BorderFactory.createTitledBorder(local.getString("aboutDialog.lblStudents"));
        upBorder.setTitleFont(new Font(this.getFont().getFamily(), Font.BOLD, 16));
        upBorder.setTitlePosition(TitledBorder.TOP);  
        
        JTextArea rightTxtArea = new JTextArea();
        rightTxtArea.setPreferredSize(dim3);
        rightTxtArea.setBorder(upBorder);
        rightTxtArea.setAlignmentX(5);
        rightTxtArea.setAlignmentY(5);
        rightTxtArea.setFont(new Font("Arial", Font.ITALIC, 14));
        rightTxtArea.setForeground(Color.BLACK);
        rightTxtArea.setBackground(Color.white);
        rightTxtArea.setEditable(false);
        rightTxtArea.setText(local.getString("aboutDialog.students"));
        
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 0;
        right.add(rightTxtArea, con); 
        
        TitledBorder downBorder = BorderFactory.createTitledBorder(local.getString("aboutDialog.lblMentors"));
        downBorder.setTitleFont(new Font(this.getFont().getFamily(), Font.BOLD, 16));
        downBorder.setTitlePosition(TitledBorder.TOP); 
        
        JTextArea downTxtArea = new JTextArea();
        downTxtArea.setPreferredSize(dim3);
        downTxtArea.setBorder(downBorder);
        downTxtArea.setAlignmentX(5);
        downTxtArea.setAlignmentY(5);
        downTxtArea.setFont(new Font("Arial", Font.ITALIC, 14));
        downTxtArea.setForeground(Color.BLACK);
        downTxtArea.setBackground(Color.white);
        downTxtArea.setEditable(false);
        downTxtArea.setText(local.getString("aboutDialog.mentors"));
        
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 1;
        right.add(downTxtArea, con); 
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        add(right, c);
        
        TitledBorder southBorder = BorderFactory.createTitledBorder(local.getString("aboutDialog.lblAbout"));
        southBorder.setTitleFont(new Font(this.getFont().getFamily(), Font.BOLD, 16));
        southBorder.setTitlePosition(TitledBorder.TOP);
     
        JTextArea southTxtArea = new JTextArea();
        southTxtArea.setPreferredSize(dim2);
        southTxtArea.setBorder(southBorder);
        southTxtArea.setAlignmentX(5);
        southTxtArea.setAlignmentY(5);
        southTxtArea.setFont(new Font("Arial", Font.PLAIN, 14));
        southTxtArea.setForeground(Color.BLACK);
        southTxtArea.setBackground(Color.white);
        southTxtArea.setEditable(false);
        southTxtArea.setText(local.getString("aboutDialog.description"));
         
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        add(southTxtArea, c);
        
        JButton button = new JButton(local.getString("aboutDialog.close"));
        button.addActionListener(listener);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 2;
        add(button, c);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
		setLocation((int)(screen.getWidth()-this.getWidth())/2, (int)(screen.getHeight()- this.getHeight())/2);
        setVisible(true);
    }
     
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            setVisible(false);
            dispose();
        }
    };
}