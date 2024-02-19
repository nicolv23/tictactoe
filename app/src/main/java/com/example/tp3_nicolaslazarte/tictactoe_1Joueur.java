package com.example.tp3_nicolaslazarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class tictactoe_1Joueur extends AppCompatActivity {

    private final List<int[]> listeCombinaisons = new ArrayList<>();

    private int [] positionsTableau = {0,0,0,0,0,0,0,0,0};

    private int tourJoueur = 1;
    private int casesSelectionnes = 0;

    private LinearLayout joueur1Tableau;
    private TextView joueur1Nom;
    private ImageView image1, image2, image3, image4, image5,
            image6, image7, image8, image9;
    private EditText joueur1Points;
    protected int pointageJoueur1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe1_joueur);

        final Button menuPrincipale = findViewById(R.id.menu);
        final Button recommencer = findViewById(R.id.reset);

        joueur1Nom = findViewById(R.id.joueur1Nom);

        joueur1Tableau = findViewById(R.id.joueur1Tableau);

        joueur1Points = findViewById(R.id.joueur1Points);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);


        listeCombinaisons.add(new int[]{0,1,2});
        listeCombinaisons.add(new int[]{3,4,5});
        listeCombinaisons.add(new int[]{6,7,8});
        listeCombinaisons.add(new int[]{0,3,6});
        listeCombinaisons.add(new int[]{1,4,7});
        listeCombinaisons.add(new int[]{2,5,8});
        listeCombinaisons.add(new int[]{2,4,6});
        listeCombinaisons.add(new int[]{0,4,8});

        final String getJoueur1Nom = getIntent().getStringExtra("joueur1");

        joueur1Nom.setText(getJoueur1Nom);

        menuPrincipale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tictactoe_1Joueur.this, Menu.class);
                startActivity(intent);
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(0, (ImageView)v);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(1, (ImageView)v);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(2, (ImageView)v);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(3, (ImageView)v);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(4, (ImageView)v);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(5, (ImageView)v);
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(6, (ImageView)v);
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(7, (ImageView)v);
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouerCoup(8, (ImageView)v);
            }
        });
    }

    // Méthode pour gérer le tour du joueur
    private void jouerCoup(int position, ImageView imageView) {
        if (casesSelectionnes < 9 && caseSelectionne(position)) {
            casesSelectionnes++;
            positionsTableau[position] = tourJoueur;
            imageView.setImageResource(R.drawable.x); // ou autre symbole pour le joueur

            // Vérifier si le joueur a gagné
            if (verifierJoueurGagnant()) {
                Toast.makeText(this, "Joueur gagnant!", Toast.LENGTH_SHORT).show();
                // Réinitialiser le jeu ou retourner au menu principal
            } else if (casesSelectionnes == 9) {
                Toast.makeText(this, "Match nul!", Toast.LENGTH_SHORT).show();
                // Réinitialiser le jeu ou retourner au menu principal
            } else {
                // Passer au tour de l'IA
                jouerCoupIA();
            }
        }
    }

    private void jouerCoupIA() {
        Random random = new Random();
        int position;
        do {
            position = random.nextInt(9); // Sélectionner une position aléatoire
        } while (!caseSelectionne(position));

        positionsTableau[position] = 2; // Supposons que 2 représente l'IA
        ImageView imageView = null;
        switch (position) {
            case 0:
                imageView = image1;
                break;
            case 1:
                imageView = image2;
                break;
            case 2:
                imageView = image3;
                break;
            case 3:
                imageView = image4;
                break;
            case 4:
                imageView = image5;
                break;
            case 5:
                imageView = image6;
                break;
            case 6:
                imageView = image7;
                break;
            case 7:
                imageView = image8;
                break;
            case 8:
                imageView = image9;
                break;
        }
        if (imageView != null) {
            imageView.setImageResource(R.drawable.cercle); // ou autre symbole pour l'IA
        }

        // Vérifier si l'IA a gagné
        if (verifierJoueurGagnant()) {
            Toast.makeText(this, "L'IA a gagné!", Toast.LENGTH_SHORT).show();
            // Réinitialiser le jeu ou retourner au menu principal
        } else if (casesSelectionnes == 9) {
            Toast.makeText(this, "Match nul!", Toast.LENGTH_SHORT).show();
            // Réinitialiser le jeu ou retourner au menu principal
        }
    }

    private boolean caseSelectionne(int position) {
        return positionsTableau[position] == 0;
    }

    private boolean verifierJoueurGagnant() {
        for (int[] combinaison : listeCombinaisons) {
            if (positionsTableau[combinaison[0]] == positionsTableau[combinaison[1]] &&
                    positionsTableau[combinaison[1]] == positionsTableau[combinaison[2]] &&
                    positionsTableau[combinaison[0]] != 0) {
                return true;
            }
        }
        return false;
    }
}
