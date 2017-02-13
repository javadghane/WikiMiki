package model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ghane on 2/13/2017.
 */

public interface apiBase {


    @GET("countries")
    Call<ArrayList<country>> getCountry();

    @GET("population/{year}/{country}/")
    Call<ArrayList<country>> getCountry(@Path("year") String year, @Path("country") String country);


}
