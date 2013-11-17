package server;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * User: Marc Date: 16.11.13 Time: 22:50
 */
public class ClientThread extends Thread {

    private int counter = 1;
    private String                    incomingMessage;
    private ServerMain                server;
    private String                    clientName;
    private String                    ip;
    private boolean                   registered;
    private AsynchronousSocketChannel client;

    public ClientThread(ServerMain serverMain, AsynchronousSocketChannel client) {
        this.server = serverMain;
        this.client = client;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            int x = (int) (Math.random() * 100);
            System.out.println(x);
            server.registerClient(this, "hans");
            if(x < 10) new Thread() {

                @Override
                public void run() {
                    server.blockingTest(counter);
                }
            }.start();
            counter++;
            try {
                sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public AsynchronousSocketChannel getClient() {
        return client;
    }
}
