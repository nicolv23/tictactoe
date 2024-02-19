package com.example.tp3_nicolaslazarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class liste_1joueur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste1joueur);


        final EditText joueur1 = findViewById(R.id.joueur1Nom);
        final Button demarrerJeu = findViewById(R.id.demarrerJeu);
        final Button retour = findViewById(R.id.retour);

        demarrerJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getJoueur1Nom = joueur1.getText().toString();

                if(getJoueur1Nom.isEmpty()){
                    Toast.makeText(liste_1joueur.this, R.string.champ_vide_joueur, Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(liste_1joueur.this, tictactoe_1Joueur.class);
                    intent.putExtra("joueur1", getJoueur1Nom);
                    startActivity(intent);
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(liste_1joueur.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}