package com.example.tp3_nicolaslazarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {


    /**
     * Page du Menu Principal
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /**
         * Initialisations des variables de la classe Menu
         */
        final Button jeu1Joueur = findViewById(R.id.jeu1Joueur);
        final Button jeu2Joueurs = findViewById(R.id.jeu2Joueurs);
        final Button instructions = findViewById(R.id.instructions);
        final Button quitter = findViewById(R.id.quitterJeu);
        final Button rotation = findViewById(R.id.rotationEcran);

        /**
         * Bouton pour aller à la page Instructions
         */
        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, CommentJouer.class);
                startActivity(intent);
            }
        });

        /**
         * Bouton pour jouer au jeu Tic-Tac-Toe
         */
        jeu2Joueurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, InscriptionJoueurs.class);
                startActivity(intent);
            }
        });

        /**
         * Bouton pour quitter le jeu
         */
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        jeu1Joueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, liste_1joueur.class);
                startActivity(intent);
            }
        });

        /**
         * Bouton pour faire tourner l'écran
         */
        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else{
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });


    }
/*
    protected void rotationEcran(){
        final Button rotation = findViewById(R.id.rotationEcran);
        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                if(window.){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
    }*/
}