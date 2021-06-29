package txt_adventure;
import java.util.ArrayList;

public class Inventory extends ArrayList<Items> {

	//lists out items in the arrayList, if any.
	public String listItems() {
		String s = "";
		if(this.size() == 0) {
			s = "Nothing... \n";
		} else {
			for( Items t : this) {
				s = s + ">" + " " + t.getName() + ": " + t.getDescription() + "\n";
			}
		}
		return s;
	}
	
	//scans arraylist for an item that matches arguement name. 
	public Items thisItem(String aName) {
		Items aItems = null;
		String itemsName = "";
		String aNameLC = aName.trim().toLowerCase();			//takes arguement name and makes it lowercase.
		for(Items t : this) {
			itemsName = t.getName().trim().toLowerCase();		//iterates through list, making each item name lowercase and checks it against the arguement name.
			if(itemsName.equals(aNameLC)) {
				aItems = t;
			}
		}
		return aItems;
	}

}
