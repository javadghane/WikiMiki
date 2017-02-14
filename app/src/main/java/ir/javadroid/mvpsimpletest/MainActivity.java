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

     /*"name": "a",
      "depth": "0",
      "id": "1",
      "lft": "1",
      "rgt": "18"*/
        //    node a1 = new node(1, "a", new node())
        presenter.setCountryList(null);
    }

    class node {
        int id;
        String name;
        node right;
        node left;

        node(int id, String name, node right, node left) {
            this.id = id;
            this.name = name;
            this.right = right;
            this.left = left;
        }

        node(int id, node right, node left) {
            this.id = id;
            this.right = right;
            this.left = left;
        }

    }

    @Override
    public void addCountries(ArrayList<country> countryList) {
        //fillList
        Logger.e("test");
    }
}
