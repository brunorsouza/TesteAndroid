package me.brunorsouza.testesantander.contact.view

import me.brunorsouza.testesantander.base.BaseView
import me.brunorsouza.testesantander.contact.ContactLayout
import me.brunorsouza.testesantander.webservice.CellResponse

/**
 * Created by Bruno Souza.
 */
interface ContactView : BaseView {

    fun showSuccessView()

    fun dismissSuccessView()

    fun onError(errorMessage: String?)

    fun getContactLayout(): ContactLayout

    fun clear()

    fun isContactError(): Boolean

    fun showError()

    fun dismissError()

    fun setListeners()

}