package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BDD.MyDatabaseHelper;
import com.example.myapplication.Modele.Utilisateurs;

import java.time.LocalDateTime;

public class InscriptionActivity extends AppCompatActivity {
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

        EditText viewEmailUtilisateurs = findViewById(R.id.editTextTextEmailAddressInscription);
        String email = viewEmailUtilisateurs.getText().toString();


        EditText viewTelephoneUtilisateurs = findViewById(R.id.editTextPhoneInscription);
        String telephone = viewTelephoneUtilisateurs.getText().toString();


        EditText viewMdpUtilisateurs = findViewById(R.id.editTextTextPasswordInscription);
        String mdpUtilisateurs = viewMdpUtilisateurs.getText().toString();

        Utilisateurs userAdd = new Utilisateurs(nomUtilisateurs,"Test", LocalDateTime.now().toString(),email,mdpUtilisateurs,telephone);
        if(!userAdd.getMdp().isEmpty() && !userAdd.getNom().isEmpty() && !userAdd.getEmail().isEmpty() && !userAdd.getMdp().isEmpty()){
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
