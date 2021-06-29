package txt_adventure;

public class Player extends ThingSuper {
	
	private Rooms room; //the player's current position
	private Inventory inventory;
	
	public Player(String aName, String aDesc, Rooms aRoom, Inventory inv) {
		super(aName, aDesc);
		this.room = aRoom;
		this.setInventory(inv);
		
	}
	
	public void setRoom(Rooms aRoom) {
		this.room = aRoom;
	}
	
	public Rooms getRoom() {
		return this.room;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	

}
