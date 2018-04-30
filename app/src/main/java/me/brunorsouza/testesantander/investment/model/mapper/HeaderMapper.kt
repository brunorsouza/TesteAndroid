package me.brunorsouza.testesantander.investment.model.mapper

import me.brunorsouza.testesantander.investment.model.Header
import me.brunorsouza.testesantander.webservice.Screen

object HeaderMapper {

    fun map(screen: Screen) = Header(
            screen.title,
            screen.fundName,
            screen.whatIs,
            screen.definition
    )

}