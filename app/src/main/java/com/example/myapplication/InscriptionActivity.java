package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BDD.MyDataBaseHelper;
import com.example.myapplication.Modele.Utilisateurs;

import java.time.LocalDateTime;

public class InscriptionActivity extends AppCompatActivity {
    private final MyDataBaseHelper myDatabaseHelper = new MyDataBaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.inscription);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickButtonSaisirInscription(View view) {

        System.out.println("S'INSCRIRE ----------------");

        EditText viewNomUtilisateurs = findViewById(R.id.editTextTextNomInscription);
        String nomUtilisateurs = viewNomUtilisateurs.getText().toString();

        EditText viewEmailUtilisateurs = findViewById(R.id.editTextTextEmailAddressInscription);
        String email = viewEmailUtilisateurs.getText().toString();


        EditText viewTelephoneUtilisateurs = findViewById(R.id.editTextPhoneInscription);
        String telephone = viewTelephoneUtilisateurs.getText().toString();


        EditText viewMdpUtilisateurs = findViewById(R.id.editTextTextPasswordInscription);
        String mdpUtilisateurs = viewMdpUtilisateurs.getText().toString();

        Utilisateurs userAdd = new Utilisateurs(nomUtilisateurs,"Test", LocalDateTime.now().toString(),email,mdpUtilisateurs,telephone);

        System.out.println(userAdd);

        myDatabaseHelper.insert(userAdd);

        Intent connexionActivity = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(connexionActivity);
        finish();

    }
}
