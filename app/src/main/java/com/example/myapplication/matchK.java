package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.TEAM.Karminepage;
import com.google.android.material.navigation.NavigationView;

public class matchK extends AppCompatActivity {
    private int i = 0;
    private int j = 0;
    private Boolean avote = false;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("cptK", i);
        savedInstanceState.putInt("cptL", j);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int cptK = savedInstanceState.getInt("cptK");
        int cptL = savedInstanceState.getInt("cptL");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){

        setTitle("LFL Direct");

        setContentView(R.layout.matchkarmine);

        Button b1 = (Button) findViewById(R.id.buttonVote1);
        TextView v1 = (TextView) findViewById(R.id.score1);
        Button b2 = (Button) findViewById(R.id.buttonVote2);
        TextView v2 = (TextView) findViewById(R.id.score2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(avote){
                    Toast T = Toast.makeText(getApplicationContext(),"Vous avez déjà voté !",Toast.LENGTH_SHORT);
                    T.show();
                }else{
                    avote = true;
                    i++;
                    String vote = Integer.toString(i);
                    v1.setText(vote);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(avote){
                    Toast T = Toast.makeText(getApplicationContext(),"Vous avez déjà voté !",Toast.LENGTH_SHORT);
                    T.show();
                }else{
                    avote = true;
                    j++;
                    String vote = Integer.toString(j);
                    v2.setText(vote);
                }
            }
        });
        }
    }


    public void onClickRetour(View view){
        Intent retour = new Intent(getApplicationContext(), Karminepage.class);
        startActivity(retour);
        finish();
    }

}
