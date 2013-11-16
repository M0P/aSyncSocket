package server;

public class ServerMain {

    public ServerMain() {
        openServer();
    }

    public static void main(String[] args) {
        new ServerMain();
    }

    public void openServer() {
        //        try {
        TestThread tt = new TestThread();
        tt.start();
        while(true) {
            System.out.println("Bla");
            tt.changeLMaa();
        }
        //            SocketAddress localaddr = new InetSocketAddress("0.0.0.0", 7777);
        //            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(localaddr,
        // 1000);
        //            Future<AsynchronousSocketChannel> connection = server.accept();
        //            AsynchronousSocketChannel client = connection.get();
        //            System.out.println(client.getRemoteAddress());
        //        } catch(IOException | InterruptedException | ExecutionException e) {
        //            e.printStackTrace();
        //        }
    }
}
