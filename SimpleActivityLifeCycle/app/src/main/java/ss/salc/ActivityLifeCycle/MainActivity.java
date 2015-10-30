package ss.salc.ActivityLifeCycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


   /**Used to setup your activity. You will almost always have to have it .
    * This is where you must call setContentView() to define the layout for the activity's user interface.
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate",  Toast.LENGTH_SHORT).show();
    }

    public void onClickButton(View view)
    {
        startActivity(new Intent(MainActivity.this, AnotherActivity.class));
    }
    /**onStart() and onStop()
     Use to setup code that starts/stops the activity. Unlike onResume() and onPause(), it includes Paused state as well.
     onRestart()Called when the activity is restarted. It is followed by onStart() and onResume().
     * */
    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    /**
     * A good place to do any cleanup before the activity is cleaned up from memory. This is the counter-part to onCreate().
     * **/
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
