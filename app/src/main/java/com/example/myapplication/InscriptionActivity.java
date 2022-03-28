package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BDD.MyDatabaseHelper;
import com.example.myapplication.Modele.Utilisateurs;

import java.time.LocalDateTime;

public class InscriptionActivity extends AppCompatActivity { //Caudron = bdd / axel = gestion des erreurs / Yorann = xml
    private final MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.inscription);

    }

    public void onClickRetour(View view){
        Intent retour = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(retour);
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickButtonSaisirInscription(View view) {

        System.out.println("S'INSCRIRE ----------------");

        EditText viewNomUtilisateurs = findViewById(R.id.editTextTextNomInscription);
        String nomUtilisateurs = viewNomUtilisateurs.getText().toString();


        EditText viewEmailUtilisateurs = findViewById(R.id.editTextTextEmailAddressInscription2);
        String email = viewEmailUtilisateurs.getText().toString();

        EditText viewPseudoUtilisateur = findViewById(R.id.editUser);
        String pseudo = viewPseudoUtilisateur.getText().toString();


        EditText viewTelephoneUtilisateurs = findViewById(R.id.editTextPhoneInscription);
        String telephone = viewTelephoneUtilisateurs.getText().toString();


        EditText viewMdpUtilisateurs = findViewById(R.id.editTextTextPasswordInscription);
        String mdpUtilisateurs = viewMdpUtilisateurs.getText().toString();

        String avote = "non";
        Utilisateurs userAdd = new Utilisateurs(nomUtilisateurs,pseudo,LocalDateTime.now().toString(),email,mdpUtilisateurs,telephone,avote);
        if(!userAdd.getMdp().isEmpty() && !userAdd.getNom().isEmpty() && !userAdd.getEmail().isEmpty() && !userAdd.getTelephone().isEmpty() && !userAdd.getPseudo().isEmpty() && userAdd.getEmail().contains("@") && userAdd.getTelephone().length() == 10){
            myDatabaseHelper.insert(userAdd);
            Intent connexionActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(connexionActivity);
            finish();
        }else{
            Toast T = Toast.makeText(getApplicationContext(),"Veuillez vérifiez votre saisie",Toast.LENGTH_SHORT);
            T.show();
        }
        System.out.println(userAdd);
        System.out.println(userAdd.getMdp());

    }
}
