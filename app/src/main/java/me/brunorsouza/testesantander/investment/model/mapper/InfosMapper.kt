package me.brunorsouza.testesantander.investment.model.mapper

import me.brunorsouza.testesantander.investment.model.Info
import me.brunorsouza.testesantander.webservice.Screen

object InfosMapper {

    fun map(screen: Screen): MutableList<Info> {
        val listInfos = mutableListOf<Info>()

        screen.info.mapTo(listInfos, { info -> Info(info.name, info.data ?: "")})

        return listInfos
    }

}