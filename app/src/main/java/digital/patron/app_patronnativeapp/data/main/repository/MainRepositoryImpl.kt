package digital.patron.app_patronnativeapp.data.main.repository

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import digital.patron.app_patronnativeapp.data.common.RetrofitClient
import digital.patron.app_patronnativeapp.data.common.WrappedResponse
import digital.patron.app_patronnativeapp.data.main.remote.api.MainApi
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.MainRepository
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImpl(application: Application) : MainRepository {
    private val client = RetrofitClient.getInstance().create(MainApi::class.java)

    override suspend fun getMain(mainRequest: MainEntity): Flow<Call<MainEntity>> {
        return flow {
            val response = client.showMain(mainRequest)
            Log.d(TAG_CURRENT,mainRequest.toString())
            response.enqueue(
                object : Callback<MainEntity> {
                    override fun onFailure(call: Call<MainEntity>, t: Throwable) {
                        print("오류 내용: " + t.message)
                    }

                    override fun onResponse(
                        call: Call<MainEntity>,
                        response: Response<MainEntity>
                    ) {
                        val mainGet = response.body()
                        print(mainGet)
                    }
                }
            )


        }
    }

    companion object {
        const val TAG_CURRENT = "MainRepositoryImpl"
    }


}