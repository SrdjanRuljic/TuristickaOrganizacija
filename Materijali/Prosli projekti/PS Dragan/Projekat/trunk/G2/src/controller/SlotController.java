package controller;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import applicationModel.SlotModel;
import documentModel.Slot;
import localization.Localization;
import main.MainClass;

public class SlotController {
	
	private static Localization local = Localization.getInstance();
	
	public int x;
	public int y;
	
	public Slot view;
	public SlotModel model;
	Boolean borderSelected;

	public SlotController(Slot view, SlotModel model){
		this.view = view;
		this.model = model;
		
		view.addListeners(ml,mml);
	}
	
	public SlotController copySlotController(){
		Slot view = this.view.copySlot();
		SlotController sc = new SlotController(view, model);
		sc.x = this.x;
		sc.y = this.y;
		sc.borderSelected = this.borderSelected;
		return sc;
	}


	
	MouseListener ml = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){
				Object[] options1 = {local.getString("slot.text") , local.getString("slot.2Dgraphics")};
				
				int result = JOptionPane.showOptionDialog(null, local.getString("slot.message"), local.getString("slot.chooseElement"),
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
				
				if (result == JOptionPane.YES_OPTION)
				{
					view.makeText();
					
				}
				
				else if(result == JOptionPane.NO_OPTION)
				{
					view.make2D();
				}

				MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage().Update();
			}	
			else if(SwingUtilities.isRightMouseButton(e)){
				//dodati properties dialog
				}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent ee) {
			// TODO Auto-generated method stub
			MainClass.mf.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		@Override
		public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				if(checkForBroder(x, y) == 0)
					borderSelected = false;
				else 
					borderSelected = true;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if((e.getX()!=x || e.getY()!=y) && borderSelected == false){
				x = e.getX()-x;
				y = e.getY() - y;
				view.setRealPositionX(view.getRealPositionX()+x);
				view.setRealPositionY(view.getRealPositionY()+y);
			}
			else if(e.getX()==x && e.getY()==y){
				view.selected = !view.selected;
			}
			else if(borderSelected == true){
				SetNewSize(e.getPoint());
			}
			MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage().model.returnSelectedSlots();
			MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage().Update();
			
		}
		
	};
	
	public int checkForBroder(int x,int y){
		int m=0;
		
		if(x<10 || (x>view.getWidth()-10 && x<view.getWidth()))
			m++;
		else if(y<10 || (y>view.getHeight()-10 && y<view.getHeight()))
			m++;

		return m;
	}
	
	public void SetNewSize(Point p){
		//Donji desni ugao
		if(x>view.getWidth()-10 && y>view.getHeight()-10)
		{
			view.setRealHeight(view.getRealHeight()+(int)(p.getY()-y));
			view.setRealWidth(view.getRealWidth()+(int)(p.getX()-x));
		}
		
		//Donji lijevi ugao
		else if(x<10 && y>view.getHeight()-10)
		{
			view.setRealHeight(view.getRealHeight()+(int)(p.getY()-y));
			view.setRealWidth(view.getRealWidth()-(int)(p.getX()-x));
			view.setRealPositionX(view.getRealPositionX()+(int)(p.getX()-x));
		}
		
		//Gornji lijevi ugao
		else if(x<10 && y<10)
		{
			view.setRealHeight(view.getRealHeight()-(int)(p.getY()-y));
			view.setRealWidth(view.getRealWidth()-(int)(p.getX()-x));
			view.setRealPositionX(view.getRealPositionX()+(int)(p.getX()-x));
			view.setRealPositionY(view.getRealPositionY()+(int)(p.getY()-y));
		}
		
		//Gornji desni ugao
		else if(x>view.getWidth()-10 && y<10)
		{
			view.setRealHeight(view.getRealHeight()-(int)(p.getY()-y));
			view.setRealWidth(view.getRealWidth()+(int)(p.getX()-x));
			view.setRealPositionY(view.getRealPositionY()+(int)(p.getY()-y));
		}
		
		//Lijeva ivica
		else if(x<10 && y>10 && y<view.getHeight()-10)
		{
			view.setRealWidth(view.getRealWidth()-(int)(p.getX()-x));
			view.setRealPositionX(view.getRealPositionX()+(int)(p.getX()-x));
		}
		
		//Gornja ivica
		else if(y<10 && x>10 && x<view.getWidth()-10)
		{
			view.setRealHeight(view.getRealHeight()-(int)(p.getY()-y));
			view.setRealPositionY(view.getRealPositionY()+(int)(p.getY()-y));
		}
		
		//Desna ivica
		else if(x>view.getWidth()-10 && y>10 && y<view.getWidth()-10)
		{
			view.setRealWidth(view.getRealWidth()+(int)(p.getX()-x));	
		}
		
		//Donja ivica
		else if(y>view.getHeight()-10 && x>10 && x<view.getWidth()-10)
		{
			view.setRealHeight(view.getRealHeight()+(int)(p.getY()-y));
		}

	}
	
	MouseMotionListener mml = new MouseMotionListener(){

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if((e.getX()>view.getWidth()-10 && e.getY()<10)||(e.getX()<10 && e.getY()>view.getHeight()-10)){
				MainClass.mf.setCursor (new Cursor(7));
			}
			else if((e.getX()>view.getWidth()-10 && e.getY()>view.getHeight()-10)||(e.getX()<10 && e.getY()<10)){
				MainClass.mf.setCursor (new Cursor(6));
				}
			else if((e.getY()<10 && e.getX()>10 && e.getX()<view.getWidth()-10)||(e.getY()>view.getHeight()-10 && e.getX()>10 && e.getX()<view.getWidth()-10)){
				MainClass.mf.setCursor (new Cursor(8));
				}
			else if((e.getX()<10 && e.getY()>10 && e.getY()<view.getHeight()-10)||(e.getX()>view.getWidth()-10 && e.getY()>10 && e.getY()<view.getWidth()-10)){
				MainClass.mf.setCursor (new Cursor(11));
				}
			else{
				MainClass.mf.setCursor (new Cursor(13));
				}	
		}

	};
}
