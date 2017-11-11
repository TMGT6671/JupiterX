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

import blue.jupiterx.network.mcpe.protocol.ProtocolInfo;
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
    	
        packet.decode();
        
        byte[] buffer = packet.array();
        
        if(packet.getId() == ProtocolInfo.HEADER_PACKET_ID) {
        	switch(buffer[0]) {
        	
        	}
        }
        
    }

}
