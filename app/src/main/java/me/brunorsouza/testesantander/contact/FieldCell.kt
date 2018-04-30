package me.brunorsouza.testesantander.contact

abstract class FieldCell(id: Int? = -1,
                         type: Int? = 1,
                         message: String? = "",
                         typeField: Any? = null,
                         hidden: Boolean? = false,
                         topSpacing: Double? = 8.0,
                         show: Int? = -1,
                         required: Boolean? = false) :
        Cell(id, type, message, typeField, hidden, topSpacing, show, required){

    abstract fun validate(response: String): Boolean
}