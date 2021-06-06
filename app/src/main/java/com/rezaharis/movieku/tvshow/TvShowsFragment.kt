package com.rezaharis.movieku.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezaharis.movieku.core.ui.adapter.TvShowsAdapter
import com.rezaharis.movieku.core.data.Resource
import com.rezaharis.movieku.core.ui.ViewModelFactory
import com.rezaharis.movieku.tvshow.detail.DetailTvShowActivity.Companion.TV_SH0WS
import com.rezaharis.movieku.databinding.FragmentTvshowsBinding
import com.rezaharis.movieku.tvshow.detail.DetailTvShowActivity

class TvShowsFragment : Fragment() {

    private lateinit var binding: FragmentTvshowsBinding
    private lateinit var tvShowsViewModel: TvShowsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvshowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val tvShowsAdapter = TvShowsAdapter()
            tvShowsAdapter.onItemClick = {
                val intent = Intent(activity, DetailTvShowActivity::class.java)
                intent.putExtra(TV_SH0WS, it)
                startActivity(intent)
            }

            val factory = context?.let { ViewModelFactory.getInstance(it) }
            tvShowsViewModel = factory?.let { ViewModelProvider(this, it) }!![TvShowsViewModel::class.java]

            tvShowsViewModel.tvShows.observe(viewLifecycleOwner, { listTvShows ->
                if (listTvShows != null){
                    when(listTvShows){
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            tvShowsAdapter.setData(listTvShows.data)
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(context, "Kesalahan Ketika Memuat Data", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.crTvshows){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressbar.visibility = View.VISIBLE
        } else{
            binding.progressbar.visibility = View.GONE
        }
    }

}