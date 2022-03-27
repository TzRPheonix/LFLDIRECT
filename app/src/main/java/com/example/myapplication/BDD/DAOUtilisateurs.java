package com.example.myapplication.BDD;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Modele.Utilisateurs;

import java.util.List;

@Dao
public interface DAOUtilisateurs {

    @Query("SELECT * FROM Utilisateurs")
    List<Utilisateurs> getAll();

    @Query("SELECT * FROM Utilisateurs WHERE id IN (:userIds)")
    List<Utilisateurs> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Utilisateurs WHERE pseudo LIKE :first AND " +
            "nom LIKE :last LIMIT 1")
    Utilisateurs findByName(String first, String last);

    @Insert
    void insertAll(Utilisateurs... users);

    @Delete
    void delete(Utilisateurs user);
}
