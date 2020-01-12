package controller;

import view.PrimaryView;
import model.WorkspaceModel;
import java.util.ArrayList;
import java.util.List;

import model.ProjectModel;

/**
 * Klasa predstavlja glavni kontroler u kom se instanciraju ostali kontorleri
 * 
 * @author Milos Nikolic
 */
public class PrimaryController
{
	private PrimaryView primaryView;
	private WorkspaceModel dataModel;

	/**
	 * Konstruktor klase {@link PrimaryController}
	 * 
	 * @param view
	 *            Glavni pogled
	 * @param model
	 *            Glavni model
	 */
	public PrimaryController(PrimaryView view, WorkspaceModel model)
	{

		this.primaryView = view;
		this.dataModel = model;

		MenuBarControler mbBarControler = new MenuBarControler(primaryView, dataModel);

	}

}