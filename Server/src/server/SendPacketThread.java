package server;

import java.util.HashMap;
import java.util.Iterator;

import data.Packet;

/**
 * User: Marc Date: 17.11.13 Time: 11:33
 */
public class SendPacketThread extends Thread {

    ServerMain server;
    Packet     packet;
    String receiver = "";

    public SendPacketThread(ServerMain server, Packet packet) {
        this.server = server;
        this.packet = packet;
    }

    public SendPacketThread(ServerMain server, Packet packet, String receiver) {
        this.server = server;
        this.packet = packet;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        super.run();
        HashMap<String, ClientThread> clientList = server.getClientList();
        if(receiver.length() > 0) {
            if(clientList.containsKey(receiver)) clientList.get(receiver).getClient().write(null);//TODO
            else ;//TODO throw error
        }
        Iterator iter = clientList.values().iterator();
        while(iter.hasNext()) {
            ((ClientThread) iter.next()).getClient().write(null);//TODO
        }
    }
}
