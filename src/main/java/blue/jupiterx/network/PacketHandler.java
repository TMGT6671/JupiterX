package blue.jupiterx.network;

import net.marfgamer.jraknet.RakNetPacket;
import net.marfgamer.jraknet.session.RakNetSession;

public class PacketHandler {

    public PacketHandler() {
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
