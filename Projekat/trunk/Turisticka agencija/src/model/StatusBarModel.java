/***********************************************************************
 * Module:  StatusBarModel.java
 * Author:  draga_000
 * Purpose: Defines the Class StatusBarModel
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 11e55555-8ff7-4c7b-8160-2d6848de5c86 */
public class StatusBarModel {
	private String cellTable = "";
	private String cellState = "";
	private String cellRow = "";
	
	public String getCurrentTable() {
		// TODO Auto-generated method stub
		return cellTable;
	}
	public void setCurrentTable(String currentTable) {
		// TODO Auto-generated method stub
		cellTable=currentTable;
	}
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return cellState;
	}
	public void setCurrentState(String currentState) {
		// TODO Auto-generated method stub
		cellState=currentState;
	}
	public String getCurrentRow() {
		// TODO Auto-generated method stub
		return cellRow;
	}
	public void setCurrentRow(String currentRow) {
		// TODO Auto-generated method stub
		cellRow=currentRow;
	}
}