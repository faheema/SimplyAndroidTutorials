package fam.sa.simplydialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout root_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root_layout=(LinearLayout)findViewById(R.id.root_layout);

       // showProgressDialog();
        //showSimpleDialog();
       //  showListDialog();
       // showSingleChoiceDialog();
        //Adding Buttons in the dialog
       //  showCustomDialog();
    }



    public  void showSimpleDialog(View view) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("AlertDialog Title");

        builder.setMessage("Simple Dialog Message")
                .setPositiveButton("OK!!!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ////
                    }
                })
        .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
               ;
        // Create the AlertDialog object and return it
         builder.create().show();
    }


    public void showListDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("pick a color")
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:
                                root_layout.setBackgroundColor(Color.RED);
                                break;
                            case 1:
                                root_layout.setBackgroundColor(Color.GREEN);
                                break;
                            case 2:
                                root_layout.setBackgroundColor(Color.BLUE);
                                break;

                        }
                        //Toast.makeText(MainActivity.this," "+which ,Toast.LENGTH_SHORT).show();
                    }
                });
         builder.create().show();
    }

    public void showSingleChoiceDialog(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setSingleChoiceItems(R.array.single_choice_array, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
    public void showMultiChoiceDialog(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMultiChoiceItems(R.array.single_choice_array, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.create().show();
    }
    public void showCustomDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Get the layout inflater
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.login_dialog, null))
                // Add action buttons
                .setPositiveButton("Sign in ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
               ;
         builder.create().show();
    }

    public void showHProgressDialog(View view)
    {

        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setMax(200);
        dialog.setTitle("Dialog Title");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // Update the progress bar
        Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                dialog.setProgress(150);
            }
        });

    dialog.show();

    }

    public void showVProgressDialog(View view)
    {   ProgressDialog dialog=new ProgressDialog(MainActivity.this);
        dialog.setTitle("Dialog Title");
        dialog.setMessage("Please wait while we process");

        dialog.show();

    }

}
