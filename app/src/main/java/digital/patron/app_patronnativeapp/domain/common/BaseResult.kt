package digital.patron.app_patronnativeapp.domain.common

import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse

sealed class BaseResult<out T : Any, out U : Any> {
    data class Success<T : Any>(val data: T) : BaseResult<T, Nothing>()
    data class Error<U : Any>(val rawResponse: U) : BaseResult<Nothing, U>()
}
