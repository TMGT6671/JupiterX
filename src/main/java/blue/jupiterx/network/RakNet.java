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

import net.marfgamer.jraknet.RakNetException;
import net.marfgamer.jraknet.identifier.MinecraftIdentifier;
import net.marfgamer.jraknet.server.RakNetServer;

public class RakNet {

    private int port;

    private int maxConnections;

    private Network network;

    private RakNetServer raknet;

    private MinecraftIdentifier identifier;

    public RakNet(int port, int maxConnections, MinecraftIdentifier identifier, PacketHandler handler) {
        this.port = port;
        this.maxConnections = maxConnections;
        this.identifier = identifier;

        raknet = new RakNetServer(this.port, this.maxConnections, this.identifier);

        startListener(handler);
        startServer();
    }

    private void startListener(PacketHandler handler) {
        raknet.addListener(new ServerListener(handler));
    }

    private void startServer() {
        try {
            raknet.start();
        } catch (RakNetException e) {
            e.printStackTrace();
        }
    }

}
