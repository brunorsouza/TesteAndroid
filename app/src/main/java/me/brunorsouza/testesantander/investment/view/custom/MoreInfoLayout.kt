package me.brunorsouza.testesantander.investment.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.more_info_layout.view.*
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.investment.model.MoreInfos

class MoreInfoLayout(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.more_info_layout, this)
    }

    fun setMoreInfos(moreInfos: MoreInfos){
        txtMoreInfoTitle.text = moreInfos.title

        txtMoreInfoFundMonth.text = moreInfos.onMonth.message1
        txtMoreInfoCdiMonth.text = moreInfos.onMonth.message2

        txtMoreInfoFundYear.text = moreInfos.onYear.message1
        txtMoreInfoCdiYear.text = moreInfos.onYear.message2

        txtMoreInfoFundTwelve.text = moreInfos.onTwelveMonths.message1
        txtMoreInfoCdiTwelve.text = moreInfos.onTwelveMonths.message2
    }

}