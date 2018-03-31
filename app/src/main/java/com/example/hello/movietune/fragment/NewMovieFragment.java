package com.example.hello.movietune.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hello.movietune.R;
import com.example.hello.movietune.adapter.MovieAdapter;
import com.example.hello.movietune.model.Movie;
import com.example.hello.movietune.network.ApiClient;
import com.example.hello.movietune.network.NetworkInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewMovieFragment extends Fragment {

    private View mMainView;
    private TextView mTexView;
   // private ImageView mImageView;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MovieAdapter mMovieAdapter;
    private NetworkInterface mNetworkInterface;


    public NewMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView =  inflater.inflate(R.layout.fragment_new_movie, container, false);
        initView();
        return mMainView;
    }

    private void initView(){
      //  mImageView = mMainView.findViewById(R.id.imageView);
        mRecyclerView = mMainView.findViewById(R.id.recylcerView);

        Retrofit retrofit = ApiClient.getInstance(getActivity());
        mNetworkInterface = retrofit.create(NetworkInterface.class);

        mLayoutManager =  new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mNetworkInterface.getMovieData().enqueue(
                new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {

                        if (response.body() != null){
                            Log.e("Success", "onResponse: "+response.body().getResults().get(0).getPosterPath() );

                            mMovieAdapter = new MovieAdapter(response.body().getResults(),getActivity());
                            mRecyclerView.setAdapter(mMovieAdapter);
                            /*String url ="http://image.tmdb.org/t/p/w500/"+ response.body().getResults().get(0).getPosterPath()+
                                    "?api_key=c37d3b40004717511adb2c1fbb15eda4";
                            Glide
                                    .with(getActivity())
                                    .load(url)
                                    .into(mImageView);*/
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {

                    }
                }
        );

    }

}
