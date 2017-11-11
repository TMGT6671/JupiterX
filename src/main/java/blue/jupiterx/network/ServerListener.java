/**     _             _ _          __  __
 *     | |_   _ _ __ (_) |_ ___ _ _\ \/ /
 *  _  | | | | | '_ \| | __/ _ \ '__\  /
 * | |_| | |_| | |_) | | ||  __/ |  /  \
 *  \___/ \__,_| .__/|_|\__\___|_| /_/\_\
 *             |_|
 *
 * These codes are from PocketMine-MP.
 *
 * JupiterX Project
 *
 * @author JupiterDevelopmentTeam
 * @link http://jupiterx.blue
 */

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
    	packet.decode();
        System.out.println("Handle Packet!: " + session.getAddress() + "::" + packet.getId() + "::" + packet.array()[0] + "::" + packet.array()[1] + "::" + channel);
        handler.handlePacket(session, packet);
    }
    
    @Override
    public void handleUnknownMessage(RakNetClientSession session, RakNetPacket packet, int channel) {
        System.out.println("Handle UnknownPacket!: " + session.getAddress() + "::" + packet.getId() + packet.array()[0] + "::" + packet.array()[1] + "::" + channel);
        handler.handlePacket(session, packet);
    }

}
