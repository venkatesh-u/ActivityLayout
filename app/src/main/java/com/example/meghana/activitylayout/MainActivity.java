package com.example.meghana.activitylayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private LinkedList<HousesInfor> houses;
    private ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("Lifecycle","oncreate");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                listView = (ListView)findViewById(R.id.list);
                setData();
                setListViewAdapter();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle","onStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle","onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle","onResume");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecycle","onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle","onDestroy");
    }



    private void setListViewAdapter() {

        adapter = new ListViewAdapter(this, R.layout.evenrow,houses);
        listView.setAdapter(adapter);
    }

    private void setData() {
        houses = new LinkedList<HousesInfor>();

        houses.add(new HousesInfor("TentHouse\n"+"\n"+"CarolinaCity\n"+"\n" +"USA", true));
        houses.add(new HousesInfor("Caribiancity\n"+"\n"+"NorthAmerica\n"+"\n"+"Paris", false));
        houses.add(new HousesInfor("Caribiancity\n" + "\n" + "NorthCaroina ", false));
        houses.add(new HousesInfor("Caribiancity\n"+"\n"+"USA", false));
        houses.add(new HousesInfor("HeavenHome\n" + "\n" + "NorthAmerica ", true));
        houses.add(new HousesInfor("Hampstirehome\n" + "\n" + "NorthAmerica ", true));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
