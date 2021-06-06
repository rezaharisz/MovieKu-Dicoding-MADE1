package com.rezaharis.movieku.tvshow.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rezaharis.movieku.BuildConfig
import com.rezaharis.movieku.R
import com.rezaharis.movieku.core.domain.model.TvShows
import com.rezaharis.movieku.core.ui.ViewModelFactory
import com.rezaharis.movieku.databinding.ActivityDetailTvShowBinding

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvShowBinding
    private lateinit var tvShowsDetailViewModel: TvShowsDetailViewModel

    companion object{
        const val TV_SH0WS = "tv_shows"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            super.onBackPressed()
        }

        val factory = ViewModelFactory.getInstance(this)
        tvShowsDetailViewModel = ViewModelProvider(this, factory)[TvShowsDetailViewModel::class.java]

        val detailTvShows = intent.getParcelableExtra<TvShows>(TV_SH0WS)

        if (detailTvShows != null){
            getTvShows(detailTvShows)
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

    private fun getTvShows(tvShows: TvShows){
        Glide.with(this)
                .load(BuildConfig.BASE_IMAGE + tvShows.poster)
                .override(250, 320)
                .into(binding.ivPosterTvshows)
        binding.tvshowsRelease.text = tvShows.releasedate
        binding.tvshowsRate.text = tvShows.rate.toString()
        binding.tvshowsVotecount.text = tvShows.votecount.toString()
        binding.tvDesTvshows.text = tvShows.description
        binding.tvTvshows.text = tvShows.tvShowsName

        var isFavorite = tvShows.setFavorite
        setFavorite(isFavorite)

        binding.setFavorite.setOnClickListener {
            isFavorite = !isFavorite
            tvShowsDetailViewModel.setFavoriteTvShows(tvShows, isFavorite)
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