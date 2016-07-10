package com.dssp.recyclervieweverything.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.MyLog;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/6/2016.
 */
public class SimpleRecyclerviewAdapter extends RecyclerView.Adapter<SimpleRecyclerviewAdapter.ViewHolder> {

    private static String LOG_TAG=SimpleRecyclerviewAdapter.class.getSimpleName();
    private Context context;
    private List<Movie> movieList;
    private LayoutInflater inflater;
    private Picasso picasso;

    /**
     * creating onItemclicklisterner
     */
    //define  listerner member variable
    private static OnItemClickListerner1 listerner_1;
    //define the listerner interface
    public interface OnItemClickListerner1{
        void onItemClick(View itemView,int position);
    }
    //define the method that allows the parent activity or fragment to define the listerner
    public void setOnRvItemClickListerner(OnItemClickListerner1 clickListerner){
        this.listerner_1 = clickListerner;
    }


    public SimpleRecyclerviewAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
        this.inflater = LayoutInflater.from(context);
        this.picasso = Picasso.with(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView moviename,moviegenre,movietheme,movie_date;
        private ImageView movie_image;

        public ViewHolder(final View itemView) {
            super(itemView);
            moviename = (TextView) itemView.findViewById(R.id.tv_moviename);
            moviegenre = (TextView) itemView.findViewById(R.id.tv_genere);
            movietheme = (TextView) itemView.findViewById(R.id.tv_description);
            movie_date = (TextView) itemView.findViewById(R.id.tv_year);
            movie_image = (ImageView) itemView.findViewById(R.id.iv_simpleimage);

            // Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if(listerner_1 != null){
                        listerner_1.onItemClick(itemView,getLayoutPosition());
                    }

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_simple_rv,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Movie movie = movieList.get(position);

        holder.moviename.setText(""+movie.getName());
        holder.moviegenre.setText(""+movie.getGenre());
        holder.movie_date.setText("" + movie.getYear());
        holder.movietheme.setText("" + movie.getDescription());
        picasso.load(movie.getImageUrl())
                .resize(200, 200)
                .centerInside()
                .into(holder.movie_image, new Callback() {
                    @Override
                    public void onSuccess() {
                        MyLog.e(LOG_TAG, "success image " + movie.getImageUrl());
                    }

                    @Override
                    public void onError() {
                        MyLog.e(LOG_TAG,"error image "+movie.getImageUrl());
                    }
                });
//        Log.e(LOG_TAG,movie.getImageUrl());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    /**
     * 2SWIPE REFRESH>updating recyclerview adapter
     */
    //clear all the elements of recycler
    public void clear(){
        movieList.clear();
        notifyDataSetChanged();
    }

    //add a list of items
    public void addAll(List<Movie> movieList1){
        movieList.addAll(movieList1);
        notifyDataSetChanged();
    }

    public void addAtPosition(int pos,List<Movie> movieList1){

        movieList.addAll(pos, movieList1);
        notifyItemChanged(pos);

    }


}
