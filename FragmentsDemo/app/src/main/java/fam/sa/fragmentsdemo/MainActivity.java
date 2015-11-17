package fam.sa.fragmentsdemo;

import android.app.FragmentManager;
import android.content.res.Configuration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements ICommunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

    }

    @Override
    public void chage(int pos) {

        ColorDetailsFragment fragment2 = (ColorDetailsFragment)getFragmentManager().findFragmentById(R.id.fragment2);

        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article

        if (fragment2 != null) {

            // Call a method in the ArticleFragment to update its content
            fragment2.change(pos);

        }
    }
}
