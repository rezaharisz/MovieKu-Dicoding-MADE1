package com.rezaharisz.core.data

sealed class Resource<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T?): com.rezaharisz.core.data.Resource<T>(data)

    class Loading<T>(data: T? = null): com.rezaharisz.core.data.Resource<T>(data)

    class Error<T>(msg: String, data: T? = null): com.rezaharisz.core.data.Resource<T>(data, msg)
}
