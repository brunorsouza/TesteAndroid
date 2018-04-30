package me.brunorsouza.testesantander.contact.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import me.brunorsouza.testesantander.contact.Cell

const val NEGATIVE_INT = -1

abstract class CellView(val cell: Cell, private val rootView: ViewGroup) {

    protected var onShowRequest: OnShowRequest? = null

    protected lateinit var view: View

    abstract fun inflateView()

    fun getCellView() = view

    protected fun inflateLayout(layoutId: Int){
        this.view = LayoutInflater
                .from(rootView.context)
                .inflate(layoutId, rootView, false)

        if(cell.hidden!!){
            this.view.visibility = View.GONE
        }

        setMargin()
    }

    private fun setMargin(){
        val params = this.view.layoutParams as LinearLayout.LayoutParams

        params.setMargins(0, cell.topSpacing!!.toInt(), 0, 0)
    }

    fun setListener(listener: OnShowRequest){
        if(cell.show != NEGATIVE_INT){
            onShowRequest = listener
        }
    }

}