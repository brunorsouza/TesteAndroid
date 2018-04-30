package me.brunorsouza.testesantander.contact

import android.app.Activity
import android.content.Context
import me.brunorsouza.testesantander.contact.view.ContactView
import me.brunorsouza.testesantander.contact.view.ContactViewBuilder
import me.brunorsouza.testesantander.webservice.CellResponse
import kotlin.properties.Delegates

/**
 * Created by brunosouza.
 */
class ContactPresenterImpl : ContactPresenter, OnFinishedListener {

    var context: Context by Delegates.notNull()
    var view: ContactView by Delegates.notNull()
    var interactor: ContactInteractor by Delegates.notNull()

    constructor(context: Context, view: ContactView) {
        this.view = view
        this.context = context
        this.interactor = ContactInteractorImpl()
    }

    override fun getData() {
        view.showLoading()
        interactor.getData(context, this)
    }

    override fun onSuccess(cellResponse: CellResponse) {
        (context as Activity).runOnUiThread {
            view.dismissLoading()
            proccessResponse(cellResponse.cells)
        }
    }

    override fun onError(errorMessage: String?) {
        (context as Activity).runOnUiThread {
            view.dismissLoading()
            view.onError(errorMessage)
        }
    }

    private fun proccessResponse(listCell: MutableList<Cell>) {
        val formViewBuilder = ContactViewBuilder(view.getContactLayout())

        formViewBuilder.proccessCellsFormView(listCell)

        view.setListeners()
    }

    override fun onSendEventClicked() {
        if(view.isContactError()){
            view.showError()
        } else {
            view.showSuccessView()
        }
    }

    override fun onNewMessageClicked() {
        view.clear()
        view.dismissSuccessView()
    }
}

interface ContactPresenter {
    fun getData()
    fun onSendEventClicked()
    fun onNewMessageClicked()
}
