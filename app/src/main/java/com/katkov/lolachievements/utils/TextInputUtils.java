package com.katkov.lolachievements.utils;

import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class TextInputUtils {

    public static String getText(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return "";
        }
        Editable text = editText.getText();
        if (text == null) {
            return "";
        }
        return text.toString();
    }

    public static void setText(TextInputLayout textInputLayout, String text) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return;
        }
        editText.setText(text);
    }

    public static void setText(TextView textView, String text) {
        if (text == null) {
            return;
        }
        textView.setText(text);
    }
}
