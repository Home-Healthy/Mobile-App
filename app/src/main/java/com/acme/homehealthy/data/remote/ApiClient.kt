package com.acme.homehealthy.data.remote

import com.acme.homehealthy.data.remote.interfaces.RoutineInterface
import com.acme.homehealthy.data.remote.interfaces.TrainingInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://60c255b2069afc0017f4a2ca.mockapi.io/"

    //Routines
    var routineInterface : RoutineInterface? = null

    fun buildRoutine() : RoutineInterface? {
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        var retrofit: Retrofit = builder.build()
        routineInterface = retrofit.create(RoutineInterface::class.java)
        return routineInterface as RoutineInterface
    }

    //Trainings
    var trainingInterface : TrainingInterface? = null

    fun buildTraining(): TrainingInterface?{
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        var retrofit: Retrofit = builder.build()
        trainingInterface = retrofit.create(TrainingInterface::class.java)
        return trainingInterface as TrainingInterface
    }

}