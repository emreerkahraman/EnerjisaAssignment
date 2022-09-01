package com.emreerkahraman.enerjisaassignment.base

import com.emreerkahraman.enerjisaassignment.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class BaseRepository {

    fun <T> responseWrapper(remoteCall: suspend () -> T): Flow<Resource<T>> =
        flow {
            emit(Resource.loading())
            try {
                emit(Resource.success(remoteCall.invoke()))
            } catch (t: Throwable) {
                emit(Resource.error(t))
            }
        }
}