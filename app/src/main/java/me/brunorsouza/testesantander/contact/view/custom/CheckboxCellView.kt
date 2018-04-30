package me.brunorsouza.testesantander.contact.view.custom

import android.view.ViewGroup
import android.widget.CheckBox
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.contact.Cell
import me.brunorsouza.testesantander.contact.view.CellView

class CheckboxCellView(private val checkboxCell: Cell, rootView: ViewGroup): CellView(checkboxCell, rootView) {

    init { this.inflateView() }

    override fun inflateView() {
        inflateLayout(R.layout.checkbox_view)

        (this.view as CheckBox).text = checkboxCell.message

        (this.view as CheckBox).setOnCheckedChangeListener { _, checked ->
            if(checked){
                onShowRequest?.showView(checkboxCell.show!!)
            } else {
                onShowRequest?.dismissView(checkboxCell.show!!)
            }
        }
    }

}