package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.TEAM.BDSpage;
import com.example.myapplication.TEAM.GOpage;
import com.example.myapplication.TEAM.GWpage;
import com.example.myapplication.TEAM.Karminepage;
import com.example.myapplication.TEAM.Ldlcpage;
import com.example.myapplication.TEAM.MEpage;
import com.example.myapplication.TEAM.MPpage;
import com.example.myapplication.TEAM.Spage;
import com.example.myapplication.TEAM.TOpage;
import com.example.myapplication.TEAM.VBpage;

public class AccueilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);


    }

    public void OnClickInfoKarmine(View view){

        Intent startKarminepage = new Intent(getApplicationContext(), Karminepage.class);
        startActivity(startKarminepage);
        onPause();
    }
    public void OnClickInfoMP(View view){

        Intent startMPpage = new Intent(getApplicationContext(), MPpage.class);
        startActivity(startMPpage);
        onPause();
    }
    public void OnClickInfoVB(View view){

        Intent startVBpage = new Intent(getApplicationContext(), VBpage.class);
        startActivity(startVBpage);
        onPause();
    }
    public void OnClickInfoS(View view){

        Intent startSpage = new Intent(getApplicationContext(), Spage.class);
        startActivity(startSpage);
        onPause();
    }

    public void OnClickInfoldlc(View view){

        Intent startLdlcpage = new Intent(getApplicationContext(), Ldlcpage.class);
        startActivity(startLdlcpage);
        onPause();
    }

    public void OnClickInfoBDS(View view){

        Intent startBDSpage = new Intent(getApplicationContext(), BDSpage.class);
        startActivity(startBDSpage);
        onPause();
    }

    public void OnClickInfoGW(View view){

        Intent startGWpage = new Intent(getApplicationContext(), GWpage.class);
        startActivity(startGWpage);
        onPause();
    }
    public void OnClickInfoGO(View view){

        Intent startGOpage = new Intent(getApplicationContext(), GOpage.class);
        startActivity(startGOpage);
        onPause();
    }
    public void OnClickInfoTO(View view){

        Intent startTOpage = new Intent(getApplicationContext(), TOpage.class);
        startActivity(startTOpage);
        onPause();
    }
    public void OnClickInfoME(View view){

        Intent startMEpage = new Intent(getApplicationContext(), MEpage.class);
        startActivity(startMEpage);
        onPause();
    }
}
