package ro.pub.cs.systems.eim.practicaltest01var08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by student on 4/1/16.
 */
public class PracticalTest01Var08Service extends Service{
        ProiectThread thread1 = null;
        @Override
        public int onStartCommand(Intent intent,int flags, int startId) {
            thread1 = new ProiectThread(this);
            thread1.start();
            return Service.START_REDELIVER_INTENT;
        }
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            thread1.stopThread();
        }
}
