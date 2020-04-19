package com.bagi.flowkotlin.activity.covid19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bagi.flowkotlin.R
import com.bagi.flowkotlin.databinding.CardDetailsLayoutBinding

class DetailsCovidAdapter (private val listDetails: MutableList<Triple<Int, Int?, Int?>>):
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<CardDetailsLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.card_details_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listDetails[position])
    }
}

class ViewHolder(private val view: CardDetailsLayoutBinding) :RecyclerView.ViewHolder(view.root){
    fun onBind(triple: Triple<Int, Int?, Int?>) {
        view.titleDetails.text = view.titleDetails.resources.getString(triple.first)
        view.numberDetails.text = triple.second.toString()
        triple.third?.let { view.numberDetails.setTextColor(ContextCompat.getColor(view.numberDetails.context, it)) }
    }

}
