package com.dssp.recyclervieweverything.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.adapter.SimpleRecyclerviewAdapter;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.DummyData;
import com.dssp.recyclervieweverything.util.MyLog;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/8/2016.
 */
public class SwipeableRecyclerViewActivity extends AppCompatActivity {

    private static String LOG_TAG = SwipeableRecyclerViewActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private SimpleRecyclerviewAdapter swipeAdapter;
    private Context context = SwipeableRecyclerViewActivity.this;
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerViewSwipe;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipeable_rv);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        recyclerViewSwipe = (RecyclerView) findViewById(R.id.rv_swipable);


        swipeAdapter = new SimpleRecyclerviewAdapter(context,movieList);
        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);//false means default item position on top
        recyclerViewSwipe.setLayoutManager(layoutManager);
        recyclerViewSwipe.setAdapter(swipeAdapter);


        /**
         * set data to adapter
         */
        setRVData();

        //setup  refresh listerner when triggers new data loading
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);


            }
        });

        //configer the refresh colors
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );


    }

    private void setRVData() {
        movieList = DummyData.prepareMovieData(movieList);
        Log.e(LOG_TAG,"MOVIE LIST SIZE "+movieList.size());

        //after all data is loadeded in list,notify the adapter

        swipeAdapter.notifyDataSetChanged();
    }

    private void fetchTimelineAsync(int i) {
        Log.e(LOG_TAG, "Refreshing load more now");
        /**
         * Note that upon successful reload, we must also signal that the refresh has completed by calling setRefreshing(false).
         * Also note that you should clear out old items before appending the new ones during a refresh.
         */

        swipeAdapter.clear();

        movieList = DummyData.loadMoreMovieData(movieList);
        MyLog.e(LOG_TAG, "MOVIE LIST SIZE " + movieList.size());

        swipeAdapter.addAll(movieList);
//        swipeAdapter.addAtPosition(0,movieList);
        swipeRefreshLayout.setRefreshing(false);

        // Send the network request to fetch the updated data
        // `client` here is an instance of Android Async HTTP
   /*     client.getHomeTimeline(0, new JsonHttpResponseHandler() {
            public void onSuccess(JSONArray json) {
                // Remember to CLEAR OUT old items before appending in the new ones
                swipeAdapter.clear();
                // ...the data has come back, add new items to your adapter...
                swipeAdapter.addAll(...);
                // Now we call setRefreshing(false) to signal refresh has finished
                swipeRefreshLayout.setRefreshing(false);
            }

            public void onFailure(Throwable e) {
                Log.d("DEBUG", "Fetch timeline error: " + e.toString());
            }
        });*/


    }
}
