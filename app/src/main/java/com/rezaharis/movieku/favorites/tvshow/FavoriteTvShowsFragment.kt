package com.rezaharis.movieku.favorites.tvshow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezaharis.movieku.MyApplication
import com.rezaharis.movieku.tvshow.detail.DetailTvShowActivity.Companion.TV_SH0WS
import com.rezaharis.movieku.databinding.FragmentFavoriteTvShowsBinding
import com.rezaharis.movieku.tvshow.detail.DetailTvShowActivity
import com.rezaharisz.core.ui.adapter.TvShowsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteTvShowsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvShowsBinding

//    @Inject
//    lateinit var factory: ViewModelFactory

    private val favoritesTvShowsViewModel: FavoritesTvShowsViewModel by viewModels()

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (requireActivity().application as MyApplication).appComponent.inject(this)
//    }

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

            favoritesTvShowsViewModel.favoriteTvShows.observe(viewLifecycleOwner) { listTvShows ->
                favoriteTvShowsAdapter.setData(listTvShows)
                if (listTvShows.isEmpty()) {
                    Toast.makeText(context, "Favorite Tv Shows is Empty!", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            with(binding.rvFavoritesTvshows){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteTvShowsAdapter
            }
        }
    }
}