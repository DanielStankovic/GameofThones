package com.example.daniel.gameofthones;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment4 extends Fragment implements View.OnClickListener {


    private  RadioGroup answerRadioGroup;
    private   RadioButton answer_1;
    private  RadioButton answer_2;
    private RadioButton answer_3;
    private TextView questionTitle;
    private TextView nextQuestion;


    public QuestionFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_fragment4, container, false);
        questionTitle = (TextView) view.findViewById(R.id.question1);
        nextQuestion = (TextView) view.findViewById(R.id.next_4);
        nextQuestion.setOnClickListener(this);
        answerRadioGroup = (RadioGroup) view.findViewById(R.id.answerRadioGroup);
        answer_1 = (RadioButton) view.findViewById(R.id.a1);
        answer_2 = (RadioButton) view.findViewById(R.id.a2);
        answer_3 = (RadioButton) view.findViewById(R.id.a3);
        mListener.changeFontText(questionTitle,answer_1,answer_2,answer_3,nextQuestion);
        mListener.getPageTitle("Question 4");

        return view;
    }



    @Override
    public void onClick(View v) {
String proba;
        int correctAnswer = answerRadioGroup.getCheckedRadioButtonId();
        String fieldID = this.getResources().getResourceName(v.getId());
        int id = Integer.parseInt(fieldID.split("_")[1]);
        if(correctAnswer == -1){
            mListener.showToast();

        } else {
            if (correctAnswer == answer_2.getId()) {
                proba = "tacno";
            } else {
                proba = "netacno";
            }
            mListener.sendInfo(proba, id);

            mListener.onFragmentSendMessage(id);


        }
    }

    OnFragmentSendMessageListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mListener = (OnFragmentSendMessageListener)context;
    }

}
