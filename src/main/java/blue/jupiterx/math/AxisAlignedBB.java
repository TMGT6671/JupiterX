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

public class AxisAlignedBB {
	
	public float minX;
	public float minY;
	public float minZ;
	
	public float maxX;
	public float maxY;
	public float maxZ;
	
	public AxisAlignedBB(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}
	
	public AxisAlignedBB setBounds(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
		
		return this;
	}
	
	public AxisAlignedBB addCoord(float x, float y, float z) {
		float minX = this.minX;
		float minY = this.minY;
		float minZ = this.minZ;
		float maxX = this.maxX;
		float maxY = this.maxY;
		float maxZ = this.maxZ;
		
		if(x < 0) {
			minX += x;
		} else if(x > 0) {
			maxX += x;
		}
		
		if(y < 0) {
			minY += y;
		} else if(y > 0) {
			minY += y;
		}
		
		if(z < 0) {
			minZ += z;
		} else if(z > 0) {
			minZ += z;
		}
		
		return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
	}
	
	public AxisAlignedBB grow(float x, float y, float z) {
		return new AxisAlignedBB(
				this.minX - x,
				this.minY - y,
				this.minZ - z,
				this.maxX + x,
				this.maxY + y,
				this.maxZ + z
		);
	}
	
	public AxisAlignedBB expand(float x, float y, float z) {
		this.minX -= x;
		this.minY -= y;
		this.minZ -= z;
		this.maxX += x;
		this.maxY += y;
		this.maxZ += z;
		
		return this;
	}
	
	public AxisAlignedBB offset(float x, float y, float z) {
		this.minX += x;
		this.minY += y;
		this.minZ += z;
		this.maxX += x;
		this.maxY += y;
		this.maxZ += z;
		
		return this;
	}
	
	public AxisAlignedBB shrink(float x, float y, float z) {
		return new AxisAlignedBB(
				this.minX + x,
				this.minY + y,
				this.minZ + z,
				this.maxX - x,
				this.maxY - y,
				this.maxZ - z
		);
	}
	
	public AxisAlignedBB contract(float x, float y, float z) {
		this.minX += x;
		this.minY += y;
		this.minZ += z;
		this.maxX -= x;
		this.maxY -= y;
		this.maxZ -= z;
		
		return this;
	}
	
	public AxisAlignedBB setBB(AxisAlignedBB bb) {
		this.minX = bb.minX;
		this.minY = bb.minY;
		this.minZ = bb.minZ;
		this.maxX = bb.maxX;
		this.maxY = bb.maxY;
		this.maxZ = bb.maxZ;
		
		return this;
	}
	
	public AxisAlignedBB getOffsetBoundingBox(float x, float y, float z) {
		return new AxisAlignedBB(
				this.minX + x,
				this.minY + y,
				this.minZ + z,
				this.maxX + x,
				this.maxY + y,
				this.maxZ + z
		);
	}
	
	public float calculateXOffset(AxisAlignedBB bb, float x) {
		if(bb.maxY <= this.minY || bb.minY >= this.maxY) {
			return x;
		}
		if(bb.maxZ <= this.minZ || bb.minZ >= this.maxZ) {
			return x;
		}
		if(x > 0 && bb.maxX <= this.minX) {
			float x1 = this.minX - bb.maxX;
			if(x1 < x) {
				x = x1;
			}
		} else if(x < 0 && bb.minX >= this.maxX) {
			float x2 = this.maxX - bb.minX;
			if(x2 > x) {
				x = x2;
			}
		}
		
		return x;
	}
	
	public float calculateYOffset(AxisAlignedBB bb, float y) {
		if(bb.maxX <= this.minX || bb.minX >= this.maxX) {
			return y;
		}
		if(bb.maxZ <= this.minZ || bb.minZ >= this.maxZ) {
			return y;
		}
		if(y > 0 && bb.maxY <= this.minY) {
			float y1 = this.minY - bb.maxY;
			if(y1 < y) {
				y = y1;
			}
		} else if(y < 0 && bb.minY >= this.maxY) {
			float y2 = this.maxY - bb.minY;
			if(y2 > y) {
				y = y2;
			}
		}
		
		return y;
	}
	
