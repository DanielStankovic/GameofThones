package com.example.daniel.gameofthones;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daniel on 8/1/2017.
 */

public class ResultDialog extends DialogFragment {
    public interface NoticeDialogListener{
        void onDialogPositiveClick(DialogFragment dialogFragment);
        void onDialogNeutralClick(DialogFragment dialogFragment);
    }

    NoticeDialogListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (NoticeDialogListener)context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }

    private String title;
    private String message;




    public void setTitle(String title){
        this.title = title;
    }
    public void setMessage(String message){
        this.message = message;
    }







    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View custom_dialog = inflater.inflate(R.layout.result_dialog, null);

        ImageButton closeBtn = (ImageButton)custom_dialog.findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultDialog.this.dismiss();
            }
        });

        TextView titleTextView = (TextView)custom_dialog.findViewById(R.id.dialogTitle);
        TextView messageTextView = (TextView)custom_dialog.findViewById(R.id.dialogMessage);






        if(savedInstanceState != null){
            title = savedInstanceState.getString("TITLE");
            message = savedInstanceState.getString("MESSAGE");

        }

        if(title != null){
            titleTextView.setText(title);
        }

        if(message != null){
            messageTextView.setText(message);
        }




        builder.setView(custom_dialog);


        builder.setPositiveButton("Exit Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogPositiveClick(ResultDialog.this);
            }
        });

        builder.setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogNeutralClick(ResultDialog.this);
            }
        });
        return builder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TITLE", title);
        outState.putString("MESSAGE", message);

    }


}
