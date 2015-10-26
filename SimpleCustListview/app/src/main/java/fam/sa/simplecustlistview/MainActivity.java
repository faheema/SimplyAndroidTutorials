package fam.sa.simplecustlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String products_list[] = {"Large Furniture", "The Home Store", "Sports & Fitness",
            " The Travel Store", "Car Tyres", " Household Supplies",
            "Pet Supplies", "DigiFlip"," Automotive Accessories"," Women Safety"
             };
    Integer image_ids[] = {R.drawable.p1,R.drawable.p2, R.drawable.p3,R.drawable.p4,
            R.drawable.p5, R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10};


    ListView mlstVProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlstVProducts= (ListView)findViewById(R.id.lstVProducts);

        ProductsAdapter adapter = new ProductsAdapter(this, image_ids, products_list);

        mlstVProducts.setAdapter(adapter);


    }
}
