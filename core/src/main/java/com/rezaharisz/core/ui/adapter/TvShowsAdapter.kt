package com.rezaharisz.core.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rezaharisz.core.BuildConfig.BASE_IMAGE
import com.rezaharisz.core.R
import com.rezaharisz.core.databinding.ItemFavoritesBinding
import com.rezaharisz.core.domain.model.TvShows

class TvShowsAdapter: RecyclerView.Adapter<TvShowsAdapter.TvShowsHolder>() {

    private var listFavoriteTvShows = ArrayList<TvShows>()
    var onItemClick: ((TvShows) -> Unit)? = null

    fun setData(favoriteTvShows: List<TvShows>?){
        if (favoriteTvShows == null) return
        listFavoriteTvShows.clear()
        listFavoriteTvShows.addAll(favoriteTvShows)
        notifyDataSetChanged()
    }

    inner class TvShowsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemFavoritesBinding.bind(itemView)

        fun bind(tvShows: TvShows){
            with(binding){
                Glide.with(itemView)
                    .load(BASE_IMAGE + tvShows.poster)
                    .override(150,220)
                    .into(ivPoster)
                tvFavorites.text = tvShows.tvShowsName
                tvRate.text = tvShows.rate.toString()
                tvReleasedate.text = tvShows.releasedate
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listFavoriteTvShows[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TvShowsHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false))

    override fun onBindViewHolder(holder: TvShowsHolder, position: Int) {
        val tvShowsFavorites = listFavoriteTvShows[position]
        holder.bind(tvShowsFavorites)
    }

    override fun getItemCount() = listFavoriteTvShows.size

}