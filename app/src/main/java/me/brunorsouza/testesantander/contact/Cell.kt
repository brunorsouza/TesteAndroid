package me.brunorsouza.testesantander.contact

import com.google.gson.annotations.SerializedName

open class Cell(val id: Int? = -1,
                val type: Int? = 1,
                val message: String? = "",
                @SerializedName("typefield") val typeField: Any? = null,
                val hidden: Boolean? = false,
                val topSpacing: Double? = 16.0,
                val show: Int? = -1,
                val required: Boolean? = false)