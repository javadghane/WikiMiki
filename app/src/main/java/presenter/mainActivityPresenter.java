package presenter;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import model.country;
import model.population;
import model.serverHelper;

/**
 * Created by ghane on 2/13/2017.
 */

public class mainActivityPresenter {
    private mainActivityView mv;
    private country countries;

    public mainActivityPresenter(mainActivityView mv) {
        this.mv = mv;
    }

    public void setCountryList() {
        serverHelper.getCountry(new serverHelper.getCountryCallback() {
            @Override
            public void onSuccess(country data) {
                countries = data;
                mv.addCountries(countries);
            }

            @Override
            public void onFailure(String error) {
                Logger.e(error);
            }
        });
        Logger.e("Country => setCountryList");
    }

    public void getPopulation(String year, String countryName) {
        serverHelper.getPopulation(year, countryName, new serverHelper.getPopulationCallback() {
            @Override
            public void onSuccess(ArrayList<population> data) {
                int male = 0;
                int female = 0;
                String countryName = "";
                for (population item : data) {
                    male += item.getMales();
                    female += item.getFemales();
                    countryName = item.getCountry();
                }
                mv.getPopulation(countryName, male, female);
            }

            @Override
            public void onFailure(String error) {
                Logger.e(error);
            }
        });
    }

    public interface mainActivityView {
        void addCountries(country countryList);

        void getPopulation(String countryName, int male, int female);
    }
}
