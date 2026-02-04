package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import org.w3c.dom.Text;

public class SummaryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summaryscreen);

        //we need to read the timestamp array lists and then pass them into the list view

        //happy
        ListView listView1 = findViewById(R.id.happylist);
        ArrayList<String> timestamps1 = getIntent().getStringArrayListExtra("timestamps1");

        assert timestamps1 != null;
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, timestamps1);
        listView1.setAdapter(adapter1);


        //sad
        ListView listView2 = findViewById(R.id.sadlist);
        ArrayList<String> timestamps2 = getIntent().getStringArrayListExtra("timestamps2");

        assert timestamps2 != null;
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, timestamps2);
        listView2.setAdapter(adapter2);

        //grateful

        ListView listView3 = findViewById(R.id.gratefullist);
        ArrayList<String> timestamps3 = getIntent().getStringArrayListExtra("timestamps3");

        assert timestamps3 != null;
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, timestamps3);
        listView3.setAdapter(adapter3);

        //angry
        ListView listView4 = findViewById(R.id.angrylist);
        ArrayList<String> timestamps4 = getIntent().getStringArrayListExtra("timestamps4");

        assert timestamps4 != null;
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, timestamps4);
        listView4.setAdapter(adapter4);

        //excited
        ListView listView5 = findViewById(R.id.excitedlist);
        ArrayList<String> timestamps5 = getIntent().getStringArrayListExtra("timestamps5");

        assert timestamps5 != null;
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, timestamps5);
        listView5.setAdapter(adapter5);

        //disappointed

        ListView listView6 = findViewById(R.id.disappointedlist);
        ArrayList<String> timestamps6 = getIntent().getStringArrayListExtra("timestamps6");

        assert timestamps6 != null;
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, timestamps6);
        listView6.setAdapter(adapter6);




        //we need to take the counts and frequencies and then pass them into the textview
        int count1 = getIntent().getIntExtra("HappyButtonCount",0);
        int count2 = getIntent().getIntExtra("SadButtonCount",0);
        int count3 = getIntent().getIntExtra("GratefulButtonCount",0);
        int count4 = getIntent().getIntExtra("AngryButtonCount",0);
        int count5 = getIntent().getIntExtra("ExcitedButtonCount",0);
        int count6 = getIntent().getIntExtra("DisappointedButtonCount",0);

        int TotalCount = getIntent().getIntExtra("TotalPresses",0);

        //happy text
        String count1freq = ("Happy " + count1+"/"+ TotalCount);
        TextView HappyText = findViewById(R.id.happytext);
        HappyText.setText(count1freq);

        //sad text
        String count2freq = ("Sad " + count2+"/"+ TotalCount);
        TextView SadText = findViewById(R.id.sadtext);
        SadText.setText(count2freq);

        //Grateful text
        String count3freq = ("Grateful " + count3+"/"+ TotalCount);
        TextView GratefulText = findViewById(R.id.gratefultext);
        GratefulText.setText(count3freq);

        //angry text
        String count4freq = ("Angry " + count4+"/"+ TotalCount);
        TextView AngryText = findViewById(R.id.angrytext);
        AngryText.setText(count4freq);

        //excited text
        String count5freq = ("Happy" + count5+"/"+ TotalCount);
        TextView ExcitedText = findViewById(R.id.excitedtext);
        ExcitedText.setText(count5freq);

        //disappointed text
        String count6freq = ("Happy" + count6+"/"+ TotalCount);
        TextView DisappointedText = findViewById(R.id.disappointedtext);
        DisappointedText.setText(count6freq);

        //back button
        Button backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(v->{
            Intent intent = new Intent(SummaryScreen.this, MainActivity.class);
            //go back to the main screen

            startActivity(intent);
        });
    }
}
//this is the summary screen