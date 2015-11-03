package fam.sa.fragmentsdemo;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ColorDetailsFragment extends Fragment {
    TextView tvColorCode;
    ImageView ivColor;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.colordetail_fragment, container, false);
        tvColorCode= (TextView) view.findViewById(R.id.tvColorCode);
        ivColor= (ImageView)view.findViewById(R.id.ivColor);


        return view;

    }
    public void change(int position){

        String code=getActivity().getResources().getStringArray(R.array.codelist)[position];
        tvColorCode.setText(code);
        ivColor.setBackgroundColor(Color.parseColor(code));


    }
}
