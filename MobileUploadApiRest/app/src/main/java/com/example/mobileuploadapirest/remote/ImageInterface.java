package com.example.mobileuploadapirest.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ImageInterface {
    //necessarios para que possamos passar dados por um formulário e envriar
    //é tipo um enctype
    @FormUrlEncoded
    @POST("testeUpload")
    Call<String> uploadImage(
            //o nome que eu colocar aqui devo colocar como sera na api
            @Field("file") String file,
            @Field("titulo") String titulo
    );
}
