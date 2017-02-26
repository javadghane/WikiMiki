package model;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ir.javadroid.mvpsimpletest.R;


/**
 * Created by JavaDroid on 7/18/2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MainHolder> {

    private country countries;
    private adapterResponse response;

    public Adapter(country countries, adapterResponse response) {
        this.countries = countries;
        this.response = response;

    }

    public interface adapterResponse {
        void click(String country);
    }


    @Override
    public int getItemCount() {
        return countries.getCountries().size();
    }


    @Override
    public void onBindViewHolder(final MainHolder mainHolder, final int position) {
        final String item = countries.getCountries().get(position);
        mainHolder.tvTitle.setText(item);
        mainHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.click(item);
            }
        });
    }


    @Override
    public MainHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.adapter_item_country, viewGroup, false);
        return new MainHolder(itemView);
    }

    public static class MainHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.title)
        TextView tvTitle;

        private MainHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }


    }
}
