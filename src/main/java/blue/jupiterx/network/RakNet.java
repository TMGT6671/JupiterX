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
