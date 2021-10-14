package com.acme.homehealthy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.acme.homehealthy.data.models.Diet
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.data.models.Training
import com.acme.homehealthy.data.models.User
import com.acme.homehealthy.data.remote.ApiClient
import com.acme.homehealthy.screens.Navigation
import com.acme.homehealthy.ui.theme.HomeHealthyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {

    //variables
    var routines by mutableStateOf(listOf<Routine>())
    var trainings by mutableStateOf(listOf<Training>())
    var diets by mutableStateOf(listOf<Diet>())
    var users by mutableStateOf(listOf<User>())
    var user: User = User(5,"Sebastian","Toulier","sebas@gmail.com","up mm","Pro",5)

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadRoutines()
        loadTrainings()
        //loadUsers()
        loadDiets()
        setContent {
            HomeHealthyTheme {
                Navigation(routines, trainings, diets, user)
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

    private fun loadDiets() {
        val dietInterface = ApiClient.buildDiets()
        val fetchDiets = dietInterface?.fetchDiet()

        fetchDiets?.enqueue(object : Callback<List<Diet>> {
            override fun onResponse(call: Call<List<Diet>>, response: Response<List<Diet>>) {
                diets = response.body()!!
            }

            override fun onFailure(call: Call<List<Diet>>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }
        })
    }

    private fun loadUsers(){
        val usersINterface = ApiClient.buildUsers()
        val fetchUsers = usersINterface?.fetchUsers()

        fetchUsers?.enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                users = response.body()!!
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }
        })
    }
}

