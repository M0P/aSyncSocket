package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServerMain {

    public ServerMain() {
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
            System.out.println(client.getRemoteAddress());
        } catch(IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
