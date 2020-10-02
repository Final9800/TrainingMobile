package Fave.mainactivity.API

import retrofit2.http.GET

interface DataServices {
    @GET("/photos")
    suspend fun getDatas(): List<Data>
}