package com.rezaharis.movieku.core.di

import androidx.room.Room
import com.rezaharis.movieku.BuildConfig
import com.rezaharis.movieku.core.data.MovieKuRepository
import com.rezaharis.movieku.core.data.sources.local.room.MovieKuRoomDatabase
import com.rezaharis.movieku.core.data.sources.local.sources.LocalDataSources
import com.rezaharis.movieku.core.data.sources.remote.network.MovieApiService
import com.rezaharis.movieku.core.data.sources.remote.sources.RemoteDataSource
import com.rezaharis.movieku.core.domain.repository.IMovieKuRepository
import com.rezaharis.movieku.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory {get <MovieKuRoomDatabase>().movieKuDao}
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieKuRoomDatabase::class.java, "favorites.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(MovieApiService::class.java)
    }
}

val repositoryModule = module {
    single {LocalDataSources(get())}
    single {RemoteDataSource(get())}
    factory {AppExecutors()}
    single<IMovieKuRepository>{MovieKuRepository(get(), get(), get())}
}