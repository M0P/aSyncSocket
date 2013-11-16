package server;

import java.util.Scanner;

import events.AcceptanceEvent;
import events.AcceptanceEventListener;

/**
 * User: Marc Date: 16.11.13 Time: 22:50
 */
public class TestThread extends Thread {

    private int lmaa = 0, counter = 1;
    private String                  incomingMessage;
    private AcceptanceEventListener listener;

    public TestThread(AcceptanceEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            System.out.println(lmaa);
            int x = (int) (Math.random() * 100);
            System.out.println(x);
            if(x == 1) fireEvent("BOOM BOOM ENDE");
            counter++;
            try {
                sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public int getCounter() {
        return counter;
    }

    public void changeLMaa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bla:");
        lmaa += scanner.nextInt();
    }

    // call this method whenever you want to notify
    //the event listeners of the particular event
    private synchronized void fireEvent(String message) {
        AcceptanceEvent event = new AcceptanceEvent(this, message);
        listener.handleMyEventClassEvent(event);
    }
}
