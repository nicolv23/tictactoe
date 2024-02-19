package com.example.tp3_nicolaslazarte;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DialogueVictoire extends Dialog {

    /**
     * Initialisation des variables et du constructeur DialogueVictoire
     */
    private final String message;
    private final TicTacToe tictactoe;
    private final tictactoe_1Joueur ticTacToe1Joueur;

    public DialogueVictoire(@NonNull Context context, String message, TicTacToe tictactoe) {
        super(context);
        this.message = message;
        this.tictactoe = tictactoe;
        this.ticTacToe1Joueur = null;
    }

    public DialogueVictoire(@NonNull Context context, String message, tictactoe_1Joueur ticTacToe1Joueur) {
        super(context);
        this.message = message;
        this.ticTacToe1Joueur = ticTacToe1Joueur;
        this.tictactoe = null;
    }

    /**
     * Message affichant lorsqu'un joueur gagne la partie
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_joueur_gagnant);

        final TextView messageTxt = findViewById(R.id.messageTexte);
        final Button recommencerPartie = findViewById(R.id.recommencer);

        messageTxt.setText(message);

        recommencerPartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tictactoe != null) {
                    tictactoe.nouvellePartie();
                } else if (ticTacToe1Joueur != null) {
                    ticTacToe1Joueur.reinitialiserPartie();
                }
                dismiss();
            }
        });
    }
}
