package com.rezaharis.movieku.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezaharis.movieku.core.ui.adapter.MovieAdapter
import com.rezaharis.movieku.core.data.Resource
import com.rezaharis.movieku.core.ui.ViewModelFactory
import com.rezaharis.movieku.movie.detail.DetailMovieActivity.Companion.MOVIE
import com.rezaharis.movieku.databinding.FragmentMoviesBinding
import com.rezaharis.movieku.movie.detail.DetailMovieActivity

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private lateinit var movieViewModel: MovieViewModel

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

            val factory = context?.let { ViewModelFactory.getInstance(it) }
            movieViewModel = factory?.let { ViewModelProvider(this, it) }!![MovieViewModel::class.java]

            movieViewModel.movies.observe(viewLifecycleOwner, { listMovies ->
                if (listMovies != null){
                    when(listMovies){
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            movieAdapter.setData(listMovies.data)
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(context, "Kesalahan Ketika Memuat Data", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.crRview){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
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