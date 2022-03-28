package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.TEAM.Karminepage;
import com.google.android.gms.maps.MapView;

public class newsK extends AppCompatActivity {  //Axel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("LFL Direct");

        setContentView(R.layout.newsk);
    }


    public void onClickRetour(View view){
        Intent retour = new Intent(getApplicationContext(), Karminepage.class);
        startActivity(retour);
        finish();
    }

    public void onClickNews1(View view){
        String url ="https://www.millenium.org/news/388424.html";
        Intent startCIC = new Intent(Intent.ACTION_VIEW);
        startCIC.setData(Uri.parse(url));
        startActivity(startCIC);
    }

    public void onClickNews2(View view){
        String url ="https://www.millenium.org/news/388582.html";
        Intent startCIC = new Intent(Intent.ACTION_VIEW);
        startCIC.setData(Uri.parse(url));
        startActivity(startCIC);
    }
    public void onClickNews3(View view){
        String url ="https://www.lequipe.fr/Esport/Actualites/League-of-legends-ldlc-ol-termine-en-tete-de-la-lfl-vitality-fait-chuter-la-karmine-corp/1321396";
        Intent startCIC = new Intent(Intent.ACTION_VIEW);
        startCIC.setData(Uri.parse(url));
        startActivity(startCIC);
    }

}
