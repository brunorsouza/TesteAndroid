package me.brunorsouza.testesantander.contact

import me.brunorsouza.testesantander.webservice.CellResponse

interface OnFinishedListener {

    fun onSuccess(cellResponse: CellResponse)

    fun onError(errorMessage: String?)

}