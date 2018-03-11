package com.example.sachinpc.restshoecommerce;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.login.widget.ProfilePictureView.TAG;

/**
 * Created by SachinPC on 3/6/2018.
 */

public class cart_logic {

    public void sendPost(Cart cart) {
        apiInterface apiService =
                ApiClient.getClient().create(apiInterface.class);
/*
        apiService.addToCart(cart).enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {

                if(response.isSuccessful()) {
                    Log.i("!!!!!",response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Log.i("!!!!!",t.toString());
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
   */ }

}
