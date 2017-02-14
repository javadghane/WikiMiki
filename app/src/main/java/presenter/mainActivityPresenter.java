package presenter;

import java.util.ArrayList;

import model.country;

/**
 * Created by ghane on 2/13/2017.
 */

public class mainActivityPresenter {
    private mainActivityView mv;
    private ArrayList<country> countries;

    public mainActivityPresenter(mainActivityView mv) {
        this.mv = mv;
    }

    public void setCountryList(ArrayList<country> countryList) {
        this.countries = countryList;
        this.mv.addCountries(countryList);
    }

    public interface mainActivityView {
        void addCountries(ArrayList<country> countryList);
    }
}
