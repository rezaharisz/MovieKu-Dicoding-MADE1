package com.rezaharis.movieku.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rezaharis.movieku.BuildConfig
import com.rezaharis.movieku.R
import com.rezaharis.movieku.core.domain.model.Movies
import com.rezaharis.movieku.core.ui.ViewModelFactory
import com.rezaharis.movieku.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    companion object{
        const val MOVIE = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            super.onBackPressed()
        }

        val factory = ViewModelFactory.getInstance(this)
        movieDetailViewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]

        val detailMovies = intent.getParcelableExtra<Movies>(MOVIE)
        if (detailMovies != null){
            getMovies(detailMovies)
            showLoading(false)
        }
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressbar.visibility = View.VISIBLE
        } else{
            binding.progressbar.visibility = View.GONE
        }
    }

    private fun getMovies(movies: Movies){
        Glide.with(this)
            .load(BuildConfig.BASE_IMAGE + movies.poster)
            .override(250, 320)
            .into(binding.ivPoster)
        binding.tvMovie.text = movies.movieName
        binding.movieRelease.text = movies.releasedate
        binding.movieRate.text = movies.rate.toString()
        binding.movieVotecount.text = movies.votecount.toString()
        binding.tvDes.text = movies.description

        var isFavorite = movies.setFavorite
        setFavorite(isFavorite)
        binding.setFavorite.setOnClickListener {
            isFavorite = !isFavorite
            movieDetailViewModel.setFavoriteMovies(movies, isFavorite)
            setFavorite(isFavorite)
        }
    }

    private fun setFavorite(state: Boolean){
        if (state){
            binding.setFavorite.setImageResource(R.drawable.ic_set_favorite)
        } else{
            binding.setFavorite.setImageResource(R.drawable.ic_no_favorite)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        finish()
    }
}