package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        setTitle("LFL DIRECT");

        Button mainPage = (Button) findViewById(R.id.conn);

        mainPage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View changePage) {

                Intent intent1 = new Intent(MainActivity.this, homePage.class);

                startActivity(intent1);
            }
        });
    }
}
