package blue.jupiterx.network;

import java.net.UnknownHostException;

import net.marfgamer.jraknet.RakNetException;
import net.marfgamer.jraknet.client.RakNetClient;

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

public class Client extends RakNetClient {

    private String address = "";
    private int port = 19132;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;

        startListener();
        startClient();
    }

    private void startListener() {
        this.addListener(new ClientListener(this));
    }
    
    private void startClient() {
    	try {
			this.connect(address, port);
		} catch (UnknownHostException | RakNetException e) {
			e.printStackTrace();
		}
    }


}