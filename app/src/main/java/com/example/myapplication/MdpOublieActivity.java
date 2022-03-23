package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BDD.MyDatabaseHelper;
import com.example.myapplication.Modele.Utilisateurs;
import com.example.myapplication.ServiceMail.SendEmailService;

public class MdpOublieActivity extends AppCompatActivity {

    private final MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdpoublie);

    }

    public void onClickRetour(View view){
        Intent retour = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(retour);
        finish();
    }

    public void onClickButtonMail(View view){

        EditText editText = findViewById(R.id.editTextEmailMdpOublie);
        String email = editText.getText().toString();

        Utilisateurs utilisateurs = myDatabaseHelper.getUsers(email);

        if (utilisateurs != null){

            System.out.println("Le mot de passe de votre compte ("+ email +"):" +utilisateurs.getMdp());

            AsyncTask.execute(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    System.out.println("TESTTT");
                    SendEmailService.getInstance(getApplicationContext()).SendEmail(email,utilisateurs);
                    Intent startConnexionActivity = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(startConnexionActivity);
                    finish();
                }
            });

        }


        // Code a ajouté



    }





}
