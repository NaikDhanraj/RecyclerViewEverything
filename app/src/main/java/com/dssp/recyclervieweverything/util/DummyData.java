package com.dssp.recyclervieweverything.util;

import com.dssp.recyclervieweverything.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/10/2016.
 */
public class DummyData {


    public static List<Movie> prepareMovieData(List<Movie> movieList) {
    //     List<Movie> movieList = new ArrayList<>();
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



        return movieList;

        //after all data is loadeded in list,notify the adapter

     //   simpleRecyclerviewAdapter.notifyDataSetChanged();


    }

    public static List<Movie> loadMoreMovieData(List<Movie> movieList) {
        //     List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Sultan more","Drama film/Sport","2016","http://t2.gstatic.com/images?q=tbn:ANd9GcS1cK4t_uWmqHaRYD9uq69hLEWy7f7NpIfjPlQECdooplpkQcEp","A middle-aged wrestling champion (Salman Khan) tries to make a comeback to represent India at the Olympics."));
        movieList.add(new Movie("Bajrangi Bhaijaan more","Drama film/Action","2015","http://t3.gstatic.com/images?q=tbn:ANd9GcTqyS3fXzIKWbqk_VFlX9N88X7cZi4O4fw1mXdEj587eOlo1GF-","Pavan, a devoted follower of Lord Hanuman, faces numerous challenges when he tries to reunite Munni with her family after she gets lost while travelling back home with her mother"));
        movieList.add(new Movie("PK more"," Fantasy/Science fiction film","2014","http://t1.gstatic.com/images?q=tbn:ANd9GcQSSaD2bSPOgmgsn4-09dF2l8mHbuvHhJxbkL7rvD1uEpAxKnLX","A stranger's childlike curiosity and world-view challenges people's long-held notions, making friends of some and foes of others."));
        movieList.add(new Movie("Fan more","Drama film/Thrille","2016","http://t1.gstatic.com/images?q=tbn:ANd9GcQkEZCmDmmi1UYbAMuu0TzK59JtwdfRyQgxiQoB57NJ8_zDYzAs","A man (Shah Rukh Khan) develops a dangerous obsession with a movie star who looks just like him"));


        return movieList;


    }
}
