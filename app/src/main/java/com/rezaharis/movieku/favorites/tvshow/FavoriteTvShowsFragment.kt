package com.rezaharis.movieku.favorites.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezaharis.movieku.core.ui.ViewModelFactory
import com.rezaharis.movieku.core.ui.adapter.TvShowsAdapter
import com.rezaharis.movieku.tvshow.detail.DetailTvShowActivity.Companion.TV_SH0WS
import com.rezaharis.movieku.databinding.FragmentFavoriteTvShowsBinding
import com.rezaharis.movieku.tvshow.detail.DetailTvShowActivity

class FavoriteTvShowsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvShowsBinding
    private lateinit var favoritesTvShowsViewModel: FavoritesTvShowsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val favoriteTvShowsAdapter = TvShowsAdapter()
            favoriteTvShowsAdapter.onItemClick = {
                val intent = Intent(activity, DetailTvShowActivity::class.java)
                intent.putExtra(TV_SH0WS, it)
                startActivity(intent)
            }

            val factory = context?.let { ViewModelFactory.getInstance(it) }
            favoritesTvShowsViewModel = factory?.let { ViewModelProvider(this, it) }!![FavoritesTvShowsViewModel::class.java]

            favoritesTvShowsViewModel.favoriteTvShows.observe(viewLifecycleOwner, {listTvShows ->
                favoriteTvShowsAdapter.setData(listTvShows)
                if (listTvShows.isEmpty()){
                    Toast.makeText(context, "Favorite Tv Shows is Empty!", Toast.LENGTH_SHORT).show()
                }
            })

            with(binding.rvFavoritesTvshows){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteTvShowsAdapter
            }
        }
    }
}