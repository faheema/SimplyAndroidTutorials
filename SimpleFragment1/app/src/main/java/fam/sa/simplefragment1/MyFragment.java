package fam.sa.simplefragment1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment extends Fragment {

    public static String mytag= "Simply-MyFragment";

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(mytag, "onAttach");

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(mytag, "OnCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(mytag, "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(mytag, "onActivityCreated - OnActvity finished executing");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(mytag, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(mytag, "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(mytag, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(mytag, "onPause");
    }




    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(mytag, "onSaveInstanceState");
    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(mytag, "onDestroyView");
    }




    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(mytag, "onDetach");
    }


}
