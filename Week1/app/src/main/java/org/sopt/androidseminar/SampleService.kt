package org.sopt.androidseminar

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService {

    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postLogin(
        @Body requestLoginData: RequestLoginData
    ) : Call<ResponseLoginData>
}