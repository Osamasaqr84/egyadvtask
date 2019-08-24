package com.noname.task.datalayer.apidata;


import com.noname.task.model.entities.Login;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.*;

public interface ServerGateway {

    @FormUrlEncoded
    @POST("LoginUser")
    Observable<Login> login(
            @Field("login") String username,
            @Field("password") String password
    );



}
