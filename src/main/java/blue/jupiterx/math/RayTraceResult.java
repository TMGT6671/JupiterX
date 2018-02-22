package blue.jupiterx.math;

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

public class RayTraceResult {
	
	public AxisAlignedBB bb;
	public int hitFace;
	public Vector3 hitVector;
	
	/**
	 * @param bb
	 * @param hitFace one of the Vector3.SIDE_* constants
	 * @param hitVector
	 */
	public RayTraceResult(AxisAlignedBB bb, int hitFace, Vector3 hitVector) {
		this.bb = bb;
		this.hitFace = hitFace;
		this.hitVector = hitVector;
	}
	
	/**
	 * @return AxisAlignedBB
	 */
	public AxisAlignedBB getBoundingBox() {
		return this.bb;
	}
	
	/**
	 * @return int
	 */
	public int getHitFace() {
		return this.hitFace;
	}
	
	/**
	 * @return Vector3
	 */
	public Vector3 getHitVector() {
		return this.hitVector;
	}
}
