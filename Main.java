package txt_adventure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	//numbers to be used to move around 3d array map. always start game at "enterance" value [2][1][1]
	protected static int y = 2;
	protected static int x = 1;
	protected static int z = 1;
	protected static  boolean active;
	
	protected static Player player;
	//list of accepted items and verbs
	private final static ArrayList<String> commands = new ArrayList<>(Arrays.asList("take", "get", "drop", "look", "l", "q", "quit", "inventory", "i", "help", "h",
			"north", "n", "south", "s", "east", "e", "west", "w", "up", "u", "down","d"));		//accepted verbs

	private final static ArrayList<String> objects = new ArrayList<>(Arrays.asList("fancykey", "plainkey", "ornatestone", "crowbar", "greasykey", "photograph", "lighter"));	//accepted object nouns.
	
	protected static Inventory playerIn;

	public static void main(String[] args) {
		
		
		//instatiating room objects in the map MDR, as well as their inventories.
		Map.popRooms();
		playerIn = new Inventory();
		playerIn.add(new Items("Photograph", "A photo of me and my brother. The lastest you have. "
								+ "\nHe's been missing for a few years, but you got an anonymous tip he might be here in this old abandonded house. "
								+ "\nCould he really be here?", 0010));
		player = new Player("Jimbo", "That's me, I'm looking for my thing", Map.map[y][x][z], playerIn);
		
		//System.out.println(currentRoom.lookAround());
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the game. "
				+ "\ntype \"h\" or \"help\" for commands.");
		System.out.println(player.getRoom().lookAround());
		active = true;
		do {
			//checks for game end condition at start of every input loop.
			if(checkItem(player.getInventory())) {
				gameFinish();
				break;
			}
			System.out.println("What do you want to do?");
			String userInput = input.nextLine().toLowerCase();
			parseInput(userInput);
		}while(active);
		input.close();
	}
	
	
	private static boolean checkItem(Inventory in) {
		boolean has = false;
		//empty inventory condition
		if(in.size() == 0) {
			has = false;
		} else {
			//checks for a specific item id.
			for(int i = 0; i < in.size(); i++) {
				if(in.get(i).getItemID() == 0006) {
					has = true;
				}
			}
		}
		return has;
	}

	//takeInput method takes user input string and splits them into individual words, filtering out non-letter or number characters
	//eg. .,'" -_ etc. and stores them in an array.
	private static void parseInput(String s) {
		String[] split = s.split("\\W+");
		for(String i : split) {
			System.out.println(">" + i);
		}
		commandSwitch(split);						//uses that array as arguement for commandSwitch method.
	}
	
	//checks how many words inputted and runs appropriate code.
	private static void commandSwitch(String[] input) {
		String message = "";
		if(input.length == 1) {
			verbSwitcher(input);
		} else if (input.length == 2){
			verbNounSwitcher(input);
		} else {
			message = "No more than 2 words, please!";
		}
		System.out.println(message);
	}
	
	//if user input 2 words, splits them into verb and noun strings. then checks them each against the master lists of verbs and nouns and
	//runs appropriate code.
	private static void verbNounSwitcher(String[] input) {
		String verb;
		String noun;
		String message = "";
		boolean noMatch = false;
		verb = input[0];
		noun = input[1];
		
		if(!commands.contains(verb)) {
			message = "Don't know how to " + verb + " something! ";
			noMatch = true;
		}
		if(!objects.contains(noun)) {
			message += "I don't know what a " + noun + " is!";
			noMatch = true;
		}
		if(!noMatch) {
			switch(verb) {
			case "take", "get":
				takeItem(noun);
				break;
			case "drop":
				dropItem(noun);
				break;
			default:
				break;
			}
		}
		if(message != "") {
			System.out.println(message);
			}
	}

	//searches room inventory for user specified 'items' object, if found runs transferItem method to bring it into player inventory
	private static void takeItem(String noun) {
		String message = "";
		Items i = player.getRoom().getInventory().thisItem(noun);
		if(noun.equals("")) {
			noun = "Nothing"; 	//setting default name if no item specified.
		}
		if(i == null) {
			message = "There's no " + noun + " to be found !";
		} else {
			transferItem(i, player.getRoom().getInventory(), player.getInventory());
			message = noun + " has been added to your inventory";
		}
		System.out.println(message);
	}
	
	
	//searches player inventory for user specified 'items' object, if found runs transferItem method to put it into room inventory
	private static void dropItem(String noun) {
		String message = "";
		Items i = player.getInventory().thisItem(noun);
		if(noun.equals("")) {
			noun = "Nothing"; 	// setting default name if no item specified.
		}
		if(i == null) {
			message = "You don't have a " + noun + " to drop!";
		} else {
			transferItem(i, player.getInventory(), player.getRoom().getInventory());
			message = "You dropped the " + noun + " on the floor!";
		}
		System.out.println(message);
	}

	
	//moves item from 1 inventory to another
	private static void transferItem(Items i, Inventory fromInv, Inventory toInv) {
		fromInv.remove(i);
		toInv.add(i);
	}

	//for single word inputs
	private static void verbSwitcher(String[] word) {
		String verb;
		String message = "";
		verb = word[0];
		if(!commands.contains(verb)) {
			message = "Don't know how to " + verb + " something! ";
		} else {
			switch(verb) {
			case "n", "north":
				goNorth();
				break;
			case "s", "south":
				goSouth();
				break;
			case "w", "west":
				goWest();
				break;
			case "e", "east":
				goEast();
				break;
			case "up", "u":
				goUp();
				break;
			case "down", "d":
				goDown();
				break;
			case "l", "look":
				look();
				break;
			case "i", "inventory":
				showInventory();
				break;
			case "q", "quit":
				System.out.println("Goodbye!");
				active = false;
				break;
			case "h", "help":
				showHelp();
				break;
			default:
				message = verb + " Not in the game";
			}
		}
		System.out.println(message);
	}

	
	private static void showHelp() {
		System.out.println("This game uses simple 1 or 2 word commands."
				+ "\nFor picking up and dropping, use \"take (item)\" (or \"get\" (item)) and \"drop (item)\" "
				+ "\nfor navigation 1 word is enough. \"north\" or just \"n\" work."
				+ "\n\"i\" or \"inventory\" to check inventory. \"q\" or \"quit\" to end the game."
				+ "\n\"look\" or \"l\" to look around your current room.");
	}
	
	//shows player inventory
	private static void showInventory() {
		String s = "You are carrying: \n" + player.getInventory().listItems();
		System.out.println(s);
	}

	//shows room name/description as well as room inventory
	private static void look() {

		String s = player.getRoom().getName() 
				+ "\n" 
				+ player.getRoom().getDescription()
				+"\n\nOn the ground you see: \n"
				+ player.getRoom().getInventory().listItems();
		System.out.println(s);
	}
	
	//checks the user inventory for an object with an itemID that matches the lockID parameter.
	private static boolean hasKey(Inventory inventory, int lockID) {
		boolean unlock = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getItemID() == lockID) {
				unlock = true;
				System.out.println("You unlocked the door with the " + inventory.get(i).getName() + "!");
				inventory.get(i).setDescription(inventory.get(i).getDescription() + " Item has been used.");
				break;
			}
		}
		return unlock;
	}
	
	private static void gameFinish() {

		System.out.println("\nYou take the lighter in hand and head for the exit. "
				+ "\nYou didn't find your brother, but for the first time in years you've found something linking you to him again. "
				+ "\nNothing to do but keep going. "
				+ "\n\nThanks for Playing.");
		active = false;
		
	}
	
	//go commands check if there's a room to move to, if that room is locked, and if player has the key to that room.
	private static void goNorth() {
		try {
			Rooms nextRoom = Map.map[y-1][x][z];	//changes the 3Darray index value based on which direction you're moving and sets it as a variable.
			
			
			if(!player.getRoom().isNorth()) {
				System.out.println("Can't go that way!");
			}else if(nextRoom.isLocked() && hasKey(player.getInventory(), nextRoom.getLockID())) { 	//unlocks door if locked && player has item with ID that matches lock ID;
				nextRoom.setLocked(false);
			}else if(!nextRoom.isLocked()) {
				y--;
				player.setRoom(nextRoom);
				System.out.println(player.getRoom().lookAround());
			} else {
				System.out.println("The Room is Locked!");
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Can't go that way!");
		}	
	}
	
	private static void goSouth() {
		try {
			Rooms nextRoom = Map.map[y+1][x][z];
		
			if(!player.getRoom().isSouth()) {
				System.out.println("Can't go that way!");
			}else if(nextRoom.isLocked() && hasKey(player.getInventory(), nextRoom.getLockID())) { 
				nextRoom.setLocked(false);
			}else if(!nextRoom.isLocked()) {
				y++;
				player.setRoom(nextRoom);
				System.out.println(player.getRoom().lookAround());
			} else {
				System.out.println("The Room is Locked!");
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Can't go that way!");
		}	
	}
	
	private static void goWest() {
		try {
			Rooms nextRoom = Map.map[y][x-1][z];
			
			if(!player.getRoom().isWest()) {
				System.out.println("Can't go that way!");
			}else if(nextRoom.isLocked() && hasKey(player.getInventory(), nextRoom.getLockID())) { 
				nextRoom.setLocked(false);
			}else if(!nextRoom.isLocked()) {
				x--;
				player.setRoom(nextRoom);
				System.out.println(player.getRoom().lookAround());
			} else {
				System.out.println("The Room is Locked!");
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Can't go that way!");
		}	
	}
	
	private static void goEast() {		
		try {
			Rooms nextRoom = Map.map[y][x+1][z];
			
			if(!player.getRoom().isEast()) {
				System.out.println("Can't go that way!");
			}else if(nextRoom.isLocked() && hasKey(player.getInventory(), nextRoom.getLockID())) { 
				nextRoom.setLocked(false);
			}else if(!nextRoom.isLocked()) {
				x++;
				player.setRoom(nextRoom);
				System.out.println(player.getRoom().lookAround());
			} else {
				System.out.println("The Room is Locked!");
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Can't go that way!");
		}	
	}
	
	private static void goUp() {
		try {
			Rooms nextRoom = Map.map[y][x][z+1];
			
			if(!player.getRoom().isUp()) {
				System.out.println("Can't go that way!");
			} else if(!nextRoom.isLocked()) {
				z++;
				player.setRoom(nextRoom);
				System.out.println(player.getRoom().lookAround());
			} else {
				System.out.println("The Room is Locked!");
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Can't go that way!");
		}	
	}
	
	private static void goDown() {
		try {
			Rooms nextRoom = Map.map[y][x][z-1];
			
			if(!player.getRoom().isDown()) {
				System.out.println("Can't go that way!");
			} else if(!nextRoom.isLocked()) {
				z--;
				player.setRoom(nextRoom);
				System.out.println(player.getRoom().lookAround());
			} else {
				System.out.println("The Room is Locked!");
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Can't go that way!");
		}	
	}
}