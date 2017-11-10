package blue.jupiterx.network;

import java.util.Random;

import blue.jupiterx.Server;
import blue.jupiterx.network.mcpe.protocol.ProtocolInfo;
import net.marfgamer.jraknet.identifier.MinecraftIdentifier;

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

public class Network {
	
	private Server server;
	
    private String motd;
    
    private String address;
    
    private int port;
    
    private int maxConnections;
    
    private RakNet raknet;
    
    private MinecraftIdentifier identifier;
	
	private SourceInterface[] interfaces;
	
	public Network(Server server){
		this.server = server;
		this.motd = server.getMotd();
		this.address = server.getAddress();
		this.port = server.getPort();
		this.maxConnections = server.getMaxConnections();
		
		identifier = new MinecraftIdentifier(motd, ProtocolInfo.SERVER_PROTOCOL, ProtocolInfo.MINECRAFT_VERSION, 0, maxConnections, new Random().nextLong(), "New World", "Survival");
		
		raknet = new RakNet(port, maxConnections, identifier);
	}
	
	public SourceInterface[] getInterfaces(){
		return this.interfaces;
	}

}