package client;

import java.io.IOException;
import java.net.InetAddress;
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
            //pingTest(ip);
            client = AsynchronousSocketChannel.open();
            client.connect(new InetSocketAddress(ip, 7777)).get();
            System.out.println(client.isOpen());
            System.out.println(client.getRemoteAddress());
            ByteBuffer message = ByteBuffer.wrap("ping".getBytes());
            client.write(message).get();
        } catch(IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void pingTest(String ip) throws Exception {
        String ipAddress = "127.0.0.1";
        InetAddress inet = InetAddress.getByName(ipAddress);

        System.out.println("Sending Ping Request to " + ipAddress);
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

        inet = InetAddress.getByName(ip);

        System.out.println("Sending Ping Request to " + ip);
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
    }
}
