package com.example.daniel.gameofthones;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView playGame;
    TextView exitGame;
    TextView gameLogo;
    int REQUEST_EXIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playGame = (TextView)findViewById(R.id.play_game);
        exitGame = (TextView)findViewById(R.id.exit_game);
        gameLogo =(TextView)findViewById(R.id.gameLogo);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/got.ttf");

        playGame.setTypeface(custom_font);
        exitGame.setTypeface(custom_font);
        gameLogo.setTypeface(custom_font);

    }


public void exitGame (View view){
    System.exit(0);
}


//glavna aktivnost ovde instancira aktivnost sa fragmentima. Na dalje sve(???) se odvija u toj novoj aktivnosti.
public void playGameClick(View view){
    Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
    startActivityForResult(intent,REQUEST_EXIT );




}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_EXIT){
            if(resultCode == RESULT_OK){
                this.finish();
            }
        }
    }




}
