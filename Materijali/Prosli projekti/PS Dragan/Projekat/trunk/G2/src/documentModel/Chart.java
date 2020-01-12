/***********************************************************************
 * Module:  Chart.java
 * Author:  Natasa
 * Purpose: Defines the Class Chart
 ***********************************************************************/

package documentModel;

import java.util.*;

/** @pdOid a8f2c06e-f7db-47ff-8439-fbe5d66f482c */
public class Chart extends SlotContent {
   /** @pdOid 6653d324-7592-4a50-ab0a-e70c6bfaeab2 */
   private String name;
   /** @pdOid 8bbf447b-9ef4-4805-a393-c0c97bbcb28e */
   private String type;
   
   /** @pdOid d332ea85-9229-41d4-a9d2-63fe46d6835d */
   public Chart() {
      // TODO: implement
   }
   
   /** @pdOid eade06ae-4d0b-4d4a-9cd4-1dd242f21caf */
   public void enterData() {
      // TODO: implement
   }
   
   /** @pdOid 1f4a27b0-1989-423a-a4b6-b9c91e8fa927 */
   public String getType() {
      return type;
   }
   
   /** @param newType
    * @pdOid dbfe7f89-67d3-469c-a073-5b204ec2a07e */
   public void setType(String newType) {
      type = newType;
   }

}