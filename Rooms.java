package txt_adventure;

public class Rooms extends ThingSuper {
	
	private boolean isLocked;
	private boolean north;
	private boolean south;
	private boolean west;
	private boolean east;
	private boolean up;
	private boolean down;
	private Inventory inventory;
	private int lockID;
	
	//overloaded constructor for locked/unlocked rooms.
	public Rooms(String aName, String aDesc, boolean n, boolean s, boolean w, boolean e, boolean u, boolean d, boolean locked, Inventory in) {
		super(aName, aDesc);
		this.isLocked = locked;
		this.north = n;
		this.south = s;
		this.west = w;
		this.east = e;
		this.up = u;
		this.down = d;
		this.inventory = in;
	}
	
	public Rooms(String aName, String aDesc, boolean n, boolean s, boolean w, boolean e, boolean u, boolean d, boolean locked, int lockId, Inventory in) {
		super(aName, aDesc);
		this.isLocked = locked;
		this.north = n;
		this.south = s;
		this.west = w;
		this.east = e;
		this.up = u;
		this.down = d;
		this.inventory = in;
		this.lockID = lockId;
	}
		
		
		
	public String lookAround() {
		return "\n" + this.getName() + "\n" + this.getDescription();
	}
	
	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	

	public boolean isNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean isSouth() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean isWest() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getLockID() {
		return lockID;
	}

}
