package com.example.covid;



import java.lang.ref.SoftReference;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface api {

    @GET("summary")//endpoint

    Call<String> summary( //response we shall get



    );

    @GET("live/country/{country}/status/confirmed/date/2020-03-23T01:13:30Z")

    Call<List<specific_case>> spec (@Path("country") String name_country);




}
