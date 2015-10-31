package fam.sa.simpleservicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this ,"My Service Created" ,Toast.LENGTH_SHORT).show();
        mediaPlayer=MediaPlayer.create(this,R.raw.laksh);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this ,"My Service Created" ,Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }
}
