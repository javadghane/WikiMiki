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
    Call<country> getCountry();

    @GET("population/{year}/{country}/")
    Call<ArrayList<population>> getPopulation(@Path("year") String year, @Path("country") String country);


}
