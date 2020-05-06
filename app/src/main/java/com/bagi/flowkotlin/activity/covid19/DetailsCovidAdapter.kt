package com.bagi.flowkotlin.activity.covid19

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagi.flowkotlin.databinding.CardDetailsLayoutBinding
import com.bagi.flowkotlin.model.Card

class DetailsCovidAdapter(private val listDetails: MutableList<Card>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = CardDetailsLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listDetails[position])
    }
}

class ViewHolder(private val view: CardDetailsLayoutBinding) : RecyclerView.ViewHolder(view.root) {
    fun onBind(card: Card) {
        view.cardDetails = card
        view.executePendingBindings()
    }

}
