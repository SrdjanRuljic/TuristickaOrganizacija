/***********************************************************************
 * Module:  Apstraktnidokument.java
 * Author:  Natasa
 * Purpose: Defines the Class Apstraktnidokument
 ***********************************************************************/

package documentModel;

import java.util.*;

/** Apstraktna klasa dokument koja može biti radni prostor, projekat ili dokument
 * 
 * @pdOid 2ecb2ae4-33eb-4014-8be3-fa4135b11eb4 */
public abstract class Apstraktnidokument {
   /** @pdOid 4b27c40b-948a-46a9-b037-1d08a8a79828 */
   private String documentName;
   /** @pdOid d43c4c50-0068-4fc3-966e-e1a374cc146a */
   private String location;
   /** @pdOid f096d037-b782-4b0c-a89b-290724732e54 */
   private Date created;
   /** @pdOid 9f4f9edb-3901-418e-818d-aebd0569bc73 */
   private Date modified;
   
   /** @param ime
    * @pdOid ccee612a-f2bf-4ace-b684-456e4ccab26f */
   public abstract void rename();
   /** @pdOid 7176e6d3-fd6a-4287-889f-0bcdacf72675 */
   public abstract Boolean delete();
   /** @pdOid 2fae02dd-4f49-4810-8a46-e35d6502994d */
   public abstract void close();
   /** @pdOid 9cdb2a14-ddc4-4933-82b0-25926e18c5dd */
   public abstract Boolean save();
   /** @param name 
    * @param location
    * @pdOid 153ad8f6-6368-41ff-9ddc-a762ee396267 */
   public Boolean saveAs(String name, String location) {
      // TODO: implement
      return null;
   }
   
   /** @param name 
    * @param location
    * @pdOid 5c902f88-e5d2-4076-832b-511638d0e520 */
   public void open(String name, String location) {
      // TODO: implement
   }
   
   /** Metoda importovanja se može implementirati unutar Workspace-a i Project-a.
    * 
    * @param name 
    * @param location
    * @pdOid c5eac258-ef86-4f4b-b9f7-848a17f68d00 */
   public void importing(String name, String location) {
      // TODO: implement
   }
   
   /** Metoda exportovanja se može implementirati unutar Workspace-a i Project-a.
    * 
    * @param name 
    * @param location
    * @pdOid f11e660a-d60c-43e7-adbe-1d129619f1a1 */
   public void exporting(String name, String location) {
      // TODO: implement
   }

}