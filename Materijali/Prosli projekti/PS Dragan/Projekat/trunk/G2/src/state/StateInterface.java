package state;

import view.MainFrame;
import java.util.*;

public interface StateInterface {
   String getStateName();
   void idle(MainFrame context);
   void edit(MainFrame context);
   void save(MainFrame context);
   void update(MainFrame context);
   void selection(MainFrame context);
   void closing(MainFrame context);

}