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

public class TicTacToe extends AppCompatActivity {

    /**
     * Initialisation des variables de la classe TicTacToe
     */
    private final List<int[]> listeCombinaisons = new ArrayList<>();

    private int [] positionsTableau = {0,0,0,0,0,0,0,0,0};

    private int tourJoueur = 1;
    private int casesSelectionnes = 1;

    private LinearLayout joueur1Tableau, joueur2Tableau;
    private TextView joueur1Nom, joueur2Nom;
    private ImageView image1, image2, image3, image4, image5,
            image6, image7, image8, image9;
    private EditText joueur1Points, joueur2Points;
    protected int pointageJoueur1, pointageJoueur2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        final Button menuPrincipale = findViewById(R.id.menu);
        final Button recommencer = findViewById(R.id.reset);

        joueur1Nom = findViewById(R.id.joueur1Nom);
        joueur2Nom = findViewById(R.id.joueur2Nom);

        joueur1Tableau = findViewById(R.id.joueur1Tableau);
        joueur2Tableau = findViewById(R.id.joueur2Tableau);


        joueur1Points = findViewById(R.id.joueur1Points);
        joueur2Points = findViewById(R.id.joueur2Points);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);


        /**
         * Ajouter les differentes combinaisons pour gagner la partie
         */
        listeCombinaisons.add(new int[]{0,1,2});
        listeCombinaisons.add(new int[]{3,4,5});
        listeCombinaisons.add(new int[]{6,7,8});
        listeCombinaisons.add(new int[]{0,3,6});
        listeCombinaisons.add(new int[]{1,4,7});
        listeCombinaisons.add(new int[]{2,5,8});
        listeCombinaisons.add(new int[]{2,4,6});
        listeCombinaisons.add(new int[]{0,4,8});

        final String getJoueur1Nom = getIntent().getStringExtra("joueur1");
        final String getJoueur2Nom = getIntent().getStringExtra("joueur2");

        joueur1Nom.setText(getJoueur1Nom);
        joueur2Nom.setText(getJoueur2Nom);

        /**
         * Bouton pour recommencer la partie
         */
        recommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reinitialiserScore();
            }
        });

        /**
         * Bouton pour retourner au Menu Principale
         */
        menuPrincipale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TicTacToe.this, Menu.class);
                startActivity(intent);
            }
        });

        /**
         * Cliquer sur les cases du Tic-Tac-Toe pour faire apparaitre les images
         */
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(caseSelectionne(0)){
                    choisirCase((ImageView)v, 0 );
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(1)){
                    choisirCase((ImageView)v, 1 );
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(2)){
                    choisirCase((ImageView)v, 2 );
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(3)){
                    choisirCase((ImageView)v, 3 );
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(4)){
                    choisirCase((ImageView)v, 4 );
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(5)){
                    choisirCase((ImageView)v, 5 );
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(6)){
                    choisirCase((ImageView)v, 6 );
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(7)){
                    choisirCase((ImageView)v, 7 );
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseSelectionne(8)){
                    choisirCase((ImageView)v, 8 );
                }
            }
        });
    }

    /**
     * Choisir une case Tic-Tac-Toe qui est libre
     * @param imageView
     * @param positionCase
     */
    private void choisirCase(ImageView imageView, int positionCase){

        positionsTableau[positionCase] = tourJoueur;

        // Joueur 1 va utiliser les X
        if(tourJoueur == 1){
            imageView.setImageResource(R.drawable.x);

            // Verifier si Joueur 1 a gagne la partie
            if(verifierJoueurGagnant()){
                pointageJoueur1++;
                joueur1Points.setText(Integer.toString(pointageJoueur1));
                DialogueVictoire gagnant = new DialogueVictoire(TicTacToe.this, joueur1Nom.getText().toString() + " " + getResources().getString(R.string.joueur_gagnant), TicTacToe.this);
                gagnant.setCancelable(false);
                gagnant.show();
            }

            // Partie Nulle si toutes les cases ont ete selectionnes
            else if(casesSelectionnes == 9){
                DialogueVictoire partieNulle = new DialogueVictoire(TicTacToe.this, getResources().getString(R.string.partie_nulle), TicTacToe.this);
                partieNulle.setCancelable(false);
                partieNulle.show();
            }

            // Changer de tour quand le joueur a selectionne sa case
            else {
                changerTourJoueur(2);
                casesSelectionnes++;
            }
        }
        else{

            // Joueur 2 va utiliser les cercles
            imageView.setImageResource(R.drawable.cercle);

            // Verifier si Joueur 2 a gagne
            if (verifierJoueurGagnant()){
                pointageJoueur2++;
                joueur2Points.setText(Integer.toString(pointageJoueur2));
                DialogueVictoire gagnant = new DialogueVictoire(TicTacToe.this, joueur2Nom.getText().toString() + " " + getResources().getString(R.string.joueur_gagnant), TicTacToe.this);
                gagnant.setCancelable(false);
                gagnant.show();
            }

            else if(casesSelectionnes == 9){
                DialogueVictoire partieNulle = new DialogueVictoire(TicTacToe.this, getResources().getString(R.string.partie_nulle), TicTacToe.this);
                partieNulle.setCancelable(false);
                partieNulle.show();
            }

            else{
                changerTourJoueur(1);
                casesSelectionnes++;
            }
        }
    }

    /**
     * Methode pour changer le tour du Joueur
     * @param tourJoueurActuel
     */
    private void changerTourJoueur(int tourJoueurActuel){

        tourJoueur = tourJoueurActuel;

        if(tourJoueur == 1){
            joueur1Tableau.setBackgroundResource(R.drawable.tableau);
            joueur2Tableau.setBackgroundResource(R.drawable.tables);
        }
        else{
            joueur2Tableau.setBackgroundResource(R.drawable.tableau);
            joueur1Tableau.setBackgroundResource(R.drawable.tables);
        }
    }

    /**
     * Methode pour savoir qui a gagne la partie
     * @return
     */
    private boolean verifierJoueurGagnant(){
        boolean confirmation = false;

        for(int i=0;i<listeCombinaisons.size();i++){

            final int [] combinaison = listeCombinaisons.get(i);

            if(positionsTableau[combinaison[0]] == tourJoueur && positionsTableau[combinaison[1]] == tourJoueur && positionsTableau[combinaison[2]] == tourJoueur){
                confirmation = true;

            }
        }
        return confirmation;
    }

    /**
     * Methode pour confirmer la case selectionne
     * @param position
     * @return
     */
    private boolean caseSelectionne(int position){
        boolean confirmation = false;

        if(positionsTableau[position] == 0){
            confirmation = true;
        }

        return confirmation;
    }

    /**
     * Methode pour reinitialiser les pointages des joueurs
     */
    public void reinitialiserScore(){

        positionsTableau = new int[]{0,0,0,0,0,0,0,0,0};
        pointageJoueur1 = 0;
        pointageJoueur2 = 0;
        joueur1Points.setText(Integer.toString(0));
        joueur2Points.setText(Integer.toString(0));
        tourJoueur = 1;

        casesSelectionnes = 1;

        image1.setImageResource(R.drawable.carre);
        image2.setImageResource(R.drawable.carre);
        image3.setImageResource(R.drawable.carre);
        image4.setImageResource(R.drawable.carre);
        image5.setImageResource(R.drawable.carre);
        image6.setImageResource(R.drawable.carre);
        image7.setImageResource(R.drawable.carre);
        image8.setImageResource(R.drawable.carre);
        image9.setImageResource(R.drawable.carre);

        Toast.makeText(this, R.string.pointage_reinitialises, Toast.LENGTH_SHORT).show();

    }

    /**
     * Methode pour commencer une nouvelle partie
     */
    public void nouvellePartie(){

        positionsTableau = new int[]{0,0,0,0,0,0,0,0,0};
        changerTourJoueur(tourJoueur);
        if(tourJoueur == 1){
            Toast.makeText(this, joueur1Nom.getText() + " " + getResources().getString(R.string.joueur_debut_partie), Toast.LENGTH_SHORT).show();
        } else if(tourJoueur == 2){
            Toast.makeText(this, joueur2Nom.getText() + " " + getResources().getString(R.string.joueur_debut_partie), Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, joueur1Nom.getText() + " " + getResources().getString(R.string.joueur_debut_partieDefaut), Toast.LENGTH_SHORT).show();
        }
        casesSelectionnes = 1;

        image1.setImageResource(R.drawable.carre);
        image2.setImageResource(R.drawable.carre);
        image3.setImageResource(R.drawable.carre);
        image4.setImageResource(R.drawable.carre);
        image5.setImageResource(R.drawable.carre);
        image6.setImageResource(R.drawable.carre);
        image7.setImageResource(R.drawable.carre);
        image8.setImageResource(R.drawable.carre);
        image9.setImageResource(R.drawable.carre);
    }
}