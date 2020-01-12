/***********************************************************************
 * Module:  Video.java
 * Author:  Natasa
 * Purpose: Defines the Class Video
 ***********************************************************************/

package documentModel;

import java.util.*;

/** @pdOid e2ea4e11-32c8-4ece-9f77-36e5c249f943 */
public class Video extends AudioVideo {
   /** @pdOid 5818ae78-cd0a-4e86-9419-62ea9e624bfe */
   private String name;
   /** @pdOid ae15869f-8a53-434e-9071-875ee07a711e */
   private Float lenght;
   
   /** @pdOid 199caf70-3a71-4531-8138-7820601e8721 */
   public Video() {
      // TODO: implement
   }
   
   /** @pdOid 6a5c0bb8-0fbc-40f0-8c93-49ae86e3785b */
   public void play() {
      // TODO: implement
   }
   
   /** @pdOid dd211f56-d6c9-49d6-aa91-e3acc588b89f */
   public void pause() {
      // TODO: implement
   }
   
   /** @param time
    * @pdOid b8044ea1-8939-4a32-aa4f-960c0be75097 */
   public Float rewind(Float time) {
      // TODO: implement
      return null;
   }
   
   /** @param time
    * @pdOid 3b7c37d1-b74f-4627-9348-ac2f591170d0 */
   public Float forward(Float time) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid f8b2a1ed-06d0-4838-9828-18bb9db5a085 */
   public void stop() {
      // TODO: implement
   }

}