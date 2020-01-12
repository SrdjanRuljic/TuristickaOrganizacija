/***********************************************************************
 * Module:  Audio.java
 * Author:  Natasa
 * Purpose: Defines the Class Audio
 ***********************************************************************/

package documentModel;

import java.util.*;

/** @pdOid 292866de-1dba-4e27-8041-3b51b0bab5d4 */
public class Audio extends AudioVideo {
   /** @pdOid e333c42a-8ffb-4aa3-923c-da5a262ebf37 */
   private String name;
   /** @pdOid 7f064bb4-cb68-44a6-9adb-6128cb0b69a1 */
   private Float lenght;
   
   /** @pdOid 3f45cf54-8976-4456-9cc3-17dc6fb816c0 */
   public Audio() {
      // TODO: implement
   }
   
   /** @pdOid 424fbf2d-3d63-48e8-a395-6bb7fa9707d0 */
   public void play() {
      // TODO: implement
   }
   
   /** @pdOid d0208bd3-675e-4ffb-a41b-9abd55b05f00 */
   public void pause() {
      // TODO: implement
   }
   
   /** @param time
    * @pdOid 4116a3aa-3dac-4d9f-bf77-a3541efbe326 */
   public Float rewind(Float time) {
      // TODO: implement
      return null;
   }
   
   /** @param time
    * @pdOid 31749fc9-480f-45ff-bfd6-57afb4b3f8dc */
   public Float forward(Float time) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 331214f5-e3fe-4426-a867-d06c52221207 */
   public void stop() {
      // TODO: implement
   }

}