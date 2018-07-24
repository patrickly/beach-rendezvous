package com.example.beachrendevous;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
/*
---List the sports available to find and join group--

 */

public class MainActivity1 extends AppCompatActivity {

    TextView sportsheader;
    ListView mListView;


    String[] gameNames = {"SOCCER", "TENNNIS", "BASEBALL", "AMERICAN FOOTBALL", "VOLLEYBALL", "SOFTBALL"};
    int[] gameImages = {
            R.drawable.soccer,
            R.drawable.tennis,
            R.drawable.baseball,
            R.drawable.football,
            R.drawable.volleyball,
            R.drawable.softball
           };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports);
        sportsheader=(TextView)findViewById(R.id.sportsheader);
        sportsheader.setText("You want to join a game? \n No Problem, which Sport?");
        mListView = (ListView) findViewById(R.id.listview);
        sportsListAdapter myAdapter = new sportsListAdapter(MainActivity.this, gameNames, gameImages);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity1.this, findsportsDetails.class);
                mIntent.putExtra("gameName", gameNames[i]);
                startActivity(mIntent);
            }
        });
    }
}
