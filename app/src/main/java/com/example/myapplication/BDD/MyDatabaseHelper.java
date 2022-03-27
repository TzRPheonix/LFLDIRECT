package com.example.myapplication.BDD;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Modele.Utilisateurs;

import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String COLUMN_NOTE_ID ="Id";
    private static final String COLUMN_NOTE_NOM ="nom";
    private static final String COLUMN_NOTE_PSEUDO = "pseudo";
    private static final String COLUMN_NOTE_DATEINSCRIPTION ="dateInscription";
    private static final String COLUMN_NOTE_EMAIL ="email";
    private static final String COLUMN_NOTE_MDP = "mdp";
    private static final String COLUMN_NOTE_TELEPHONE ="telephone";



// ....

    public MyDatabaseHelper(Context context) {
        super(context, "db_LFLDIRECT", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String script = "CREATE TABLE IF NOT EXISTS " + "Utilisateurs" + "("
                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NOTE_NOM + " TEXT,"
                + COLUMN_NOTE_PSEUDO + " TEXT,"+ COLUMN_NOTE_DATEINSCRIPTION+ " TEXT," + COLUMN_NOTE_EMAIL + " TEXT," + COLUMN_NOTE_MDP + " TEXT," + COLUMN_NOTE_TELEPHONE + " TEXT"+ ")" ;
        // Execute script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop table
        db.execSQL("DROP TABLE IF EXISTS " + "Utilisateurs");


        // Recreate
        onCreate(db);
    }



    public List<Utilisateurs> getAll() {
        return null;
    }


    public List<Utilisateurs> loadAllByIds(int[] userIds) {
        return null;
    }


    public Utilisateurs findByName(String first, String last) {
        return null;
    }

    public void insertAll(Utilisateurs... users) {

    }


    public void insert(Utilisateurs user) {

        String sql = "INSERT INTO Utilisateurs (nom, pseudo, dateInscription, email, mdp, telephone) VALUES('" + user.getNom() + "', '" + user.getPseudo() + "', '" + user.getDateInscription() + "', '" + user.getEmail() + "', '" + user.getMdp() +  "' ,'" + user.getTelephone() +  "')" ;
        getWritableDatabase().execSQL(sql);
    }


    public Utilisateurs getUsers(String elementConnexion){

        String sql = "Select * from Utilisateurs where pseudo ='" +elementConnexion +"' or email='"+elementConnexion+"';";
        @SuppressLint("Recycle") Cursor cursor = getWritableDatabase().rawQuery(sql,null);

        int id = -1;
        String nom = null;
        String pseudo = null;
        String dateInscription = null;
        String email= null;
        String mdp= null;
        String telephone= null;

        if (cursor.moveToFirst()){
            id = cursor.getInt(0);
            nom = cursor.getString(1);
            pseudo = cursor.getString(2);
            dateInscription = cursor.getString(3);
            email = cursor.getString(4);
            mdp = cursor.getString(5);
            telephone = cursor.getString(6);
        }
        else{
            System.out.println("L'utilisateur n'existe Pas");
        }
        return new Utilisateurs(id,nom,pseudo,dateInscription,email,mdp,telephone);
    }


    public void delete(Utilisateurs user) {

    }
}
