package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JToolBar;

import controller.ToolbarListener;

public class Toolbar extends JToolBar {
	
	private static final long serialVersionUID = 1L;

	JButton buttonFirst;
	JButton buttonNext;
	JButton buttonPrevious;
	JButton buttonLast;
	
	JButton buttonNew;
	JButton buttonEdit;
	JButton buttonDelete;
	
	JButton buttonAccept;
	JButton buttonCancel;
	
	JButton buttonReport;
	
	ToolbarListener toolbarListener;
	JTable table;
	
	public Toolbar()
	{
		super(JToolBar.HORIZONTAL);
		toolbarListener = new ToolbarListener();
		
		addToolbar();
	}
	
	public Toolbar(JTable table)
	{
		super(JToolBar.HORIZONTAL);
		this.table = table;
		toolbarListener = new ToolbarListener(table);
		
		addToolbar();
	}
	
	private void addToolbar()
	{
		
		setRollover(true);
		
		setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		buttonFirst = new JButton(new ImageIcon("Ikonice/first-icon.png"));
		buttonFirst.setToolTipText("First");
		buttonFirst.setActionCommand("first");
		buttonFirst.addActionListener(toolbarListener);
		add(buttonFirst);
		
		buttonPrevious = new JButton(new ImageIcon("Ikonice/previous-icon.png"));
		buttonPrevious.setToolTipText("Previous");
		buttonPrevious.setActionCommand("previous");
		buttonPrevious.addActionListener(toolbarListener);
		add(buttonPrevious);
		
		buttonNext = new JButton(new ImageIcon("Ikonice/next-icon.png"));
		buttonNext.setToolTipText("Next");
		buttonNext.setActionCommand("next");
		buttonNext.addActionListener(toolbarListener);
		add(buttonNext);
		
		buttonLast = new JButton(new ImageIcon("Ikonice/last-icon.png"));
		buttonLast.setToolTipText("Last");
		buttonLast.setActionCommand("last");
		buttonLast.addActionListener(toolbarListener);
		add(buttonLast);
		addSeparator();
		
		buttonNew = new JButton(new ImageIcon("Ikonice/new-icon.png"));
		buttonNew.setToolTipText("New");
		buttonNew.setActionCommand("new");
		buttonNew.addActionListener(toolbarListener);
		add(buttonNew);
		
		buttonEdit = new JButton(new ImageIcon("Ikonice/edit-icon.png"));
		buttonEdit.setToolTipText("Edit");
		buttonEdit.setActionCommand("edit");
		buttonEdit.addActionListener(toolbarListener);
		add(buttonEdit);
		
		buttonDelete = new JButton(new ImageIcon("Ikonice/delete-icon.png"));
		buttonDelete.setToolTipText("Delete");
		buttonDelete.setActionCommand("delete");
		buttonDelete.addActionListener(toolbarListener);
		add(buttonDelete);
		addSeparator();
		
		buttonAccept = new JButton(new ImageIcon("Ikonice/accept-icon.png"));
		buttonAccept.setToolTipText("Accept");
		buttonAccept.setActionCommand("accept");
		buttonAccept.addActionListener(toolbarListener);
		add(buttonAccept);
		
		buttonCancel = new JButton(new ImageIcon("Ikonice/cancel-icon.png"));
		buttonCancel.setToolTipText("Cancel");
		buttonCancel.setActionCommand("cancel");
		buttonCancel.addActionListener(toolbarListener);
		add(buttonCancel);
		addSeparator();
		
		buttonReport = new JButton(new ImageIcon("Ikonice/report-icon.png"));
		buttonReport.setToolTipText("Report");
		buttonReport.setActionCommand("report");
		buttonReport.addActionListener(toolbarListener);
		add(buttonReport);
	}
}