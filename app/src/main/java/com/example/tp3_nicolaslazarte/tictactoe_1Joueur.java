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

import java.util.ArrayList;
import java.util.List;

public class tictactoe_1Joueur extends AppCompatActivity {

    private final List<int[]> listeCombinaisons = new ArrayList<>();

    private int [] positionsTableau = {0,0,0,0,0,0,0,0,0};

    private int tourJoueur = 1;
    private int casesSelectionnes = 1;

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

    }
}