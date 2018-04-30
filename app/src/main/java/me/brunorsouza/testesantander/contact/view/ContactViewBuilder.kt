package me.brunorsouza.testesantander.contact.view

import me.brunorsouza.testesantander.base.Type
import me.brunorsouza.testesantander.contact.Cell
import me.brunorsouza.testesantander.contact.ContactLayout
import me.brunorsouza.testesantander.contact.FieldCell
import me.brunorsouza.testesantander.contact.view.custom.CheckboxCellView
import me.brunorsouza.testesantander.contact.view.custom.SendCellView
import me.brunorsouza.testesantander.contact.view.custom.TextCellView
import me.brunorsouza.testesantander.contact.view.custom.TextFieldCellView

class ContactViewBuilder(private val rootView: ContactLayout) {

    fun proccessCellsFormView(cells: MutableList<Cell>): MutableList<CellView>{
        val listCellView = mutableListOf<CellView>()

        cells.forEach { cell ->
            listCellView.add(getCellView(cell))
        }

        rootView.setCellsView(listCellView)

        return listCellView
    }

    private fun getCellView(cell: Cell): CellView {
        return when (cell.type) {
            Type.field.position -> TextFieldCellView(cell as FieldCell, rootView)
            Type.text.position -> TextCellView(cell, rootView)
            Type.checkbox.position -> CheckboxCellView(cell, rootView)
            Type.send.position -> SendCellView(cell, rootView)
            else -> TextCellView(cell, rootView)
        }
    }
}