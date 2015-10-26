package fam.sa.simpleimplicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onbrowerIntent(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.simplyandroid.info"));

        MainActivity.this.startActivity(intent);



    }
    public void onGallaryIntent(View view) {

        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivity(i);

    }


    public void onTelephoneIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:555–555–5555"));
        MainActivity.this.startActivity(intent);

    }
}
