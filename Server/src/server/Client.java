package server;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * User: Marc Date: 16.11.13 Time: 22:29
 */
public class Client {

    private String                    clientName;
    private String                    ip;
    private AsynchronousSocketChannel connection;

    public Client(String userName, String ipAddress, AsynchronousSocketChannel client) {
        this.clientName = userName;
        this.ip = ipAddress;
        this.connection = client;
    }

    public String getClientName() {
        return clientName;
    }

    public String getIp() {
        return ip;
    }

    public AsynchronousSocketChannel getConnection() {
        return connection;
    }
}
