package me.brunorsouza.testesantander.contact.view.custom

import android.view.ViewGroup
import me.brunorsouza.testesantander.contact.FieldCell
import me.brunorsouza.testesantander.contact.view.CellView

abstract class FieldCellView(fieldCell: FieldCell,
                             rootView: ViewGroup): CellView(fieldCell, rootView){

    abstract fun isValid(): Boolean

    abstract fun showError()

    abstract fun dismissError()

    abstract fun clear()

}