package fam.sa.simplylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String selectedItems;
    String months [] ={"Reading Books","Cycling","Badminton","Cricket"	,"Playing Chess"	,"Cooking"	,"Creative writing","Gardening","Video Games","Coin collection","Travelling","Watching Movies"};

    //Define a Adapter
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.simpleListView);
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,months);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p_arg0, View p_arg1, int p_arg2, long p_arg3) {
                selectedItems = new String("Selected Items = ");
                int totalcount=listView.getCount();
                SparseBooleanArray sparseBooleanArray = listView.getCheckedItemPositions();
                for(int i = 0; i < totalcount; i++){

                    if(sparseBooleanArray.get(i)) {

                        selectedItems += listView.getItemAtPosition(i).toString() + "\n";

                    }

                }
                Toast.makeText(MainActivity.this,selectedItems,Toast.LENGTH_LONG).show();
                Log.v("values", selectedItems);
            }
        });


    }
}
