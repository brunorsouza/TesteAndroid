package me.brunorsouza.testesantander.contact.view.cell

import me.brunorsouza.testesantander.contact.FieldCell
import java.util.regex.Pattern

const val EMAIL_REGEX: String = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}\$"

class EmailFieldCell(id: Int = -1,
                     type: Int = 1,
                     message: String = "",
                     typeField: Int = 3,
                     hidden: Boolean = false,
                     topSpacing: Double = 8.0,
                     show: Int = -1,
                     required: Boolean = false) :
        FieldCell(id, type, message, typeField, hidden, topSpacing, show, required){

    private val EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX,
            Pattern.CASE_INSENSITIVE)

    override fun validate(response: String) = EMAIL_PATTERN.matcher(response).find()

}