package com.example.sachinpc.restshoecommerce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface apiInterface {
    @GET("notes")
    Call<List<Product>> getAll();

   // @Headers("Content-Type: application/json")
    @POST("addToCart")
    // @FormUrlEncoded
    Call<Cart> addToCart(@Body Cart cart);
    //@GET("movie/{id}")
    //Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
