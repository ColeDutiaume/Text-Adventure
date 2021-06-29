package txt_adventure;

public class Items extends ThingSuper {
	
	private final int itemID;
	
	public Items(String aName, String aDesc, int id) {
		super(aName, aDesc);
		this.itemID = id;
	}

	public int getItemID() {
		return itemID;
	}

}
