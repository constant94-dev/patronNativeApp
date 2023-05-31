package digital.patron.app_patronnativeapp.domain.common


sealed class BaseResult<out T : Any, out U : Any> {
    data class Success<T : Any>(val data: Any?) : BaseResult<T, Nothing>()
    data class Error<U : Any>(val rawResponse: U) : BaseResult<Nothing, U>()
}
