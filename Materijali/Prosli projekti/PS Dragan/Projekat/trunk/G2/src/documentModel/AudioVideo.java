/***********************************************************************
 * Module:  AudioVideo.java
 * Author:  Natasa
 * Purpose: Defines the Class AudioVideo
 ***********************************************************************/

package documentModel;

import java.util.*;

/** @pdOid 451936a0-bb10-4978-a76a-12bfd3928c75 */
public class AudioVideo extends SlotContent {
   /** @pdOid 135f8aac-5504-47dc-bd40-3e24bdc23bf7 */
   private String name;
   /** @pdOid a830865e-399e-4b93-8371-a0af04ae1a84 */
   private Float lenght;
   
   /** @pdOid 8ff74f7b-6992-4ce0-8e89-608d251a6da0 */
   public void play() {
      // TODO: implement
   }
   
   /** @pdOid 1298b980-ca16-44d8-92ca-7b88f99d2095 */
   public void pause() {
      // TODO: implement
   }
   
   /** @param time
    * @pdOid 76524b9a-ce78-463b-ac7e-326b42cd4bcc */
   public Float rewind(Float time) {
      // TODO: implement
      return null;
   }
   
   /** @param time
    * @pdOid 50dbcf9e-3f45-4285-b66a-bb2f7bfc57a8 */
   public Float forward(Float time) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 7c55c667-82df-4d39-8fab-5f205ed03690 */
   public void stop() {
      // TODO: implement
   }

}