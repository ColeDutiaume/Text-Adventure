package txt_adventure;

public class Map {
	
	protected static Rooms[][][] map = new Rooms[3][3][3];
	
		//(String aName, String aDesc, boolean locked ||| booleans north south west east up down ||| boolean locked)
		//creates and stores room objects & their inventories.
	public static void popRooms() {
		
		//room inventories
		Inventory kitchenIn = new Inventory();
			kitchenIn.add(new Items("FancyKey", "An ornate key", 0001));
		Inventory diningIn = new Inventory();
		Inventory stair1stIn = new Inventory();
		Inventory foyerIn = new Inventory();
		Inventory enteranceIn = new Inventory();
		Inventory enterRoomIn = new Inventory();
			enterRoomIn.add(new Items("GreasyKey", "A key with scorch marks and grease stains.", 0002));
		Inventory mastBedIn = new Inventory();
			mastBedIn.add(new Items("Crowbar", "A heavy-duty steel crowbar. Guaranteed to break or open anything you need.", 0005));
		Inventory hallWIn = new Inventory();
		Inventory stair2ndIn = new Inventory();
		Inventory hallEIn = new Inventory();
		Inventory wash1In = new Inventory();
		Inventory eastBedIn = new Inventory();
			eastBedIn.add(new Items("OrnateStone", "A smooth, beautifully carved stone. A simple keepsake, or.,?", 0003));
		Inventory wash2In = new Inventory();
			wash2In.add(new Items("PlainKey", "A plain, average looking key.", 0004));
		Inventory stairBaseIn = new Inventory();
		Inventory baseIn = new Inventory();
		Inventory secretIn = new Inventory();
			secretIn.add(new Items("Lighter", "An old worn lighter that upon closer insepction bears your brother's name.", 0006));
		
		//first floor
		map[0][0][1] = new Rooms("Kitchen", "Not even the smell of the spoiled food remains. \nYou think you see a dull shimmer coming from the rusted out sink.", false, true, false, false, false, false , true, 0002, kitchenIn);
		map[1][0][1] = new Rooms("Dining Hall", "A large table covered with old dishes and some candles serves and the main focal point of the room. \n The kitchen sits to the North.", true, false, false, true, false, false, false, diningIn);
		map[0][1][1] = new Rooms("Stairwell (First Floor)", "Half-rotten stairs lead both up and down from here.",false, true, false, false, true, true, false, stair1stIn);
		map[1][1][1] = new Rooms("Foyer", "Dark, musty, and run down. Not the most welcoming place. \n A door to the north, doorways East and West.", true, true, true, true, false, false, false, foyerIn);
		map[2][1][1] = new Rooms("Enterance", "You stand South of the enterance of an old rotting house. I hope my brother is the only person that's been here recently.", true, false, false, false, false, false, false, enteranceIn);
		map[1][2][1] = new Rooms("Enternaining Room", "An enormous room filled with seating and not much else. A large fireplace sits to the south of the room.",false, false, true, false, false, false, false, enterRoomIn);
		
		//second floor
		map[0][0][2] = new Rooms("Master Bedroom", "A simply furnished room with some gnarly stains in the carpet. \nA moderately sized bed, a dresser, and not much else. \nYou see a hole in the wall on the far side of the room.",false, true, false, false, false, false, true, 0004, mastBedIn);
		map[1][0][2] = new Rooms("Hallway (West)", "A window with a view of the side yard sits at the end of this hallway. A large door to the north with a simple lock.", true, false, false, true, false, false, false, hallWIn);
		map[0][1][2] = new Rooms("Stairwell (Second Floor)", "Half-rotten stairs lead down to the first floor. \nA door leading to the rest of the 2nd floor to the South.", false, true, false, false, false, true, false, stair2ndIn);
		map[1][1][2] = new Rooms("Hallway (East)", "A Large hallway that extends further West. \nDoors South, East, and North. \nThe door to the East looking more elaborate than the usual.", true, true, true, true, false, false, false, hallEIn);
		map[2][1][2] = new Rooms("Washroom", "Once a luxurious personal palace now lays in unmentionable ruin and mess. You don't like it here.", true, false, false, false, false, false, false, wash1In);
		map[1][2][2] = new Rooms("East Bedroom", "A large bed surrounded with drapes and an elaborately designed mirror furnish the room. \nStrange decorations on the nightstand catch your eye.", false, false, true, false, false, false, true, 0001, eastBedIn);
		
		//basement
		map[1][0][0] = new Rooms("Small Washroom", "Thankfully this bathroom is much cleaner than the previous. A faint unpleasant odour lingers. \nThe floor is covered with various bits of trash.", false, false, false, true, false, false, false, wash2In);
		map[0][1][0] = new Rooms("Stairwell (Basement)", "The stairs get even more decrepit as you reach the basement. The dirt floor crunches beneath your feet when your reach the bottom. \nThe door to the rest of the basement is South. \nThere is a strange table full of stones of various sizes and colours.", false, true, false, false, true, false, false, stairBaseIn);
		map[1][1][0] = new Rooms("Basement", "Lit candles provide just enough light to see in front of you. A large basement full of long forgotten boxes of odds and ends. \nTo the South you see some boards on the wall, you think you can see something on the other side, but you can't move the boards.", true, true, true, false, false, false, true, 0003, baseIn);
		map[2][1][0] = new Rooms("Secret Room", "A small cramped crawl space, Food cans and wrappers litter the space, to the left you see what looks like a bed made of old rags and insulation. What the hell is this doing here?", true, false, false, false, false, false, true, 0005, secretIn);
	}
}
