package me.brunorsouza.testesantander.investment.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.header_investment.view.*
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.investment.model.Header

class HeaderLayout(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.header_investment, this)
    }

    fun setInfos(header: Header){
        txtName.text = header.assetName
        txtHeaderTitle.text = header.title
        txtHeaderWhatIs.text = header.whatIs
        txtHeaderDefinition.text = header.definition
    }

}