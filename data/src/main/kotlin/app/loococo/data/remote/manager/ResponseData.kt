package app.loococo.data.remote.manager

import app.loococo.domain.model.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

suspend fun <T : Any, R : Any> suspendResponseResultWithBackoff(
    execute: suspend () -> Response<T>,
    mapResponse: (T) -> R = { it as R },
    maxRetries: Int = 3,
    initialDelay: Long = 1000L,
    factor: Double = 2.0
): Flow<Resource<R>> = flow {
    var currentDelay = initialDelay
    var retryCount = 0

    while (retryCount <= maxRetries) {
        emit(Resource.Loading)

        try {
            val response = execute()
            when {
                response.isSuccessful -> {
                    val body = response.body()
                    if (body != null) {
                        emit(Resource.Success(mapResponse(body)))
                        return@flow
                    } else {
                        emit(Resource.Error("Response body is null"))
                        return@flow
                    }
                }

                else -> {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    emit(Resource.Error("API call failed: $errorMessage"))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception occurred: ${e.message}"))
        }

        if (retryCount == maxRetries) {
            emit(Resource.Error("Maximum retries reached"))
            break
        }

        delay(currentDelay)
        currentDelay = (currentDelay * factor).toLong()
        retryCount++
    }
}.catch { e ->
    emit(Resource.Error("Unhandled exception: ${e.message}"))
}
