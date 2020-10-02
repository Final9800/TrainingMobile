package Fave.mainactivity.API

import retrofit2.http.GET

interface PhotoServices {
    @GET("photos")
    suspend fun getPhotos(): List<Data>

}