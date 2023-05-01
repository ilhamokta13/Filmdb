package com.example.filmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmdb.databinding.ActivityMainBinding
import com.example.filmdb.model.PopularMovie
import com.example.filmdb.model.Result
import com.example.filmdb.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val listMovie = mutableListOf<Result>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFilm()
    }


    fun getFilm(){

        RetrofitClient.instance.getmoviepopular(APIKEY = "7f40338572c7bcecdd056ae5622e950d", PAGE = 1)
            .enqueue(object : Callback<PopularMovie<Result>>{
                override fun onResponse(
                    call: Call<PopularMovie<Result>>,
                    response: Response<PopularMovie<Result>>
                ) {
                    if (response.isSuccessful){
                        binding.rvFilm.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        val filmResponse = response.body()
                        if(filmResponse != null){
                            listMovie.addAll(filmResponse.results)
                            binding.rvFilm.adapter = MovieAdapter(listMovie)
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<PopularMovie<Result>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }

            })

    }

}