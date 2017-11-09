package blue.jupiterx.network;

import blue.jupiterx.Player;
import blue.jupiterx.network.mcpe.protocol.DataPacket;

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

public interface SourceInterface {
	
	public void start();
	
	public void close(Player player, String reason);
	
	public void  putPacket(Player player, DataPacket packet, boolean needACK, boolean immidate);
	
	public void setName(String name);
	
	public boolean process();
	
	public boolean shutdown();
	
	public boolean emergencyShutdown();

}