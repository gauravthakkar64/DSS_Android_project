package com.example.gaurav.crudretrofit.remote;

import com.example.gaurav.crudretrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/")
    Call<List<User>> getUsers();

    @POST("add/")
    Call<User> addUser(@Body User user);

    @PUT("update/{id}")
    Call<User> UpdateUser(@Path("id") int id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id")int id);
}
