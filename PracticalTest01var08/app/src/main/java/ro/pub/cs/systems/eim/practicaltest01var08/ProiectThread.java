package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

/**
 * Created by student on 4/1/16.
 */
public class ProiectThread extends Thread{
    private Context context;

    private double ma,mg;
    private boolean isRunning = true;
    public ProiectThread(Context context) {
        this.context = context;
    }

    public void stopThread() {
        isRunning = false;
    }
    @Override
    public void run() {
        while(isRunning){
            sendMessage();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("orice");
        intent.putExtra("mesaj", new Date(System.currentTimeMillis())+" "+ma+" "+mg);
        context.sendBroadcast(intent);
    }
}