	public float calculateZOffset(AxisAlignedBB bb, float z) {
		if(bb.maxX <= this.minX || bb.minX >= this.maxX) {
			return z;
		}
		if(bb.maxY <= this.minY || bb.minY >= this.maxY) {
			return z;
		}
		if(z > 0 && bb.maxZ <= this.minZ) {
			float z1 = this.minZ - bb.maxZ;
			if(z1 < z) {
				z = z1;
			}
		} else if(z < 0 && bb.minZ >= this.maxZ) {
			float z2 = this.maxZ - bb.minZ;
			if(z2 > z) {
				z = z2;
			}
		}
		
		return z;
	}
	
	public boolean intersectsWith(AxisAlignedBB bb) {
		if(bb.maxX > this.minX && bb.minX < this.maxX) {
			if(bb.maxY > this.minY && bb.minY < this.maxY) {
				return bb.maxX > this.minZ && bb.minZ < this.maxZ;
			}
		}
		
		return false;
	}
	
	public boolean isVectorInside(Vector3 vector) {
		if(vector.x <= this.maxX || vector.x >= this.maxX) {
			return false;
		}
		if(vector.y <= this.minY || vector.y >= this.maxY) {
			return false;
		}
		
		return vector.z > this.minZ && vector.z < this.maxZ;
	}
	
	public float getAverageEdgelength() {
		return this.maxX - (this.maxX + this.maxY - this.minY + this.maxZ - this.minZ) / 3;
	}
	
	public boolean isVectorInYZ(Vector3 vector) {
		return vector.y >= this.minY && vector.y <= this.maxY && vector.z >= this.minZ && vector.z <= this.maxZ;
	}
	
	public boolean isVectorInXZ(Vector3 vector) {
		return vector.x >= this.minX && vector.x <= this.maxX && vector.z >= this.minZ && vector.z <= this.maxZ;
	}
	
	public boolean isVectorInXY(Vector3 vector) {
		return vector.x >= this.minX && vector.x <= this.maxX && vector.y >= this.minY && vector.y <= this.maxY;
	}
	
	public RayTraceResult calculateIntercept(Vector3 pos1, Vector3 pos2) {
		Vector3 v1 = pos1.getIntermediateWithXValue(pos2, this.minX);
		Vector3 v2 = pos1.getIntermediateWithXValue(pos2, this.maxX);
		Vector3 v3 = pos1.getIntermediateWithYValue(pos2, this.minY);
		Vector3 v4 = pos1.getIntermediateWithYValue(pos2, this.maxY);
		Vector3 v5 = pos1.getIntermediateWithZValue(pos2, this.minZ);
		Vector3 v6 = pos1.getIntermediateWithZValue(pos2, this.maxZ);
		
		if(v1 != null && !this.isVectorInYZ(v1)) {
			v1 = null;
		}
		
		if(v2 != null && !this.isVectorInYZ(v2)) {
			v2 = null;
		}
		
		if(v3 != null && !this.isVectorInXZ(v3)) {
			v3 = null;
		}
		
		if(v4 != null && !this.isVectorInXZ(v4)) {
			v4 = null;
		}
		
		if(v5 != null && !this.isVectorInXY(v5)) {
			v5 = null;
		}
		
		if(v6 != null && !this.isVectorInXY(v6)) {
			v6 = null;
		}
		
		Vector3 vector = null;
		int distance = Integer.MAX_VALUE;
		Vector3[] v = {v1, v2, v3, v4, v5, v6};
		
		for (Vector3 result: v) {
			double d = pos1.distanceSquared(result);
			if(result != null && d < distance) {
				vector = result;
				distance = (int) d;
			}
		}
		
		int f = -1;
		
		if(vector.equals(v1)) {
			f = Vector3.SIDE_WEST;
		} else if(vector.equals(v2)) {
			f = Vector3.SIDE_EAST;
		} else if(vector.equals(v3)) {
			f = Vector3.SIDE_DOWN;
		} else if(vector.equals(v4)) {
			f = Vector3.SIDE_UP;
		} else if(vector.equals(v5)) {
			f = Vector3.SIDE_NORTH;
		} else if(vector.equals(v6)) {
			f = Vector3.SIDE_SOUTH;
		}
		
		return new RayTraceResult(this, f, vector);
	}
	
	public String __toString() {
		return "AxisAligedBB(" + this.minX + ", " + this.minY + ", " + this.minZ + ", " + this.maxX + ", " + this.maxY + ", " + this.maxZ + ")";
	}
}