package com.example.mobileuploadapirest.remote;

public class ApiUtil {

    private static final String API_URL = "http://10.107.144.14:3000/";

    public static ImageInterface uploadImage(){
        //indicamos onde roda nossa aplicacao, e indica a rota
        return RetroFitClient.getClient(API_URL).create(ImageInterface.class);
    }

}
