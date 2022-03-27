package com.example.myapplication.TEAM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.AccueilActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Modele.Utilisateurs;
import com.example.myapplication.R;
import com.example.myapplication.matchK;

public class Karminepage extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pargekarmine);


    }

    public void onClickMatch(View view){
        Intent retour = new Intent(getApplicationContext(), matchK.class);
        startActivity(retour);
        finish();
    }

    public void onClickRetour(View view){
        Intent retour = new Intent(getApplicationContext(), AccueilActivity.class);
        startActivity(retour);
        finish();
    }



}
