package com.saitej3.medaramjathara.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.saitej3.medaramjathara.ItemClickSupport;
import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.adapter.MyRecyclerViewAdapter;
import com.saitej3.medaramjathara.adapter.MyRecyclerViewAdapterLang;
import com.saitej3.medaramjathara.model.DataObject;
import com.saitej3.medaramjathara.model.Lang;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Rohts on 1/18/2016.
 */
public class LangActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Locale myLocale;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);


        CardView cardView=(CardView)findViewById(R.id.card_view);

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view_lang);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapterLang(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if(position==1)
                {

                    Toast.makeText(getApplication(),
                            "You have selected English", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");
                }
                else
                {
                    Toast.makeText(getApplication(),
                            "You have selected Telugu", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("te");
                }
            }
        });

    }
    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LangActivity.class);
        startActivity(refresh);
    }
    private ArrayList<Lang> getDataSet() {
        ArrayList<Lang> results = new ArrayList<Lang>(2);
        results.add(0, new Lang(R.drawable.wlpd,"English"));
        results.add(1, new Lang(R.drawable.wlpd,"Telugu"));
        return results;
    }
}
