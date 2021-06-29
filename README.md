# Text-Adventure
-A short text adventure to play in an IDE console.  
-Code takes 1 or 2 word commands to use in navigation or inventory management. Code takes user inputted String and uses .split() to break it up into words and adds them to an array to pass on. .split() uses the "\\W+" regex to filter non a-z & 0-9 characters out. If user enters 3 or more words it gets rejected and prompts user to type again.  
-The player and each Room object is built with an ArrayList in their constructor parameters for inventory. This makes it easy to pick up and drop items in any room and keep track of them.  
-The map is a 3 dimensional array with each element being a "Rooms" object.
The room the player is currently in is stored in the player object itself as a Rooms parameter using a map Array element as the arguement. At runtime the Player object is always instantiated with the room object at map[2][1][1] position (the enterance to the house map).  
-Map navigation is achieved with direction methods (north, south, east, west, up, and down). Each direction modifies an Array value corresponding with the direction chosen.  
-North would be map[y-1][x][z], East map[y][x+1][z], etc. Each method checks if the direction to move has a room to go to (each room has boolean values for each 6 directions the player can move); if that room is locked; and if locked, checks the player inventory for a key to that room.
-Rooms have a boolean "isLocked" param. Unlocking is achieved with 2 integer values. Each item has an "itemID" param in their constructors, and each locked room has a "lockID" param. When the player tries to enter a locked room the game checks each item in the player's inventory for an itemID that matches the locked room's lockID. If a match is found the code runs the lockID setter method and sets it to false.
-Only locked rooms have a lockID, via an overloaded "Rooms" class constructor.
