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

import net.marfgamer.jraknet.client.RakNetClientListener;
import net.marfgamer.jraknet.session.RakNetServerSession;

public class ClientListener implements RakNetClientListener {
	
	private Client client;
	
	public ClientListener(Client client) {
		this.client = client;
	}
	
	@Override
	public void onConnect(RakNetServerSession session) {
		System.out.println("Successfully connected to server with address " + session.getAddress());
		client.disconnect();
	}

	// Server disconnected
	@Override
	public void onDisconnect(RakNetServerSession session, String reason) {
		System.out.println("Successfully disconnected from server with address " + session.getAddress()
				+ " for the reason \"" + reason + "\"");
		client.shutdown();
	}

}
