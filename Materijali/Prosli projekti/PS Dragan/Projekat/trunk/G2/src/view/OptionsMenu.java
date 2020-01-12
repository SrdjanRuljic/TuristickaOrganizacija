/***********************************************************************
 * Module:  OptionsMenu.java
 * Author:  Natasa
 * Purpose: Defines the Class OptionsMenu
 ***********************************************************************/

package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import localization.Localization;

/** @pdOid e9308d03-4a52-4448-879f-e21a1f69bfd9 */
public class OptionsMenu extends JMenu{

	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuOptions = new JMenu(local.getString("mnuOptions.title"));
	
	private JMenuItem mnuItemCustomize;
	private JMenuItem mnuItemEnglish;
	private JMenuItem mnuItemSerbian;
	private JMenuItem mnuItemBosnian;
	
	public OptionsMenu()
	{
		local.registerComponent("mnuOptions.title", mnuOptions);
		add(mnuOptions);
		mnuOptions.setMnemonic(KeyEvent.VK_T);
		
		mnuItemCustomize = new JMenuItem(local.getString("mnuOptions.customize"));
		local.registerComponent("mnuOptions.customize", mnuItemCustomize);
		mnuItemCustomize.setMnemonic(KeyEvent.VK_C);
		mnuItemCustomize.setIcon(new ImageIcon("Icons/settings.png"));
		mnuOptions.add(mnuItemCustomize);

		mnuOptions.addSeparator();
		
		JMenu mnuLanguage = new JMenu(local.getString("mnuOptions.mnuLanguage.title"));
		local.registerComponent("mnuOptions.mnuLanguage.title", mnuLanguage);
		mnuLanguage.setMnemonic(KeyEvent.VK_L);
		mnuLanguage.setIcon(new ImageIcon("Icons/language.png"));

		mnuItemEnglish = new JMenuItem(local.getString("mnuOptions.mnuLanguage.english"));
		local.registerComponent("mnuOptions.mnuLanguage.english", mnuItemEnglish);
		mnuItemEnglish.setMnemonic(KeyEvent.VK_E);
		mnuLanguage.add(mnuItemEnglish);
		
		mnuItemSerbian = new JMenuItem(local.getString("mnuOptions.mnuLanguage.serbian"));
		local.registerComponent("mnuOptions.mnuLanguage.serbian", mnuItemSerbian);
		mnuItemSerbian.setMnemonic(KeyEvent.VK_S);
		mnuLanguage.add(mnuItemSerbian);
		
		mnuItemBosnian = new JMenuItem(local.getString("mnuOptions.mnuLanguage.bosnian"));
		local.registerComponent("mnuOptions.mnuLanguage.bosnian", mnuItemBosnian);
		mnuItemBosnian.setMnemonic(KeyEvent.VK_B);
		mnuLanguage.add(mnuItemBosnian);
		
		mnuOptions.add(mnuLanguage);
	}
	public void AddListener(ActionListener listener)
	{
		mnuItemCustomize.addActionListener(listener);
		mnuItemCustomize.setActionCommand("Customize");
		
		mnuItemEnglish.addActionListener(listener);
		mnuItemEnglish.setActionCommand("English");
		
		mnuItemSerbian.addActionListener(listener);
		mnuItemSerbian.setActionCommand("Serbian");
		
		mnuItemBosnian.addActionListener(listener);
		mnuItemBosnian.setActionCommand("Bosnian");
	}
}