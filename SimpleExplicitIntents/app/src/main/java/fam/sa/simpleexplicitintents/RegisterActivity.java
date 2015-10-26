package fam.sa.simpleexplicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button submit;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        submit=(Button)findViewById(R.id.submit);
        editText=(EditText)findViewById(R.id.editText);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    @Override
    public void finish() {
        // Prepare data intent
        Intent registerintent = new Intent();
        registerintent.putExtra("registerKey", " "+editText.getText());

        // Activity finished ok, return the data
        setResult(RESULT_OK, registerintent);
        super.finish();
    }
}
