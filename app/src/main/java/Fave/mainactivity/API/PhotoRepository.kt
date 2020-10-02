package Fave.mainactivity.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Class as Class1

object PhotoRepository {

    val BASE_URL= "https://jsonplaceholder.typicode.com"

    fun createPhotosRepository(java: Class1<PhotoServices>):PhotoServices{
        val retrofitPhotos = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitPhotos.create(PhotoServices::class.java)
    }
}