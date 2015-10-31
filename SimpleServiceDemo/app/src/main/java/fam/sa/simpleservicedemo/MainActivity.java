package fam.sa.simpleservicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "SERVICE_DEMO";
    Button btn_startService, btn_stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_startService = (Button)findViewById(R.id.btn_startService);
        btn_stopService =(Button)findViewById(R.id.btn_stopService);
        btn_startService.setOnClickListener(this);
        btn_stopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_startService:
                startService(new Intent(MainActivity.this, MyService.class));
            break;

            case R.id.btn_stopService:
                stopService(new Intent(MainActivity.this, MyService.class));
            break;

        }
    }
}