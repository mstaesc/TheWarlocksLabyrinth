package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.R;

public class Door extends AppCompatActivity {
    /*
    SOURCE: https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
     */

    // Context object
    Context context;

    // Array of images
    int[] evenDoors;

    // Layout Inflater
    LayoutInflater mLayoutInflater;


    // Viewpager Constructor
    public Door(int[] evenDoors) {
//        this.context = context;
        this.evenDoors = evenDoors;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

}
