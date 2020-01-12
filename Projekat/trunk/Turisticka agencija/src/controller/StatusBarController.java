/***********************************************************************
 * Module:  StatusBarController.java
 * Author:  draga_000
 * Purpose: Defines the Class StatusBarController
 ***********************************************************************/

package controller;

import view.StatusBar;
import model.StatusBarModel;
import java.util.*;

/** @pdOid 45ef7d6c-e480-44d5-9c86-56259424db02 */
public class StatusBarController {
   /** @pdRoleInfo migr=no name=StatusBar assc=statusBarControllerHasStatusBar mult=1..1 */
   public StatusBar statusBar;
   /** @pdRoleInfo migr=no name=StatusBarModel assc=statusBarControllerHasStatusBarModel mult=1..1 */
   public StatusBarModel statusBarModel;
   
   public StatusBarController(StatusBarModel model, StatusBar view)
   {
	   statusBar=view;
	   statusBarModel=model;
	   view.Update();
   }
}