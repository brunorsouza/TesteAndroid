package me.brunorsouza.testesantander.contact.view.custom

import android.content.res.ColorStateList
import android.graphics.Color
import android.support.design.widget.TextInputEditText
import android.support.v4.view.ViewCompat
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.edit_text_view.view.*
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.base.EditTextMask
import me.brunorsouza.testesantander.contact.FieldCell
import me.brunorsouza.testesantander.contact.view.PhoneNumberFieldCell
import me.brunorsouza.testesantander.contact.view.cell.EmailFieldCell
import me.brunorsouza.testesantander.contact.view.cell.TextFieldCell

class TextFieldCellView(private val textFieldCell: FieldCell, rootView: ViewGroup): FieldCellView(textFieldCell, rootView) {

    init { this.inflateView() }

    private lateinit var editText: TextInputEditText

    private var phoneMask: EditTextMask? = null

    override fun isValid(): Boolean {
        if(this.view.visibility == View.GONE) return true

        val text = editText.text.toString()

        return textFieldCell.validate(text)
    }

    override fun showError() {
        val colorState = ColorStateList.valueOf(Color.RED)
        ViewCompat.setBackgroundTintList(editText, colorState)
    }

    override fun dismissError() {
        val colorState = ColorStateList.valueOf(Color.GREEN)
        ViewCompat.setBackgroundTintList(editText, colorState)
    }

    override fun inflateView() {
        inflateLayout(R.layout.edit_text_view)

        editText = this.view.editText

        val textInputLayout = this.view.textInputLayout

        textInputLayout.hint = textFieldCell.message

        val colorStateList = ColorStateList.valueOf(Color.GRAY)
        ViewCompat.setBackgroundTintList(editText, colorStateList)

        when(textFieldCell){
            is EmailFieldCell -> setupEmailField()
            is PhoneNumberFieldCell -> setupPhoneNumberField()
            is TextFieldCell -> setupTextField()
        }
    }

    private fun setupEmailField() {
        editText.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
    }

    private fun setupPhoneNumberField() {
        editText.inputType = InputType.TYPE_CLASS_PHONE

        phoneMask = EditTextMask("(##)#####-####", editText)
        editText.addTextChangedListener(phoneMask)
    }

    private fun setupTextField() {
        editText.inputType = InputType.TYPE_CLASS_TEXT
    }

    override fun clear() {
        editText.setText("", TextView.BufferType.EDITABLE)

        val colorState = ColorStateList.valueOf(Color.GRAY)
        ViewCompat.setBackgroundTintList(editText, colorState)
    }


}