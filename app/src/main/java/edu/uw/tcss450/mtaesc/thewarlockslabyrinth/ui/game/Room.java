package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;

/**
    Room class - will keep track of the player within the labyrinth (represented as a matrix).
    @author StephMGibbs
 */
public class Room {
    /*
    TODO:
        Labyrinth as matrix (default 3x3), where user starts in upper left corner & ends game once reaches the lower right corner.
        EX: o = player
        [o][ ][ ]
        [ ][ ][ ]
        [ ][ ][ ] <- exit

        Each [ ] is a room in the maze, which the player looks at different sides of the room to select a door to interact with.
        Each room is broken down as:
                              NORTH                             Door_1
                        WEST [     ] EAST        =      Door_4 [      ] Door_2
                              SOUTH                             Door_3

        User will click on picture of door displayed on screen, and answer the question displayed on screen (NewGameFragment.java).
     */

}
