package com.example.tp3_nicolaslazarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CommentJouer extends AppCompatActivity {

    /**
     * Page d'applications pour les instructions du jeu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_jouer);

        final Button retourner_menu = findViewById(R.id.retourner_menu);

        /**
         * Retourner au Menu Principal
         */
        retourner_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommentJouer.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}