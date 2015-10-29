package fam.sa.simplysqllitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> arrayAdapter;
    TaskDBHelperClass dbHelperClass;

    private ListView lstVTaks ;
    private Button btnAdd;
    private EditText edtTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVTaks =(ListView)findViewById(R.id.lstVTaks);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        edtTask= (EditText) findViewById(R.id.edtTask);
        dbHelperClass=new TaskDBHelperClass(this);

        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dbHelperClass.getAllTasks());

        lstVTaks.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task= edtTask.getText().toString().trim();
               //If not null add in the DB
                if(!task.isEmpty())
                dbHelperClass.addTask(task);

                //update the listview
                lstVTaks.invalidate();
                 arrayAdapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, dbHelperClass.getAllTasks());
                lstVTaks.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
