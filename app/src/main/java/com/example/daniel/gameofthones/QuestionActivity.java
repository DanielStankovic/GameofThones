package com.example.daniel.gameofthones;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity implements OnFragmentSendMessageListener, ResultDialog.NoticeDialogListener {

    FrameLayout fragmentContainer;

public int counter = 0;

    public  int answ1 = 0;
    public  int answ2 = 0;
    public  int answ3  = 0;
    public  int answ4  = 0;
    public  int answ5  = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
if(fragmentContainer!= null){
    if(savedInstanceState == null){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment firstQuestion = new QuestionFragment1();


        ft.add(fragmentContainer.getId(), firstQuestion);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}


    }


    @Override
    public void onFragmentSendMessage(int message) {
        onNextButtonClick(message);
    }

    @Override
    public void changeFontText(TextView question, RadioButton a1, RadioButton a2, RadioButton a3, TextView next) {
        changeFont(question, a1,a2, a3, next);
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Choose an answer", Toast.LENGTH_SHORT ).show();
    }


    @Override
    public void showResultDialog() {

        int pointCounter = answ1 + answ2 + answ3 + answ4 + answ5;
        String title = "Congratulations!";
        String message = "You have answered " + pointCounter + " question(s) correctly!";
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ResultDialog resultDialog = new ResultDialog();
        resultDialog.setTitle(title);
        resultDialog.setMessage(message);

        resultDialog.show(ft, "result_dialog");


    }

    @Override
    public int sendInfo(String proba, int id) {
        switch (id){
            case 1:
            if(proba.equals("tacno")){
                return answ1 = 1;
            } else if(proba.equals("netacno")){
                return answ1 = 0;
            }


            case 2:
                if(proba.equals("tacno")){
                    return  answ2 = 1;
                }
                else if(proba.equals("netacno")) {
                    return answ2 = 0;
                }
            case 3:
                if(proba.equals("tacno")){
                    return  answ3 = 1;
                }else if(proba.equals("netacno")) {
                    return answ3 = 0;
                }
            case 4:
                if(proba.equals("tacno")){
                    return   answ4 = 1;
                } else if(proba.equals("netacno")) {
                    return answ4 = 0;
                }
            case 5:
                if(proba.equals("tacno")){
                    return    answ5 = 1;
                } else if(proba.equals("netacno")) {
                    return answ5 = 0;
                }


        }
        return 0;


    }

    @Override
    public void getPageTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


    public void onNextButtonClick(int id) {
        Fragment fragment = null;
        switch (id) {
            case 1:
                fragment = new QuestionFragment2();

                break;
            case 2:
                fragment = new QuestionFragment3();
                break;
            case 3:
                fragment = new QuestionFragment4();
                break;
            case 4:
                fragment = new QuestionFragment5();
                break;




        }
if(fragmentContainer != null) {

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

    ft.replace(fragmentContainer.getId(), fragment);
    ft.addToBackStack(null);
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    ft.commit();
}

    }

    public void changeFont(TextView question, RadioButton a1, RadioButton a2, RadioButton a3, TextView next) {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/got.ttf");
        question.setTypeface(custom_font);
        a1.setTypeface(custom_font);
        a2.setTypeface(custom_font);
        a3.setTypeface(custom_font);
        next.setTypeface(custom_font);
    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialogFragment) {
        setResult(RESULT_OK, null);
        finish();
    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialogFragment) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
