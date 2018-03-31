package com.example.hello.movietune.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hello.movietune.R;
import com.example.hello.movietune.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hello on 10/3/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private List<ResultsItem> stringList = new ArrayList<>();
    private Context mContext;
    public MovieAdapter(List<ResultsItem> stringList, Context context) {
        this.stringList = stringList;
        this.mContext = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_adapter, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        String url ="http://image.tmdb.org/t/p/w500/"+stringList.get( position).getPosterPath()+
                "?api_key=c37d3b40004717511adb2c1fbb15eda4";

                Glide.with(mContext)
                .load(url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewMovie);
        }
    }
}
