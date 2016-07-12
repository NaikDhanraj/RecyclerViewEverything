package com.dssp.recyclervieweverything.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.adapter.InfiniteScrollAdapter;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/12/2016.
 */
public class InfiniteRvActivity extends AppCompatActivity {

    private static String LOG_TAG = InfiniteRvActivity.class.getSimpleName();
    private Context context = InfiniteRvActivity.this;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private InfiniteScrollAdapter infiniteAdapter;
    private List<Movie> movieList = new ArrayList<>();
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_rv);

        handler = new Handler();

        typcastingViews();
        setRecycler();
        setDataForInfiniteRv();

        infiniteAdapter.setOnLoadMoreListener(new InfiniteScrollAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                movieList.add(null);
                infiniteAdapter.notifyItemChanged(movieList.size() - 1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        movieList.remove(movieList.size() - 1);
                        infiniteAdapter.notifyItemRemoved(movieList.size());

                        //add items more
                        movieList = DummyData.loadMoreMovieData(movieList);
                        infiniteAdapter.notifyItemChanged(movieList.size()-1);
                        infiniteAdapter.setLoaded();

                    }
                },3000);

            }
        });
    }

    private void setDataForInfiniteRv() {
        movieList = DummyData.prepareMovieData(movieList);
        infiniteAdapter.notifyDataSetChanged();
    }

    private void setRecycler() {
        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        infiniteAdapter = new InfiniteScrollAdapter(context,movieList,recyclerView);
        recyclerView.setAdapter(infiniteAdapter);
    }

    private void typcastingViews() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_simple);
    }


}
