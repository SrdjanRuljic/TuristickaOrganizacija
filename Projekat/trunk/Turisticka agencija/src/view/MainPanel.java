/***********************************************************************
 * Module:  MainPanel.java
 * Author:  draga_000
 * Purpose: Defines the Class MainPanel
 ***********************************************************************/

package view;

import java.util.*;

import view.DatabaseBrowser.DatabaseBrowser;

/** @pdOid b3862286-8dd0-448b-9479-641466e598d8 */
public class MainPanel {
   /** @pdRoleInfo migr=no name=Toolbar assc=mainPanelContainsToolbar mult=1..1 type=Composition */
   public Toolbar toolbar;
   /** @pdRoleInfo migr=no name=DatabaseBrowser assc=mainPanelContainsDatabaseBrowser mult=1..1 type=Composition */
   public DatabaseBrowser databaseBrowser;
   /** @pdRoleInfo migr=no name=TablePreview assc=mainPanelContainsTablePreview mult=1..1 type=Composition */
   public TablePreview tablePreview;
   /** @pdRoleInfo migr=no name=InputPanel assc=mainPanelContainsInputPanel mult=1..1 type=Composition */
   public InputPanel inputPanel;

}