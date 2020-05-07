package com.bagi.flowkotlin.activity.covid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bagi.flowkotlin.R
import com.bagi.flowkotlin.databinding.ActivityMainBinding
import com.bagi.flowkotlin.model.Card
import kotlinx.android.synthetic.main.activity_main.*

class Covid19Activity : AppCompatActivity() {
    private lateinit var covid19ActivityViewModel: Covid19ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setVM()

        binding.viewModel = covid19ActivityViewModel
        binding.lifecycleOwner = this
    }

    private fun setVM() {
        covid19ActivityViewModel =
            ViewModelProviders.of(this).get(Covid19ActivityViewModel::class.java)
        covid19ActivityViewModel.getCountryDetailsMLD()
            .observe(this, Observer { fetchDataSuccess(it) })
    }

    private fun fetchDataSuccess(countryDetails: MutableList<Card>) {
        setRecyclerView(countryDetails)
    }

    private fun setRecyclerView(countryDetails: MutableList<Card>) {
        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        listDetails?.layoutManager = manager
        listDetails?.adapter = DetailsCovidAdapter(countryDetails)
    }
}
