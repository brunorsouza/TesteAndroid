package me.brunorsouza.testesantander.investment

import android.content.Context
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.base.BaseInteractorImpl
import me.brunorsouza.testesantander.investment.entity.mapper.AssetMapper
import me.brunorsouza.testesantander.webservice.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by brunosouza.
 */
class InvestmentInteractorImpl : BaseInteractorImpl(), InvestmentInteractor {

    override fun getFund(context: Context, listener: OnInvestmentFinishedListener) {

        val api = createAPI(Constants.DOMAIN_URL, InvestmentAPI::class.java) as InvestmentAPI
        val call = api.getFund()

        call.enqueue(object : Callback<InvestmentResponse> {
            override fun onResponse(call: Call<InvestmentResponse>, response: Response<InvestmentResponse>) {
                if (response.code() == ServerStatusEnum.STATUS_OK.code) {
                    listener.onSuccess(AssetMapper.map(response.body()))
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

            override fun onFailure(call: Call<InvestmentResponse>, t: Throwable) {
                if (t.message != null)
                    listener.onError(t.message.toString())
                else
                    listener.onError("")
            }
        })
    }
}

interface InvestmentInteractor {
    fun getFund(context: Context, listener: OnInvestmentFinishedListener)
}