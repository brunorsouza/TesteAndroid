package me.brunorsouza.testesantander.webservice

import me.brunorsouza.testesantander.contact.INVALID_DOUBLE
import me.brunorsouza.testesantander.contact.INVALID_INT
import me.brunorsouza.testesantander.contact.INVALID_STRING
import me.brunorsouza.testesantander.investment.entity.ScreenResponse

/**
 * Created by brunosouza.
 */
data class InvestmentResponse (
        val screen: ScreenResponse
)

data class InvestmentResponseFormated(
        val screen: Screen
)

data class Screen(val title: String = INVALID_STRING,
                  val fundName: String = INVALID_STRING,
                  val whatIs: String = INVALID_STRING,
                  val definition: String = INVALID_STRING,
                  val riskTitle: String = INVALID_STRING,
                  val risk: Int = INVALID_INT,
                  val infoTitle: String = INVALID_STRING,
                  val monthInfo: TimeInfo = TimeInfo(),
                  val yearInfo: TimeInfo = TimeInfo(),
                  val twelveInfo: TimeInfo = TimeInfo(),
                  val info: MutableList<Info> = mutableListOf(),
                  val downInfo: MutableList<Info> = mutableListOf())

data class TimeInfo(val fund: Double = INVALID_DOUBLE,
                    val cdi: Double = INVALID_DOUBLE)

data class Info(val name: String = INVALID_STRING,
                val data: String = INVALID_STRING)