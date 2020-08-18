package id.refactory.myapplication.infrastructures.api

import id.refactory.data.payload.api.user.GetUsersApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserApi {
    @GET("db")
    fun getUsers(@QueryMap queries: Map<String, String>): Observable<GetUsersApiResponse>
}