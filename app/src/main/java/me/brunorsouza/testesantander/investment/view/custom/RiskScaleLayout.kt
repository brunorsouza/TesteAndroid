package me.brunorsouza.testesantander.investment.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.risk_scale.view.*
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.investment.model.Risk

class RiskScaleLayout(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init { LayoutInflater.from(context).inflate(R.layout.risk_scale, this) }

    fun setRiskInfo(riskInfo: Risk){
        txtRiskTitle.text = riskInfo.title

        when(riskInfo.risk){
            1 -> setRiskIndicator(colorLow, icLow)
            2 -> setRiskIndicator(colorMedium, icMedium)
            3 -> setRiskIndicator(colorHigh, icHigh)
            4 -> setRiskIndicator(colorHigher, icHigher)
        }
    }

    fun setRiskIndicator(colorIndicator: View, iconIndicator: ImageView){
        val params = colorIndicator.layoutParams
        params.height = 35
        colorIndicator.layoutParams = params

        iconIndicator.setImageResource(R.drawable.ic_down_arrow_24)
    }
}