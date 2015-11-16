package fam.sa.fragmentsdemo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
;
/**
 * Created by Faheem on 03/11/15.
 */
public class ColorListFragment extends Fragment {

    ListView listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.colorlist_fragment, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getActivity().getResources().getStringArray(R.array.colorlist));

        listView=(ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ColorDetailsFragment fragment2 = (ColorDetailsFragment)getFragmentManager().findFragmentById(R.id.fragment2);
                fragment2.change(position);
                listView.setSelector(android.R.color.holo_blue_dark);


            }
        });

        return view;

    }


}
