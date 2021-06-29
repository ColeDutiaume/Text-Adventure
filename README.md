# Text-Adventure
A short text adventure to play in an IDE console.  
Code takes 1 or 2 word commands to use in navigation or inventory management. Code takes user inputted String and uses .split() to break it up into words and adds them to an array to pass on. .split() uses the "\\W+" regex to filter non a-z & 0-9 characters out. If user enters 3 or more words it gets rejected and prompts user to type again.  
The player and each Room object is built with an ArrayList in their constructor parameters for inventory. This makes it easy to pick up and drop items in any room and keep track of them.  
The map is a 3 dimensional array with each element being a "Rooms" object.
