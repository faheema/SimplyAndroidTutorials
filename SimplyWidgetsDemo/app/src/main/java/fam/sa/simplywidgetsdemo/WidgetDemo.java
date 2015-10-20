package fam.sa.simplywidgetsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;import fam.sa.simplywidgetsdemo.R;

public class WidgetDemo extends AppCompatActivity {

    Button buttonDemo;
    CheckBox checkBox;
    RadioButton radioButton;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_demo);
        textView = (TextView)findViewById(R.id.textViewdemo);
        buttonDemo = (Button)findViewById(R.id.button_demo);
        buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast toast= Toast.makeText(WidgetDemo.this,"Button is clicked", Toast.LENGTH_SHORT);
                       toast.setGravity(Gravity.TOP,30,30);
                toast.show();

            }
        });

        checkBox = (CheckBox)findViewById(R.id.checkbox_Demo);
        radioButton= (RadioButton)findViewById(R.id.radiobtn_demo);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("CHEK BOX is Checked !!!");
                } else {
                    textView.setText("");
                }

            }
        });
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(true);
            }
        });

        editText = (EditText)findViewById(R.id.editTextDemo);
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                textView.setText("You have entered  "+editText.getText().toString().length()+" characters");
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }
}
