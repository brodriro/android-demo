package me.rzknairb.data.remote;

import java.util.List;

import io.reactivex.Single;
import me.rzknairb.data.remote.entities.UserResponse;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {

    String BASE_URL = "https://my-json-server.typicode.com/rzkbrian/public_db/";

    @Headers("Content-Type: application/json")
    @GET("profile")
    Single<UserResponse> getProfile();

    @Headers("Content-Type: application/json")
    @GET("users")
    Single<List<UserResponse>> getUsers();


}
