package fam.sa.simplecustlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Faheem on 23/10/15.
 */
public class ProductsAdapter extends ArrayAdapter<String > {


    String[] products_list;
    Integer[] image_ids;
    Context context;
    public ProductsAdapter(Activity context, Integer[] image_ids, String[] products_list){
        super(context, R.layout.list_item, products_list);
        this.products_list = products_list;
        this.image_ids = image_ids;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.list_item, null,
                true);
        TextView textView = (TextView) single_row.findViewById(R.id.text);
        ImageView imageView = (ImageView) single_row.findViewById(R.id.icon);
        textView.setText(products_list[position]);
        imageView.setImageResource(image_ids[position]);
        return single_row;
    }
}
