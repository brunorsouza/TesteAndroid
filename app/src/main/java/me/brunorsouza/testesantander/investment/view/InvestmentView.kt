package me.brunorsouza.testesantander.investment.view

import me.brunorsouza.testesantander.base.BaseView
import me.brunorsouza.testesantander.investment.model.Header
import me.brunorsouza.testesantander.investment.model.Info
import me.brunorsouza.testesantander.investment.model.MoreInfos
import me.brunorsouza.testesantander.investment.model.Risk

interface InvestmentView : BaseView {

    fun setHeader(headerInfo: Header)

    fun setRisk(riskInfo: Risk)

    fun setMoreInfos(moreInfos: MoreInfos)

    fun setListInfos(infos: MutableList<Info>)

    fun setDownInfos(infos: MutableList<Info>)

    fun onError(txt: String?)

}