package edu.uw.tcss450.mtaesc.thewarlockslabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

//import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game.MainGameDisplay;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Inside onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Inside onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Inside onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "Inside onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Inside onDestory");
        super.onDestroy();
    }
}