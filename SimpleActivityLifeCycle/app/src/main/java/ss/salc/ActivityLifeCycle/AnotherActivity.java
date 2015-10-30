package ss.salc.ActivityLifeCycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
    }
/*
    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "AnotherActivity - onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "AnotherActivity - onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "AnotherActivity - onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "AnotherActivity - onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "AnotherActivity - onRestart", Toast.LENGTH_SHORT).show();
    }

    *//**
     * A good place to do any cleanup before the activity is cleaned up from memory. This is the counter-part to onCreate().
     * **//*
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "AnotherActivity - onDestroy", Toast.LENGTH_SHORT).show();
    }
*/
}
