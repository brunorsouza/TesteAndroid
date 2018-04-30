package me.brunorsouza.testesantander.base

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class EditTextMask(private val mMask: String, private val mEditText: EditText) : TextWatcher {

    private var isUpdating: Boolean = false
    private var old = ""

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        val str = unmask(s.toString())
        val mascara: String

        if (isUpdating) {
            old = str
            isUpdating = false
            return
        }

        if (str.length > old.length)
            mascara = mask(mMask, str)
        else
            mascara = s.toString()

        isUpdating = true

        mEditText.setText(mascara)
        mEditText.setSelection(mascara.length)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable) {}

    companion object {

        fun unmask(s: String): String {
            return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
                    .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
                    .replace("[)]".toRegex(), "")
        }

        fun mask(format: String, text: String): String {
            var maskedText = ""
            var i = 0
            for (m in format.toCharArray()) {
                if (m != '#') {
                    maskedText += m
                    continue
                }
                try {
                    maskedText += text[i]
                } catch (e: Exception) {
                    break
                }

                i++
            }
            return maskedText
        }
    }
}

