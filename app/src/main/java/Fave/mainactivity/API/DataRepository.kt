package Fave.mainactivity.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {
    const val BASE_URL = "https://jsonplaceholder.typicode.com"
    fun createDataRepository(java: Class<DataServices>): DataServices {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(DataServices::class.java)
    }
}
