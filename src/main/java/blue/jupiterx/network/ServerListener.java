package blue.jupiterx.network;

import net.marfgamer.jraknet.RakNetPacket;
import net.marfgamer.jraknet.server.RakNetServerListener;
import net.marfgamer.jraknet.session.RakNetClientSession;

public class ServerListener implements RakNetServerListener {

    private PacketHandler handler;

    public ServerListener(PacketHandler handler) {
        this.handler = handler;
    }

    // Connected Client
    @Override
    public void onClientConnect(RakNetClientSession session) {
        System.out.println("Client Connected!: " + session.getAddress());
        handler.connected(session);
    }

    // Disconnected Client
    @Override
    public void onClientDisconnect(RakNetClientSession session, String reason) {
        System.out.println("Client Disconnected!: " + session.getAddress());
        handler.disConnected(session, reason);
    }

    // Packet Received
    @Override
    public void handleMessage(RakNetClientSession session, RakNetPacket packet, int channel) {
        System.out.println("Handle Packet!: " + session.getAddress() + "::" + packet.buffer().array() + "::" + channel);
        handler.handlePacket(session, packet);
    }

}
