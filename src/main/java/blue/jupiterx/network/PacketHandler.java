package blue.jupiterx.network;

import blue.jupiterx.Server;
import net.marfgamer.jraknet.RakNetPacket;
import net.marfgamer.jraknet.session.RakNetSession;

public class PacketHandler {

    private Server server;

    public PacketHandler(Server server) {
        this.server = server;
    }

    public void connected(RakNetSession session) {

    }

    public void disConnected(RakNetSession session, String reason) {
    	
    }

    public void handlePacket(RakNetSession session, RakNetPacket packet) {
        switch(packet.array()[1]) {
        	
        }
    }

}
