package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServerMain {

    private HashMap<String, ClientThread> clientList;

    public ServerMain() {
        clientList = new HashMap<>();
        openServer();
    }

    public static void main(String[] args) {
        new ServerMain();
    }

    public void openServer() {
        try {
            SocketAddress localaddr = new InetSocketAddress("0.0.0.0", 7777);
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(localaddr, 1000);
            Future<AsynchronousSocketChannel> connection = server.accept();
            AsynchronousSocketChannel client = connection.get();
            ClientThread tt = new ClientThread(this, client);
            tt.start();
        } catch(IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void registerClient(ClientThread clientThread, String hans) {
        if(!getClientList().containsKey(hans)) getClientList().put(hans, clientThread);
    }

    public void blockingTest(int thread) {
        System.out.println(thread + " Durchläufe ");
        System.out.println("Blocking....");
        new Scanner(System.in).next();
        System.exit(1);
    }

    public HashMap<String, ClientThread> getClientList() {
        return clientList;
    }
}
