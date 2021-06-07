package com.rezaharis.movieku.favorites.movie

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
import com.rezaharis.movieku.movie.detail.DetailMovieActivity.Companion.MOVIE
import com.rezaharis.movieku.databinding.FragmentFavoriteMoviesBinding
import com.rezaharis.movieku.movie.detail.DetailMovieActivity
import com.rezaharisz.core.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMoviesBinding

//    @Inject
//    lateinit var factory: ViewModelFactory

    private val favoritesMovieViewModel: FavoritesMovieViewModel by viewModels()

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (requireActivity().application as MyApplication).appComponent.inject(this)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val favoriteMovieAdapter = MovieAdapter()
            favoriteMovieAdapter.onItemClick = {
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(MOVIE, it)
                startActivity(intent)
            }

            favoritesMovieViewModel.favoriteMovies.observe(viewLifecycleOwner) { listMovie ->
                favoriteMovieAdapter.setData(listMovie)
                if (listMovie.isEmpty()) {
                    Toast.makeText(context, "Favorite Movies is Empty!", Toast.LENGTH_SHORT).show()
                }
            }

            with(binding.rvFavoritesMovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteMovieAdapter
            }
        }
    }
}