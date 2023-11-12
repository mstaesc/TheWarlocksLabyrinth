package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;

import android.content.Context;
import android.view.LayoutInflater;

public class Door {
    /*
        TODO: Door must consist of an ImageButton, Question obj, and indicator if room index is
         even or odd (to change color of images to distinguish user is in new room).
     */

    // Context object
    Context context;

    // Array of images
    int[] evenDoors;
    int[] oddDoors;

    //Question associated with door
    Question[] question;

    // Layout Inflater
    LayoutInflater mLayoutInflater;


    // Viewpager Constructor
    public Door(int[] evenDoors, int[] oddDoors, Question[] question) {
        this.evenDoors = evenDoors;
        this.oddDoors = oddDoors;
        this.question = question;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private int getEvenDoor(int doorAt) {
        return evenDoors[doorAt];
    }

    private int getOddDoor(int doorAt) {
        return oddDoors[doorAt];
    }

    public int[] getEvenDoors() {
        return evenDoors;
    }

    public void setEvenDoors(int[] evenDoors) {
        this.evenDoors = evenDoors;
    }

    public int[] getOddDoors() {
        return oddDoors;
    }

    public void setOddDoors(int[] oddDoors) {
        this.oddDoors = oddDoors;
    }

    /**
     * Gets the door to display to user currently. Checks if the room is
     *      even or odd, and what direction the user is facing (doorAt).
     * NOTE: doorAt is from 0 (North), 1 (East), 2 (South), 3 (West)
     * @param roomIndex
     * @param doorAt
     * @return
     */
    public int getDisplayDoor(int roomIndex, int doorAt) {
        int doorRet;
        if (roomIndex % 2 == 0) { //see if room is even
            doorRet = getEvenDoor(doorAt);
        } else { //room is odd
            doorRet = getOddDoor(doorAt);
        }

        return doorRet;
    }

    /**
     * Gets the question for the door based on matching index in Question[] with door[].
     * @param doorAt
     * @return
     */
    public Question getDoorQuestion(int doorAt) {
        Question questionRet = question[doorAt];

        return questionRet;
    }

}
