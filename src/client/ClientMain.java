package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * User: Marc Date: 14.11.13 Time: 20:16
 */
public class ClientMain {

    public ClientMain(String ip) {
        connectToServer(ip);
    }

    public static void main(String[] args) {
        new ClientMain(new Scanner(System.in).next());
    }

    public void connectToServer(String ip) {
        System.out.println(ip);
        AsynchronousSocketChannel client = null;
        try {
            client = AsynchronousSocketChannel.open();
            client.connect(new InetSocketAddress(ip, 2587)).get();
            System.out.println(client.isOpen());
            ByteBuffer message = ByteBuffer.wrap("ping".getBytes());
            client.write(message).get();
        } catch(IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
