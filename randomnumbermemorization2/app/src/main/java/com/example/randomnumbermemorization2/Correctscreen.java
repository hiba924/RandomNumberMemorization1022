package com.example.randomnumbermemorization2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

public class Correctscreen extends AppCompatActivity {
    Button nextlevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correctscreen);
        TextView thescore = (TextView) findViewById(R.id.thescore);
        int thescore2 = getIntent().getIntExtra("currentlevel", R.id.thescore);
        nextlevel = (Button) findViewById(R.id.nextlevel);
        String correctsequence = getIntent().getStringExtra("correctstring").trim();

        List<String> players = getIntent().getStringArrayListExtra("players");

        nextlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thescore3 = thescore2;
                String score = Integer.toString(thescore3);
                Intent correctscreen = new Intent(Correctscreen.this, SeeSequenceActivity.class);//connects to next display page
                correctscreen.putExtra("thescore", score);
                correctscreen.putExtra("addontothis", correctsequence);
                correctscreen.putExtra("players", (Serializable) players);
                System.out.println("this is what" + correctsequence);
                startActivity(correctscreen);//starts screen
            }
        });
        thescore.setText("Score: "+(correctsequence.length()));//outputs score


    }
}