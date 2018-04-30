package me.brunorsouza.testesantander.investment.entity

import com.google.gson.annotations.SerializedName

data class MoreInfoResponse(

        val month: MoreInfoDetailResponse?,
        val year: MoreInfoDetailResponse?,
        @SerializedName("12months") val twelveMonths: MoreInfoDetailResponse?

)