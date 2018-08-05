package com.mysy.star_0733.mysy1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class Fragment_video extends Fragment {
    View rootview;
    RecyclerView recycle;
    boolean data=false;
    boolean wifi=false;
    NetworkInfo networkInfo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_video,container,false);
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        //get status of mobile data
        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        data = networkInfo.isConnected();

        //get status of device wifi
        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        wifi = networkInfo.isConnected();
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(data || wifi) {
            RecyclerView recyclerView=(RecyclerView)rootview.findViewById(R.id.recycle);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerAdapter adapter=new RecyclerAdapter(getContext());
            recyclerView.setAdapter(adapter);
        }
        else
        {
            FancyToast.makeText(getContext(),"No Internet Connection",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
