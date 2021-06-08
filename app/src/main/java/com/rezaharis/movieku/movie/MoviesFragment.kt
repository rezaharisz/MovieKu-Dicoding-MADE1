package com.rezaharis.movieku.movie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezaharis.movieku.movie.detail.DetailMovieActivity.Companion.MOVIE
import com.rezaharis.movieku.databinding.FragmentMoviesBinding
import com.rezaharis.movieku.movie.detail.DetailMovieActivity
import com.rezaharisz.core.data.Resource
import com.rezaharisz.core.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = {
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(MOVIE, it)
                startActivity(intent)
            }

            movieViewModel.movies.observe(viewLifecycleOwner) { listMovies ->
                if (listMovies != null) {
                    when (listMovies) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            movieAdapter.setData(listMovies.data)
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(
                                context,
                                "Kesalahan Ketika Memuat Data",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

            with(binding.crRview){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            binding.favBtn.setOnClickListener {
                val uri = Uri.parse("movieku://favorites")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
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