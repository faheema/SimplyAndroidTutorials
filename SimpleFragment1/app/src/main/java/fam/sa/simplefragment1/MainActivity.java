package fam.sa.simplefragment1;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(MyFragment.mytag, "onCreate- ACTIVITY");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(MyFragment.mytag, "onStart - ACTIVITY");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(MyFragment.mytag, "onResume - ACTIVITY");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(MyFragment.mytag, "onRestart - ACTIVITY");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(MyFragment.mytag, "onPause - ACTIVITY");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MyFragment.mytag, "onStop - ACTIVITY");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(MyFragment.mytag, "onSaveInstanceState - ACTIVITY");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(MyFragment.mytag, "onRestoreInstanceState - ACTIVITY");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(MyFragment.mytag, "onDestroy - ACTIVITY");
    }


}
