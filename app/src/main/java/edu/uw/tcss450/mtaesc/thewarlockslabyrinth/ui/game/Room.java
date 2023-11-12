package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
    Room class - will keep track of the player within the labyrinth (represented as a matrix).
    SOURCE: https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/

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
    TODO:
        [ ](> | <)[ ](> | <)[ ]             [ ] = room
        (⌄)       (⌄)       (⌄)             (⌄^<>) = direction user can interact with the door pic
        (-)       (-)       (-)             (-) = The door chosen by user, question is given
        (^)       (^)       (^)
        [ ](> | <)[ ](> | <)[ ]
        (⌄)       (⌄)       (⌄)
        (-)       (-)       (-)
        (^)       (^)       (^)
        [ ](> | <)[ ](> | <)[ ]

        User will click on picture of door displayed on screen, and answer the question displayed on screen (NewGameFragment.java).
     */
    final int labyrinthSize = 3;
    int[][] roomPosition = new int[labyrinthSize][labyrinthSize]; //will keep user's position in room

    public void playerChoosesDoor(View view) {
        ImageView door = (ImageView) view;
        int selectedDoor = Integer.parseInt(door.getTag().toString());
    }


    Context context; //context obj
    int[] doorsOdd; //array of door images for a room
    int[] doorsEven; //array of door images for a room, using alt pics
    LayoutInflater mLayoutInflater; //layout inflater

    /**
     * Constructor
     */
    public Room(Context context, int[] doorsEven, int[] doorsOdd) {
        this.context = context;
        this.doorsEven = doorsEven;
        this.doorsOdd = doorsOdd;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

}
