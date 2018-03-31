package com.example.hello.movietune.network;

import com.example.hello.movietune.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hello on 10/3/18.
 */

public interface NetworkInterface {


    @GET("https://api.themoviedb.org/3/movie/now_playing?api_key=c37d3b40004717511adb2c1fbb15eda4&page=1")
    Call<Movie> getMovieData();
}
