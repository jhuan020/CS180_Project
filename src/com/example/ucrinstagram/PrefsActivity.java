package com.example.ucrinstagram;

import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.TextView;
=======
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
>>>>>>> origin/master

public class PrefsActivity extends PreferenceActivity {
	final int ACTIVITY_SELECT_IMAGE = 1234;
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   getActionBar().setDisplayHomeAsUpEnabled(true);
   addPreferencesFromResource(R.xml.prefs);
<<<<<<< HEAD
}

=======

}
>>>>>>> origin/master

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            // This is called when the Home (Up) button is pressed
            // in the Action Bar.
            Intent parentActivityIntent = new Intent(this, Profile.class);
            parentActivityIntent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentActivityIntent);
            finish();
            return true;
    }
    return super.onOptionsItemSelected(item);
}

}
