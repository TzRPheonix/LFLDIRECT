package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.BDD.MyDatabaseHelper;
import com.example.myapplication.Modele.Utilisateurs;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private final MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("LFL Direct");

        setContentView(R.layout.connexion);
    }

    public void onClickButtonMdpOublie(View view){
        Intent startMdpOublieActivity = new Intent(getApplicationContext(),MdpOublieActivity.class);
        startActivity(startMdpOublieActivity);
        finish();
    }

    public void onClickButtonReset(View view){
        SQLiteDatabase md = myDatabaseHelper.getReadableDatabase();
        myDatabaseHelper.onUpgrade(md,0,1);
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
            if(utilisateurs.getMdp().equals(mdpUtilisateurs) && nomUtilisateurs.equals(utilisateurs.getPseudo()) || nomUtilisateurs.equals(utilisateurs.getEmail())){

                Intent startAccueilActivity = new Intent(getApplicationContext(),AccueilActivity.class);
                startActivity(startAccueilActivity);
                finish();

            }
            else{
                System.out.println("La connexion a échoué :( ");
                Toast T = Toast.makeText(getApplicationContext(),"Veuillez vérifiez votre saisie",Toast.LENGTH_SHORT);
                T.show();
            }
        }else{
            Toast T = Toast.makeText(getApplicationContext(),"Veuillez vérifiez votre saisie",Toast.LENGTH_SHORT);
            T.show();
        }
    }
}