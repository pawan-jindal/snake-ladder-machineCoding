# README #
### What is this repository for? ###
* Snake and ladder game for Machine coding round.
* It will focus on the design of a Snake and ladder game like Ludo and others. But this design will be a much smaller scale.

### Requirements of snake and ladder application ###
Let’s first understand the requirements and rules.

### Mandatory Requirements ###
The application should take as input (from the command line or a file).
* Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.
* Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.
* Number of players (p) followed by p lines each containing a name. p<=10
* After taking these inputs, you should print all the moves in the form of the current player name followed by a random number between 1 to 6 denoting the die roll and the initial and final position based on the move.
  * Format: <player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>
  * When someone wins the game, print that the player won the game. 
    * Format: Player: %s win the game
* Snakes and Ladders can form an infinite loop(show validation)

    
### Rules of the game ###
* The board will have 100 cells numbered from 1 to 100.
* The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
* Each player has a piece which is initially kept outside the board (i.e., at position 0).
* Each player rolls the dice when their turn comes.
* Based on the dice value, the player moves their piece forward that number of cells. Ex: If the dice value is 5 and the piece is at position 21, the player will put their piece at position 26 now (21+5).
* A player wins if it exactly reaches the position 100 and the game ends there.
* After the dice roll, if a piece is supposed to move outside position 100, it does not move.
* The board also contains some snakes and ladders.
* There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.

### Assumptions you can take apart from those already mentioned in rules ###
* There won’t be a snake at 100.
* There won’t be multiple snakes/ladders at the same start/head point.
* It is possible to reach 100, i.e., it is possible to win the game.

### About Code ###
* Implemented using core-Java, so flow will be run at Terminal/console.
* RunnerClass.java: Is the driver/runner file or starting point of the service/code.
