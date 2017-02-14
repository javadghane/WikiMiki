package ir.javadroid.mvpsimpletest;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ghane on 2/13/2017.
 */

public class App extends Application {
    public static Context context;
    public static Retrofit myRetrofit;
    static String BaseAddress = "http://api.population.io/1.0/";


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Logger.init("MVP");
    }

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        myRetrofit = new Retrofit.Builder()
                .baseUrl(BaseAddress)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return myRetrofit;
    }

}
