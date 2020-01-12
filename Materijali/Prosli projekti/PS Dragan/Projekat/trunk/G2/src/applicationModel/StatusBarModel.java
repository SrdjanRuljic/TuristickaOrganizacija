package applicationModel;

import java.util.*;

import documentModel.Document;
import documentModel.Page;
import localization.Localization;
import main.MainClass;

public class StatusBarModel {
	private static Localization local = Localization.getInstance();
	
	private String eastCell = "";
	private String westCell = "";
	private String centerCell = "";
	private int zoomRatio = 50;
	
	public void setEastCell(String text)
	{
		this.eastCell = text;
	}
	
	public String getEastCell() {
		return eastCell;
	}

	public void setWestCell(String text)
	{
		this.westCell = text;
	}

	public String getWestCell() {
		return westCell;
	}

	public void setCenterCell(String text)
	{
		this.centerCell = text;
	}

	public String getCenterCell() {
		return centerCell;
	}
	
	public int getZoomRatio() {
		return zoomRatio;
	}

	public void setZoomRatio(int zoomRatio) {
		if(zoomRatio>0 && zoomRatio<101){
			this.zoomRatio = zoomRatio;
			int i = MainClass.mf.mainPanel.canvasModel.getSelectedNiz();
			if(i!=-1)
			MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(i).getPage().setZoomFactor(zoomRatio);
			}
		}
	
	public void ZoomIncrement()
	{
		setZoomRatio(getZoomRatio()+1);		
		int i = MainClass.mf.mainPanel.canvasModel.getSelectedNiz();
		if(i!=-1)
		MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(i).getPage().setZoomFactor(zoomRatio);
	}
	
	public void ZoomDecrement()
	{
		setZoomRatio(getZoomRatio()-1);
		int i = MainClass.mf.mainPanel.canvasModel.getSelectedNiz();
		if(i!=-1)
		MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(i).getPage().setZoomFactor(zoomRatio);
	}
}