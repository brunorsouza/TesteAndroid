package me.brunorsouza.testesantander.investment

import me.brunorsouza.testesantander.webservice.InvestmentResponseFormated

interface OnInvestmentFinishedListener {

    fun onSuccess(investmentResponse: InvestmentResponseFormated)

    fun onError(errorMessage: String?)

}