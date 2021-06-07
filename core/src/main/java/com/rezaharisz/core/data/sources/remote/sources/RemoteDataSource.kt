package com.rezaharisz.core.data.sources.remote.sources

import android.util.Log
import com.rezaharisz.core.data.sources.remote.network.ApiResponse
import com.rezaharisz.core.data.sources.remote.network.MovieApiService
import com.rezaharisz.core.data.sources.remote.responses.ResponseDataMovie
import com.rezaharisz.core.data.sources.remote.responses.ResponseDataTvShows
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val movieApiService: MovieApiService) {

    suspend fun getMovies(): Flow<ApiResponse<List<ResponseDataMovie>>> {
        return flow {
            try {
                val response = movieApiService.getMovie()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else{
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTvShows(): Flow<ApiResponse<List<ResponseDataTvShows>>>{
        return flow {
            try {
                val response = movieApiService.getTvShows()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else{
                    emit(ApiResponse.Empty)
                }
            } catch (e:Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}