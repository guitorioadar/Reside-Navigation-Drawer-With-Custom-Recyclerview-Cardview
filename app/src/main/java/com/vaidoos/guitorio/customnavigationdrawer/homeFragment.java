package com.vaidoos.guitorio.customnavigationdrawer;


import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guitorio on 2/15/2018.
 */

public class homeFragment extends Fragment {

    private RecyclerView recyclerviewCardDetail;

    private RecyclerViewAdapter recyclerViewAdapter;

    List<CardDetail> cardDetailList = new ArrayList<>();

    private Context mCtx;

    private int height;

    public homeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,null);

        mCtx = getActivity();

        preparedData();

        recyclerViewAdapter = new RecyclerViewAdapter(mCtx,cardDetailList);

        recyclerviewCardDetail = v.findViewById(R.id.recyclerviewCardDetail);

        recyclerviewCardDetail.setLayoutManager(new LinearLayoutManager(mCtx));

        recyclerviewCardDetail.setHasFixedSize(true);

        recyclerviewCardDetail.setAdapter(recyclerViewAdapter);

        Resources myResources = getResources();
        int idStatusBarHeight = myResources.getIdentifier("status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = getResources().getDimensionPixelSize(idStatusBarHeight);
            Toast.makeText(getActivity(),"Status Bar Height = " + height,Toast.LENGTH_LONG).show();
        }else{
            height = 0;
            Toast.makeText(getActivity(),"Resources NOT found",Toast.LENGTH_LONG).show();
        }

        return v;
    }


    public void preparedData(){

        cardDetailList.add(new CardDetail("$321654.10","1028","4050","10/10"));
        cardDetailList.add(new CardDetail("$326554.10","1221","4780","21/12"));
        cardDetailList.add(new CardDetail("$121654.10","1828","3250","18/32"));
        cardDetailList.add(new CardDetail("$121654.10","1828","3250","18/32"));
        cardDetailList.add(new CardDetail("$121654.10","1828","3250","18/32"));
        cardDetailList.add(new CardDetail("$121654.10","1828","3250","18/32"));
        cardDetailList.add(new CardDetail("$121654.10","1828","3250","18/32"));

    }

}
