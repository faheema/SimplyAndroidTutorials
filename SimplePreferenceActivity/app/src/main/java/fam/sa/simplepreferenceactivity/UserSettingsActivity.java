package fam.sa.simplepreferenceactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Faheem on 25/10/15.
 */
public class UserSettingsActivity
        extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefes);
    }


}

