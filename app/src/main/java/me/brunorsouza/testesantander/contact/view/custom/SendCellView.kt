package me.brunorsouza.testesantander.contact.view.custom

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.contact.Cell
import me.brunorsouza.testesantander.contact.view.CellView

class SendCellView(private val sendFieldCell: Cell,
                   rootView: ViewGroup): CellView(sendFieldCell, rootView) {

    init {
        this.inflateView()
    }

    override fun inflateView() {
        inflateLayout(R.layout.send_cell_view)

        (this.view as Button).text = sendFieldCell.message
    }

    fun setSendListener(clickListener: View.OnClickListener){
        this.view.setOnClickListener(clickListener)
    }

}