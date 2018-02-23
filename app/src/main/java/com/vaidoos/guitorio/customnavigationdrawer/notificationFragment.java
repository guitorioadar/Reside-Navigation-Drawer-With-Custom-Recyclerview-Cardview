package com.vaidoos.guitorio.customnavigationdrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Guitorio on 2/15/2018.
 */

public class notificationFragment extends Fragment {

    public notificationFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.notification_fragment,null);

        return v;
    }

}
