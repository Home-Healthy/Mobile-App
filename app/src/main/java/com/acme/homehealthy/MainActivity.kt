package com.acme.homehealthy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.data.models.Training
import com.acme.homehealthy.data.remote.ApiClient
import com.acme.homehealthy.screens.MainScreen
import com.acme.homehealthy.screens.Navigation
import com.acme.homehealthy.screens.trainingsView
import com.acme.homehealthy.ui.theme.HomeHealthyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : ComponentActivity() {

    //variables
    var routines by mutableStateOf(listOf<Routine>())
    var trainings by mutableStateOf(listOf<Training>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadRoutines()
        loadTrainings()
        setContent {
            HomeHealthyTheme {
                Navigation(routines, trainings)
            }
        }
    }

    private fun loadRoutines() {
        val routineInterface = ApiClient.buildRoutine()
        val fetchRoutines = routineInterface?.fetchRoutines()

        fetchRoutines?.enqueue(object : Callback<List<Routine>> {
            override fun onResponse(call: Call<List<Routine>>, response: Response<List<Routine>>) {
                routines = response.body()!!
            }

            override fun onFailure(call: Call<List<Routine>>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }
        })
    }

    private fun loadTrainings() {
        val trainingInterface = ApiClient.buildTraining()
        val fetchTraining = trainingInterface?.fetchTrainings()

        fetchTraining?.enqueue(object : Callback<List<Training>> {
            override fun onResponse(
                call: Call<List<Training>>,
                response: Response<List<Training>>
            ) {
                trainings = response.body()!!
            }

            override fun onFailure(call: Call<List<Training>>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }

        })
    }
}

