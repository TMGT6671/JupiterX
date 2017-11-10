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

    public RakNet(int port, int maxConnections, MinecraftIdentifier identifier) {
    	this.port = port;
    	this.maxConnections = maxConnections;
    	this.identifier = identifier;
    	
    	raknet = new RakNetServer(this.port, this.maxConnections, this.identifier);
    	raknet.addListener(new ServerListener());
    	
    	startServer();
    }
    
    private void startServer() {
    	try {
			raknet.start();
		} catch (RakNetException e) {
			e.printStackTrace();
		}
    }

}
