package com.dssp.recyclervieweverything.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dssp.recyclervieweverything.R;
import com.dssp.recyclervieweverything.model.Movie;
import com.dssp.recyclervieweverything.util.MyLog;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/12/2016.
 */
public class InfiniteScrollAdapter extends RecyclerView.Adapter<InfiniteScrollAdapter.ViewHolderMain> {

    private static String LOG_TAG=SimpleRecyclerviewAdapter.class.getSimpleName();
    private Context context;
    private List<Movie> movieList;
    private LayoutInflater inflater;
    private Picasso picasso;


    /**
     *
     * INFINITE RECYCLERVIEW
     */
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;
    public void setLoad(){
        loading = false;
    }
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener){
        this.onLoadMoreListener = onLoadMoreListener;
    }
    public interface OnLoadMoreListener {
        void onLoadMore();
    }
    public void setLoaded() {
        loading = false;
    }


    public InfiniteScrollAdapter(Context context, List<Movie> movieList,RecyclerView recyclerView) {
        this.context = context;
        this.movieList = movieList;
        this.inflater = LayoutInflater.from(context);
        this.picasso = Picasso.with(context);

        if(recyclerView.getLayoutManager() instanceof LinearLayoutManager){
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);


                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if(!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)){
                        if(onLoadMoreListener != null){
                            onLoadMoreListener.onLoadMore();
                        }
                        loading = true;
                    }


                }
            });
        }

    }

    public static class ViewHolderMain extends RecyclerView.ViewHolder{
        public ViewHolderMain(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderMovies extends ViewHolderMain{

        private TextView moviename,moviegenre,movietheme,movie_date;
        private ImageView movie_image;

        public ViewHolderMovies(final View itemView) {
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
                   /* if(listerner_1 != null){
                        listerner_1.onItemClick(itemView,getLayoutPosition());
                    }*/

                }
            });
        }
    }

    public class ViewHolderNull extends ViewHolderMain{
        private ProgressBar progressBar;
        public ViewHolderNull(View itemView) {
            super(itemView);
            progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
        }
    }

    @Override
    public ViewHolderMain onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolderMain viewHolderMain = null;
        if(viewType==1){
            View view = inflater.inflate(R.layout.item_simple_rv,parent,false);

            viewHolderMain = new ViewHolderMovies(view);
        }else{
            View view = inflater.inflate(R.layout.progress_item,parent,false);
            viewHolderMain = new ViewHolderNull(view);
        }

      //  View view = inflater.inflate(R.layout.item_simple_rv,parent,false);

        return viewHolderMain;
    }

    @Override
    public void onBindViewHolder(ViewHolderMain holder, int position) {

        if(holder.getItemViewType() ==1){

            ViewHolderMovies viewHolderMovies = (ViewHolderMovies) holder;

            final Movie movie = movieList.get(position);

            viewHolderMovies.moviename.setText(""+movie.getName());
            viewHolderMovies.moviegenre.setText(""+movie.getGenre());
            viewHolderMovies.movie_date.setText("" + movie.getYear());
            viewHolderMovies.movietheme.setText("" + movie.getDescription());
            picasso.load(movie.getImageUrl())
                    .resize(200, 200)
                    .centerInside()
                    .into(viewHolderMovies.movie_image, new Callback() {
                        @Override
                        public void onSuccess() {
                            MyLog.e(LOG_TAG, "success image " + movie.getImageUrl());
                        }

                        @Override
                        public void onError() {
                            MyLog.e(LOG_TAG,"error image "+movie.getImageUrl());
                        }
                    });

        }else{
            ViewHolderNull viewHolderNull = (ViewHolderNull) holder;
            viewHolderNull.progressBar.setIndeterminate(true);

        }

//        Log.e(LOG_TAG,movie.getImageUrl());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    @Override
    public int getItemViewType(int position) {

        return movieList.get(position) !=null ? 1 : 0;
     //   return super.getItemViewType(position);

    }
}
