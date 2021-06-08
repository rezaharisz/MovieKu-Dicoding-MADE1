package com.rezaharisz.favorites.di

import android.content.Context
import com.rezaharis.movieku.di.FavoritesDependencies
import com.rezaharisz.favorites.movies.FavoriteMovieFragment
import com.rezaharisz.favorites.tvshows.FavoriteTvShowsFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoritesDependencies::class])
interface FavoritesComponent {

    fun inject(favoriteMovieFragment: FavoriteMovieFragment)
    fun inject(favoriteTvShowsFragment: FavoriteTvShowsFragment)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoritesDependencies: FavoritesDependencies): Builder
        fun build(): FavoritesComponent
    }

}