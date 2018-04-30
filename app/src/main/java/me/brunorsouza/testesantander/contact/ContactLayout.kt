package me.brunorsouza.testesantander.contact

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import me.brunorsouza.testesantander.contact.view.CellView
import me.brunorsouza.testesantander.contact.view.custom.FieldCellView
import me.brunorsouza.testesantander.contact.view.OnShowRequest
import me.brunorsouza.testesantander.contact.view.custom.SendCellView

class ContactLayout(context: Context, attrs: AttributeSet): LinearLayout(context, attrs), OnShowRequest {

    init {
        layoutTransition = LayoutTransition()
    }

    var listCellView = mutableListOf<CellView>()

    fun setCellsView(cells: MutableList<CellView>){

        listCellView = cells

        listCellView.forEach { cell ->
            cell.setListener(this)
            addView(cell.getCellView())
        }

    }

    fun clearAll(){
        listCellView.forEach { cell ->
            if (cell is FieldCellView) {
                cell.dismissError()
                cell.clear()
            }
        }
    }

    fun checkErrors(): Boolean {
        var hasError = false

        listCellView.forEach { cell ->
            if(cell is FieldCellView && !cell.isValid()) {
                hasError = true
            }
        }

        return hasError
    }

    fun dismissError(){
        listCellView.forEach { cell ->
            if (cell is FieldCellView) {
                cell.dismissError()
            }
        }
    }

    fun showError(){
        listCellView.forEach { cell ->
            if (cell is FieldCellView && !cell.isValid()) {
                cell.showError()
            }
        }
    }

    fun setSendButtonListener(listener: View.OnClickListener){
        listCellView.forEach { cell ->
            (cell as? SendCellView)?.setSendListener(listener)
        }
    }

    override fun showView(id: Int) {
        listCellView.forEach { cellView ->
            if(cellView.cell.id == id){
                cellView.getCellView().visibility = View.VISIBLE
            }
        }
    }

    override fun dismissView(id: Int) {
        listCellView.forEach { cellView ->
            if(cellView.cell.id == id){
                cellView.getCellView().visibility = View.GONE
            }
        }
    }
}