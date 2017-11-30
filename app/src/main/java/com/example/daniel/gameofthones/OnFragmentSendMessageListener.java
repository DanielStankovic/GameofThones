package com.example.daniel.gameofthones;

import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Daniel on 7/31/2017.
 */

public interface OnFragmentSendMessageListener {
    public void onFragmentSendMessage(int id);
    public void changeFontText(TextView question, RadioButton a1, RadioButton a2, RadioButton a3, TextView next);
        void showToast();
    public void showResultDialog();
    int sendInfo(String proba, int id);
     void getPageTitle(String title);
}
