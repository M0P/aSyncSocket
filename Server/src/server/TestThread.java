package server;

import events.AcceptanceEvent;
import events.AcceptanceEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * User: Marc Date: 16.11.13 Time: 22:50
 */
public class TestThread extends Thread {

    private int lmaa = 0;

    @Override
    public void run() {
        super.run();
        while(true) {
            System.out.println(lmaa);
            try {
                sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public void changeLMaa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bla:");
        lmaa += scanner.nextInt();
    }

    private List _listeners = new ArrayList();
    public synchronized void addEventListener(AcceptanceEventListener listener)  {
        _listeners.add(listener);
    }
    public synchronized void removeEventListener(AcceptanceEventListener listener)   {
        _listeners.remove(listener);
    }

    // call this method whenever you want to notify
    //the event listeners of the particular event
    private synchronized void fireEvent() {
        AcceptanceEvent event = new AcceptanceEvent(this);
        Iterator i = _listeners.iterator();
        while(i.hasNext())  {
            ((AcceptanceEventListener) i.next()).handleMyEventClassEvent(event);
        }
    }
}
