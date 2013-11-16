package server;

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
        lmaa += scanner.nextInt();
    }
}
