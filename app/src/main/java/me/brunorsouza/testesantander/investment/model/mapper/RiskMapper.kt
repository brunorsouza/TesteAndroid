package me.brunorsouza.testesantander.investment.model.mapper

import me.brunorsouza.testesantander.investment.model.Risk
import me.brunorsouza.testesantander.webservice.Screen

object RiskMapper {

    fun map(screen: Screen) = Risk (
            screen.riskTitle,
            screen.risk
    )

}