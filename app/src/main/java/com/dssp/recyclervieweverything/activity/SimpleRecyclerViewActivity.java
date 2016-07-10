package com.dssp.recyclervieweverything.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.adapter.SimpleRecyclerviewAdapter;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.DividerItemDecoration;
import com.dssp.recyclervieweverything.util.DummyData;
import com.dssp.recyclervieweverything.util.MyLog;
import com.dssp.recyclervieweverything.util.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/6/2016.
 */
public class SimpleRecyclerViewActivity extends AppCompatActivity {

    private static final String LOG_TAG = SimpleRecyclerViewActivity.class.getSimpleName();
    private Context context = SimpleRecyclerViewActivity.this;
    private Toolbar toolbar;
    private RecyclerView recyclerViewSimple;
    private List<Movie> movieList =new ArrayList<>();
    private SimpleRecyclerviewAdapter simpleRecyclerviewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_rv);

        /**
        **typcasting views
         *
         */
        typecastingViews();
        /**
         * recyclerview setup
         */
        setRecyclerview();

        /**
         *storing movie data
         */
        prepareMovieData();

        /**
         * toolbar operations
         */
        toolbarSetup();
        
        simpleRecyclerviewAdapter.setOnRvItemClickListerner(new SimpleRecyclerviewAdapter.OnItemClickListerner1() {
            @Override
            public void onItemClick(View itemView, int position) {
                String moviename= movieList.get(position).getName();
                movieList.get(position).setYear("Released");
                simpleRecyclerviewAdapter.notifyDataSetChanged();
                Toast.makeText(SimpleRecyclerViewActivity.this, " "+moviename, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void toolbarSetup() {
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setTitle("Simple Recyclerview");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //overflow menu
        toolbar.inflateMenu(R.menu.menu_simple_rv);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                switch (item.getItemId()){

                    case R.id.action_grid:
                     //   Toast.makeText(SimpleRecyclerViewActivity.this, "Wle", Toast.LENGTH_SHORT).show();
                        layoutManager = new GridLayoutManager(context,2);

                        recyclerViewSimple.setLayoutManager(layoutManager);

                        return true;

                    case R.id.action_staggered:
                        // First param is number of columns and second param is orientation i.e Vertical or Horizontal
                        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                        //We can decorate the items using various decorators attached to the recyclerview
                        SpacesItemDecoration decoration = new SpacesItemDecoration(6);
                        recyclerViewSimple.addItemDecoration(decoration);
                        // Attach the layout manager to the recycler view
                        recyclerViewSimple.setLayoutManager(layoutManager);
                        return true;

                    case R.id.action_horizontal:
                        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
                        // Attach the layout manager to the recycler view
                        recyclerViewSimple.setLayoutManager(layoutManager);
                        return true;

                    case R.id.action_vertical:
                        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                        // Attach the layout manager to the recycler view
                        recyclerViewSimple.setLayoutManager(layoutManager);
                        return true;


                    // break;
                }

                return false;

            }
        });



    }

    private void setRecyclerview() {

        simpleRecyclerviewAdapter = new SimpleRecyclerviewAdapter(context,movieList);
        layoutManager = new LinearLayoutManager(context);

        // Attach layout manager to the RecyclerView
        recyclerViewSimple.setLayoutManager(layoutManager);
        //We can also enable optimizations if all item views are of the same height and width for significantly smoother scrolling
      //  recyclerViewSimple.setHasFixedSize(true);
        // Optionally customize the position you want to default scroll to
        // layoutManager.scrollToPosition(0);


        /**Animators -->default i have used
         * for complex recyclerview animations,use this library https://github.com/wasabeef/recyclerview-animators
         */
        recyclerViewSimple.setItemAnimator(new DefaultItemAnimator());


        /**
         * DECORATIONS
         */
        //We can decorate the items using various decorators attached to the recyclerview
    //    RecyclerView.ItemDecoration itemDecorator = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST);
     //   recyclerViewSimple.addItemDecoration(itemDecorator);

        recyclerViewSimple.setAdapter(simpleRecyclerviewAdapter);



    }


    private void typecastingViews() {
        recyclerViewSimple = (RecyclerView) findViewById(R.id.rv_simple);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void prepareMovieData() {

/*
        movieList.add(new Movie("Sultan","Drama film/Sport","2016","http://t2.gstatic.com/images?q=tbn:ANd9GcS1cK4t_uWmqHaRYD9uq69hLEWy7f7NpIfjPlQECdooplpkQcEp","A middle-aged wrestling champion (Salman Khan) tries to make a comeback to represent India at the Olympics."));
        movieList.add(new Movie("Bajrangi Bhaijaan","Drama film/Action","2015","http://t3.gstatic.com/images?q=tbn:ANd9GcTqyS3fXzIKWbqk_VFlX9N88X7cZi4O4fw1mXdEj587eOlo1GF-","Pavan, a devoted follower of Lord Hanuman, faces numerous challenges when he tries to reunite Munni with her family after she gets lost while travelling back home with her mother"));
        movieList.add(new Movie("PK"," Fantasy/Science fiction film","2014","http://t1.gstatic.com/images?q=tbn:ANd9GcQSSaD2bSPOgmgsn4-09dF2l8mHbuvHhJxbkL7rvD1uEpAxKnLX","A stranger's childlike curiosity and world-view challenges people's long-held notions, making friends of some and foes of others."));
        movieList.add(new Movie("Fan","Drama film/Thrille","2016","http://t1.gstatic.com/images?q=tbn:ANd9GcQkEZCmDmmi1UYbAMuu0TzK59JtwdfRyQgxiQoB57NJ8_zDYzAs","A man (Shah Rukh Khan) develops a dangerous obsession with a movie star who looks just like him"));
        movieList.add(new Movie("Kick","Bollywood/Thriller","2015","http://t3.gstatic.com/images?q=tbn:ANd9GcQgnLm96dlwBF3jn0W9KBOjGad-DEHuzdITyJJsQ_LKTlXxmhYg","Devi Lal Singh, a typical youth with an anomalous standard of living, tries to find pleasure in whatever he does. He eventually becomes a thief and dons a new name, Devil."));
        movieList.add(new Movie("3 Idiots","Drama film/Bollywood","2009","http://www.gstatic.com/tv/thumb/dvdboxart/7951929/p7951929_d_v8_aa.jpg","In college, Farhan and Raju form a great bond with Rancho due to his refreshing outlook. Years later, a bet gives them a chance to look for their long-lost friend whose existence seems rather elusive."));
        movieList.add(new Movie("Sholay","Drama film/Bollywood","1975","http://www.gstatic.com/tv/thumb/dvdboxart/71627/p71627_d_v8_aa.jpg","Jai and Veeru, two small-time crooks, are hired by Thakur Baldev Singh, a retired policeman, to help him nab Gabbar Singh, a notorious dacoit, who has spread havoc in the village of Ramgarh."));
        movieList.add(new Movie("Dangal","Drama film/Sport","2016","https://upload.wikimedia.org/wikipedia/en/3/3f/Dangal_first_look.jpg","Dangal is an upcoming Indian biographical sports drama film directed by Nitesh Tiwari. The film is produced by Disney Studio India."));
        movieList.add(new Movie("Mohenjo Daro","Drama film/Bollywood","2016","http://t2.gstatic.com/images?q=tbn:ANd9GcS80mAtrrEQB4hgbfi6w-wLQI1N-EQ3tNuEgXU3fVK6XhDlocih","Mohenjo Daro is an upcoming Indian epic adventure-romance film written and directed by Ashutosh Gowariker. The film is produced by Siddharth Roy Kapur and Sunita A. Gowariker. It features Hrithik Roshan and Pooja Hegde in the lead roles"));
        movieList.add(new Movie("Mughal-E-Azam","Drama film/Bollywoo","1960","https://jillbrary.files.wordpress.com/2010/01/mughal-e-azam.gif","Salim, an emperor's son, falls in love with a beautiful courtesan. He is determined to be with her, even if it means waging a hopeless war against his father."));
*/


        movieList = DummyData.prepareMovieData(movieList);
        MyLog.e(LOG_TAG, "MOVIE LIST SIZE " + movieList.size());

        //after all data is loadeded in list,notify the adapter

        simpleRecyclerviewAdapter.notifyDataSetChanged();


    }


}
