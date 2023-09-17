//package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game;
//
//import android.graphics.Canvas;
//import android.util.Log;
//import android.view.SurfaceHolder;
//
///**
// * SOURCE: https://www.javacodegeeks.com/2011/07/android-game-development-basic-game_05.html
// */
//public class MainThread extends Thread{
//    //flag for holding the game's state
//    private boolean isRunning;
//
//    private SurfaceHolder surfaceHolder;
//    private MainGameDisplay gameDisplay;
//    private static final String TAG = MainThread.class.getSimpleName();
//
//    public MainThread(SurfaceHolder surfaceHolder, MainGameDisplay gameDisplay) {
//        super();
//        this.surfaceHolder = surfaceHolder;
//        this.gameDisplay = gameDisplay;
//    }
//
//    public void setRunning(boolean running) {
//        this.isRunning = running;
//    }
//
//    @Override
//    public void run() {
//        Canvas canvas;
////        long count = 0L;
//        Log.d(TAG, "Game loop started");
//
//        while (isRunning == true) {
//            //TODO: update game state & render to screen
//            canvas = null;
////            count++;
//            try {
//                canvas = this.surfaceHolder.lockCanvas();
//                synchronized (surfaceHolder) {
//                    //TODO: update game state, draw canvas on panel
//                    this.gameDisplay.onDraw(canvas);
//                }
//            } finally {
//                //exception from surface in inconsistent state
//                if (canvas != null) {
//                    surfaceHolder.unlockCanvasAndPost(canvas);
//                }
//            }
//        }
////        Log.d(TAG, "Game loop executed " + count + " times");
//    }
//
//}
