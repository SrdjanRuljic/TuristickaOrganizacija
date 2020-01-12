/***********************************************************************
 * Module:  Command.java
 * Author:  draga_000
 * Purpose: Defines the Interface Command
 ***********************************************************************/

package command;

import java.util.*;

/** @pdOid c08c3e28-5c19-4d8f-9014-cc175d49fe16 */
public interface Command {
   /** @pdOid 1af8d83a-5509-4a0c-9a51-05c6c31b450a */
   void execute(Boolean b);
   /** @pdOid 8c6f534f-8402-48d1-963f-b27515c0eaa6 */
   void unexecute();

}