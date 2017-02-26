package presenter;

import com.orhanobut.logger.Logger;

import model.country;
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
        serverHelper.getCountry(new serverHelper.getData() {
            @Override
            public void onSuccess(country data) {
                countries = data;
                mv.addCountries(data);
            }

            @Override
            public void onFailure(String error) {
                Logger.e(error);
            }
        });
        Logger.e("Country => setCountryList");
    }

    public interface mainActivityView {
        void addCountries(country countryList);
    }
}
