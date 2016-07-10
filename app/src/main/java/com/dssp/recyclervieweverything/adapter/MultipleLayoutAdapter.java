package com.dssp.recyclervieweverything.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.MyLog;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/10/2016.
 */
public class MultipleLayoutAdapter extends RecyclerView.Adapter<MultipleLayoutAdapter.ViewHolder> {
    private static String LOG_TAG = MultipleLayoutAdapter.class.getSimpleName();
    private Context context;
    private List<Movie> movieList;
    private static final int VIEW_TYPE1 = 1;
    private static final int VIEW_TYPE2 = 2;
    private LayoutInflater inflater;
    private Picasso picasso;

    public MultipleLayoutAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
        inflater = LayoutInflater.from(this.context);
        picasso = Picasso.with(this.context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderX extends ViewHolder{

        private TextView moviename,moviegenre,movietheme,movie_date;
        private ImageView movie_image;

        public ViewHolderX(View itemView) {
            super(itemView);

            moviename = (TextView) itemView.findViewById(R.id.tv_moviename);
            moviegenre = (TextView) itemView.findViewById(R.id.tv_genere);
            movietheme = (TextView) itemView.findViewById(R.id.tv_description);
            movie_date = (TextView) itemView.findViewById(R.id.tv_year);
            movie_image = (ImageView) itemView.findViewById(R.id.iv_simpleimage);
        }

    }

    public class ViewHolderY extends ViewHolder{

        private TextView moviename,moviegenre,movietheme,movie_date;
        private ImageView movie_image;

        public ViewHolderY(View itemView) {
            super(itemView);

            moviename = (TextView) itemView.findViewById(R.id.tv_moviename);
            moviegenre = (TextView) itemView.findViewById(R.id.tv_genere);
            movietheme = (TextView) itemView.findViewById(R.id.tv_description);
            movie_date = (TextView) itemView.findViewById(R.id.tv_year);
            movie_image = (ImageView) itemView.findViewById(R.id.iv_simpleimage);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if( movieList.get(position).getYear().equals("2016") ){

            return 1;

        }else{

            return 2;


        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(viewType == VIEW_TYPE1){
            view = inflater.inflate(R.layout.item_simple_rv,parent,false);
            return new ViewHolderX(view);
        }else {

            view = inflater.inflate(R.layout.item_simple_rv2,parent,false);
            return new ViewHolderY(view);

        }
      //  return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Movie movieName = movieList.get(position);

        if(holder.getItemViewType() ==VIEW_TYPE1){

            ViewHolderX viewHolderX = (ViewHolderX) holder;

            viewHolderX.moviename.setText(""+movieName.getName());
            viewHolderX.moviegenre.setText(""+movieName.getGenre());
            viewHolderX.movie_date.setText("" + movieName.getYear());
            viewHolderX.movietheme.setText("" + movieName.getDescription());
            picasso.load(movieName.getImageUrl())
                    .resize(200, 200)
                    .centerInside()
                    .into(viewHolderX.movie_image, new Callback() {
                        @Override
                        public void onSuccess() {
                            MyLog.e(LOG_TAG, "success image " + movieName.getImageUrl());
                        }

                        @Override
                        public void onError() {
                            MyLog.e(LOG_TAG, "error image " + movieName.getImageUrl());
                        }
                    });

        }else{

            ViewHolderY viewHoldery = (ViewHolderY) holder;

            viewHoldery.moviename.setText(""+movieName.getName());
            viewHoldery.moviegenre.setText(""+movieName.getGenre());
            viewHoldery.movie_date.setText("" + movieName.getYear());
            viewHoldery.movietheme.setText("" + movieName.getDescription());
            picasso.load(movieName.getImageUrl())
                    .resize(200, 200)
                    .centerInside()
                    .into(viewHoldery.movie_image, new Callback() {
                        @Override
                        public void onSuccess() {
                            MyLog.e(LOG_TAG, "success image " + movieName.getImageUrl());
                        }

                        @Override
                        public void onError() {
                            MyLog.e(LOG_TAG, "error image " + movieName.getImageUrl());
                        }
                    });

        }

    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
