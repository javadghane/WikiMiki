package ir.javadroid.mvpsimpletest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;
import model.Adapter;
import model.country;
import presenter.mainActivityPresenter;

public class MainActivity extends AppCompatActivity implements mainActivityPresenter.mainActivityView {
    mainActivityPresenter presenter;

    @InjectView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;
    @InjectView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        presenter = new mainActivityPresenter(this);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.setCountryList();
            }
        });
        swipeRefreshLayout.setRefreshing(true);
    }


    @Override
    public void addCountries(country countryList) {
        swipeRefreshLayout.setRefreshing(false);
        Logger.e("Country =>" + countryList.getCountries().size());

        Adapter adapter = new Adapter(countryList, new Adapter.adapterResponse() {
            @Override
            public void click(String country) {
                Toast.makeText(MainActivity.this, country + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(adapter);

    }
}
