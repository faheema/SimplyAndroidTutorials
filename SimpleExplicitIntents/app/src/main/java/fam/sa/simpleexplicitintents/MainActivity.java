package fam.sa.simpleexplicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int REGISTER_REQUEST_CODE = 1;

    Button registerBtn;
    TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerText=(TextView)findViewById(R.id.registerText);

        registerBtn= (Button)findViewById(R.id.buttonRegister);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,RegisterActivity.class);

               // MainActivity.this.startActivity(i);

                startActivityForResult(i, REGISTER_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentdata) {
        // Check which request we're responding to
        if (requestCode == REGISTER_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

               String name= intentdata.getStringExtra("registerKey");
                registerText.setText("Thankyou "+name+" for registering with us");

            }
        }
    }
}
