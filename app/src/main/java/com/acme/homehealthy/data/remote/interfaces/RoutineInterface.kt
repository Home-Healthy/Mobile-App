package com.acme.homehealthy.data.remote.interfaces

import com.acme.homehealthy.data.models.Routine
import retrofit2.Call
import retrofit2.http.GET


interface RoutineInterface {
    @GET("rutines")
    fun fetchRoutines(): Call<List<Routine>>
}