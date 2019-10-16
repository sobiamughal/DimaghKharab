package com.example.notification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public Button malebtn,femalebtn;
    private Switch mSwitch;
    public static String TRANSPARENT = "transparent";
    private SharedPreferences sharedPref;
    public Intent intent;
    Context ctx = MainActivity.this;
SettingsActivity st = new SettingsActivity();

MainActivity(){

}

    MainActivity(Context ctx){
this.ctx = ctx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         malebtn = (Button)findViewById(R.id.malebtn);
       femalebtn = (Button)findViewById(R.id.femalebtn);

        final Switch toggle =(Switch) findViewById(R.id.switchid);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                if (isChecked){
                    femalebtn.setVisibility(View.VISIBLE);
                }else {
                    femalebtn.setVisibility(View.INVISIBLE);
                }
//                if(!sharedPref.getBoolean(TRANSPARENT, false))
//                {
//                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
//
//                }
//                else
//                {
//                    startActivity(new Intent(MainActivity.this, MainActivity.class));
//                }
//                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // launch settings activity
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            intent.putExtra("select","selected");
            startActivity(intent);

            return true;
        }

        if (id == R.id.action_settings_headers) {
            // launch settings activity
//            startActivity(new Intent(MainActivity.this, SettingsHeadersActivity.class));
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnSwitchClicked(View view) {
    }
}
