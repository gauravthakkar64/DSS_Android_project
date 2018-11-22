package com.example.gaurav.crudretrofit.remote;

public class APIUtils {

    private APIUtils(){};

    public  static final  String API_URL="https://reqres.in/api/";

    public  static  UserService getUserService(){
        return  RetrofitClient.getClient(API_URL).create(UserService.class);

    }
}
