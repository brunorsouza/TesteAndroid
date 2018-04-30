package me.brunorsouza.testesantander.contact.view.custom

import android.view.ViewGroup
import android.widget.TextView
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.contact.Cell
import me.brunorsouza.testesantander.contact.view.CellView

class TextCellView(private val textCell: Cell, rootView: ViewGroup): CellView(textCell, rootView) {

    init { inflateView() }

    override fun inflateView() {
        inflateLayout(R.layout.text_view)
        (this.view as TextView).text = textCell.message
    }

}