package fam.sa.simplesharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText score;
    CheckBox checkBoxrem;
    Button btn_erase;
    TextView textViewShow;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText)findViewById(R.id.edt_name);
        score= (EditText)findViewById(R.id.edt_score);
        checkBoxrem= (CheckBox) findViewById(R.id.checkBox_rem);
        btn_erase= (Button) findViewById(R.id.btn_erase);
        textViewShow = (TextView) findViewById(R.id.textViewShow);
        sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        try {
            name.setText(sharedPref.getString("name_key", " "));
            score.setText(""+sharedPref.getInt("score_key", 0));
          }catch (Exception e) {e.printStackTrace();}

        checkBoxrem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("name_key", name.getText().toString());

                    int value = Integer.valueOf(score.getText().toString());
                    editor.putInt("score_key", value);

                    editor.commit();
                    textViewShow.setText(name.getText().toString() + "      " + score.getText().toString() + "\n" + "Stored in shared preference");


                }
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this,"Deleted SharedPreference Data",Toast.LENGTH_SHORT ).show();
            }
        });

    }
}
