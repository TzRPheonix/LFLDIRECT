package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.BDD.MyDataBaseHelper;
import com.example.myapplication.Modele.Utilisateurs;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private final MyDataBaseHelper myDatabaseHelper = new MyDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("LFL Direct");

        int a = 1;
        System.out.println("66666666666666666666666666666666666666666666" + myDatabaseHelper.getUsers("caudron"));



        setContentView(R.layout.connexion);
    }

    public void onClickButtonMdpOublie(View view){
        Intent startMdpOublieActivity = new Intent(getApplicationContext(),MdpOublieActivity.class);
        startActivity(startMdpOublieActivity);
        finish();
    }




    public void onClickButtonInscription(View view){

        Intent startInscriptionActivity = new Intent(getApplicationContext(),InscriptionActivity.class);
        startActivity(startInscriptionActivity);
        finish();

    }

    public void onClickButtonConnexion(View view){

        EditText viewNomUtilisateurs = findViewById(R.id.userEditText);
        String nomUtilisateurs = viewNomUtilisateurs.getText().toString();

        EditText viewMdpUtilisateurs = findViewById(R.id.passwordEditText);
        String mdpUtilisateurs = viewMdpUtilisateurs.getText().toString();

        System.out.println("Test : " + nomUtilisateurs);
        System.out.println("Test : " + mdpUtilisateurs);


        Utilisateurs utilisateurs = myDatabaseHelper.getUsers(nomUtilisateurs);
        System.out.println(utilisateurs.getNom());

        if (utilisateurs.getId() != -1){
            if(utilisateurs.getMdp().equals(mdpUtilisateurs) && nomUtilisateurs.equals(utilisateurs.getNom())){

                Intent startAccueilActivity = new Intent(getApplicationContext(),AccueilActivity.class);
                startActivity(startAccueilActivity);
                finish();

            }
            else{
                System.out.println("La connexion a échoué :( ");
            }
        }
        


    }
}