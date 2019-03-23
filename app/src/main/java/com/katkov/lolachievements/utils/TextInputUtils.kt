package com.katkov.lolachievements.utils

import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

object TextInputUtils {

    fun getText(textInputLayout: TextInputLayout): String {
        val editText = textInputLayout.editText ?: return CommonStringUtils.EMPTY_STING
        val text = editText.text ?: return CommonStringUtils.EMPTY_STING
        return text.toString()
    }

    fun setText(textInputLayout: TextInputLayout, text: String) {
        val editText = textInputLayout.editText ?: return
        editText.setText(text)
    }

    fun setText(textView: TextView, text: String?) {
        if (text == null) {
            return
        }
        textView.text = text
    }
}
