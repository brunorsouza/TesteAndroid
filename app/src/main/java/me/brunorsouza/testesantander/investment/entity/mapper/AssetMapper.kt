package me.brunorsouza.testesantander.investment.entity.mapper

import me.brunorsouza.testesantander.contact.INVALID_DOUBLE
import me.brunorsouza.testesantander.contact.INVALID_INT
import me.brunorsouza.testesantander.contact.INVALID_STRING
import me.brunorsouza.testesantander.investment.entity.InfoDetailResponse
import me.brunorsouza.testesantander.investment.entity.MoreInfoDetailResponse
import me.brunorsouza.testesantander.webservice.*

object AssetMapper {

    fun map(investmentJsonResponse: InvestmentResponse): InvestmentResponseFormated {
        return InvestmentResponseFormated(Screen(
                investmentJsonResponse.screen?.title ?: INVALID_STRING,
                investmentJsonResponse.screen?.assetName ?: INVALID_STRING,
                investmentJsonResponse.screen?.whatIs ?: INVALID_STRING,
                investmentJsonResponse.screen?.definition ?: INVALID_STRING,
                investmentJsonResponse.screen?.riskTitle ?: INVALID_STRING,
                investmentJsonResponse.screen?.risk ?: INVALID_INT,
                investmentJsonResponse.screen?.infoTitle ?: INVALID_STRING,
                map(investmentJsonResponse.screen?.moreInfo?.month),
                map(investmentJsonResponse.screen?.moreInfo?.year),
                map(investmentJsonResponse.screen?.moreInfo?.twelveMonths),
                map(investmentJsonResponse.screen?.info),
                map(investmentJsonResponse.screen?.downInfo)
            )
        )
    }

    private fun map(moreInfoDetailResponse: MoreInfoDetailResponse?) =
            TimeInfo(moreInfoDetailResponse?.fund ?: INVALID_DOUBLE,
                    moreInfoDetailResponse?.CDI ?: INVALID_DOUBLE)

    private fun map(infoDetailsList: MutableList<InfoDetailResponse>?): MutableList<Info> {
        val infoList = mutableListOf<Info>()

        infoDetailsList?.mapTo(infoList, {infoDetail -> map(infoDetail)})

        return infoList
    }

    private fun map(infoDetailResponse: InfoDetailResponse?) =
            Info(infoDetailResponse?.name ?: INVALID_STRING,
                    infoDetailResponse?.data ?: INVALID_STRING)

}