package events;

import java.util.EventObject;

import server.TestThread;

/**
 * Created with IntelliJ IDEA. User: Xenowar Date: 16.11.13 Time: 22:43 To change this template use File | Settings |
 * File Templates.
 */
public class AcceptanceListener implements AcceptanceEventListener {
    // ... code here

    //implement the required method(s) of the interface
    public void handleMyEventClassEvent(EventObject e) {
        System.out.println(((TestThread) (e).getSource()).getCounter() + " Durchläufe " + ((AcceptanceEvent) e)
                                                                                                  .getMessage());
        System.exit(1);
    }
}
