package com.bagi.flowkotlin.model

import androidx.core.content.ContextCompat.getColor
import com.bagi.flowkotlin.R

data class Card(
    val resStringTitle: Int,
    val detail: Int,
    val textColor: Int?
) {
    val stringDetail: String
        get() = detail.toString()

    val textColorToShow: Int
    get() = textColor ?: android.R.color.background_light
}
