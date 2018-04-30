package me.brunorsouza.testesantander.contact

import android.content.Context
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.base.BaseInteractorImpl
import me.brunorsouza.testesantander.contact.view.cell.EmailFieldCell
import me.brunorsouza.testesantander.contact.view.PhoneNumberFieldCell
import me.brunorsouza.testesantander.contact.view.cell.TextFieldCell
import me.brunorsouza.testesantander.webservice.CellResponse
import me.brunorsouza.testesantander.webservice.Constants
import me.brunorsouza.testesantander.webservice.ContactAPI
import me.brunorsouza.testesantander.webservice.ServerStatusEnum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val INVALID_INT = -1
const val INVALID_STRING = ""
const val INVALID_DOUBLE = -1.0

/**
 * Created by brunosouza.
 */
class ContactInteractorImpl : BaseInteractorImpl(), ContactInteractor {

    override fun getData(context: Context, listener: OnFinishedListener) {

        val api = createAPI(Constants.DOMAIN_URL, ContactAPI::class.java) as ContactAPI
        val call = api.getCells()

        call.enqueue(object : Callback<CellResponse> {
            override fun onResponse(call: Call<CellResponse>, response: Response<CellResponse>) {
                if (response.code() == ServerStatusEnum.STATUS_OK.code) {
                    listener.onSuccess(map(response.body()))
                    return
                }

                if (response.code() == ServerStatusEnum.STATUS_UNAUTHORIZED.code) {
                    listener.onError(context.getString(R.string.txt_unauthorized))
                    return
                }

                var errorMessage: String? = ""
                try {
                    var error = convetJsonToObjct(response.errorBody().string(), Error::class.java) as Error

                    if (error != null && error.message != null)
                        errorMessage = error.message
                    else
                        errorMessage = response.message()

                } catch (e: Exception) {
                }

                listener.onError(errorMessage)
            }

            override fun onFailure(call: Call<CellResponse>, t: Throwable) {
                if (t.message != null)
                    listener.onError(t.message.toString())
                else
                    listener.onError("")
            }
        })
    }

    fun map(cellResponse: CellResponse): CellResponse {

        val cellList = mutableListOf<Cell>()

        cellResponse.cells.mapTo(cellList, { cell -> map(cell)})

        return CellResponse(cellList)
    }

    fun map(cell: Cell): Cell {
        return when(cell.typeField){
            1.0 -> getTextFieldCell(cell)
            2.0 -> getTelNumberFieldCell(cell)
            3.0 -> getEmailFieldCell(cell)
            "telnumber" -> getTelNumberFieldCell(cell)
            else -> getSimpleCell(cell)
        }
    }

    private fun getSimpleCell(cell: Cell) =
            Cell(
                    cell.id ?: INVALID_INT,
                    cell.type ?:INVALID_INT,
                    cell.message ?: INVALID_STRING,
                    getCorrectTypeField(cell.typeField),
                    cell.hidden ?: false,
                    cell.topSpacing ?: INVALID_DOUBLE,
                    cell.show ?: INVALID_INT,
                    cell.required ?: false
            )

    private fun getEmailFieldCell(cell: Cell) =
            EmailFieldCell(
                    cell.id ?: INVALID_INT,
                    cell.type ?: INVALID_INT,
                    cell.message ?: INVALID_STRING,
                    getCorrectTypeField(cell.typeField),
                    cell.hidden ?: false,
                    cell.topSpacing ?: INVALID_DOUBLE,
                    cell.show ?: INVALID_INT,
                    cell.required ?: false
            )

    private fun getTelNumberFieldCell(cell: Cell) =
            PhoneNumberFieldCell(
                    cell.id ?: INVALID_INT,
                    cell.type ?: INVALID_INT,
                    cell.message ?: INVALID_STRING,
                    getCorrectTypeField(cell.typeField),
                    cell.hidden ?: false,
                    cell.topSpacing ?: INVALID_DOUBLE,
                    cell.show ?: INVALID_INT,
                    cell.required ?: false
            )

    private fun getTextFieldCell(cell: Cell) =
            TextFieldCell(
                    cell.id ?: INVALID_INT,
                    cell.type ?: INVALID_INT,
                    cell.message ?: INVALID_STRING,
                    getCorrectTypeField(cell.typeField),
                    cell.hidden ?: false,
                    cell.topSpacing ?: INVALID_DOUBLE,
                    cell.show ?: INVALID_INT,
                    cell.required ?: false
            )

    private fun getCorrectTypeField(typeField: Any?): Int{
        return when(typeField){
            is Int -> typeField
            is String -> mapStringTypeField(typeField)
            else -> INVALID_INT
        }
    }

    private fun mapStringTypeField(typeField: String): Int{
        return when(typeField){
            "text" -> 1
            "telnumber" -> 2
            "email" -> 3
            else -> INVALID_INT
        }
    }
}




interface ContactInteractor {
    fun getData(context: Context, listener: OnFinishedListener)
}