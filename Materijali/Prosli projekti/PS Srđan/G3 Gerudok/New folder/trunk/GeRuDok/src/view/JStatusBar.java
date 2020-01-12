package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JStatusBar extends javax.swing.JPanel {
   private static final long serialVersionUID = 1L;
   
   public JLabel stanje = null;
   public JLabel koordinate = null;
   
   public JStatusBar() {    
          setLayout(new GridLayout(1,3));
          setPreferredSize(new Dimension(getWidth(), 33));
   
       
          stanje=new JLabel("READY");
   
          stanje.setForeground(Color.RED);
          add(stanje);
          
          
          
          koordinate=new JLabel("Koordinate:  ");
          koordinate.setForeground(Color.RED);
          add(koordinate,BorderLayout.SOUTH);
          
          Calendar cal = Calendar.getInstance();
          SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
          
         
          JLabel tajmer=new JLabel("Vrijeme pokretanja aplikacije:     "+sdf.format(cal.getTime()));
          tajmer.setHorizontalAlignment(2);
          tajmer.setForeground(Color.RED);
          add(tajmer);
         
          
          
        
      }
   
   /** @param text */
   public void setKoordinate(String text) {
   	koordinate.setText(text);
   }

}