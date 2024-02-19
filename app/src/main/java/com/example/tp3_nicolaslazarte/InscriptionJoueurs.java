package com.example.tp3_nicolaslazarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionJoueurs extends AppCompatActivity {

    /**
     * Page d'inscription pour les 2 joueurs
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_joueurs);

        /**
         * Initialisations des variables de la classe InscriptionJoueurs
         */
        final EditText joueur1 = findViewById(R.id.joueur1Nom);
        final EditText joueur2 = findViewById(R.id.joueur2Nom);
        final Button demarrerJeu = findViewById(R.id.demarrerJeu);
        final Button retour = findViewById(R.id.retour);

        /**
         * Bouton pour démarrer le jeu
         */
        demarrerJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getJoueur1Nom = joueur1.getText().toString();
                final String getJoueur2Nom = joueur2.getText().toString();

                if(getJoueur1Nom.isEmpty() || getJoueur2Nom.isEmpty()){
                    Toast.makeText(InscriptionJoueurs.this, R.string.champ_vides_joueurs, Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(InscriptionJoueurs.this, TicTacToe.class);
                    intent.putExtra("joueur1", getJoueur1Nom);
                    intent.putExtra("joueur2", getJoueur2Nom);
                    startActivity(intent);
                }
            }
        });

        /**
         * Retour au menu principal
         */
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InscriptionJoueurs.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}