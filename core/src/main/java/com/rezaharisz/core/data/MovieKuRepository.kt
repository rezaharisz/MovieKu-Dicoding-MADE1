package com.rezaharisz.core.data

import com.rezaharisz.core.data.sources.local.sources.LocalDataSources
import com.rezaharisz.core.data.sources.remote.network.ApiResponse
import com.rezaharisz.core.data.sources.remote.responses.ResponseDataMovie
import com.rezaharisz.core.data.sources.remote.responses.ResponseDataTvShows
import com.rezaharisz.core.data.sources.remote.sources.RemoteDataSource
import com.rezaharisz.core.domain.model.Movies
import com.rezaharisz.core.domain.model.TvShows
import com.rezaharisz.core.domain.repository.IMovieKuRepository
import com.rezaharisz.core.utils.AppExecutors
import com.rezaharisz.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieKuRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSources: LocalDataSources,
    private val appExecutors: AppExecutors
): IMovieKuRepository {

    override fun getMovies(): Flow<Resource<List<Movies>>> {
        return object : com.rezaharisz.core.data.NetworkBoundResource<List<Movies>, List<ResponseDataMovie>>(){
            override fun loadFromDB(): Flow<List<Movies>> {
                return localDataSources.getAllMovies().map {
                    DataMapper.mapMovieEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movies>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseDataMovie>>> {
                return remoteDataSource.getMovies()
            }

            override suspend fun saveCallResult(data: List<ResponseDataMovie>) {
                val movieList = DataMapper.mapMovieResponsesToEntities(data)
                localDataSources.insertMovies(movieList)
            }
        }.asFlow()
    }

    override fun getFavoriteMovies(): Flow<List<Movies>> {
        return localDataSources.getFavoriteMovies().map {
            DataMapper.mapMovieEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovies(movies: Movies, state: Boolean) {
        val movieEntities = DataMapper.mapMovieDomainToEntities(movies)
        appExecutors.diskIO().execute {
            localDataSources.setFavoriteMovies(movieEntities, state)
        }
    }

    override fun getTvShows(): Flow<Resource<List<TvShows>>>{
        return object : com.rezaharisz.core.data.NetworkBoundResource<List<TvShows>, List<ResponseDataTvShows>>(){
            public override fun loadFromDB(): Flow<List<TvShows>> {
                return localDataSources.getAlltTvShows().map {
                    DataMapper.mapTvShowsEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvShows>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseDataTvShows>>> {
                return remoteDataSource.getTvShows()
            }

            override suspend fun saveCallResult(data: List<ResponseDataTvShows>) {
                val tvShowsList = DataMapper.mapTvShowsResponsesToEntites(data)
                localDataSources.insertTvShows(tvShowsList)
            }
        }.asFlow()
    }

    override fun getFavoriteTvShows(): Flow<List<TvShows>> {
        return localDataSources.getFavoriteTvShows().map{
            DataMapper.mapTvShowsEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTvShows(tvShows: TvShows, state: Boolean) {
        val tvShowsEntities = DataMapper.mapTvShowsDomainToEntities(tvShows)
        appExecutors.diskIO().execute {
            localDataSources.setFavoriteTvShows(tvShowsEntities, state)
        }
    }
}