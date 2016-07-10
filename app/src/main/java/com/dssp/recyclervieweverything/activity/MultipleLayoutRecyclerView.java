package com.dssp.recyclervieweverything.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.adapter.MultipleLayoutAdapter;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/10/2016.
 */
public class MultipleLayoutRecyclerView extends AppCompatActivity {

    private static String LOG_TAG = MultipleLayoutRecyclerView.class.getSimpleName();
    private Context context = MultipleLayoutRecyclerView.this;
    private List<Movie> movieList = new ArrayList<>();
    private MultipleLayoutAdapter multipleLayoutAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rv_simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_rv);

        rv_simple = (RecyclerView) findViewById(R.id.rv_simple);
        multipleLayoutAdapter = new MultipleLayoutAdapter(context,movieList);
        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rv_simple.setLayoutManager(layoutManager);
        rv_simple.setAdapter(multipleLayoutAdapter);


        setDataToList();


    }

    private void setDataToList() {
        movieList = DummyData.prepareMovieData(movieList);
        multipleLayoutAdapter.notifyDataSetChanged();
    }
}
