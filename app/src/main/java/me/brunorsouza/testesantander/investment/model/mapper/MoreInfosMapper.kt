package me.brunorsouza.testesantander.investment.model.mapper

import me.brunorsouza.testesantander.investment.model.Info
import me.brunorsouza.testesantander.investment.model.MoreInfos
import me.brunorsouza.testesantander.webservice.Screen

object MoreInfosMapper {

    fun map(screen: Screen) = MoreInfos(
            screen.infoTitle,
            Info(screen.monthInfo.fund.toString(), screen.monthInfo.cdi.toString()),
            Info(screen.yearInfo.fund.toString(), screen.yearInfo.cdi.toString()),
            Info(screen.twelveInfo.fund.toString(), screen.twelveInfo.cdi.toString())
    )

}