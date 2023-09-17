//package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//
//import androidx.annotation.NonNull;
//
//import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.R;
//
///**
// * SOURCE: https://www.javacodegeeks.com/2011/07/android-game-development-basic-game_05.html
// */
//public class MainGameDisplay extends SurfaceView implements SurfaceHolder.Callback {
//
//    private MainThread mThread;
//    private static final String TAG = MainGameDisplay.class.getSimpleName();
//
//    public MainGameDisplay(Context context) {
//        super(context);
//
//        //set current class as handler for events on actual surface
//        getHolder().addCallback(this); //add callback for this, to surface holder to get events
//
//        mThread = new MainThread(getHolder(), this); //create game loop thread
//
//        setFocusable(true); //make display focusable to handle events
//    }
//
//    @Override
//    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
//        //instantiate thread to true & start it
//        mThread.setRunning(true);
//        mThread.start();
//        //surface is created & game loop starts
//    }
//
//    @Override
//    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
//        //shutdown thread & make it wait to finish
//        boolean isRetry = true;
//        while (isRetry) {
//            try {
//                //block thread & wait for it to idle
//                mThread.join();
//                isRetry = false;
//
//            } catch (InterruptedException e) {
//                //shut down the thread
//            }
//        }
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //NOTE: screen upper left is coordinates (0,0) & lower right is (getWidth(), getHeight())
//        if (event.getAction() == MotionEvent.ACTION_DOWN) { //start of a pressed gesture on screen
//            if (event.getY() > getHeight() - 50) { //check if touch on lower part of screen (lower 50 pixels)
//                //set thread status & call finish() to exit app
//                mThread.setRunning(false);
//                ((Activity)getContext()).finish();
//            } else {
//                Log.d(TAG, "Coords: x=" + event.getX() + ", y=" + event.getY());
//            }
//        }
//
//        return super.onTouchEvent(event);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.omnitom), 10, 10, null); //at coordinate (10,10)
//    }
//}
