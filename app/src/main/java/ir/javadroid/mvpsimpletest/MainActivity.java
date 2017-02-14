package ir.javadroid.mvpsimpletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import model.country;
import presenter.mainActivityPresenter;

public class MainActivity extends AppCompatActivity implements mainActivityPresenter.mainActivityView {
    mainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new mainActivityPresenter(this);

        presenter.setCountryList(null);
    }


    @Override
    public void addCountries(ArrayList<country> countryList) {
        //fillList
        Logger.e("test");
    }
}
