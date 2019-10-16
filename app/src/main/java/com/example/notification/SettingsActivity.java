package com.example.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class SettingsActivity extends info.androidhive.settings.AppCompatPreferenceActivity {
    public static final String TAG = SettingsActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_main);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button malebtn = (Button)findViewById(R.id.malebtn);
        final Button femalebtn = (Button)findViewById(R.id.femalebtn);

        // Get the custom preference
        SwitchPreference switchPreference = (SwitchPreference) findPreference("switch");
        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object  newValue) {
                boolean isOn = (boolean) newValue;

                MainActivity ma= new MainActivity(SettingsActivity.this);
               // Button btn = ma.malebtn;

                ma.malebtn =  findViewById(R.id.malebtn);
                if (isOn) {
                    malebtn.setText(getIntent().getStringExtra("select"));
                 //   btn.setText("Demo");
                   ma.malebtn.setVisibility(View.VISIBLE);
                    //femalebtn.setVisibility(View.VISIBLE);
                    Toast.makeText(SettingsActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();

                } else {
                    //femalebtn.setVisibility(View.INVISIBLE);
                    Toast.makeText(SettingsActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

}
