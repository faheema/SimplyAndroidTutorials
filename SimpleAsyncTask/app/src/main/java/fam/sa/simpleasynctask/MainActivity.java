package fam.sa.simpleasynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

   private  String IMG_URL="https://pbs.twimg.com/profile_images/615680132565504000/EIpgSD2K.png";

    ImageView ivShowImage;
    Button btn_dwnlodImage;
    private ProgressDialog progressDialg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivShowImage = (ImageView) findViewById(R.id.imv_showImage);

        btn_dwnlodImage = (Button) findViewById(R.id.btn_dwnldImage);

        // Capture button click
        btn_dwnlodImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Execute DownloadImage AsyncTask
                new DownloadImage().execute(IMG_URL);
            }
        });
    }

    // DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            progressDialg = new ProgressDialog(MainActivity.this);
            progressDialg.setMessage("dowloading image...");
            progressDialg.setIndeterminate(false);
            // Show progressdialog
            progressDialg.show();
        }

        @Override
        protected Bitmap doInBackground(String... urlarr) {

            String strImageURL = urlarr[0];
            Bitmap img=null;
            URL url;
            try {
                img= download_Image(strImageURL);
            } catch (Exception e) {
                // here
                e.printStackTrace();
            }
            return img;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            Log.d("***result****"," result= "+result);
        // Set the bitmap into ImageView
            ivShowImage.setImageBitmap(result);
            // Close progressdialog
            progressDialg.dismiss();
        }
        private Bitmap download_Image(String url) {

            Bitmap bmp =null;
            try{
               URL ulrn = new URL(url);

                HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();

                InputStream is = con.getInputStream();

                 bmp = BitmapFactory.decodeStream(is);

                Log.d("***bmp****"," bmp= "+bmp);
                if (null != bmp)
                    return bmp;

            }catch(Exception e){}
            return bmp;
        }

    }

}
