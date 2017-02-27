package model;

import java.util.ArrayList;

import ir.javadroid.mvpsimpletest.App;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ghane on 2/26/2017.
 */

public class serverHelper {
    private static apiBase baseAPI = App.getRetrofit().create(apiBase.class);

    public static void getCountry(final getCountryCallback callback) {
        Call<country> call = baseAPI.getCountry();
        call.enqueue(new Callback<country>() {
            @Override
            public void onResponse(Call<country> call, Response<country> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure("UnSuccessResponse Code:" + response.code());
                }
            }

            @Override
            public void onFailure(Call<country> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface getCountryCallback {

        void onSuccess(country data);

        void onFailure(String error);

    }

    public static void getPopulation(String year, String countryName, final getPopulationCallback callback) {
        Call<ArrayList<population>> call = baseAPI.getPopulation(year, countryName);
        call.enqueue(new Callback<ArrayList<population>>() {
            @Override
            public void onResponse(Call<ArrayList<population>> call, Response<ArrayList<population>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure("UnSuccessResponse Code:" + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<population>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface getPopulationCallback {

        void onSuccess(ArrayList<population> data);

        void onFailure(String error);

    }

}
