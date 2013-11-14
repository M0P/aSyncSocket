package server;

import java.io.IOException;
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
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(null);
            Future<AsynchronousSocketChannel> acceptFuture = server.accept();
            AsynchronousSocketChannel worker = acceptFuture.get();
            System.out.println(worker.getRemoteAddress());
        } catch(IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
